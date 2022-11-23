import java.beans.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Demo
 */
public class Demo {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="";
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}