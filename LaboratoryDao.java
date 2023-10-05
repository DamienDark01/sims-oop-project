/*
 * Classname : LaboratoryDao
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

// class implementation
public class LaboratoryDao {
    
    // show all
    public static ArrayList<Laboratory> getAll() {
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            String query = "SELECT * FROM laboratory;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Laboratory lab = new Laboratory();

                // setters are called

                // object is added to ArrayList
                list.add(lab);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Laboratory getById(String id) {
        Laboratory lab = new Laboratory();

        try {
            String query = "SELECT * FROM laboratory WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                // setters are called

            }

            return lab;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Laboratory> getByName(String name) {
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            String query = "SELECT * FROM laboratory WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Laboratory lab = new Laboratory();

                // setters are called

                // add object to ArrayList
                list.add(lab);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}