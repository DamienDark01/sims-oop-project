/*
 * Class Name : TeacherWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.gui.general;

// imports
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sliit.dao.TeacherDao;
import com.sliit.entity.Teacher;
import com.sliit.entity.User;
import com.sliit.gui.create.NewTeacherWindow;
import com.sliit.gui.update.EditTeacherWindow;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

// class implementation
public class TeacherWindow implements EntityWindow {

	// properties
	private JFrame frmTeacher;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnClassroom, btnExamination, btnUser, btnLaboratory, btnStudent, btnPrincipal, btnSearch, btnEditDetails, btnDeleteEntries, btnSubject, btnAddTeacher, btnRefresh;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<Teacher> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public TeacherWindow(User user) {
		initialize(user);
		
		// column nmaes
		columnNames = new Vector<>();
        columnNames.add("Teacher ID");
        columnNames.add("First Name");
        columnNames.add("Last Name");
        columnNames.add("Email");
        columnNames.add("Contact Number");
        columnNames.add("Qualification");
        columnNames.add("Subject");
        columnNames.add("Address");
        columnNames.add("Gender");

        // create table model
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

        // create table and scroll pane
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
		
        // showing items of the table
		itemList = TeacherDao.getAll();
		try {
			getTable(itemList);
		} catch (Exception exp) {
			JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(User user) {
		// frame methods
		frmTeacher = new JFrame();
		frmTeacher.setTitle("School Information Management System");
		frmTeacher.setBounds(10, 10, 1080, 720);
		frmTeacher.setVisible(true);
		frmTeacher.setResizable(false);
		frmTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeacher.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmTeacher.setIconImage(img.getImage());
		
        // header
		lblEntity = new JLabel("Teacher");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(133, 36, 198, 48);
		frmTeacher.getContentPane().add(lblEntity);
		
		// dashboard button
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(user);
				frmTeacher.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmTeacher.getContentPane().add(btnDashboard);
		
		// access other entity windows
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new ClassroomWindow(user);
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frmTeacher.getContentPane().add(btnClassroom);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new ExaminationWindow(user);
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frmTeacher.getContentPane().add(btnExamination);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new LaboratoryWindow(user);
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frmTeacher.getContentPane().add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new PrincipalWindow(user);
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmTeacher.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new StudentWindow(user);
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmTeacher.getContentPane().add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new SubjectWindow(user);
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frmTeacher.getContentPane().add(btnSubject);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeacher.dispose();
				new UserWindow(user);
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 611, 181, 48);
		frmTeacher.getContentPane().add(btnUser);
		
		// search input
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 404, 48);
		frmTeacher.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		// select search criteria
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Name");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(662, 127, 155, 48);
		frmTeacher.getContentPane().add(comboBoxSelect);
		
		// search button
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = comboBoxSelect.getSelectedIndex();
				String searchInput = txtEnterTheValue.getText();
				
				if (searchInput.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text to search!", "Error", 0);
				} else {
					if (selectedItem == 0) {
						Teacher teacher = TeacherDao.getById(searchInput);
						
						try {
							getTable(teacher);
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
						}
					} else {
						itemList = TeacherDao.getByName(searchInput);
						
						try {
							getTable(itemList);
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
						}
					}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frmTeacher.getContentPane().add(btnSearch);
		
		// user info
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmTeacher.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmTeacher.getContentPane().add(lblAccType);
		
		// edit
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmTeacher.getContentPane().add(lblEdit);
		
		// add button
		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewTeacherWindow();
			}
		});
		btnAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddTeacher.setBounds(302, 198, 199, 48);
		frmTeacher.getContentPane().add(btnAddTeacher);
		
		// edit button
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditTeacherWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(567, 198, 199, 48);
		frmTeacher.getContentPane().add(btnEditDetails);
		
		// delete button
		btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// confirm prompt
				int input = JOptionPane.showConfirmDialog(null, "Confirm Deletion?\\n(Warning : Edit references before deleting!)", "Delete Entries", 0);
				int deletedRowCount = 0;

				// if input is yes
				if (input == 0) {
					// delete the rows inside table model
					for (int row=0; row<model.getRowCount(); row++) {
						String idValue = (String) model.getValueAt(row, 0);
						deletedRowCount += TeacherDao.getDeleteConfirmation(idValue);
					}
					
					// display the number of deleted entries
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmTeacher.getContentPane().add(btnDeleteEntries);
		
		// logo
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 7, 100, 100);
		frmTeacher.getContentPane().add(panelLogo);
		
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
		
		// refresh button
		btnRefresh = new JButton("Load/Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList = TeacherDao.getAll();
				
				try {
					getTable(itemList);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
				}
			}
		});
		btnRefresh.setBounds(341, 51, 110, 33);
		frmTeacher.getContentPane().add(btnRefresh);
	}
	
	// retrieve table method for many items
	public <E> void getTable(ArrayList<E> itemList) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmTeacher.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add items in list to rows
        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((Teacher) item).getId());
            row.add(((Teacher) item).getFirstName());
            row.add(((Teacher) item).getLastName());
            row.add(((Teacher) item).getEmail());
            row.add(((Teacher) item).getContact());
            row.add(((Teacher) item).getQualification());
            row.add(((Teacher) item).getSubject().getName());
            row.add(((Teacher) item).getAddress());
            row.add(((Teacher) item).getGender());

            // add row to table model
            model.addRow(row);
        }
	}
	
	// retrieve table method for one item
	public <E> void getTable(Teacher teacher) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmTeacher.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add info in object to row
        Vector<String> row = new Vector<>();
        row.add(teacher.getId());
        row.add(teacher.getFirstName());
        row.add(teacher.getLastName());
        row.add(teacher.getEmail());
        row.add(teacher.getContact());
        row.add(teacher.getQualification());
        row.add(teacher.getSubject().getName());
        row.add(teacher.getAddress());
        row.add(teacher.getGender());

        // add row to table model
        model.addRow(row);
	}

}
