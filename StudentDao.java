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
                String id = rslt.getString("student_id");
                String firstName = rslt.getString("student_f_name");
                String lastName = rslt.getString("student_l_name");
                String address = rslt.getString("s_address");
                String contact = rslt.getString("s_contact");
                String email = rslt.getString("s_email");
                String gender = rslt.getString("gender");
                String classId = rslt.getString("class_id");

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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Student getById(String pId) {
        Student student = new Student();

        try {
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

            return student;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Student> getByName(String name) {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}