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

public class ExportedKeysTest {

    @Test
    public void testExportedKeys() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.EXPORTED_KEYS);
        metaManager.createMetadata(tableTypes, "adventureworks", "creditcard", connection);
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("EXPORTED_KEYS");
        
        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement("SELECT \r\n"
        		+ "    		CONSTRAINT_CATALOG\r\n"
        		+ "        		,CONSTRAINT_SCHEMA                \r\n"
        		+ "        		,CONSTRAINT_NAME\r\n"
        		+ "        		,TABLE_CATALOG\r\n"
        		+ "        		,TABLE_SCHEMA\r\n"
        		+ "        		,TABLE_NAME\r\n"
        		+ "        		,COLUMN_NAME\r\n"
        		+ "        		,POSITION_IN_UNIQUE_CONSTRAINT\r\n"
        		+ "        		,REFERENCED_TABLE_SCHEMA\r\n"
        		+ "        		,REFERENCED_TABLE_NAME\r\n"
        		+ "        		,REFERENCED_COLUMN_NAME\r\n"
        		+ "        		 FROM information_schema.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_NAME = 'creditcard'\r\n");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
        	 while (resultSet.next() && sqlResultSet.next()) {
                 // Compare each imported key column description
                 assertEquals(resultSet.getString("PKTABLE_CAT"), sqlResultSet.getString("REFERENCED_TABLE_SCHEMA"));
                 if (resultSet.getString("PKTABLE_SCHEM") != null ) {
                 	assertEquals(resultSet.getString("PKTABLE_SCHEM"), sqlResultSet.getString("REFERENCED_TABLE_SCHEMA"));
                 }
                 assertEquals(resultSet.getString("PKTABLE_NAME"), sqlResultSet.getString("REFERENCED_TABLE_NAME"));
                 assertEquals(resultSet.getString("PKCOLUMN_NAME"), sqlResultSet.getString("REFERENCED_COLUMN_NAME"));
                 assertEquals(resultSet.getString("FKTABLE_CAT"), sqlResultSet.getString("REFERENCED_TABLE_SCHEMA"));
                 if (resultSet.getString("PKTABLE_SCHEM") != null ) {
                 	assertEquals(resultSet.getString("FKTABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEMA"));
                 }
                 assertEquals(resultSet.getString("FKTABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
                 assertEquals(resultSet.getString("FKCOLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                 //assertEquals(resultSet.getShort("KEY_SEQ"), sqlResultSet.getShort("ORDINAL_POSITION"));
                 //assertEquals(resultSet.getShort("UPDATE_RULE"), sqlResultSet.getShort("UPDATE_RULE"));
                 //assertEquals(resultSet.getShort("DELETE_RULE"), sqlResultSet.getShort("DELETE_RULE"));
                 assertEquals(resultSet.getString("FK_NAME"), sqlResultSet.getString("CONSTRAINT_NAME"));
                 //assertEquals(resultSet.getString("PK_NAME"), sqlResultSet.getString("CONSTRAINT_NAME"));
                 //assertEquals(resultSet.getShort("DEFERRABILITY"), sqlResultSet.getShort("DEFERRABILITY"));
             }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}