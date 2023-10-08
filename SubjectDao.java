/*
 * Class Name : SubjectDao
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
class SubjectDao {

    // show all
    public static ArrayList<Subject> getAll() {
        // create the returning list
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM student;";
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
        }

        // returns null if the above list is not returned
        return null;
    }

    // search by id
    public static Subject getById(String pId) {
        // create returning object
        Subject sub = new Subject();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM subject WHERE id = " + pId + ";";
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
        }

        // returns null if the above list is not returned
        return null;
    }

    // search by name
    public static ArrayList<Subject> getByName(String pName) {
        // create the returning list
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM subject WHERE name LIKE '%" + pName + "';";
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
        }

        // returns null if the above list is not returned
        return null;
    }

}