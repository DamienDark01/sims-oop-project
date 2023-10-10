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
class NewPrincipalWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField idTxt;
	private JTextField fNameTxt;
	private JTextField lNameTxt;
	private JTextField emailTxt;
	private JTextField contactTxt;
	private JTextField positionTxt;
	private JTextField addressTxt;
	private JTextField genderTxt;

	/**
	 * Create the application.
	 */
	public NewPrincipalWindow() {
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
		
		JLabel lblNewLabel = new JLabel("Add new values to Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("First Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 138, 39);
		frmAddValues.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Last Name :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblPassword);
		
		JLabel lblAccountType = new JLabel("Email :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblAccountType);
		
		JLabel lblEmail = new JLabel("Contact No :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 272, 146, 39);
		frmAddValues.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Position :");
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
		btnEnterDetails.setBounds(238, 472, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
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
		
		fNameTxt = new JTextField();
		fNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fNameTxt.setColumns(10);
		fNameTxt.setBounds(202, 127, 290, 34);
		frmAddValues.getContentPane().add(fNameTxt);
		
		lNameTxt = new JTextField();
		lNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lNameTxt.setColumns(10);
		lNameTxt.setBounds(202, 177, 290, 34);
		frmAddValues.getContentPane().add(lNameTxt);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTxt.setColumns(10);
		emailTxt.setBounds(146, 227, 290, 34);
		frmAddValues.getContentPane().add(emailTxt);
		
		contactTxt = new JTextField();
		contactTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contactTxt.setColumns(10);
		contactTxt.setBounds(202, 277, 290, 34);
		frmAddValues.getContentPane().add(contactTxt);
		
		positionTxt = new JTextField();
		positionTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		positionTxt.setColumns(10);
		positionTxt.setBounds(173, 327, 290, 34);
		frmAddValues.getContentPane().add(positionTxt);
		
		addressTxt = new JTextField();
		addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressTxt.setColumns(10);
		addressTxt.setBounds(173, 377, 290, 34);
		frmAddValues.getContentPane().add(addressTxt);
		
		genderTxt = new JTextField();
		genderTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderTxt.setColumns(10);
		genderTxt.setBounds(173, 427, 290, 34);
		frmAddValues.getContentPane().add(genderTxt);
	}

}
