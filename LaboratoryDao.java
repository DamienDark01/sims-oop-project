/*
 * Classname : LaboratoryDao
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
public class LaboratoryDao {
    
    // show all
    public static ArrayList<Laboratory> getAll() {
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            String query = "SELECT * FROM laboratory;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                Laboratory lab = new Laboratory();
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);

                // object is added to ArrayList
                list.add(lab);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Laboratory getById(String pId) {
        Laboratory lab = new Laboratory();

        try {
            String query = "SELECT * FROM laboratory WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);
            }

            return lab;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Laboratory> getByName(String name) {
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            String query = "SELECT * FROM laboratory WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                String id = rslt.getString("lab_id");
                String purpose = rslt.getString("purpose");
                String location = rslt.getString("location");
                String teacherId = rslt.getString("teacher_id");

                Laboratory lab = new Laboratory();
                Teacher teacher = TeacherDao.getById(teacherId);

                // setters are called
                lab.setId(id);
                lab.setPurpose(purpose);
                lab.setLocation(location);
                lab.setTeacher(teacher);

                // add object to ArrayList
                list.add(lab);
            }

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}