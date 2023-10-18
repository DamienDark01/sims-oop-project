/*
 * Class Name : NewTeacherWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package com.sliit.gui.create;

// imports
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.sliit.dao.TeacherDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewTeacherWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtFName, txtLName, txtEmail, txtContact, txtSubject, txtAddress, txtGender, txtQualification;
	private JLabel lblHeader, lblId, lblFName, lblLName, lblEmail, lblName1, lblName2, lblName3, lblContact, lblSubject, lblAddress, lblGender, lblQualification;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;

	/**
	 * Create the application.
	 */
	public NewTeacherWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("src/logo.png");
        frmAddValues.setIconImage(img.getImage());
		
		lblHeader = new JLabel("Add new values to Teacher");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblFName = new JLabel("First Name :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 122, 125, 39);
		frmAddValues.getContentPane().add(lblFName);
		
		lblLName = new JLabel("Last Name :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblLName);
		
		lblSubject = new JLabel("Subject Name :");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSubject.setBounds(69, 222, 175, 39);
		frmAddValues.getContentPane().add(lblSubject);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 272, 106, 39);
		frmAddValues.getContentPane().add(lblEmail);
		
		lblContact = new JLabel("Contact No :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(69, 322, 138, 39);
		frmAddValues.getContentPane().add(lblContact);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(69, 422, 106, 39);
		frmAddValues.getContentPane().add(lblAddress);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(69, 472, 106, 39);
		frmAddValues.getContentPane().add(lblGender);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String subject = txtSubject.getText();
				String email = txtEmail.getText();
				String contact = txtContact.getText();
				String qualification = txtQualification.getText();
				String address = txtAddress.getText();
				String gender = txtGender.getText();
				
				int addedEntries = TeacherDao.getAddConfirmation(id, fName, lName, subject, email, contact, qualification, address, gender);
				txtResult.setText(addedEntries + " entry/entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(254, 533, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 583, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
		lblQualification = new JLabel("Qualification :");
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblQualification.setBounds(69, 372, 158, 39);
		frmAddValues.getContentPane().add(lblQualification);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(534, 0, 100, 100);
		frmAddValues.getContentPane().add(panelLogo);
		
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
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(204, 127, 290, 34);
		frmAddValues.getContentPane().add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(204, 177, 290, 34);
		frmAddValues.getContentPane().add(txtLName);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubject.setColumns(10);
		txtSubject.setBounds(243, 227, 290, 34);
		frmAddValues.getContentPane().add(txtSubject);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 277, 290, 34);
		frmAddValues.getContentPane().add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(204, 327, 290, 34);
		frmAddValues.getContentPane().add(txtContact);
		
		txtQualification = new JTextField();
		txtQualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtQualification.setColumns(10);
		txtQualification.setBounds(214, 377, 290, 34);
		frmAddValues.getContentPane().add(txtQualification);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(173, 427, 290, 34);
		frmAddValues.getContentPane().add(txtAddress);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBounds(162, 477, 290, 34);
		frmAddValues.getContentPane().add(txtGender);
	}

}
