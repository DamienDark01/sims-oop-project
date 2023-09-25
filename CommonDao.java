import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonDao {

    private static Connection dbcon;
    private static Statement stmt;
    private static ResultSet rslt;

    public static ResultSet getResultSet(String sqlQuery) {
        try {
            // enter correct URL
            dbcon = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "1234");
            stmt = dbcon.createStatement();
            rslt = stmt.executeQuery(sqlQuery);

            return rslt;
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

}