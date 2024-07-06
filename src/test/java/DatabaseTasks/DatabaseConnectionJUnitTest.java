package DatabaseTasks;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DatabaseConnectionJUnitTest {

    private static final String TEST_IP = "localhost:3306";
    private static final String TEST_USERNAME = "reportUser";
    private static final String TEST_PASSWORD = "123456";
    private static final String TEST_SCHEMA = "adventureworks";

    private Connection testConnection;

    @BeforeEach
    public void setUp() {
        // Set up any preconditions or resources needed for the tests
    }

    @AfterEach
    public void tearDown() {
        // Clean up any resources after the tests
    }

    @Test
    public void testConnect() {
        // Test connection establishment

        // Act
        testConnection = DatabaseConnection.connect(TEST_IP, TEST_SCHEMA, TEST_USERNAME, TEST_PASSWORD);

        // Assert
        assertNotNull(testConnection);
        try {
            assertFalse(testConnection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testCloseConnection() {
        // Test connection closure

        // Arrange
        testConnection = DatabaseConnection.connect(TEST_IP, TEST_SCHEMA, TEST_USERNAME, TEST_PASSWORD);

        // Act
        DatabaseConnection.closeConnection();

        // Assert
        try {
            assertTrue(testConnection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQLException: " + e.getMessage());
        }
    }
}