/*
 * Class Name : NewLaboratoryWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
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

import com.sliit.dao.LaboratoryDao;
import com.sliit.entity.Laboratory;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// class implementation
public class EditLaboratoryWindow implements EditWindow {

	// properties
	private JFrame frmEditValues;
	private JTextField txtId, txtLocation, txtPurpose;
	private JLabel lblHeader, lblId, lblLocation, lblPurpose, lblName1, lblName2, lblName3, lblFName, lblLName;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JButton btnNext;
	private ArrayList<Laboratory> list;
	private int currentIndex;
	private JTextField txtFName;
	private JTextField txtLName;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public EditLaboratoryWindow(ArrayList<Laboratory> list) {
		this.list = list;
		this.currentIndex = 0;
		initialize();
		addDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// frame methods
		frmEditValues = new JFrame();
		frmEditValues.setTitle("Add values");
		frmEditValues.setVisible(true);
		frmEditValues.setResizable(false);
		frmEditValues.setBounds(10, 10, 650, 700);
		frmEditValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditValues.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmEditValues.setIconImage(img.getImage());
		
        // header
		lblHeader = new JLabel("Edit values in Laboratory");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmEditValues.getContentPane().add(lblHeader);
		
		// input prompts
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmEditValues.getContentPane().add(lblId);
		
		lblPurpose = new JLabel("Purpose :");
		lblPurpose.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPurpose.setBounds(69, 122, 106, 39);
		frmEditValues.getContentPane().add(lblPurpose);
		
		lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLocation.setBounds(69, 172, 125, 39);
		frmEditValues.getContentPane().add(lblLocation);
		
		lblFName = new JLabel("Teacher Name (First) :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 222, 243, 39);
		frmEditValues.getContentPane().add(lblFName);
		
		lblLName = new JLabel("Teacher Name (Last) :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 272, 243, 39);
		frmEditValues.getContentPane().add(lblLName);
		
		// enter details button
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String location = txtLocation.getText();
				String purpose = txtPurpose.getText();
				
				int editedEntries = LaboratoryDao.getEditConfirmation(id, purpose, location, fName, lName);
				
				txtResult.setText("Edited " + editedEntries + " entry/entries...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(115, 509, 138, 39);
		frmEditValues.getContentPane().add(btnEnterDetails);
		
		// show results
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmEditValues.getContentPane().add(txtResult);
		
		// logo
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
		
		// take inputs
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmEditValues.getContentPane().add(txtId);
		
		txtPurpose = new JTextField();
		txtPurpose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPurpose.setColumns(10);
		txtPurpose.setBounds(173, 127, 290, 34);
		frmEditValues.getContentPane().add(txtPurpose);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLocation.setColumns(10);
		txtLocation.setBounds(173, 172, 290, 34);
		frmEditValues.getContentPane().add(txtLocation);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(301, 227, 290, 34);
		frmEditValues.getContentPane().add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(301, 277, 290, 34);
		frmEditValues.getContentPane().add(txtLName);
		
		// next entry button
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
	
	// add details method
	public void addDetails() {
        if (currentIndex >= 0 && currentIndex < list.size()) {
            Laboratory lab = list.get(currentIndex);
            
            txtId.setText(lab.getId());
            txtLocation.setText(lab.getLocation());
            txtPurpose.setText(lab.getPurpose());
            txtFName.setText(lab.getTeacher().getFirstName());
            txtLName.setText(lab.getTeacher().getLastName());
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }
}
