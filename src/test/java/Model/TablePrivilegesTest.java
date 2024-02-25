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

public class TablePrivilegesTest {

    @Test
    public void testTablePrivileges() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.TABLE_PRIVILEGES);
        metaManager.createMetadata(tableTypes, "adventureworks", "contactcreditcard", connection);
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("TABLE_PRIVILEGES");

        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement(" SELECT GRANTEE\r\n"
        		+ ",TABLE_CATALOG\r\n"
        		+ ",TABLE_SCHEMA\r\n"
        		+ ",TABLE_NAME\r\n"
        		+ ",PRIVILEGE_TYPE\r\n"
        		+ ",IS_GRANTABLE\r\n"
        		+ " FROM information_schema.TABLE_PRIVILEGES WHERE TABLE_NAME = 'contactcreditcard'");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
                // Compare each privilege description
                assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("TABLE_SCHEMA"));
                if (resultSet.getString("TABLE_SCHEM") != null ) {
                 	assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEMA"));
                 }
                assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
               // assertEquals(resultSet.getString("GRANTOR"), sqlResultSet.getString("GRANTOR"));
                assertEquals(resultSet.getString("GRANTEE"), sqlResultSet.getString("GRANTEE").replaceAll("'", ""));
                assertEquals(resultSet.getString("PRIVILEGE"), sqlResultSet.getString("PRIVILEGE_TYPE"));
               // assertEquals(resultSet.getString("IS_GRANTABLE"), sqlResultSet.getString("IS_GRANTABLE"));
            }

            // Ensure both result sets have been fully traversed
           // assertFalse(resultSet.next());
           // assertFalse(sqlResultSet.next());
        }
    }
}