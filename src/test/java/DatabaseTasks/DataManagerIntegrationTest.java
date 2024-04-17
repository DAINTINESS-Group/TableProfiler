package DatabaseTasks;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DatabaseTasks.DataManager;
import Enums.MetadataType;

public class DataManagerIntegrationTest {

    private Connection connection;
    private DataManager dataManager;
    String schemaName = "adventureworks";
    String tableName = "salesorderheader";

    @Before
    public void setUp() throws SQLException {
        // Establish a connection to your testing database
        String jdbcUrl = "jdbc:mysql://localhost:3306/adventureworks";
        String username = "reportUser";
        String password = "123456";

        connection = DriverManager.getConnection(jdbcUrl, username, password);
        dataManager = new DataManager();
    }

    @After
    public void tearDown() throws SQLException {
        // Close the connection after the test
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testExtractTableMetadataForTables() throws SQLException {
        
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.TABLES, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForColumns() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.COLUMNS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForPrimaryKeys() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.PRIMARY_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForImportedKeys() throws SQLException {
       
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.IMPORTED_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForExportedKeys() throws SQLException {
     
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.EXPORTED_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForIndexes() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.INDEXES, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForTablePrivileges() throws SQLException {
    
        ResultSet resultSet = dataManager.extractTableMetadata(connection, MetadataType.TABLE_PRIVILEGES, schemaName, tableName);

        assertNotNull(resultSet);

        assertFalse(resultSet.next());
    }    
}