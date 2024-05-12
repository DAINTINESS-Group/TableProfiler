package DatabaseTasks;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Enums.MetadataType;

public class DataManagerIntegrationTest {

    private Connection connection;
    private DataManager dataManager;
    String schemaName = "adventureworks";
    String tableName = "salesorderheader";
    String jdbcUrl = "jdbc:mysql://localhost:3306/adventureworks";
    String username = "reportUser";
    String password = "123456";

    @Before
    public void setUp() throws SQLException {
    	dataManager = new DataManager("localhost:3306", schemaName, username, password);
        //connection = DriverManager.getConnection(jdbcUrl, username, password);
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
        
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.TABLES, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForColumns() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.COLUMNS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForPrimaryKeys() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.PRIMARY_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForImportedKeys() throws SQLException {
       
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.IMPORTED_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForExportedKeys() throws SQLException {
     
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.EXPORTED_KEYS, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForIndexes() throws SQLException {
   
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.INDEXES, schemaName, tableName);

        assertNotNull(resultSet);

        assertTrue(resultSet.next());
    }

    @Test
    public void testExtractTableMetadataForTablePrivileges() throws SQLException {
    
        ResultSet resultSet = dataManager.extractTableMetadata(MetadataType.TABLE_PRIVILEGES, schemaName, tableName);

        assertNotNull(resultSet);

        assertFalse(resultSet.next());
    }    
}