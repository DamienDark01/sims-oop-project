import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDao {
    
    public static ArrayList<Subject> getAll() {
        ArrayList<Subject> list = new ArrayList<Subject>();

        try {
            String query = "SELECT * FROM student;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Subject sub = new Subject();

                // setters are called

                // object is added to ArrayList
                list.add(sub);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}