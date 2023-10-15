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

import com.sliit.dao.ClassroomDao;
import com.sliit.entities.Classroom;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// class implementation
public class EditClassroomWindow implements EditWindow {

	// properties
	private JFrame frmEditValues;
	private JTextField txtId, txtLocation, txtFName, txtCapacity;
	private JLabel lblHeader, lblId, lblFName, lblLocation, lblCapacity, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JTextField txtLName;
	private ArrayList<Classroom> list;
	private int currentIndex;

	/**
	 * Create the application.
	 */
	public EditClassroomWindow(ArrayList<Classroom> list) {
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
		frmEditValues.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmEditValues.setVisible(true);
		frmEditValues.setResizable(false);
		frmEditValues.setTitle("Edit values");
		frmEditValues.setBounds(10, 10, 650, 700);
		frmEditValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditValues.getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("src/logo.png");
        frmEditValues.setIconImage(img.getImage());
		
		lblHeader = new JLabel("Edit values of Classroom");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmEditValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmEditValues.getContentPane().add(lblId);
		
		lblFName = new JLabel("Teacher Name (First) :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 122, 243, 39);
		frmEditValues.getContentPane().add(lblFName);
		
		lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLocation.setBounds(69, 222, 125, 39);
		frmEditValues.getContentPane().add(lblLocation);
		
		lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCapacity.setBounds(69, 272, 167, 39);
		frmEditValues.getContentPane().add(lblCapacity);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String location = txtLocation.getText();
				String capacity = txtCapacity.getText();
				
				int editedEntries = ClassroomDao.getEditConfirmation(id, fName, lName, location, capacity);
				
				txtResult.setText("Edited " + editedEntries + "...");
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
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setEditable(false);
		txtId.setBounds(115, 72, 290, 34);
		frmEditValues.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(301, 127, 290, 34);
		frmEditValues.getContentPane().add(txtFName);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLocation.setColumns(10);
		txtLocation.setBounds(178, 227, 290, 34);
		frmEditValues.getContentPane().add(txtLocation);
		
		txtCapacity = new JTextField();
		txtCapacity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(178, 277, 290, 34);
		frmEditValues.getContentPane().add(txtCapacity);
		
		JLabel lblLName = new JLabel("Teacher Name (Last) :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 172, 243, 39);
		frmEditValues.getContentPane().add(lblLName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(301, 177, 290, 34);
		frmEditValues.getContentPane().add(txtLName);
		
		JButton btnNext = new JButton("Next Entry");
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
            Classroom classroom = list.get(currentIndex);
            
            txtId.setText(classroom.getId());
            txtFName.setText(classroom.getTeacher().getFirstName());
            txtLName.setText(classroom.getTeacher().getLastName());
            txtLocation.setText(classroom.getLocation());
            txtCapacity.setText(String.valueOf(classroom.getCapacity()));
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }
	
}
