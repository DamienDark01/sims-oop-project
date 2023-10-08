/*
 * Class Name : StudentDao
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
public class StudentDao {
    
    // show all
    public static ArrayList<Student> getAll() {
        // create the returning list
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM student;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("student_id");
                String firstName = rslt.getString("student_f_name");
                String lastName = rslt.getString("student_l_name");
                String address = rslt.getString("s_address");
                String contact = rslt.getString("s_contact");
                String email = rslt.getString("s_email");
                String gender = rslt.getString("gender");
                String classId = rslt.getString("class_id");

                // using Data Access Objects to create specific objects
                Student student = new Student();
                Classroom classroom = ClassroomDao.getById(classId);

                // setters are called
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setContact(contact);
                student.setEmail(email);
                student.setGender(gender);
                student.setClassroom(classroom);

                // object is added to ArrayList
                list.add(student);
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
    public static Student getById(String pId) {
        // create returning object
        Student student = new Student();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM student WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("student_id");
                String firstName = rslt.getString("student_f_name");
                String lastName = rslt.getString("student_l_name");
                String address = rslt.getString("s_address");
                String contact = rslt.getString("s_contact");
                String email = rslt.getString("s_email");
                String gender = rslt.getString("gender");
                String classId = rslt.getString("class_id");

                // using Data Access Objects to create specific objects
                Classroom classroom = ClassroomDao.getById(classId);

                // setters are called
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setContact(contact);
                student.setEmail(email);
                student.setGender(gender);
                student.setClassroom(classroom);
            }

            // return object
            return student;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        // returns null if the above list is not returned
        return null;
    }

    // search by name
    public static ArrayList<Student> getByName(String name) {
        // create the returning list
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM student WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("student_id");
                String firstName = rslt.getString("student_f_name");
                String lastName = rslt.getString("student_l_name");
                String address = rslt.getString("s_address");
                String contact = rslt.getString("s_contact");
                String email = rslt.getString("s_email");
                String gender = rslt.getString("gender");
                String classId = rslt.getString("class_id");

                // using Data Access Objects to create specific objects
                Student student = new Student();
                Classroom classroom = ClassroomDao.getById(classId);

                // setters are called
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setContact(contact);
                student.setEmail(email);
                student.setGender(gender);
                student.setClassroom(classroom);

                // add object to ArrayList
                list.add(student);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        return null;
    }

}