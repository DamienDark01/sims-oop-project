/*
 * Classname : ClassroomDao
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
class ClassroomDao {

    // show all
    public static ArrayList<Classroom> getAll() {
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            String query = "SELECT * FROM classroom;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String classId = rslt.getString("class_id");
                String teacherId = rslt.getString("teacher_id");
                String location = rslt.getString("location");
                int capacity = rslt.getInt("capacity");

                Classroom classroom = ClassroomDao.getById(classId);
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called

                // object is added to ArrayList
                list.add(classroom);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Classroom getById(String id) {
        Classroom classroom = new Classroom();

        try {
            String query = "SELECT * FROM classroom WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                // setters are called

            }

            return classroom;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Classroom> getByName(String name) {
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            String query = "SELECT * FROM classroom WHERE name LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Classroom classroom = new Classroom();

                // setters are called

                // add object to ArrayList
                list.add(classroom);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}