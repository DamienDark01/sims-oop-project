/*
 * Class Name : LoginWindow
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
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class LoginWindow {

	// properties
	private JFrame frmLogin;
	private JTextField uNameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application - MAIN METHOD
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmLogin.setResizable(false);
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(10, 10, 900, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel colorPanel = new JPanel();
		colorPanel.setBounds(0, 0, 437, 561);
		colorPanel.setBackground(Color.black);
		frmLogin.getContentPane().add(colorPanel);
		colorPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(79, 139, 249, 246);
		colorPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Western");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(10, 0, 151, 53);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("High");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3_1.setBounds(10, 50, 151, 53);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("School");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3_2.setBounds(10, 98, 151, 53);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("School Information Management System");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(10, 221, 216, 14);
		panel.add(lblNewLabel_4);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(436, 0, 448, 561);
		frmLogin.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(179, 55, 66, 48);
		loginPanel.add(lblNewLabel);
		
		uNameTextField = new JTextField();
		uNameTextField.setBounds(119, 173, 225, 34);
		loginPanel.add(uNameTextField);
		uNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(118, 150, 102, 20);
		loginPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(119, 238, 101, 20);
		loginPanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					String uId = uNameTextField.getText();
					String password = new String(passwordField.getPassword());
					
					User user = UserDao.validateUser(uId, password);
					
					if (user != null) {
						frmLogin.dispose();
						new DashboardWindow(user);
					} else {
						JOptionPane.showInternalMessageDialog(null, "Error : Wrong Credentials!", "Error", 0);
					}
				} catch (Exception exp) {
					JOptionPane.showInternalMessageDialog(null, "Error : " + exp.getMessage(), "Error", 0);
				}
			}
		});
		btnNewButton.setBounds(179, 330, 89, 34);
		loginPanel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Forgot Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Please Contact Support Desk", "Password Recovery", 1);
			}
		});
		btnNewButton_2.setBounds(157, 471, 132, 23);
		loginPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Contact Support");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = "Name : Damith Bandara\nContact Number : 0701454289\nEmail : damithinduranga@gmail.com";
				JOptionPane.showInternalMessageDialog(null, value, "Contact Details", 1);
			}
		});
		btnNewButton_3.setBounds(157, 506, 132, 23);
		loginPanel.add(btnNewButton_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 269, 225, 34);
		loginPanel.add(passwordField);
	}
	
}
