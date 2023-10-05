/*
 * Classname : ExaminationDao
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
class ExaminationDao {

    // show all
    public static ArrayList<Examination> getAll() {
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            String query = "SELECT * FROM examination;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by id
    public static Examination getById(String pId) {
        Examination exam = new Examination();

        try {
            String query = "SELECT * FROM examination WHERE id = " + pId + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                exam.setId(id);
                exam.setSubject(sub);
                exam.setExamType(examType);
                exam.setDuration(duration);
            }

            return exam;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    // search by name
    public static ArrayList<Examination> getByName(String name) {
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            String query = "SELECT * FROM examination WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("exam_id");
                String subjectId = rslt.getString("sub_id");
                String examType = rslt.getString("exam_type");
                String duration = rslt.getString("duration");

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

            return list;
        } catch (SQLException e) {
            // gui
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}