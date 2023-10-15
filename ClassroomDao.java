/*
 * Class Name : ClassroomDao
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

import com.sliit.entities.Classroom;
import com.sliit.entities.Teacher;

// class implementation
public class ClassroomDao {

    // show all
    public static ArrayList<Classroom> getAll() {
        // create the returning list
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Classroom classroom = ClassroomDao.getById(classId);
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);

                // object is added to ArrayList
                list.add(classroom);
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
    public static Classroom getById(String id) {
        // create returning object
        Classroom classroom = new Classroom();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom WHERE class_id = '" + id + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);
            }

            // return object
            return classroom;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<Classroom> getByLocation(String name) {
        // create the returning list
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom WHERE location LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Classroom classroom = ClassroomDao.getById(classId);
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);

                // add object to ArrayList
                list.add(classroom);
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
    public static int getAddConfirmation(String id, String fName, String lName, String location, String capacity) {
    	int addedEntires = 0;
    	
    	String query = "INSERT INTO classroom VALUES ('" + id + "', (SELECT teacher_id FROM teacher WHERE teacher_f_name='" + fName + "' AND teacher_l_name='" + lName + "'), '" + location + "', " + capacity + ");";
    	addedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntires;
    }
    
    // return the number of edited entries
    public static int getEditConfirmation(String id, String fName, String lName, String location, String capacity) {
    	int editedEntries = 0;
    	
    	String query = "UPDATE classroom SET teacher_id=(SELECT teacher_id FROM teacher WHERE teacher_f_name='" + fName + "' AND teacher_l_name='" + lName + "'), location='" + location + "', capacity='" + capacity + "';";
    	editedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntries;
    }
    
    // return the number of deleted entries
    public static int getDeleteConfirmation(String id) {
    	int deletedEntires = 0;
    	
    	String query = "DELETE FROM classroom WHERE class_id = '" + id + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}