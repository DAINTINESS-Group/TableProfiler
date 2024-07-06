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

public class IndexInfoTest {

    @Test
    public void testIndexInfo() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "adventureworks", "reportUser", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.INDEXES);
        metaManager.createMetadata("localhost:3306", "adventureworks", "reportUser", "123456", tableTypes, "adventureworks", "contactcreditcard");
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("INDEXES");

        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement(" SELECT \r\n"
        		+ " a.TABLE_CATALOG\r\n"
        		+ ",a.TABLE_SCHEMA\r\n"
        		+ ",a.TABLE_NAME\r\n"
        		+ ",case when a.NON_UNIQUE = 1 then 'true' else 'false' end as NON_UNIQUE\r\n"
        		+ ",a.INDEX_SCHEMA\r\n"
        		+ ",a.INDEX_NAME\r\n"
        		+ ",a.SEQ_IN_INDEX\r\n"
        		+ ",a.COLUMN_NAME\r\n"
        		+ ",a.COLLATION\r\n"
        		+ ",a.CARDINALITY\r\n"
        		+ ",a.SUB_PART\r\n"
        		+ ",a.PACKED\r\n"
        		+ ",a.NULLABLE\r\n"
        		+ ",a.INDEX_TYPE\r\n"
        		+ ",a.COMMENT\r\n"
        		+ ",a.INDEX_COMMENT\r\n"
        		+ ",a.IS_VISIBLE\r\n"
        		+ ",a.EXPRESSION\r\n"
        		+ ",c.INDEX_ID\r\n"
        		+ ",c.NAME\r\n"
        		+ ",c.TABLE_ID\r\n"
        		+ ",c.TYPE\r\n"
        		+ ",c.N_FIELDS\r\n"
        		+ ",c.PAGE_NO\r\n"
        		+ ",c.SPACE\r\n"
        		+ ",c.MERGE_THRESHOLD\r\n"
        		+ " FROM information_schema.statistics a\r\n"
        		+ " inner join information_schema.INNODB_TABLES b \r\n"
        		+ "	on concat(a.TABLE_SCHEMA,'/',a.TABLE_NAME) = b.NAME\r\n"
        		+ "inner join information_schema.INNODB_INDEXES c \r\n"
        		+ "	on b.table_id = c.table_id and a.INDEX_NAME = c.NAME\r\n"
        		+ " WHERE a.TABLE_NAME = 'contactcreditcard' \r\n"
        		+ " and c.type <> 0");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
            	if ( resultSet.getShort("TYPE") != 0) {
            		// Compare each index info description
                    assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("TABLE_SCHEMA"));
                    if(resultSet.getString("TABLE_SCHEM") != null) {
                    	assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEMA"));                	
                    }
                    assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
                    assertEquals(resultSet.getBoolean("NON_UNIQUE"), sqlResultSet.getBoolean("NON_UNIQUE"));
                    //assertEquals(resultSet.getString("INDEX_QUALIFIER"), sqlResultSet.getString("INDEX_QUALIFIER"));
                    assertEquals(resultSet.getString("INDEX_NAME"), sqlResultSet.getString("INDEX_NAME"));
                    assertEquals(resultSet.getShort("TYPE"), sqlResultSet.getShort("TYPE"));
                    assertEquals(resultSet.getShort("ORDINAL_POSITION"), sqlResultSet.getShort("SEQ_IN_INDEX"));
                    assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                    //didn't store the information anyware in information_schema
                    //assertEquals(resultSet.getString("ASC_OR_DESC"), sqlResultSet.getString("ASC_OR_DESC"));
                    assertEquals(resultSet.getLong("CARDINALITY"), sqlResultSet.getLong("CARDINALITY"));
                   // assertEquals(resultSet.getLong("PAGES"), sqlResultSet.getLong("PAGE_NO"));
                   // assertEquals(resultSet.getString("FILTER_CONDITION"), sqlResultSet.getString("FILTER_CONDITION"));	
            	}                
            }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}