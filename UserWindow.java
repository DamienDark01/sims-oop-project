/*
 * Class Name : UserWindow
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

import com.sliit.dao.UserDao;
import com.sliit.entities.User;
import com.sliit.gui.create.NewUserWindow;
import com.sliit.gui.update.EditUserWindow;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

// class implementation
public class UserWindow implements EntityWindow {

	// properties
	private JFrame frmUser;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnClassroom, btnExamination, btnPrincipal, btnLaboratory, btnStudent, btnTeacher, btnSearch, btnEditDetails, btnDeleteEntries, btnSubject, btnAddUser, btnRefresh;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<User> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public UserWindow(User user) {
		initialize(user);
		
		columnNames = new Vector<>();
        columnNames.add("User ID");
        columnNames.add("User Name");
        columnNames.add("Password");
        columnNames.add("Account Type");
        columnNames.add("Email");
        columnNames.add("Contact Number");
        columnNames.add("Address");
        columnNames.add("Gender");

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
		
		itemList = UserDao.getAll();
		getTable(itemList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(User user) {
		frmUser = new JFrame();
		frmUser.setTitle("School Information Management System");
		frmUser.setBounds(10, 10, 1080, 720);
		frmUser.setVisible(true);
		frmUser.setResizable(false);
		frmUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUser.getContentPane().setLayout(null);
		
		lblEntity = new JLabel("User");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(132, 38, 198, 48);
		frmUser.getContentPane().add(lblEntity);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// in case of an update, a new user object is created and details are retrieved
				User newUser = UserDao.getById(user.getId());
				new DashboardWindow(newUser);
				frmUser.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmUser.getContentPane().add(btnDashboard);
		
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new ClassroomWindow(user);
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frmUser.getContentPane().add(btnClassroom);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new ExaminationWindow(user);
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frmUser.getContentPane().add(btnExamination);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new LaboratoryWindow(user);
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frmUser.getContentPane().add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new PrincipalWindow(user);
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmUser.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new StudentWindow(user);
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmUser.getContentPane().add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new SubjectWindow(user);
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frmUser.getContentPane().add(btnSubject);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUser.dispose();
				new TeacherWindow(user);
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frmUser.getContentPane().add(btnTeacher);
		
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 404, 48);
		frmUser.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Name");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(662, 127, 155, 48);
		frmUser.getContentPane().add(comboBoxSelect);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = comboBoxSelect.getSelectedIndex();
				String searchInput = txtEnterTheValue.getText();
				
				if (searchInput.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text to search!", "Error", 0);
				} else {
					if (selectedItem == 0) {
						User user = UserDao.getById(searchInput);
						getTable(user);
					} else {
						itemList = UserDao.getByName(searchInput);
						getTable(itemList);
					}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frmUser.getContentPane().add(btnSearch);
		
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmUser.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmUser.getContentPane().add(lblAccType);
		
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmUser.getContentPane().add(lblEdit);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewUserWindow();
			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddUser.setBounds(302, 198, 199, 48);
		frmUser.getContentPane().add(btnAddUser);
		
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditUserWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(575, 198, 199, 48);
		frmUser.getContentPane().add(btnEditDetails);
		
		btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Confirm Deletion?", "Delete Entries", 0);
				int deletedRowCount = 0;

				if (input == 0) {
					for (int row=0; row<model.getRowCount(); row++) {
						String idValue = (String) model.getValueAt(row, 0);
						deletedRowCount += UserDao.getDeleteConfirmation(idValue);
					}
					
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmUser.getContentPane().add(btnDeleteEntries);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 11, 100, 100);
		frmUser.getContentPane().add(panelLogo);
		
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
				itemList = UserDao.getAll();
				getTable(itemList);
			}
		});
		btnRefresh.setBounds(340, 53, 110, 33);
		frmUser.getContentPane().add(btnRefresh);
	}
	
	public <E> void getTable(ArrayList<E> itemList) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmUser.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((User) item).getId());
            row.add(((User) item).getName());
            row.add(((User) item).getPassword());
            row.add(((User) item).getAccountType());
            row.add(((User) item).getEmail());
            row.add(((User) item).getContact());
            row.add(((User) item).getAddress());
            row.add(((User) item).getGender());

            model.addRow(row);
        }
	}
	
	public void getTable(User user) {
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmUser.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        Vector<String> row = new Vector<>();
        row.add(user.getId());
        row.add(user.getName());
        row.add(user.getPassword());
        row.add(user.getAccountType());
        row.add(user.getEmail());
        row.add(user.getContact());
        row.add(user.getAddress());
        row.add(user.getGender());

        model.addRow(row);
	}

}
