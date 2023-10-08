/*
 * Class Name : StudentWindow
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;

// class implementation
class StudentWindow {

	// properties
	private JFrame frame;
	private JTable table;
	private JTextField txtEnterTheValue;

	/**
	 * Create the application.
	 */
	public StudentWindow(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frame = new JFrame();
		frame.setTitle("School Information Management System");
		frame.setBounds(10, 10, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(133, 36, 198, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 127, 181, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ClassroomWindow(user);
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frame.getContentPane().add(btnClassroom);
		
		JButton btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ExaminationWindow(user);
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExamination.setBounds(10, 316, 181, 48);
		frame.getContentPane().add(btnExamination);
		
		JButton btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LaboratoryWindow(user);
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frame.getContentPane().add(btnLaboratory);
		
		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PrincipalWindow(user);
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frame.getContentPane().add(btnPrincipal);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserWindow(user);
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 493, 181, 48);
		frame.getContentPane().add(btnUser);
		
		JButton btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SubjectWindow(user);
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frame.getContentPane().add(btnSubject);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new TeacherWindow(user);
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frame.getContentPane().add(btnTeacher);
		
		table = new JTable();
		table.setBounds(240, 257, 774, 402);
		frame.getContentPane().add(table);
		
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(252, 127, 393, 48);
		frame.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Select an option ...");
		comboBox.setName("");
		comboBox.setBounds(662, 127, 155, 48);
		frame.getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("User Name : " + user.getName());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(690, 11, 253, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Account type : " + user.getAccountType());
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(690, 49, 253, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Edit :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(241, 204, 63, 37);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new NewStudentWindow();
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddStudent.setBounds(302, 198, 199, 48);
		frame.getContentPane().add(btnAddStudent);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(559, 198, 199, 48);
		frame.getContentPane().add(btnEditDetails);
		
		JButton btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(815, 198, 199, 48);
		frame.getContentPane().add(btnDeleteEntries);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 11, 100, 100);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(15, 15, 65, 65);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Western");
		lblNewLabel_3.setBounds(2, 0, 46, 14);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("High");
		lblNewLabel_3_1.setBounds(2, 11, 46, 14);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("School");
		lblNewLabel_3_2.setBounds(2, 25, 46, 14);
		panel_4.add(lblNewLabel_3_2);
	}

}
