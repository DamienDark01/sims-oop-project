/*
 * Class Name : UserDao
 * Data Access Object class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No : 
 */

// package
package com.sliit.dao;

// imports
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sliit.entities.User;

// class implementation
public class UserDao {

    // to validate user
    public static User validateUser(String pId, String pPw) {
        User user = new User();
        boolean isValid = false;

        try {
            String query = "SELECT * FROM user WHERE user_id = '" + pId + "' AND u_password = '" + pPw + "';";
            isValid = CommonDao.getValidation(query);

            if (isValid == true) {
                ResultSet rslt = CommonDao.getResultSet(query);

                if (rslt.next()) {
                    // column data are taken
                    String id = rslt.getString("user_id");
                    String name = rslt.getString("user_name");
                    String password = rslt.getString("u_password");
                    String accountType = rslt.getString("account_type");
                    String email = rslt.getString("u_email");
                    String contact = rslt.getString("u_contact");
                    String address = rslt.getString("u_address");
                    String gender = rslt.getString("gender");

                    // setters are called
                    user.setId(id);
                    user.setName(name);
                    user.setPassword(password);
                    user.setAccountType(accountType);
                    user.setEmail(email);
                    user.setContact(contact);
                    user.setAddress(address);
                    user.setGender(gender);
                }

                return user;
            } else {
                JOptionPane.showMessageDialog(null, "No User Found!", "Error", 0);
                return null;
            }
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // show all
    public static ArrayList<User> getAll() {
        // create the returning list
        ArrayList<User> list = new ArrayList<User>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM user;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("user_id");
                String name = rslt.getString("user_name");
                String password = rslt.getString("u_password");
                String accountType = rslt.getString("account_type");
                String email = rslt.getString("u_email");
                String contact = rslt.getString("u_contact");
                String address = rslt.getString("u_address");
                String gender = rslt.getString("gender");

                User user = new User();

                // setters are called
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
                user.setAccountType(accountType);
                user.setEmail(email);
                user.setContact(contact);
                user.setAddress(address);
                user.setGender(gender);

                // object is added to the list
                list.add(user);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by id
    public static User getById(String pId) {
        // create returning object
        User user = new User();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE user_id = '" + pId + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("user_id");
                String name = rslt.getString("user_name");
                String password = rslt.getString("u_password");
                String accountType = rslt.getString("account_type");
                String email = rslt.getString("u_email");
                String contact = rslt.getString("u_contact");
                String address = rslt.getString("u_address");
                String gender = rslt.getString("gender");

                // setters are called
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
                user.setAccountType(accountType);
                user.setEmail(email);
                user.setContact(contact);
                user.setAddress(address);
                user.setGender(gender);
            }

            // return object
            return user;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<User> getByName(String pName) {
        // create the returning list
        ArrayList<User> list = new ArrayList<User>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE user_name LIKE '%" + pName + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("user_id");
                String name = rslt.getString("user_name");
                String password = rslt.getString("password");
                String accountType = rslt.getString("account_type");
                String email = rslt.getString("u_email");
                String contact = rslt.getString("u_contact");
                String address = rslt.getString("u_address");
                String gender = rslt.getString("gender");

                User user = new User();

                // setters are called
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
                user.setAccountType(accountType);
                user.setEmail(email);
                user.setContact(contact);
                user.setAddress(address);
                user.setGender(gender);

                // add object to ArrayList
                list.add(user);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }
    
    // return the number of added entries
    public static int getAddConfirmation(String id, String name, String password, String email, String contact, String accType, String address, String gender) {
    	int addedEntries = 0;
    	
    	String query = "INSERT INTO user VALUES ('" + id + "', '" + name + "', '" + password + "', '" + accType + "', '" + email + "', '" + contact + "', '" + address + "', '" + gender + "';";
    	addedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntries;
    }
    
    // return the number of edited entries
    public static int getEditConfirmation(String id, String name, String password, String email, String contact, String accType, String address, String gender) {
    	int editedEntires = 0;
    	
    	String query = "UPDATE user SET user_name = '" + name + "', u_password = '" + password + "', u_email = '" + email + "', u_contact = '" + contact + "', account_type = '" + accType + "', u_address = '" + address + "', gender = '" + gender + "'  where user_id = '" + id + "';";
    	editedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntires;
    }
    
    // return the number of deleted entries
    public static int getDeleteConfirmation(String pId) {
    	int deletedEntires = 0;
    	
    	String query = "DELETE FROM user WHERE user_id = '" + pId + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}