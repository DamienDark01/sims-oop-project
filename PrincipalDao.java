/*
 * Class Name : PricipalDao
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
public class PrincipalDao {
    
    // show all
    public static ArrayList<Principal> getAll() {
        // create the returning list
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM principal;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("principal_id");
                String firstName = rslt.getString("principal_f_name");
                String lastName = rslt.getString("principal_l_name");
                String email = rslt.getString("p_email");
                String contact = rslt.getString("p_contact");
                String position = rslt.getString("position");
                String address = rslt.getString("p_address");
                String gender = rslt.getString("gender");

                Principal principal = new Principal();

                // setters are called
                principal.setId(id);
                principal.setFirstName(firstName);
                principal.setLastName(lastName);
                principal.setEmail(email);
                principal.setContact(contact);
                principal.setPosition(position);
                principal.setAddress(address);
                principal.setGender(gender);

                // object is added to ArrayList
                list.add(principal);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Principal getById(String pId) {
        // create returning object
        Principal principal = new Principal();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM principal WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("principal_id");
                String firstName = rslt.getString("principal_f_name");
                String lastName = rslt.getString("principal_l_name");
                String email = rslt.getString("p_email");
                String contact = rslt.getString("p_contact");
                String position = rslt.getString("position");
                String address = rslt.getString("p_address");
                String gender = rslt.getString("gender");

                // setters are called
                principal.setId(id);
                principal.setFirstName(firstName);
                principal.setLastName(lastName);
                principal.setEmail(email);
                principal.setContact(contact);
                principal.setPosition(position);
                principal.setAddress(address);
                principal.setGender(gender);
            }

            // return object
            return principal;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Principal> getByName(String name) {
        // create the returning list
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM principal WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("principal_id");
                String firstName = rslt.getString("principal_f_name");
                String lastName = rslt.getString("principal_l_name");
                String email = rslt.getString("p_email");
                String contact = rslt.getString("p_contact");
                String position = rslt.getString("position");
                String address = rslt.getString("p_address");
                String gender = rslt.getString("gender");

                Principal principal = new Principal();

                // setters are called
                principal.setId(id);
                principal.setFirstName(firstName);
                principal.setLastName(lastName);
                principal.setEmail(email);
                principal.setContact(contact);
                principal.setPosition(position);
                principal.setAddress(address);
                principal.setGender(gender);

                // add object to ArrayList
                list.add(principal);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }

        // returns null if the above list is not returned
        return null;
    }

}