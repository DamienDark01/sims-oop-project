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
package com.sliit.gui.update;

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

import com.sliit.dao.PrincipalDao;
import com.sliit.entities.Principal;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// class implementation
public class EditPrincipalWindow implements EditWindow {

	// properties
	private JFrame frmEditValues;
	private JTextField txtId, txtFName, txtLName, txtEmail, txtContact, txtPosition, txtAddress, txtGender;
	private JLabel lblHeader, lblId, lblFName, lblLName, lblEmail, lblName1, lblName2, lblName3, lblContact, lblPosition, lblAddress, lblGender;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JButton btnNext;
	private ArrayList<Principal> list;
	private int currentIndex;

	/**
	 * Create the application.
	 */
	public EditPrincipalWindow(ArrayList<Principal> list) {
		this.list = list;
		this.currentIndex = 0;
		initialize();
		addDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmEditValues = new JFrame();
		frmEditValues.setTitle("Add values");
		frmEditValues.setVisible(true);
		frmEditValues.setResizable(false);
		frmEditValues.setBounds(10, 10, 650, 700);
		frmEditValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditValues.getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("src/logo.png");
        frmEditValues.setIconImage(img.getImage());
		
		lblHeader = new JLabel("Add new values to Principal");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmEditValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmEditValues.getContentPane().add(lblId);
		
		lblFName = new JLabel("First Name :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 122, 138, 39);
		frmEditValues.getContentPane().add(lblFName);
		
		lblLName = new JLabel("Last Name :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 172, 125, 39);
		frmEditValues.getContentPane().add(lblLName);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(69, 222, 167, 39);
		frmEditValues.getContentPane().add(lblEmail);
		
		lblContact = new JLabel("Contact No :");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblContact.setBounds(69, 272, 146, 39);
		frmEditValues.getContentPane().add(lblContact);
		
		lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPosition.setBounds(69, 322, 106, 39);
		frmEditValues.getContentPane().add(lblPosition);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAddress.setBounds(69, 372, 106, 39);
		frmEditValues.getContentPane().add(lblAddress);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGender.setBounds(69, 422, 106, 39);
		frmEditValues.getContentPane().add(lblGender);
		
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
				
				int editedEntries = PrincipalDao.getEditConfirmation(id, fName, lName, email, contact, position, address, gender);
				
				txtResult.setText("Edited " + editedEntries + " entry/entries...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(115, 509, 138, 39);
		frmEditValues.getContentPane().add(btnEnterDetails);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmEditValues.getContentPane().add(txtResult);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(534, 0, 100, 100);
		frmEditValues.getContentPane().add(panelLogo);
		
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
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmEditValues.getContentPane().add(txtId);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(202, 127, 290, 34);
		frmEditValues.getContentPane().add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(202, 177, 290, 34);
		frmEditValues.getContentPane().add(txtLName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 227, 290, 34);
		frmEditValues.getContentPane().add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(202, 277, 290, 34);
		frmEditValues.getContentPane().add(txtContact);
		
		txtPosition = new JTextField();
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPosition.setColumns(10);
		txtPosition.setBounds(173, 327, 290, 34);
		frmEditValues.getContentPane().add(txtPosition);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(173, 377, 290, 34);
		frmEditValues.getContentPane().add(txtAddress);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBounds(173, 427, 290, 34);
		frmEditValues.getContentPane().add(txtGender);
		
		btnNext = new JButton("Next Entry");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex++;
				
				if (currentIndex < list.size()) {
					addDetails();
				} else {
					txtResult.setText("All entries are edited...");
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(384, 509, 138, 39);
		frmEditValues.getContentPane().add(btnNext);
	}
	
	public void addDetails() {
        if (currentIndex >= 0 && currentIndex < list.size()) {
            Principal principal = list.get(currentIndex);
            
            txtId.setText(principal.getId());
            txtFName.setText(principal.getFirstName());
            txtLName.setText(principal.getLastName());
            txtEmail.setText(principal.getEmail());
            txtContact.setText(principal.getContact());
            txtPosition.setText(principal.getPosition());
            txtAddress.setText(principal.getAddress());
            txtGender.setText(principal.getGender());
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }

}
