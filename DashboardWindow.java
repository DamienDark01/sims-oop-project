/*
 * Class Name : DashboardWindow
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

//imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//class implementation
class DashboardWindow {

	// properties
	private JFrame frmDashboard;

	/**
	 * Create the application.
	 */
	public DashboardWindow(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frmDashboard = new JFrame();
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setVisible(true);
		frmDashboard.setResizable(false);
		frmDashboard.setBounds(10, 10, 1080, 720);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		
		Border line = BorderFactory.createLineBorder(Color.black);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1044, 108);
		panel.setBorder(line);
		frmDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome, ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(368, 25, 121, 52);
		panel.add(lblNewLabel);
		
		JLabel nameLabel = new JLabel(user.getName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		nameLabel.setBounds(488, 25, 363, 52);
		panel.add(nameLabel);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDashboard.dispose();
				new LoginWindow();
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutBtn.setBounds(861, 36, 138, 39);
		panel.add(logoutBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.black);
		panel_3.setBounds(5, 5, 100, 100);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(15, 15, 65, 65);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Western");
		lblNewLabel_3.setBounds(2, 0, 46, 14);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("High");
		lblNewLabel_3_1.setBounds(2, 11, 46, 14);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("School");
		lblNewLabel_3_2.setBounds(2, 25, 46, 14);
		panel_4.add(lblNewLabel_3_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(line);
		panel_1.setBounds(10, 130, 387, 540);
		frmDashboard.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(10, 11, 219, 39);
		panel_1.add(lblNewLabel_1);
		
		JButton editDetails = new JButton("Edit Details");
		editDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editDetails.setBounds(116, 490, 138, 39);
		panel_1.add(editDetails);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(10, 82, 106, 39);
		panel_1.add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(10, 132, 106, 39);
		panel_1.add(lblName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(10, 182, 125, 39);
		panel_1.add(lblPassword);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(10, 232, 167, 39);
		panel_1.add(lblAccountType);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(10, 282, 106, 39);
		panel_1.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(10, 332, 106, 39);
		panel_1.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(10, 382, 106, 39);
		panel_1.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(10, 432, 106, 39);
		panel_1.add(lblGender);
		
		JLabel nameLabel_1 = new JLabel(user.getId());
		nameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_1.setBounds(63, 82, 314, 39);
		panel_1.add(nameLabel_1);
		
		JLabel nameLabel_2 = new JLabel(user.getName());
		nameLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_2.setBounds(94, 132, 283, 39);
		panel_1.add(nameLabel_2);
		
		JLabel nameLabel_3 = new JLabel(user.getPassword());
		nameLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_3.setBounds(130, 182, 247, 39);
		panel_1.add(nameLabel_3);
		
		JLabel nameLabel_4 = new JLabel(user.getAccountType());
		nameLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_4.setBounds(172, 232, 205, 39);
		panel_1.add(nameLabel_4);
		
		JLabel nameLabel_5 = new JLabel(user.getEmail());
		nameLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_5.setBounds(86, 282, 291, 39);
		panel_1.add(nameLabel_5);
		
		JLabel nameLabel_6 = new JLabel(user.getContact());
		nameLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_6.setBounds(116, 332, 261, 39);
		panel_1.add(nameLabel_6);
		
		JLabel nameLabel_7 = new JLabel(user.getAddress());
		nameLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_7.setBounds(116, 382, 261, 39);
		panel_1.add(nameLabel_7);
		
		JLabel nameLabel_8 = new JLabel(user.getGender());
		nameLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_8.setBounds(105, 432, 272, 39);
		panel_1.add(nameLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(line);
		panel_2.setBounds(407, 130, 647, 540);
		frmDashboard.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dashboard");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(10, 11, 226, 34);
		panel_2.add(lblNewLabel_2);
		
		JButton btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClassroom.setBounds(10, 67, 169, 90);
		panel_2.add(btnClassroom);
		
		JButton btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnExamination.setBounds(246, 67, 169, 90);
		panel_2.add(btnExamination);
		
		JButton btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLaboratory.setBounds(468, 67, 169, 90);
		panel_2.add(btnLaboratory);
		
		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPrincipal.setBounds(10, 186, 169, 90);
		panel_2.add(btnPrincipal);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnStudent.setBounds(246, 186, 169, 90);
		panel_2.add(btnStudent);
		
		JButton btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSubject.setBounds(468, 186, 169, 90);
		panel_2.add(btnSubject);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTeacher.setBounds(121, 309, 169, 90);
		panel_2.add(btnTeacher);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnUser.setBounds(355, 309, 169, 90);
		panel_2.add(btnUser);
		
		JButton btnContactSupport = new JButton("Contact Support");
		btnContactSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = "Name : Damith Bandara\nContact Number : 0701454289\nEmail : damithinduranga@gmail.com";
				JOptionPane.showInternalMessageDialog(null, value, "Contact Details", 1);
			}
		});
		btnContactSupport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContactSupport.setBounds(255, 479, 138, 39);
		panel_2.add(btnContactSupport);
	}
	
}