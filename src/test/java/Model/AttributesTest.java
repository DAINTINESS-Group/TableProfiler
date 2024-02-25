package Model;

import org.junit.jupiter.api.Test;

import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;
import Enums.SQLTypeMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class AttributesTest {

//    @Test
//    public void testAttributes() throws SQLException {
//        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
//        MetadataManager metaManager = new MetadataManager();
//        ArrayList<MetadataType> tableTypes = new ArrayList<>();
//        tableTypes.add(MetadataType.ATTRIBUTES);
//        metaManager.createMetadata(tableTypes, "adventureworks", "", connection);
//        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("ATTRIBUTES");
//
//        // Execute the SQL query
//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM information_schema.ATTRIBUTES");
//             ResultSet sqlResultSet = statement.executeQuery()) {
//
//            // Loop through the result sets and compare values
//            while (resultSet.next() && sqlResultSet.next()) {
//                // Compare each attribute description
//                assertEquals(resultSet.getString("TYPE_CAT"), sqlResultSet.getString("TYPE_CAT"));
//                assertEquals(resultSet.getString("TYPE_SCHEM"), sqlResultSet.getString("TYPE_SCHEM"));
//                assertEquals(resultSet.getString("TYPE_NAME"), sqlResultSet.getString("TYPE_NAME"));
//                assertEquals(resultSet.getString("ATTR_NAME"), sqlResultSet.getString("ATTR_NAME"));
//                assertEquals(SQLTypeMapper.getSqlTypeName(Integer.parseInt(resultSet.getString("DATA_TYPE").toString())), sqlResultSet.getString("DATA_TYPE"));
//                assertEquals(resultSet.getString("ATTR_TYPE_NAME"), sqlResultSet.getString("ATTR_TYPE_NAME"));
//                assertEquals(resultSet.getInt("ATTR_SIZE"), sqlResultSet.getInt("ATTR_SIZE"));
//                assertEquals(resultSet.getInt("DECIMAL_DIGITS"), sqlResultSet.getInt("NUMERIC_SCALE"));
//                int expectedValueFromResultSet = resultSet.getInt("NUM_PREC_RADIX");
//                String numericPrecisionStr = sqlResultSet.getString("NUMERIC_PRECISION");
//                Integer parsedNumericPrecision = numericPrecisionStr != null ? Integer.parseInt(numericPrecisionStr) : null;
//                // Assert if the values are equal
//                if (numericPrecisionStr != null) {
//                    assertEquals(Integer.valueOf(expectedValueFromResultSet), parsedNumericPrecision);
//                } else {
//                    assertNull(parsedNumericPrecision);
//                }
//                assertEquals(resultSet.getInt("NULLABLE"), sqlResultSet.getInt("NULLABLE"));
//                assertEquals(resultSet.getString("REMARKS"), sqlResultSet.getString("REMARKS"));
//                assertEquals(resultSet.getString("ATTR_DEF"), sqlResultSet.getString("ATTR_DEF"));
//                assertEquals(resultSet.getInt("SQL_DATA_TYPE"), sqlResultSet.getInt("SQL_DATA_TYPE"));
//                assertEquals(resultSet.getInt("SQL_DATETIME_SUB"), sqlResultSet.getInt("SQL_DATETIME_SUB"));
//                assertEquals(resultSet.getInt("CHAR_OCTET_LENGTH"), sqlResultSet.getInt("CHAR_OCTET_LENGTH"));
//                assertEquals(resultSet.getInt("ORDINAL_POSITION"), sqlResultSet.getInt("ORDINAL_POSITION"));
//                assertEquals(resultSet.getString("IS_NULLABLE"), sqlResultSet.getString("IS_NULLABLE"));
//                assertEquals(resultSet.getString("SCOPE_CATALOG"), sqlResultSet.getString("SCOPE_CATALOG"));
//                assertEquals(resultSet.getString("SCOPE_SCHEMA"), sqlResultSet.getString("SCOPE_SCHEMA"));
//                assertEquals(resultSet.getString("SCOPE_TABLE"), sqlResultSet.getString("SCOPE_TABLE"));
//                assertEquals(resultSet.getShort("SOURCE_DATA_TYPE"), sqlResultSet.getShort("SOURCE_DATA_TYPE"));
//            }
//
//            // Ensure both result sets have been fully traversed
//            assertFalse(resultSet.next());
//            assertFalse(sqlResultSet.next());
//        }
//    }
}