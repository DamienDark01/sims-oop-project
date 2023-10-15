/*
 * Class Name : ExaminationDao
 * Data Access Object class
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// class implementation
public class ExaminationDao {

    // show all
    public static ArrayList<Examination> getAll() {
        // create the returning list
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Examination exam = new Examination();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);

                // object is added to ArrayList
                list.add(exam);
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
    public static Examination getById(String pId) {
        // create returning object
        Examination exam = new Examination();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination WHERE exam_id = '" + pId + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);
            }

            // return object
            return exam;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<Examination> getByType(String name) {
        // create the returning list
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination WHERE exam_type LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Examination exam = new Examination();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);

                // add object to ArrayList
                list.add(exam);
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
    
    public static int getAddConfirmation(String id, String fName, String lName, String location, String capacity) {
    	int addedEntries = 0;
    	
    	String query = "INSERT INTO examination VALUES ('" + id + "', (SELECT teacher_id FROM teacher WHERE teacher_f_name='" + fName + "' AND teacher_l_name='" + lName + "'), '" + location + "', '" + capacity + "');";
    	addedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntries;
    }
    
    public static int getEditConfirmation(String id, String subject, String type, String duration) {
    	int editedEntires = 0;
    	
    	String query = "UPDATE examination SET sub_id=(SELECT sub_id FROM subject WHERE sub_name='" + subject + "'), exam_type='" + type + "', duration='" + duration + "' WHERE exam_id='" + id + "';";
    	editedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntires;
    }
    
    public static int getDeleteConfirmation(String pId) {
    	int deletedEntires = 0;
    	
    	String query = "DELETE FROM examination WHERE exam_id = '" + pId + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}