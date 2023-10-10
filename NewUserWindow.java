/*
 * Class Name : NewUserWindow
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

// class implementation
class NewUserWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	private JTextField accTxt;
	private JTextField emailTxt;
	private JTextField contactTxt;
	private JTextField addressTxt;
	private JTextField genderTxt;

	/**
	 * Create the application.
	 */
	public NewUserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setBounds(100, 100, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new values to User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 106, 39);
		frmAddValues.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblPassword);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblAccountType);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 272, 106, 39);
		frmAddValues.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(69, 322, 106, 39);
		frmAddValues.getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(69, 372, 106, 39);
		frmAddValues.getContentPane().add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(69, 422, 106, 39);
		frmAddValues.getContentPane().add(lblGender);
		
		JButton btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(238, 490, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		JLabel nameLabel_1 = new JLabel("");
		nameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_1.setBounds(185, 72, 314, 39);
		frmAddValues.getContentPane().add(nameLabel_1);
		
		JLabel nameLabel_2 = new JLabel("");
		nameLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_2.setBounds(216, 122, 283, 39);
		frmAddValues.getContentPane().add(nameLabel_2);
		
		JLabel nameLabel_3 = new JLabel("");
		nameLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_3.setBounds(252, 172, 247, 39);
		frmAddValues.getContentPane().add(nameLabel_3);
		
		JLabel nameLabel_4 = new JLabel("");
		nameLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_4.setBounds(294, 222, 205, 39);
		frmAddValues.getContentPane().add(nameLabel_4);
		
		JLabel nameLabel_5 = new JLabel("");
		nameLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_5.setBounds(208, 272, 291, 39);
		frmAddValues.getContentPane().add(nameLabel_5);
		
		JLabel nameLabel_6 = new JLabel("");
		nameLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_6.setBounds(238, 322, 261, 39);
		frmAddValues.getContentPane().add(nameLabel_6);
		
		JLabel nameLabel_7 = new JLabel("");
		nameLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_7.setBounds(238, 372, 261, 39);
		frmAddValues.getContentPane().add(nameLabel_7);
		
		JLabel nameLabel_8 = new JLabel("");
		nameLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nameLabel_8.setBounds(227, 422, 272, 39);
		frmAddValues.getContentPane().add(nameLabel_8);
		
		JTextArea txtrResult = new JTextArea();
		txtrResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrResult.setText("Result...");
		txtrResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtrResult);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(534, 0, 100, 100);
		frmAddValues.getContentPane().add(panel_3);
		
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
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idTxt.setColumns(10);
		idTxt.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(idTxt);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setColumns(10);
		nameTxt.setBounds(150, 127, 290, 34);
		frmAddValues.getContentPane().add(nameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(185, 177, 290, 34);
		frmAddValues.getContentPane().add(passwordTxt);
		
		accTxt = new JTextField();
		accTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		accTxt.setColumns(10);
		accTxt.setBounds(232, 227, 290, 34);
		frmAddValues.getContentPane().add(accTxt);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTxt.setColumns(10);
		emailTxt.setBounds(150, 277, 290, 34);
		frmAddValues.getContentPane().add(emailTxt);
		
		contactTxt = new JTextField();
		contactTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contactTxt.setColumns(10);
		contactTxt.setBounds(172, 327, 290, 34);
		frmAddValues.getContentPane().add(contactTxt);
		
		addressTxt = new JTextField();
		addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressTxt.setColumns(10);
		addressTxt.setBounds(172, 377, 290, 34);
		frmAddValues.getContentPane().add(addressTxt);
		
		genderTxt = new JTextField();
		genderTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderTxt.setColumns(10);
		genderTxt.setBounds(172, 427, 290, 34);
		frmAddValues.getContentPane().add(genderTxt);
	}

}
