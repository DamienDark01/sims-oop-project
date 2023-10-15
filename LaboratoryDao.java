/*
 * Class Name : LaboratoryDao
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

import com.sliit.entities.Laboratory;
import com.sliit.entities.Teacher;

// class implementation
public class LaboratoryDao {
    
    // show all
    public static ArrayList<Laboratory> getAll() {
        // create the returning list
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM laboratory;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                // using Data Access Objects to create specific objects
                Laboratory lab = new Laboratory();
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);

                // object is added to ArrayList
                list.add(lab);
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
    public static Laboratory getById(String pId) {
        // create returning object
        Laboratory lab = new Laboratory();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM laboratory WHERE lab_id = '" + pId + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                // using Data Access Objects to create specific objects
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);
            }

            // return object
            return lab;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<Laboratory> getByPurpose(String name) {
        // create the returning list
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM laboratory WHERE purpose LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                // using Data Access Objects to create specific objects
                Laboratory lab = new Laboratory();
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);

                // add object to ArrayList
                list.add(lab);
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
    public static int getAddConfirmation(String id, String purpose, String location, String fName, String lName) {
    	int addedEntries = 0;
    	
    	String query = "INSERT INTO laboratory VALUES ('" + id + "', '" + purpose + "', '" + location + "', (SELECT teacher_id FROM teacher WHERE teacher_f_name='" + fName + "' AND teacher_l_name='" + lName + "'));";
    	addedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntries;
    }
    
    // return the number of edited entries
    public static int getEditConfirmation(String id, String purpose, String location, String fName, String lName) {
    	int editedEntires = 0;
    	
    	String query = "UPDATE laboratory SET purpose = '" + purpose + "', location = '" + location + "', teacher_id = (SELECT teacher_id FROM teacher WHERE teacher_f_name='" + fName + "' AND teacher_l_name='" + lName + "') where lab_id = '" + id + "';";
    	editedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntires;
    }
    
    // return the number of deleted entries
    public static int getDeleteConfirmation(String pId) {
    	int deletedEntires = 0;
    	
    	String query = "DELETE FROM laboratory WHERE lab_id = '" + pId + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}