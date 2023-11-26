/*
 * Class Name : NewUserWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
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

import com.sliit.dao.UserDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewUserWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtName, txtPassword, txtEmail, txtContact, txtAccType, txtAddress, txtGender;
	private JLabel lblHeader, lblId, lblName, lblPassword, lblEmail, lblName1, lblName2, lblName3, lblContact, lblAccountType, lblAddress, lblGender;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public NewUserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// frame methods
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmAddValues.setIconImage(img.getImage());
		
        // header
		lblHeader = new JLabel("Add new values to User");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		// input prompts
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 106, 39);
		frmAddValues.getContentPane().add(lblName);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblPassword);
		
		lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblAccountType);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 272, 106, 39);
		frmAddValues.getContentPane().add(lblEmail);
		
		lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(69, 322, 106, 39);
		frmAddValues.getContentPane().add(lblContact);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(69, 372, 106, 39);
		frmAddValues.getContentPane().add(lblAddress);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(69, 422, 106, 39);
		frmAddValues.getContentPane().add(lblGender);
		
		// enter details button
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String password = txtPassword.getText();
				String email = txtEmail.getText();
				String contact = txtContact.getText();
				String accType = txtAccType.getText();
				String address = txtAddress.getText();
				String gender = txtGender.getText();
				
				int addedEntries = UserDao.getAddConfirmation(id, name, password, email, contact, accType, address, gender);
				txtResult.setText(addedEntries + " entry/entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(240, 509, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		// show results
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
		// logo
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
		
		// taking inputs
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(150, 127, 290, 34);
		frmAddValues.getContentPane().add(txtName);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(185, 177, 290, 34);
		frmAddValues.getContentPane().add(txtPassword);
		
		txtAccType = new JTextField();
		txtAccType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAccType.setColumns(10);
		txtAccType.setBounds(232, 227, 290, 34);
		frmAddValues.getContentPane().add(txtAccType);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(150, 277, 290, 34);
		frmAddValues.getContentPane().add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(172, 327, 290, 34);
		frmAddValues.getContentPane().add(txtContact);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(172, 377, 290, 34);
		frmAddValues.getContentPane().add(txtAddress);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBounds(172, 427, 290, 34);
		frmAddValues.getContentPane().add(txtGender);
	}

}
