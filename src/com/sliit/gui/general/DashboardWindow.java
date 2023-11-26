/*
 * Class Name : DashboardWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.gui.general;

//imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sliit.app.LoginWindow;
import com.sliit.entity.User;
import com.sliit.gui.update.EditUserWindow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//class implementation
public class DashboardWindow {

	// properties
	private JFrame frmDashboard;
	private ImageIcon img;
	private JPanel panelHeader, panelLogo, panelLogo2, panelAccDetails, panelDashboard;
	private JLabel lblId, lblWelcome, lblUserName, lblAddress, lblGender, lblName1, lblName2, lblNewLabel_1, lblName, lblPassword, nameLabel_1, nameLabel_2, nameLabel_3, nameLabel_4, nameLabel_5, nameLabel_6, nameLabel_7, nameLabel_8;
	private JLabel lblAccountType;
	private JLabel lblEmail, lblNewLabel_2, lblName3;
	private JLabel lblContact;
	private JButton btnClassroom, btnExamination, btnLaboratory, btnPrincipal, btnStudent, btnSubject, btnTeacher, btnUser, btnContactSupport, btnEditDetails;      

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
		// frame methods
		frmDashboard = new JFrame();
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setVisible(true);
		frmDashboard.setResizable(false);
		frmDashboard.setBounds(10, 10, 1080, 720);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmDashboard.setIconImage(img.getImage());
		
        // border
		Border line = BorderFactory.createLineBorder(Color.black);
		
		// header
		panelHeader = new JPanel();
		panelHeader.setBounds(10, 11, 1044, 108);
		panelHeader.setBorder(line);
		frmDashboard.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(368, 25, 121, 52);
		panelHeader.add(lblWelcome);
		
		lblUserName = new JLabel(user.getName());
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUserName.setBounds(488, 25, 363, 52);
		panelHeader.add(lblUserName);
		
		// logout button
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginWindow();
				frmDashboard.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(861, 36, 138, 39);
		panelHeader.add(btnLogout);
		
		// logo
		panelLogo = new JPanel();
		panelLogo.setBackground(Color.black);
		panelLogo.setBounds(5, 5, 100, 100);
		panelHeader.add(panelLogo);
		panelLogo.setLayout(null);
		
		panelLogo2 = new JPanel();
		panelLogo2.setBounds(15, 15, 65, 65);
		panelLogo.add(panelLogo2);
		panelLogo2.setLayout(null);
		
		lblName1 = new JLabel("Western");
		lblName1.setBounds(2, 0, 46, 14);
		panelLogo2.add(lblName1);
		
		lblName2 = new JLabel("High");
		lblName2.setBounds(2, 11, 46, 14);
		panelLogo2.add(lblName2);
		
		lblName3 = new JLabel("School");
		lblName3.setBounds(2, 25, 46, 14);
		panelLogo2.add(lblName3);
		
		// account details panel
		panelAccDetails = new JPanel();
		panelAccDetails.setBorder(line);
		panelAccDetails.setBounds(10, 130, 387, 540);
		frmDashboard.getContentPane().add(panelAccDetails);
		panelAccDetails.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Account Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(10, 11, 219, 39);
		panelAccDetails.add(lblNewLabel_1);
		
		// edit details button
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> itemList = new ArrayList<User>();
				itemList.add(user);
				
				new EditUserWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditDetails.setBounds(116, 490, 138, 39);
		panelAccDetails.add(btnEditDetails);
		
		// account details
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(10, 82, 106, 39);
		panelAccDetails.add(lblId);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(10, 132, 106, 39);
		panelAccDetails.add(lblName);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(10, 182, 125, 39);
		panelAccDetails.add(lblPassword);
		
		lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(10, 232, 167, 39);
		panelAccDetails.add(lblAccountType);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(10, 282, 106, 39);
		panelAccDetails.add(lblEmail);
		
		lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(10, 332, 106, 39);
		panelAccDetails.add(lblContact);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(10, 382, 106, 39);
		panelAccDetails.add(lblAddress);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(10, 432, 106, 39);
		panelAccDetails.add(lblGender);
		
		nameLabel_1 = new JLabel(user.getId());
		nameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_1.setBounds(63, 82, 314, 39);
		panelAccDetails.add(nameLabel_1);
		
		nameLabel_2 = new JLabel(user.getName());
		nameLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_2.setBounds(94, 132, 283, 39);
		panelAccDetails.add(nameLabel_2);
		
		nameLabel_3 = new JLabel(user.getPassword());
		nameLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_3.setBounds(130, 182, 247, 39);
		panelAccDetails.add(nameLabel_3);
		
		nameLabel_4 = new JLabel(user.getAccountType());
		nameLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_4.setBounds(172, 232, 205, 39);
		panelAccDetails.add(nameLabel_4);
		
		nameLabel_5 = new JLabel(user.getEmail());
		nameLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_5.setBounds(86, 282, 291, 39);
		panelAccDetails.add(nameLabel_5);
		
		nameLabel_6 = new JLabel(user.getContact());
		nameLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_6.setBounds(116, 332, 261, 39);
		panelAccDetails.add(nameLabel_6);
		
		nameLabel_7 = new JLabel(user.getAddress());
		nameLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_7.setBounds(116, 382, 261, 39);
		panelAccDetails.add(nameLabel_7);
		
		nameLabel_8 = new JLabel(user.getGender());
		nameLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_8.setBounds(105, 432, 272, 39);
		panelAccDetails.add(nameLabel_8);
		
		panelDashboard = new JPanel();
		panelDashboard.setBorder(line);
		panelDashboard.setBounds(407, 130, 647, 540);
		frmDashboard.getContentPane().add(panelDashboard);
		panelDashboard.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Dashboard");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(10, 11, 226, 34);
		panelDashboard.add(lblNewLabel_2);
		
		// buttons to access entities
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
				frmDashboard.dispose();
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClassroom.setBounds(10, 67, 169, 90);
		panelDashboard.add(btnClassroom);
		
		btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
				frmDashboard.dispose();
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnExamination.setBounds(246, 67, 169, 90);
		panelDashboard.add(btnExamination);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
				frmDashboard.dispose();
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLaboratory.setBounds(468, 67, 169, 90);
		panelDashboard.add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmDashboard.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPrincipal.setBounds(10, 186, 169, 90);
		panelDashboard.add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmDashboard.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnStudent.setBounds(246, 186, 169, 90);
		panelDashboard.add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubjectWindow(user);
				frmDashboard.dispose();
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSubject.setBounds(468, 186, 169, 90);
		panelDashboard.add(btnSubject);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmDashboard.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTeacher.setBounds(121, 309, 169, 90);
		panelDashboard.add(btnTeacher);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmDashboard.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnUser.setBounds(355, 309, 169, 90);
		panelDashboard.add(btnUser);
		
		// contact support button
		btnContactSupport = new JButton("Contact Support");
		btnContactSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = "Name : Damith Bandara\nContact Number : 0701454289\nEmail : damithinduranga@gmail.com";
				JOptionPane.showInternalMessageDialog(null, value, "Contact Details", 1);
			}
		});
		btnContactSupport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContactSupport.setBounds(246, 479, 160, 39);
		panelDashboard.add(btnContactSupport);
	}
	
}