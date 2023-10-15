/*
 * Class Name : LaboratoryWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package project;

// imports
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

import java.awt.BorderLayout;
import java.awt.Color;

// class implementation
public class LaboratoryWindow implements EntityWindow {

	// properties
	private JFrame frmLaboratory;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnClassroom, btnExamination, btnUser, btnPrincipal, btnStudent, btnTeacher, btnSearch, btnEditDetails, btnDeleteEntries, btnSubject, btnAddLab, btnRefresh;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<Laboratory> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public LaboratoryWindow(User user) {
		initialize(user);
		
		columnNames = new Vector<>();
        columnNames.add("Laboratory ID");
        columnNames.add("Purpose");
        columnNames.add("Location");
        columnNames.add("Lab Instructor");

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
		
		itemList = LaboratoryDao.getAll();
		getTable(itemList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(User user) {
		frmLaboratory = new JFrame();
		frmLaboratory.setTitle("School Information Management System");
		frmLaboratory.setBounds(10, 10, 1080, 720);
		frmLaboratory.setVisible(true);
		frmLaboratory.setResizable(false);
		frmLaboratory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaboratory.getContentPane().setLayout(null);
		
		lblEntity = new JLabel("Laboratory");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(134, 36, 198, 48);
		frmLaboratory.getContentPane().add(lblEntity);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmLaboratory.getContentPane().add(btnDashboard);
		
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frmLaboratory.getContentPane().add(btnClassroom);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frmLaboratory.getContentPane().add(btnExamination);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 375, 181, 48);
		frmLaboratory.getContentPane().add(btnUser);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmLaboratory.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmLaboratory.getContentPane().add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubjectWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frmLaboratory.getContentPane().add(btnSubject);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmLaboratory.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frmLaboratory.getContentPane().add(btnTeacher);
		
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 404, 48);
		frmLaboratory.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Purpose");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(662, 127, 155, 48);
		frmLaboratory.getContentPane().add(comboBoxSelect);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = comboBoxSelect.getSelectedIndex();
				String searchInput = txtEnterTheValue.getText();
				
				if (searchInput.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text to search!", "Error", 0);
				} else {
					if (selectedItem == 0) {
						Laboratory lab = LaboratoryDao.getById(searchInput);
						getTable(lab);
					} else {
						itemList = LaboratoryDao.getByPurpose(searchInput);
						getTable(itemList);
					}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frmLaboratory.getContentPane().add(btnSearch);
		
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmLaboratory.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmLaboratory.getContentPane().add(lblAccType);
		
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmLaboratory.getContentPane().add(lblEdit);
		
		btnAddLab = new JButton("Add Laboratory");
		btnAddLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewLaboratoryWindow();
				frmLaboratory.dispose();
			}
		});
		btnAddLab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddLab.setBounds(302, 198, 199, 48);
		frmLaboratory.getContentPane().add(btnAddLab);
		
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditLaboratoryWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(565, 198, 199, 48);
		frmLaboratory.getContentPane().add(btnEditDetails);
		
		btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Confirm Deletion?", "Delete Entries", 0);
				int deletedRowCount = 0;

				if (input == 0) {
					for (int row=0; row<model.getRowCount(); row++) {
						String idValue = (String) model.getValueAt(row, 0);
						deletedRowCount += LaboratoryDao.getDeleteConfirmation(idValue);
					}
					
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmLaboratory.getContentPane().add(btnDeleteEntries);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 11, 100, 100);
		frmLaboratory.getContentPane().add(panelLogo);
		
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
				itemList = LaboratoryDao.getAll();
				getTable(itemList);
			}
		});
		btnRefresh.setBounds(342, 51, 110, 33);
		frmLaboratory.getContentPane().add(btnRefresh);
	}
	
	public <E> void getTable(ArrayList<E> itemList) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmLaboratory.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((Laboratory) item).getId());
            row.add(((Laboratory) item).getPurpose());
            row.add(((Laboratory) item).getLocation());
            row.add(((Laboratory) item).getTeacher().getFirstName() + " " + ((Laboratory) item).getTeacher().getLastName());
            row.add(((Laboratory) item).getLocation());

            model.addRow(row);
        }
	}
	
	public void getTable(Laboratory lab) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmLaboratory.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        Vector<String> row = new Vector<>();
        row.add(lab.getId());
        row.add(lab.getPurpose());
        row.add(lab.getLocation());
        row.add(lab.getTeacher().getFirstName() + " " + lab.getTeacher().getLastName());
        row.add(lab.getLocation());

        model.addRow(row);
	}

}
