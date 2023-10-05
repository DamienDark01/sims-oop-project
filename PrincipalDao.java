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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Principal getById(String pId) {
        Principal principal = new Principal();

        try {
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

            return principal;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Principal> getByName(String name) {
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}