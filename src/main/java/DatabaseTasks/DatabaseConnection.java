package DatabaseTasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DatabaseConnection {

    // JDBC URL, username, and password of MySQL server
//    private static final String URL = "jdbc:mysql://localhost:3306/dwh";
//    private static final String USER = "root";
//    private static final String PASSWORD = "123456";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;

    // Method to establish a connection to the database
    public static Connection connect(String ip, String schema, String username, String password) {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            ip = "jdbc:mysql://"+ip+"/"+schema;
            // Open a connection
            connection = DriverManager.getConnection(ip, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    // Method to close the connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}