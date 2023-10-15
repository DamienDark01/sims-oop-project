/*
 * Class Name : NewPrincipalWindow
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.sliit.dao.PrincipalDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewPrincipalWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtFName, txtLName, txtEmail, txtContact, txtPosition, txtAddress, txtGender;
	private JLabel lblHeader, lblId, lblFName, lblLName, lblEmail, lblName1, lblName2, lblName3, lblContact, lblPosition, lblAddress, lblGender;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;

	/**
	 * Create the application.
	 */
	public NewPrincipalWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		lblHeader = new JLabel("Add new values to Principal");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblFName = new JLabel("First Name :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 122, 138, 39);
		frmAddValues.getContentPane().add(lblFName);
		
		lblLName = new JLabel("Last Name :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblLName);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblEmail);
		
		lblContact = new JLabel("Contact No :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(69, 272, 146, 39);
		frmAddValues.getContentPane().add(lblContact);
		
		lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPosition.setBounds(69, 322, 106, 39);
		frmAddValues.getContentPane().add(lblPosition);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(69, 372, 106, 39);
		frmAddValues.getContentPane().add(lblAddress);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(69, 422, 106, 39);
		frmAddValues.getContentPane().add(lblGender);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String email = txtEmail.getText();
				String contact = txtContact.getText();
				String position = txtPosition.getText();
				String address = txtAddress.getText();
				String gender = txtGender.getText();
				
				int addedEntries = PrincipalDao.getAddConfirmation(id, fName, lName, email, contact, position, address, gender);
				txtResult.setText(addedEntries + " entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(267, 509, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
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
		txtFName.setBounds(202, 127, 290, 34);
		frmAddValues.getContentPane().add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(202, 177, 290, 34);
		frmAddValues.getContentPane().add(txtLName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 227, 290, 34);
		frmAddValues.getContentPane().add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(202, 277, 290, 34);
		frmAddValues.getContentPane().add(txtContact);
		
		txtPosition = new JTextField();
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPosition.setColumns(10);
		txtPosition.setBounds(173, 327, 290, 34);
		frmAddValues.getContentPane().add(txtPosition);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(173, 377, 290, 34);
		frmAddValues.getContentPane().add(txtAddress);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBounds(173, 427, 290, 34);
		frmAddValues.getContentPane().add(txtGender);
	}

}
