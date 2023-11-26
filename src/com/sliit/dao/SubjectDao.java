/*
 * Class Name : SubjectDao
 * Data Access Object class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.dao;

// imports
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sliit.entity.Subject;

// class implementation
public class SubjectDao {

    // show all
    public static ArrayList<Subject> getAll() {
        // create the returning list
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM subject;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("sub_id");
                String name = rslt.getString("sub_name");
                int noOfModules = rslt.getInt("no_of_modules");

                Subject sub = new Subject();

                // setters are called
                sub.setId(id);
                sub.setName(name);
                sub.setNoOfModules(noOfModules);

                // object is added to ArrayList
                list.add(sub);
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
    public static Subject getById(String pId) {
        // create returning object
        Subject sub = new Subject();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM subject WHERE sub_id = '" + pId + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("sub_id");
                String name = rslt.getString("sub_name");
                int noOfModules = rslt.getInt("no_of_modules");

                // setters are called
                sub.setId(id);
                sub.setName(name);
                sub.setNoOfModules(noOfModules);
            }

            // return object
            return sub;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<Subject> getByName(String pName) {
        // create the returning list
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM subject WHERE sub_name LIKE '%" + pName + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("sub_id");
                String name = rslt.getString("sub_name");
                int noOfModules = rslt.getInt("no_of_modules");

                Subject sub = new Subject();

                // setters are called
                sub.setId(id);
                sub.setName(name);
                sub.setNoOfModules(noOfModules);

                // add object to ArrayList
                list.add(sub);
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
    public static int getAddConfirmation(String id, String name, String moduleNum) {
    	int addedEntries = 0;
    	
    	// getting the number of added entries
    	String query = "INSERT INTO subject VALUES ('" + id + "', '" + name + "', " + moduleNum + ");";
    	addedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntries;
    }
    
    // return the number of edited entries
    public static int getEditConfirmation(String id, String name, String moduleNum) {
    	int editedEntires = 0;
    	
    	// getting the number of edited entries
    	String query = "UPDATE subject SET sub_name = '" + name + "', no_of_modules = '" + moduleNum + "' where sub_id = '" + id + "';";
    	editedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntires;
    }
    
    // return the number of deleted entries
    public static int getDeleteConfirmation(String pId) {
    	int deletedEntires = 0;
    	
    	// getting the number of deleted entries
    	String query = "DELETE FROM subject WHERE sub_id = '" + pId + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}