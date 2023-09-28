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
    
    public static ArrayList<Teacher> getAll() {
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
            String query = "SELECT * FROM teacher;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Teacher teacher = new Teacher();

                // setters are called

                // object is added to the list
                list.add(teacher);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}