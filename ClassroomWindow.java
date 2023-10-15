/*
 * Class Name : ClassroomWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package com.sliit.gui.general;

import com.sliit.dao.ClassroomDao;
// imports
import com.sliit.entities.Classroom;
import com.sliit.entities.User;
import com.sliit.gui.create.NewClassroomWindow;
import com.sliit.gui.update.EditClassroomWindow;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.BorderLayout;

//class implementation
public class ClassroomWindow implements EntityWindow {
	
	// properties
	private JFrame frmClassroom;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnLaboratory, btnExamination, btnUser, btnPrincipal, btnStudent, btnTeacher, btnSearch, btnEditDetails, btnDeleteEntries, btnSubject, btnAddStudent, btnRefresh;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<Classroom> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public ClassroomWindow(User user) {
		initialize(user);
		
		columnNames = new Vector<>();
        columnNames.add("Classroom ID");
        columnNames.add("Location");
        columnNames.add("Teacher Name");
        columnNames.add("Capacity");

        model = new DefaultTableModel(columnNames, 0) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        table = new JTable(model);
        scrollPane = new JScrollPane(table);
		
		itemList = ClassroomDao.getAll();
		getTable(itemList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(User user) {
		frmClassroom = new JFrame();
		frmClassroom.setVisible(true);
		frmClassroom.setResizable(false);
		frmClassroom.setTitle("School Information Management System");
		frmClassroom.setBounds(10, 10, 1080, 720);
		frmClassroom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClassroom.getContentPane().setLayout(null);
		
		lblEntity = new JLabel("Classroom");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(134, 36, 198, 48);
		frmClassroom.getContentPane().add(lblEntity);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(user);
				frmClassroom.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmClassroom.getContentPane().add(btnDashboard);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmClassroom.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 257, 181, 48);
		frmClassroom.getContentPane().add(btnUser);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
				frmClassroom.dispose();
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frmClassroom.getContentPane().add(btnExamination);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
				frmClassroom.dispose();
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frmClassroom.getContentPane().add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmClassroom.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmClassroom.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmClassroom.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmClassroom.getContentPane().add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubjectWindow(user);
				frmClassroom.dispose();
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frmClassroom.getContentPane().add(btnSubject);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmClassroom.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frmClassroom.getContentPane().add(btnTeacher);
		
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 393, 48);
		frmClassroom.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Location");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(651, 127, 155, 48);
		frmClassroom.getContentPane().add(comboBoxSelect);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = comboBoxSelect.getSelectedIndex();
				String searchInput = txtEnterTheValue.getText();
				
				if (searchInput.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text to search!", "Error", 0);
				} else {
					if (selectedItem == 0) {
						Classroom classroom = ClassroomDao.getById(searchInput);
						getTable(classroom);
					} else {
						itemList = ClassroomDao.getByLocation(searchInput);
						getTable(itemList);
					}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frmClassroom.getContentPane().add(btnSearch);
		
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmClassroom.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmClassroom.getContentPane().add(lblAccType);
		
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmClassroom.getContentPane().add(lblEdit);
		
		btnAddStudent = new JButton("Add Classroom");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewClassroomWindow();
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddStudent.setBounds(302, 198, 199, 48);
		frmClassroom.getContentPane().add(btnAddStudent);
		
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditClassroomWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(569, 198, 199, 48);
		frmClassroom.getContentPane().add(btnEditDetails);
		
		btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Confirm Deletion?", "Delete Entries", 0);
				int deletedRowCount = 0;

				if (input == 0) {
					for (int row=0; row<model.getRowCount(); row++) {
						String idValue = (String) model.getValueAt(row, 0);
						deletedRowCount += ClassroomDao.getDeleteConfirmation(idValue);
					}
					
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmClassroom.getContentPane().add(btnDeleteEntries);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 7, 100, 100);
		frmClassroom.getContentPane().add(panelLogo);
		
		panelLogo2 = new JPanel();
		panelLogo2.setLayout(null);
		panelLogo2.setBounds(15, 15, 65, 65);
		panelLogo.add(panelLogo2);
		
		lblName1 = new JLabel("Western");
		lblName1.setBounds(2, 0, 46, 14);
		panelLogo2.add(lblName1);
		
		lblName2 = new JLabel("High");
		lblName2.setBounds(2, 11, 46, 14);
		panelLogo2.add(lblName2);
		
		lblName3 = new JLabel("School");
		lblName3.setBounds(2, 25, 46, 14);
		panelLogo2.add(lblName3);
		
		btnRefresh = new JButton("Load/Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList = ClassroomDao.getAll();
				getTable(itemList);
			}
		});
		btnRefresh.setBounds(342, 49, 110, 33);
		frmClassroom.getContentPane().add(btnRefresh);
	}
	
	public <E> void getTable(ArrayList<E> itemList) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmClassroom.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
        model.setRowCount(0);

        table = new JTable(model);
        panel.add(scrollPane, BorderLayout.CENTER);

        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((Classroom) item).getId());
            row.add(((Classroom) item).getLocation());
            row.add(((Classroom) item).getTeacher().getFirstName() + " " + ((Classroom) item).getTeacher().getLastName());
            row.add(String.valueOf(((Classroom) item).getCapacity()));

            model.addRow(row);
        }
	}
	
	public void getTable(Classroom classroom) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmClassroom.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        Vector<String> row = new Vector<>();
        row.add(classroom.getId());
        row.add(classroom.getLocation());
        row.add(classroom.getTeacher().getFirstName() + " " + classroom.getTeacher().getLastName());
        row.add(String.valueOf(classroom.getCapacity()));

        model.addRow(row);
        
	}
	
}
