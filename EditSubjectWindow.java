/*
 * Class Name : NewSubjectWindow
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

import com.sliit.dao.SubjectDao;
import com.sliit.entities.Subject;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// class implementation
public class EditSubjectWindow implements EditWindow {

	// properties
	private JFrame frmEditValues;
	private JTextField txtId, txtModule, txtName;
	private JLabel lblHeader, lblId, lblName, lblModules, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JButton btnNext;
	private ArrayList<Subject> list;
	private int currentIndex;

	/**
	 * Create the application.
	 */
	public EditSubjectWindow(ArrayList<Subject> list) {
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
		
		lblHeader = new JLabel("Add new values to Subject");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmEditValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmEditValues.getContentPane().add(lblId);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 106, 39);
		frmEditValues.getContentPane().add(lblName);
		
		lblModules = new JLabel("No of Modules :");
		lblModules.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblModules.setBounds(69, 172, 167, 39);
		frmEditValues.getContentPane().add(lblModules);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String moduleNum = txtModule.getText();
				
				int editedEntries = SubjectDao.getEditConfirmation(id, name, moduleNum);
				
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
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(154, 127, 290, 34);
		frmEditValues.getContentPane().add(txtName);
		
		txtModule = new JTextField();
		txtModule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtModule.setColumns(10);
		txtModule.setBounds(238, 177, 290, 34);
		frmEditValues.getContentPane().add(txtModule);
		
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
            Subject sub = list.get(currentIndex);
            
            txtId.setText(sub.getId());
            txtName.setText(sub.getName());
            txtModule.setText(String.valueOf(sub.getNoOfModules()));
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }

}
