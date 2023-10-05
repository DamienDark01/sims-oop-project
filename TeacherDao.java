/*
 * Classname : TeacherDao
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
public class TeacherDao {
    
    // show all
    public static ArrayList<Teacher> getAll() {
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
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

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Teacher getById(String pId) {
        Teacher teacher = new Teacher();

        try {
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

            return teacher;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Teacher> getByName(String name) {
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
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

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}