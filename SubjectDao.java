/*
 * Classname : SubjectDao
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
public class SubjectDao {

    // show all
    public static ArrayList<Subject> getAll() {
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
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

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Subject getById(String pId) {
        Subject sub = new Subject();

        try {
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

            return sub;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Subject> getByName(String pName) {
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}