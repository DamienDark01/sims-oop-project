/*
 * Class Name : SubjectWindow
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

import com.sliit.dao.SubjectDao;
import com.sliit.entity.Subject;
import com.sliit.entity.User;
import com.sliit.gui.create.NewSubjectWindow;
import com.sliit.gui.update.EditSubjectWindow;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

// class implementation
public class SubjectWindow implements EntityWindow {

	// properties
	private JFrame frmSubject;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnClassroom, btnExamination, btnUser, btnLaboratory, btnStudent, btnTeacher, btnSearch, btnEditDetails, btnDeleteEntries, btnPrincipal, btnAddSubject, btnRefresh;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<Subject> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public SubjectWindow(User user) {
		initialize(user);
		
		// column names
		columnNames = new Vector<>();
        columnNames.add("Subject ID");
        columnNames.add("Subject Name");
        columnNames.add("Number of Modules");

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
		itemList = SubjectDao.getAll();
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
		frmSubject = new JFrame();
		frmSubject.setTitle("School Information Management System");
		frmSubject.setBounds(10, 10, 1080, 720);
		frmSubject.setVisible(true);
		frmSubject.setResizable(false);
		frmSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubject.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmSubject.setIconImage(img.getImage());
		
        // header
		lblEntity = new JLabel("Subject");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(133, 36, 198, 48);
		frmSubject.getContentPane().add(lblEntity);
		
		// dashboard button
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(user);
				frmSubject.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmSubject.getContentPane().add(btnDashboard);
		
		// access other entity windows
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
				frmSubject.dispose();
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frmSubject.getContentPane().add(btnClassroom);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
				frmSubject.dispose();
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frmSubject.getContentPane().add(btnExamination);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
				frmSubject.dispose();
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frmSubject.getContentPane().add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmSubject.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmSubject.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmSubject.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmSubject.getContentPane().add(btnStudent);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmSubject.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 552, 181, 48);
		frmSubject.getContentPane().add(btnUser);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmSubject.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frmSubject.getContentPane().add(btnTeacher);
		
		// search input
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 404, 48);
		frmSubject.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		// select search criteria
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Name");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(662, 127, 155, 48);
		frmSubject.getContentPane().add(comboBoxSelect);
		
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
						Subject sub = SubjectDao.getById(searchInput);
						
						try {
							getTable(sub);
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
						}
					} else {
						itemList = SubjectDao.getByName(searchInput);
						
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
		frmSubject.getContentPane().add(btnSearch);
		
		// user info
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmSubject.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmSubject.getContentPane().add(lblAccType);
		
		// edit
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmSubject.getContentPane().add(lblEdit);
		
		// add button
		btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewSubjectWindow();
			}
		});
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddSubject.setBounds(302, 198, 199, 48);
		frmSubject.getContentPane().add(btnAddSubject);
		
		// edit button
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditSubjectWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(576, 198, 199, 48);
		frmSubject.getContentPane().add(btnEditDetails);
		
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
						deletedRowCount += SubjectDao.getDeleteConfirmation(idValue);
					}
					
					// display the number of deleted entries
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmSubject.getContentPane().add(btnDeleteEntries);
		
		// logo
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 11, 100, 100);
		frmSubject.getContentPane().add(panelLogo);
		
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
				itemList = SubjectDao.getAll();
				
				try {
					getTable(itemList);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
				}
			}
		});
		btnRefresh.setBounds(341, 51, 110, 33);
		frmSubject.getContentPane().add(btnRefresh);
	}
	
	// retrieve table method for many items
	public <E> void getTable(ArrayList<E> itemList) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmSubject.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add items in list to rows
        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((Subject) item).getId());
            row.add(((Subject) item).getName());
            row.add(String.valueOf(((Subject) item).getNoOfModules()));
            
            // add row to table model
            model.addRow(row);
        }
	}
	
	// retrieve table method for one item
	public <E> void getTable(Subject sub) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmSubject.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add info in object to row
        Vector<String> row = new Vector<>();
        row.add(sub.getId());
        row.add(sub.getName());
        row.add(String.valueOf(sub.getNoOfModules()));
        
        // add row to table model
        model.addRow(row);
	}

}
