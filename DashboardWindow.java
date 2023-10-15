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
package com.sliit.gui.general;

//imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sliit.app.LoginWindow;
import com.sliit.entities.User;
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
		
		ImageIcon img = new ImageIcon("src/logo.png");
        frmDashboard.setIconImage(img.getImage());
		
		Border line = BorderFactory.createLineBorder(Color.black);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(10, 11, 1044, 108);
		panelHeader.setBorder(line);
		frmDashboard.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(368, 25, 121, 52);
		panelHeader.add(lblWelcome);
		
		JLabel lblUserName = new JLabel(user.getName());
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUserName.setBounds(488, 25, 363, 52);
		panelHeader.add(lblUserName);
		
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
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.black);
		panelLogo.setBounds(5, 5, 100, 100);
		panelHeader.add(panelLogo);
		panelLogo.setLayout(null);
		
		JPanel panelLogo2 = new JPanel();
		panelLogo2.setBounds(15, 15, 65, 65);
		panelLogo.add(panelLogo2);
		panelLogo2.setLayout(null);
		
		JLabel lblName1 = new JLabel("Western");
		lblName1.setBounds(2, 0, 46, 14);
		panelLogo2.add(lblName1);
		
		JLabel lblName2 = new JLabel("High");
		lblName2.setBounds(2, 11, 46, 14);
		panelLogo2.add(lblName2);
		
		JLabel lblName3 = new JLabel("School");
		lblName3.setBounds(2, 25, 46, 14);
		panelLogo2.add(lblName3);
		
		JPanel panelAccDetails = new JPanel();
		panelAccDetails.setBorder(line);
		panelAccDetails.setBounds(10, 130, 387, 540);
		frmDashboard.getContentPane().add(panelAccDetails);
		panelAccDetails.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(10, 11, 219, 39);
		panelAccDetails.add(lblNewLabel_1);
		
		JButton btnEditDetails = new JButton("Edit Details");
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
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(10, 82, 106, 39);
		panelAccDetails.add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(10, 132, 106, 39);
		panelAccDetails.add(lblName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(10, 182, 125, 39);
		panelAccDetails.add(lblPassword);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(10, 232, 167, 39);
		panelAccDetails.add(lblAccountType);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(10, 282, 106, 39);
		panelAccDetails.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(10, 332, 106, 39);
		panelAccDetails.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(10, 382, 106, 39);
		panelAccDetails.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(10, 432, 106, 39);
		panelAccDetails.add(lblGender);
		
		JLabel nameLabel_1 = new JLabel(user.getId());
		nameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_1.setBounds(63, 82, 314, 39);
		panelAccDetails.add(nameLabel_1);
		
		JLabel nameLabel_2 = new JLabel(user.getName());
		nameLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_2.setBounds(94, 132, 283, 39);
		panelAccDetails.add(nameLabel_2);
		
		JLabel nameLabel_3 = new JLabel(user.getPassword());
		nameLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_3.setBounds(130, 182, 247, 39);
		panelAccDetails.add(nameLabel_3);
		
		JLabel nameLabel_4 = new JLabel(user.getAccountType());
		nameLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_4.setBounds(172, 232, 205, 39);
		panelAccDetails.add(nameLabel_4);
		
		JLabel nameLabel_5 = new JLabel(user.getEmail());
		nameLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_5.setBounds(86, 282, 291, 39);
		panelAccDetails.add(nameLabel_5);
		
		JLabel nameLabel_6 = new JLabel(user.getContact());
		nameLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_6.setBounds(116, 332, 261, 39);
		panelAccDetails.add(nameLabel_6);
		
		JLabel nameLabel_7 = new JLabel(user.getAddress());
		nameLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_7.setBounds(116, 382, 261, 39);
		panelAccDetails.add(nameLabel_7);
		
		JLabel nameLabel_8 = new JLabel(user.getGender());
		nameLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_8.setBounds(105, 432, 272, 39);
		panelAccDetails.add(nameLabel_8);
		
		JPanel panelDashboard = new JPanel();
		panelDashboard.setBorder(line);
		panelDashboard.setBounds(407, 130, 647, 540);
		frmDashboard.getContentPane().add(panelDashboard);
		panelDashboard.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dashboard");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(10, 11, 226, 34);
		panelDashboard.add(lblNewLabel_2);
		
		JButton btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
				frmDashboard.dispose();
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClassroom.setBounds(10, 67, 169, 90);
		panelDashboard.add(btnClassroom);
		
		JButton btnExamination = new JButton("Examination");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExaminationWindow(user);
				frmDashboard.dispose();
			}
		});
		btnExamination.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnExamination.setBounds(246, 67, 169, 90);
		panelDashboard.add(btnExamination);
		
		JButton btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
				frmDashboard.dispose();
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLaboratory.setBounds(468, 67, 169, 90);
		panelDashboard.add(btnLaboratory);
		
		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmDashboard.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPrincipal.setBounds(10, 186, 169, 90);
		panelDashboard.add(btnPrincipal);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmDashboard.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnStudent.setBounds(246, 186, 169, 90);
		panelDashboard.add(btnStudent);
		
		JButton btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmDashboard.dispose();
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSubject.setBounds(468, 186, 169, 90);
		panelDashboard.add(btnSubject);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmDashboard.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTeacher.setBounds(121, 309, 169, 90);
		panelDashboard.add(btnTeacher);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmDashboard.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnUser.setBounds(355, 309, 169, 90);
		panelDashboard.add(btnUser);
		
		JButton btnContactSupport = new JButton("Contact Support");
		btnContactSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = "Name : Damith Bandara\nContact Number : 0701454289\nEmail : damithinduranga@gmail.com";
				JOptionPane.showInternalMessageDialog(null, value, "Contact Details", 1);
			}
		});
		btnContactSupport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContactSupport.setBounds(255, 479, 138, 39);
		panelDashboard.add(btnContactSupport);
	}
	
}