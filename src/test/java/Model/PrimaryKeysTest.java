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

public class PrimaryKeysTest {

    @Test
    public void testPrimaryKeys() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.PRIMARY_KEYS);
        metaManager.createMetadata(tableTypes, "adventureworks", "contactcreditcard", connection);
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("PRIMARY_KEYS");
        //System.out.println(resultSet.getShort("KEY_SEQ"));
        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement("SELECT \r\n"
        		+ "    		CONSTRAINT_CATALOG\r\n"
        		+ "        		,CONSTRAINT_SCHEMA                \r\n"
        		+ "        		,CONSTRAINT_NAME\r\n"
        		+ "        		,TABLE_CATALOG\r\n"
        		+ "        		,TABLE_SCHEMA\r\n"
        		+ "        		,TABLE_NAME\r\n"
        		+ "        		,COLUMN_NAME\r\n"
        		+ "        		,ORDINAL_POSITION\r\n"
        		+ "        		,REFERENCED_TABLE_SCHEMA\r\n"
        		+ "        		,REFERENCED_TABLE_NAME\r\n"
        		+ "        		,REFERENCED_COLUMN_NAME\r\n"
        		+ "        		 FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME = 'contactcreditcard'\r\n"
        		+ "                 and CONSTRAINT_NAME = 'PRIMARY'");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
                // Compare each primary key column description
                assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("CONSTRAINT_SCHEMA"));
                if (resultSet.getString("TABLE_SCHEM") != null ) {
                	assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("CONSTRAINT_SCHEMA"));                	
                }
                assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
                assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                assertEquals(resultSet.getShort("KEY_SEQ"), sqlResultSet.getShort("ORDINAL_POSITION"));
                assertEquals(resultSet.getString("PK_NAME"), sqlResultSet.getString("CONSTRAINT_NAME"));
            }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}