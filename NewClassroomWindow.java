/*
 * Class Name : NewClassroomWindow
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
class NewClassroomWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField locationTxt;
	private JTextField capacityTxt;

	/**
	 * Create the application.
	 */
	public NewClassroomWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setTitle("Add values");
		frmAddValues.setBounds(100, 100, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new values to Classroom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Teacher Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 167, 39);
		frmAddValues.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Location :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPassword.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblPassword);
		
		JLabel lblAccountType = new JLabel("Capacity :");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountType.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblAccountType);
		
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
		idTxt.setBounds(115, 72, 290, 34);
		frmAddValues.getContentPane().add(idTxt);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setColumns(10);
		nameTxt.setBounds(238, 127, 290, 34);
		frmAddValues.getContentPane().add(nameTxt);
		
		locationTxt = new JTextField();
		locationTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locationTxt.setColumns(10);
		locationTxt.setBounds(178, 177, 290, 34);
		frmAddValues.getContentPane().add(locationTxt);
		
		capacityTxt = new JTextField();
		capacityTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		capacityTxt.setColumns(10);
		capacityTxt.setBounds(178, 227, 290, 34);
		frmAddValues.getContentPane().add(capacityTxt);
	}
}
