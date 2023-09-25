import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrincipalDao {
    
    public static ArrayList<Principal> getAll() {
        ArrayList<Principal> list = new ArrayList<Principal>();

        try {
            String query = "SELECT * FROM principal;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken

                Principal principal = new Principal();

                // setters are called

                // object is added to ArrayList
                list.add(principal);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}