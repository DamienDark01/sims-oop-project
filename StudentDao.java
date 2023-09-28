/*
 * Classname : StudentDao
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
public class StudentDao {
    
    // show all
    public static ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            String query = "SELECT * FROM student;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Student student = new Student();

                // setters are called

                // object is added to ArrayList
                list.add(student);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public ArrayList<Student> getById(String id) {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            String query = "SELECT * FROM student WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Student student = new Student();

                // setters are called

                // add object to ArrayList
                list.add(student);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public ArrayList<Student> getByName(String name) {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            String query = "SELECT * FROM student WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Student student = new Student();

                // setters are called

                // add object to ArrayList
                list.add(student);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}