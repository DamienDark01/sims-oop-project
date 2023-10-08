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

// imports
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
        }

        // returns null if the above list is not returned
        return null;
    }

    // search by id
    public static Laboratory getById(String pId) {
        // create returning object
        Laboratory lab = new Laboratory();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM laboratory WHERE id = " + pId + ";";
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
        }

        return null;
    }

    // search by name
    public static ArrayList<Laboratory> getByName(String name) {
        // create the returning list
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM laboratory WHERE name LIKE '%" + name + "';";
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
        }

        // returns null if the above list is not returned
        return null;
    }

}