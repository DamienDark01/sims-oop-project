/*
 * Class Name : ClassroomDao
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
class ClassroomDao {

    // show all
    public static ArrayList<Classroom> getAll() {
        // create the returning list
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Classroom classroom = ClassroomDao.getById(classId);
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);

                // object is added to ArrayList
                list.add(classroom);
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
    public static Classroom getById(String id) {
        // create returning object
        Classroom classroom = new Classroom();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);
            }

            // return object
            return classroom;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        // returns null if the above list is not returned
        return null;
    }

    // search by name
    public static ArrayList<Classroom> getByName(String name) {
        // create the returning list
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM classroom WHERE name LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                // using Data Access Objects to create specific objects
                Classroom classroom = ClassroomDao.getById(classId);
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                classroom.setId(classId);
                classroom.setTeacher(teacher);
                classroom.setLocation(location);
                classroom.setCapacity(capacity);

                // add object to ArrayList
                list.add(classroom);
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

}