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

    public static ArrayList<Classroom> getAll() {
        ArrayList<Classroom> list = new ArrayList<Classroom>();

        try {
            String query = "SELECT * FROM classroom;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Classroom classroom = new Classroom();

                // setters are called

                // object is added to ArrayList
                list.add(classroom);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}