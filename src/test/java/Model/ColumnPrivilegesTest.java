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

public class ColumnPrivilegesTest {

    @Test
    public void testColumnPrivileges() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "adventureworks", "reportUser", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.COLUMN_PRIVILEGES);
        metaManager.createMetadata("localhost:3306", "adventureworks", "reportUser", "123456", tableTypes, "adventureworks", "contactcreditcard");
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("COLUMN_PRIVILEGES");
        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement("select \r\n"
        		+ "GRANTEE\r\n"
        		+ ",TABLE_CATALOG\r\n"
        		+ ",TABLE_SCHEMA\r\n"
        		+ ",TABLE_NAME\r\n"
        		+ ",COLUMN_NAME\r\n"
        		+ ",PRIVILEGE_TYPE\r\n"
        		+ ",IS_GRANTABLE\r\n"
        		+ "from information_schema.COLUMN_PRIVILEGES B where B.table_name = 'contactcreditcard'");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
                // Compare each column's metadata
                assertEquals(resultSet.getString("GRANTEE"), sqlResultSet.getString("GRANTEE"));
                assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("TABLE_SCHEMA"));
                if (resultSet.getString("TABLE_SCHEM") != null) {                	
                	assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEMA"));
                }
                assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
                assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                assertEquals(resultSet.getString("PRIVILEGE"), sqlResultSet.getString("PRIVILEGE_TYPE"));
                assertEquals(resultSet.getString("IS_GRANTABLE"), sqlResultSet.getString("IS_GRANTABLE"));
            }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}