/*
 * Class Name : LoginWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.app;

// imports
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.sliit.dao.UserDao;
import com.sliit.entity.User;
import com.sliit.gui.general.DashboardWindow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class LoginWindow {

	// properties
	private JFrame frmLogin;
	private JTextField txtUid;
	private JPasswordField txtPassword;
	private JPanel colorPanel, logoPanel, loginPanel;
	private JLabel lblName1, lblName2, lblName3, lblName4, lblLogin, lblUid, lblUpassword;
	private JButton btnLogin, btnForgotPassword, btnContactSupport;
	private String uId, uPassword, value;

	/**
	 * Launch the application - MAIN METHOD
	 */
	public static void main(String[] args) {
		// thread safe calling of LoginWindow object - configured by Eclipse
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginWindow();
				} catch (Exception e) {
					// if any errors, showing it in JOptionPane
					JOptionPane.showMessageDialog(null, "Error : " + e.getMessage(), "Error", 0);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame methods
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setVisible(true);
		frmLogin.setResizable(false);
		frmLogin.setBounds(10, 10, 900, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		// icon
		ImageIcon img = new ImageIcon("src/logo.png");
        frmLogin.setIconImage(img.getImage());
		
        // background panel
		colorPanel = new JPanel();
		colorPanel.setBounds(0, 0, 437, 561);
		colorPanel.setBackground(Color.black);
		frmLogin.getContentPane().add(colorPanel);
		colorPanel.setLayout(null);
		
		// logo panel
		logoPanel = new JPanel();
		logoPanel.setBounds(79, 139, 249, 246);
		colorPanel.add(logoPanel);
		logoPanel.setLayout(null);
		
		lblName1 = new JLabel("Western");
		lblName1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblName1.setBounds(10, 0, 151, 53);
		logoPanel.add(lblName1);
		
		lblName2 = new JLabel("High");
		lblName2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblName2.setBounds(10, 50, 151, 53);
		logoPanel.add(lblName2);
		
		lblName3 = new JLabel("School");
		lblName3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblName3.setBounds(10, 98, 151, 53);
		logoPanel.add(lblName3);
		
		lblName4 = new JLabel("School Information Management System");
		lblName4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblName4.setBounds(10, 221, 216, 14);
		logoPanel.add(lblName4);
		
		// login panel
		loginPanel = new JPanel();
		loginPanel.setBounds(436, 0, 448, 561);
		frmLogin.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLogin.setBounds(179, 55, 66, 48);
		loginPanel.add(lblLogin);
		
		// taking user name input
		txtUid = new JTextField();
		txtUid.setBounds(119, 173, 225, 34);
		loginPanel.add(txtUid);
		txtUid.setColumns(10);
		
		lblUid = new JLabel("User ID");
		lblUid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUid.setBounds(118, 150, 102, 20);
		loginPanel.add(lblUid);
		
		lblUpassword = new JLabel("Password");
		lblUpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpassword.setBounds(119, 238, 101, 20);
		loginPanel.add(lblUpassword);
		
		// login button
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					uId = txtUid.getText();
					uPassword = new String(txtPassword.getPassword());
					
					User user = UserDao.validateUser(uId, uPassword);
					
					if (user != null) {
						new DashboardWindow(user);
						frmLogin.dispose();
					} else {
						JOptionPane.showInternalMessageDialog(null, "Error : Wrong Credentials!", "Error", 0);
					}
				} catch (Exception exp) {
					JOptionPane.showInternalMessageDialog(null, "Error : " + exp.getMessage(), "Error", 0);
				}
			}
		});
		btnLogin.setBounds(179, 330, 89, 34);
		loginPanel.add(btnLogin);
		
		// forgot password button
		btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Please Contact Support Desk!", "Password Recovery", 1);
			}
		});
		btnForgotPassword.setBounds(157, 471, 132, 23);
		loginPanel.add(btnForgotPassword);
		
		// contact support button
		btnContactSupport = new JButton("Contact Support");
		btnContactSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = "Name : K. L. Rahul\nContact Number : 0759595685\nEmail : klrahul895@gmail.com";
				JOptionPane.showInternalMessageDialog(null, value, "Contact Details", 1);
			}
		});
		btnContactSupport.setBounds(157, 506, 132, 23);
		loginPanel.add(btnContactSupport);
		
		// taking password input
		txtPassword = new JPasswordField();
		txtPassword.setBounds(119, 269, 225, 34);
		loginPanel.add(txtPassword);
	}
	
}
