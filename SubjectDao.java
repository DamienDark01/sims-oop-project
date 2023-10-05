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

                Subject sub = new Subject();

                // setters are called

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
    public static ArrayList<Subject> getById(String id) {
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            String query = "SELECT * FROM subject WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Subject sub = new Subject();

                // setters are called

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

    // search by name
    public static ArrayList<Subject> getByName(String name) {
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            String query = "SELECT * FROM subject WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Subject sub = new Subject();

                // setters are called

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