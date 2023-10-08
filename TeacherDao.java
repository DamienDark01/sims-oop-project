/*
 * Class Name : TeacherDao
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
public class TeacherDao {
    
    // show all
    public static ArrayList<Teacher> getAll() {
        // create the returning list
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Teacher teacher = new Teacher();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);

                // object is added to the list
                list.add(teacher);
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

    // search by id
    public static Teacher getById(String pId) {
        // create returning object
        Teacher teacher = new Teacher();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);
            }

            // return object
            return teacher;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }

        // return object
        return null;
    }

    // search by name
    public static ArrayList<Teacher> getByName(String name) {
        // create the returning list
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Teacher teacher = new Teacher();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);

                // add object to ArrayList
                list.add(teacher);
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