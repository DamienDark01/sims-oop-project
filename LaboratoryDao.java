import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LaboratoryDao {
    
    public static ArrayList<Laboratory> getAll() {
        ArrayList<Laboratory> list = new ArrayList<Laboratory>();

        try {
            String query = "SELECT * FROM laboratory;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Laboratory lab = new Laboratory();

                // setters are called

                // object is added to ArrayList
                list.add(lab);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}