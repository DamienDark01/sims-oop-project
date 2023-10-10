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
    private static String url = "jdbc:mysql://localhost:3306/oop_project";
    private static String name = "root";
    private static String password = "1234";
    

    // for login validation
    public static boolean getValidation(String sqlQuery) {
        boolean isValid = false;

        try {
            // correct url
            dbcon = DriverManager.getConnection(url, name, password);
            stmt = dbcon.createStatement();
            rslt = stmt.executeQuery(sqlQuery);

            if (rslt.next()) {
                isValid = true;
                return isValid;
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
            dbcon = DriverManager.getConnection(url, name, password);
            stmt = dbcon.createStatement();
            rslt = stmt.executeQuery(sqlQuery);

            return rslt;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // for insert, update and delete queries
    public static boolean getInsertUpdateDeleteStatus(String sqlQuery) {
        boolean isSuccess = false;

        try {
            // correct url
            dbcon = DriverManager.getConnection(url, name, password);
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