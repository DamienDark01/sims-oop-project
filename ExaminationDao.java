/*
 * Class Name : ExaminationDao
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
class ExaminationDao {

    // show all
    public static ArrayList<Examination> getAll() {
        // create the returning list
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Examination exam = new Examination();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);

                // object is added to ArrayList
                list.add(exam);
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
    public static Examination getById(String pId) {
        // create returning object
        Examination exam = new Examination();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);
            }

            // return object
            return exam;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
        }

        return null;
    }

    // search by name
    public static ArrayList<Examination> getByName(String name) {
        // create the returning list
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM examination WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                // using Data Access Objects to create specific objects
                Examination exam = new Examination();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);

                // add object to ArrayList
                list.add(exam);
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