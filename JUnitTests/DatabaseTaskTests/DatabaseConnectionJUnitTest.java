package DatabaseTaskTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DatabaseTasks.DatabaseConnection;

class DatabaseConnectionTest {

    private static Connection connection;

    @BeforeAll
    static void setUp() {
        // Establish a connection before running tests
        connection = DatabaseConnection.connect();
    }

    @AfterAll
    static void tearDown() {
        // Close the connection after running tests
        DatabaseConnection.closeConnection();
    }

    @Test
    void testConnectionNotNull() {
        assertNotNull(connection, "Connection should not be null");
    }

    @Test
    void testConnectionIsOpen() {
        try {
			assertTrue(DatabaseConnection.connect().isValid(5), "Connection should be open and valid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}