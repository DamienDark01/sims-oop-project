/*
 * Class Name : NewExaminationWindow
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

import com.sliit.dao.ExaminationDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewExaminationWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtSubject, txtExamType, txtDuration;
	private JLabel lblHeader, lblId, lblSubject, lblExamType, lblDuration, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public NewExaminationWindow() {
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
		lblHeader = new JLabel("Add new values to Examination");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		// input prompts
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblSubject = new JLabel("Subject :");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSubject.setBounds(69, 122, 106, 39);
		frmAddValues.getContentPane().add(lblSubject);
		
		lblExamType = new JLabel("Exam Type :");
		lblExamType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblExamType.setBounds(69, 172, 147, 39);
		frmAddValues.getContentPane().add(lblExamType);
		
		lblDuration = new JLabel("Duration :");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDuration.setBounds(69, 222, 167, 39);
		frmAddValues.getContentPane().add(lblDuration);
		
		// enter details button
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String subject = txtSubject.getText();
				String examType = txtExamType.getText();
				String duration = txtDuration.getText();
				
				int addedEntries = ExaminationDao.getAddConfirmation(id, subject, examType, duration, duration);
				txtResult.setText(addedEntries + " entry/entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(239, 509, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
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
		
		// show results
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
		// taking inputs
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubject.setColumns(10);
		txtSubject.setBounds(166, 127, 290, 34);
		frmAddValues.getContentPane().add(txtSubject);
		
		txtExamType = new JTextField();
		txtExamType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtExamType.setColumns(10);
		txtExamType.setBounds(206, 177, 290, 34);
		frmAddValues.getContentPane().add(txtExamType);
		
		txtDuration = new JTextField();
		txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDuration.setColumns(10);
		txtDuration.setBounds(180, 227, 290, 34);
		frmAddValues.getContentPane().add(txtDuration);
	}

}
