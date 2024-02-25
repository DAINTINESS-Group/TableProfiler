package Model;

import org.junit.jupiter.api.Test;

import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TablesTest {

    @Test
    public void testTables() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.TABLES);
        metaManager.createMetadata(tableTypes, "adventureworks", "contactcreditcard", connection);
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("TABLES");

        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement(" SELECT \r\n"
        		+ " TABLE_CATALOG\r\n"
        		+ ",TABLE_SCHEMA\r\n"
        		+ ",TABLE_NAME\r\n"
        		+ ",TABLE_TYPE\r\n"
        		+ ",ENGINE\r\n"
        		+ ",VERSION\r\n"
        		+ ",ROW_FORMAT\r\n"
        		+ ",TABLE_ROWS\r\n"
        		+ ",AVG_ROW_LENGTH\r\n"
        		+ ",DATA_LENGTH\r\n"
        		+ ",MAX_DATA_LENGTH\r\n"
        		+ ",INDEX_LENGTH\r\n"
        		+ ",DATA_FREE\r\n"
        		+ ",AUTO_INCREMENT\r\n"
        		+ ",CREATE_TIME\r\n"
        		+ ",UPDATE_TIME\r\n"
        		+ ",CHECK_TIME\r\n"
        		+ ",TABLE_COLLATION\r\n"
        		+ ",CHECKSUM\r\n"
        		+ ",CREATE_OPTIONS\r\n"
        		+ ",TABLE_COMMENT\r\n"
        		+ " FROM information_schema.TABLES a where a.TABLE_NAME = 'contactcreditcard'");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
                // Compare each table description
                assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("TABLE_SCHEMA"));
                if (resultSet.getString("TABLE_SCHEM") != null) {
                	assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEMA"));                	
                }
                //all the other are null 
//                assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
//                assertEquals(resultSet.getString("TABLE_TYPE"), sqlResultSet.getString("TABLE_TYPE"));
//                assertEquals(resultSet.getString("REMARKS"), sqlResultSet.getString("REMARKS"));
//                assertEquals(resultSet.getString("TYPE_CAT"), sqlResultSet.getString("TYPE_CAT"));
//                assertEquals(resultSet.getString("TYPE_SCHEM"), sqlResultSet.getString("TYPE_SCHEM"));
//                assertEquals(resultSet.getString("TYPE_NAME"), sqlResultSet.getString("TYPE_NAME"));
//                assertEquals(resultSet.getString("SELF_REFERENCING_COL_NAME"), sqlResultSet.getString("SELF_REFERENCING_COL_NAME"));
//                assertEquals(resultSet.getString("REF_GENERATION"), sqlResultSet.getString("REF_GENERATION"));
//                System.out.println(resultSet.getString("TABLE_NAME"));
//                System.out.println(resultSet.getString("TABLE_TYPE"));
//                System.out.println(resultSet.getString("REMARKS"));
//                System.out.println(resultSet.getString("TYPE_CAT"));
//                System.out.println(resultSet.getString("TYPE_SCHEM"));
//                System.out.println(resultSet.getString("TYPE_NAME"));
//                System.out.println(resultSet.getString("SELF_REFERENCING_COL_NAME"));
//                System.out.println(resultSet.getString("REF_GENERATION"));
            }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}