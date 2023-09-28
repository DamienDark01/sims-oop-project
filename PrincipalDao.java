/*
 * Classname : PricipalDao
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
public class PrincipalDao {
    
    // show all
    public static ArrayList<Principal> getAll() {
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            String query = "SELECT * FROM principal;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Principal principal = new Principal();

                // setters are called

                // object is added to ArrayList
                list.add(principal);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public ArrayList<Principal> getById(String id) {
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            String query = "SELECT * FROM principal WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Principal principal = new Principal();

                // setters are called

                // add object to ArrayList
                list.add(principal);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public ArrayList<Principal> getByName(String name) {
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            String query = "SELECT * FROM principal WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Principal principal = new Principal();

                // setters are called

                // add object to ArrayList
                list.add(principal);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}