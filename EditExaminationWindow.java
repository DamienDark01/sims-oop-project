/*
 * Class Name : EditExaminationWindow
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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.sliit.dao.ExaminationDao;
import com.sliit.entities.Examination;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class EditExaminationWindow implements EditWindow {

	// properties
	private JFrame frmEditValues;
	private JTextField txtId, txtSubject, txtExamType, txtDuration;
	private JLabel lblHeader, lblId, lblSubject, lblExamType, lblDuration, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private ArrayList<Examination> list;
	private int currentIndex;

	/**
	 * Create the application.
	 */
	public EditExaminationWindow(ArrayList<Examination> list) {
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
		frmEditValues.setTitle("Edit values");
		frmEditValues.setVisible(true);
		frmEditValues.setResizable(false);
		frmEditValues.setBounds(10, 10, 650, 700);
		frmEditValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditValues.getContentPane().setLayout(null);
		
		lblHeader = new JLabel("Edit values of Examination");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmEditValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmEditValues.getContentPane().add(lblId);
		
		lblSubject = new JLabel("Subject :");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSubject.setBounds(69, 122, 106, 39);
		frmEditValues.getContentPane().add(lblSubject);
		
		lblExamType = new JLabel("Exam Type :");
		lblExamType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblExamType.setBounds(69, 172, 147, 39);
		frmEditValues.getContentPane().add(lblExamType);
		
		lblDuration = new JLabel("Duration :");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDuration.setBounds(69, 222, 167, 39);
		frmEditValues.getContentPane().add(lblDuration);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String subject = txtSubject.getText();
				String type = txtExamType.getText();
				String duration = txtDuration.getText();
				
				int editedEntries = ExaminationDao.getEditConfirmation(id, subject, type, duration);
				
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
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmEditValues.getContentPane().add(txtId);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubject.setColumns(10);
		txtSubject.setBounds(166, 127, 290, 34);
		frmEditValues.getContentPane().add(txtSubject);
		
		txtExamType = new JTextField();
		txtExamType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtExamType.setColumns(10);
		txtExamType.setBounds(206, 177, 290, 34);
		frmEditValues.getContentPane().add(txtExamType);
		
		txtDuration = new JTextField();
		txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDuration.setColumns(10);
		txtDuration.setBounds(180, 227, 290, 34);
		frmEditValues.getContentPane().add(txtDuration);
		
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
            Examination exam = list.get(currentIndex);
            
            txtId.setText(exam.getId());
            txtSubject.setText(exam.getSubject().getName());
            txtExamType.setText(exam.getExamType());
            txtDuration.setText(String.valueOf(exam.getDuration()));
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }
	
}
