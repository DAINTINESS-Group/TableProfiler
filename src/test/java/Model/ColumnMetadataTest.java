package Model;

import org.junit.jupiter.api.Test;

import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;
import Enums.SQLTypeMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.sql.*;
import java.util.ArrayList;

public class ColumnMetadataTest {

    @Test
    public void testColumnMetadata() throws SQLException {
        	Connection connection = DatabaseConnection.connect("localhost:3306", "adventureworks", "reportUser", "123456"); 
        	MetadataManager metaManager = new MetadataManager();
            ArrayList<MetadataType> tableTypes =  new ArrayList<MetadataType>();
        	tableTypes.add(MetadataType.COLUMNS);
        	metaManager.createMetadata(tableTypes,"adventureworks", "contactcreditcard", connection);
        	ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("COLUMNS");
            // Execute the SQL query
            try (PreparedStatement statement = connection.prepareStatement("select "
            		+ "TABLE_CATALOG\r\n"
            		+ ",TABLE_SCHEMA\r\n"
            		+ ",TABLE_NAME\r\n"
            		+ ",COLUMN_NAME\r\n"
            		+ ",ORDINAL_POSITION\r\n"
            		+ ",case when UPPER(COLUMN_DEFAULT) = 'DATETIME' then 'DATE' else UPPER(COLUMN_DEFAULT) end COLUMN_DEFAULT\r\n"
            		+ ",IS_NULLABLE\r\n"
            		+ ",case when UPPER(DATA_TYPE) = 'DATETIME' then 'DATE' else UPPER(DATA_TYPE) end DATA_TYPE\r\n"
            		+ ",CHARACTER_MAXIMUM_LENGTH\r\n"
            		+ ",CHARACTER_OCTET_LENGTH\r\n"
            		+ ",NUMERIC_PRECISION\r\n"
            		+ ",NUMERIC_SCALE\r\n"
            		+ ",DATETIME_PRECISION\r\n"
            		+ ",CHARACTER_SET_NAME\r\n"
            		+ ",COLLATION_NAME\r\n"
            		+ ",COLUMN_TYPE\r\n"
            		+ ",COLUMN_KEY\r\n"
            		+ ",EXTRA\r\n"
            		+ ",PRIVILEGES\r\n"
            		+ ",COLUMN_COMMENT\r\n"
            		+ ",GENERATION_EXPRESSION\r\n"
            		+ ",SRS_ID\r\n"
            		+ " from information_schema.COLUMNS B where B.table_name = 'contactcreditcard'");
                 ResultSet sqlResultSet = statement.executeQuery()) {

                // Loop through the result sets and compare values
                while (resultSet.next() && sqlResultSet.next()) {
                    // Compare each column's metadata
                	assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                    assertEquals(SQLTypeMapper.getSqlTypeName(Integer.parseInt(resultSet.getString("DATA_TYPE").toString())), sqlResultSet.getString("DATA_TYPE"));
                    assertEquals(resultSet.getString("TYPE_NAME"), sqlResultSet.getString("DATA_TYPE"));
                    //assertEquals(resultSet.getString("COLUMN_SIZE"), sqlResultSet.getString("NUMERIC_PRECISION"));
                    assertEquals(resultSet.getInt("DECIMAL_DIGITS"), sqlResultSet.getInt("NUMERIC_SCALE"));
                    int expectedValueFromResultSet = resultSet.getInt("NUM_PREC_RADIX");
                    String numericPrecisionStr = sqlResultSet.getString("NUMERIC_PRECISION");
                    Integer parsedNumericPrecision = numericPrecisionStr != null ? Integer.parseInt(numericPrecisionStr) : null;
                    // Assert if the values are equal
                    if (numericPrecisionStr != null) {
                        assertEquals(Integer.valueOf(expectedValueFromResultSet), parsedNumericPrecision);
                    } else {
                        assertNull(parsedNumericPrecision);
                    }
                    //assertEquals(resultSet.getInt("NUM_PREC_RADIX"), Integer.parseInt(sqlResultSet.getString("NUMERIC_PRECISION")));
                    assertEquals(resultSet.getString("COLUMN_DEF"), sqlResultSet.getString("COLUMN_DEFAULT"));
                    assertEquals(resultSet.getInt("CHAR_OCTET_LENGTH"), sqlResultSet.getInt("CHARACTER_OCTET_LENGTH"));
                    assertEquals(resultSet.getInt("ORDINAL_POSITION"), sqlResultSet.getInt("ORDINAL_POSITION"));
                    assertEquals(resultSet.getString("IS_NULLABLE"), sqlResultSet.getString("IS_NULLABLE"));
                    //assertEquals(resultSet.getString("IS_AUTOINCREMENT"), sqlResultSet.getString("IS_AUTOINCREMENT"));
                    //assertEquals(resultSet.getString("IS_GENERATEDCOLUMN"), sqlResultSet.getString("IS_GENERATEDCOLUMN"));
                }

                // Ensure both result sets have been fully traversed
                assertFalse(resultSet.next());
                assertFalse(sqlResultSet.next());
            }
        }
   }
