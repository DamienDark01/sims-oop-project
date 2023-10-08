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
package project;

// imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

// class implementation
class CommonDao {

    private static Connection dbcon = null;
    private static Statement stmt = null;
    private static ResultSet rslt = null;

    // for login validation
    public static boolean getValidation(String sqlQuery) {
        boolean isValid = false;

        try {
            // correct url
            dbcon = DriverManager.getConnection("jdbc:mysql://localhost/oop_project", "root", "1234");
            stmt = dbcon.createStatement();
            rslt = stmt.executeQuery(sqlQuery);

            while (rslt.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        return isValid;
    }

    // for select queries
    public static ResultSet getResultSet(String sqlQuery) {
        try {
            // correct URL
            dbcon = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "1234");
            stmt = dbcon.createStatement();
            rslt = stmt.executeQuery(sqlQuery);

            return rslt;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        return null;
    }

    // for insert, update and delete queries
    public static boolean getInsertUpdateDeleteStatus(String sqlQuery) {
        boolean isSuccess = false;

        try {
            // correct url
            dbcon = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "1234");
            stmt = dbcon.createStatement();
            int result = stmt.executeUpdate(sqlQuery);

            if (result > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        return isSuccess;
    }

}