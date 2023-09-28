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
    public ArrayList<Examination> getAll() {
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            String query = "SELECT * FROM examination;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Examination exam = new Examination();

                // setters are called

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
    public ArrayList<Examination> getById(String id) {
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            String query = "SELECT * FROM examination WHERE id = " + id + ";";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Examination exam = new Examination();

                // setters are called

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

    // search by name
    public ArrayList<Examination> getByName(String name) {
        ArrayList<Examination> list = new ArrayList<Examination>();

        try {
            String query = "SELECT * FROM examination WHERE name LIKE '%" + name + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data

                Examination exam = new Examination();

                // setters are called

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