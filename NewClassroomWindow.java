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

import com.sliit.dao.ClassroomDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewClassroomWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtLocation, txtFName, txtCapacity;
	private JLabel lblHeader, lblId, lblFName, lblLocation, lblCapacity, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JTextField txtLName;

	/**
	 * Create the application.
	 */
	public NewClassroomWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setTitle("Add values");
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("src/logo.png");
        frmAddValues.setIconImage(img.getImage());
		
		lblHeader = new JLabel("Add new values to Classroom");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblFName = new JLabel("Teacher First Name :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 122, 233, 39);
		frmAddValues.getContentPane().add(lblFName);
		
		lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLocation.setBounds(69, 222, 125, 39);
		frmAddValues.getContentPane().add(lblLocation);
		
		lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCapacity.setBounds(69, 272, 167, 39);
		frmAddValues.getContentPane().add(lblCapacity);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String location = txtLocation.getText();
				String capacity = txtCapacity.getText();
				
				int addedEntries = ClassroomDao.getAddConfirmation(id, fName, lName, location, capacity);
				txtResult.setText(addedEntries + " entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(240, 509, 138, 39);
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
		txtId.setBounds(115, 72, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(294, 127, 290, 34);
		frmAddValues.getContentPane().add(txtFName);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLocation.setColumns(10);
		txtLocation.setBounds(178, 227, 290, 34);
		frmAddValues.getContentPane().add(txtLocation);
		
		txtCapacity = new JTextField();
		txtCapacity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(178, 277, 290, 34);
		frmAddValues.getContentPane().add(txtCapacity);
		
		JLabel lblLName = new JLabel("Teacher Last Name :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 172, 233, 39);
		frmAddValues.getContentPane().add(lblLName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(294, 177, 290, 34);
		frmAddValues.getContentPane().add(txtLName);
	}
	
}
