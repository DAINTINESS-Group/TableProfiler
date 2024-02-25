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
/**
 * There is no table in database for this resultSet 
 * ***/
public class TypeInfoTest {

//    @Test
//    public void testTypeInfo() throws SQLException {
//        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
//        MetadataManager metaManager = new MetadataManager();
//        ArrayList<MetadataType> tableTypes = new ArrayList<>();
//        tableTypes.add(MetadataType.TYPE_INFO);
//        metaManager.createMetadata(tableTypes, "", "", connection);
//        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("TYPE_INFO");
//
//        // Execute the SQL query
//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM information_schema.columns");
//             ResultSet sqlResultSet = statement.executeQuery()) {
//
//            // Loop through the result sets and compare values
//            while (resultSet.next() && sqlResultSet.next()) {
//                // Compare each type info description
////                assertEquals(resultSet.getString("TYPE_NAME"), sqlResultSet.getString("TYPE_NAME"));
////                assertEquals(resultSet.getInt("DATA_TYPE"), sqlResultSet.getInt("DATA_TYPE"));
////                assertEquals(resultSet.getInt("PRECISION"), sqlResultSet.getInt("PRECISION"));
////                assertEquals(resultSet.getString("LITERAL_PREFIX"), sqlResultSet.getString("LITERAL_PREFIX"));
////                assertEquals(resultSet.getString("LITERAL_SUFFIX"), sqlResultSet.getString("LITERAL_SUFFIX"));
////                assertEquals(resultSet.getString("CREATE_PARAMS"), sqlResultSet.getString("CREATE_PARAMS"));
////                assertEquals(resultSet.getShort("NULLABLE"), sqlResultSet.getShort("NULLABLE"));
////                assertEquals(resultSet.getBoolean("CASE_SENSITIVE"), sqlResultSet.getBoolean("CASE_SENSITIVE"));
////                assertEquals(resultSet.getShort("SEARCHABLE"), sqlResultSet.getShort("SEARCHABLE"));
////                assertEquals(resultSet.getBoolean("UNSIGNED_ATTRIBUTE"), sqlResultSet.getBoolean("UNSIGNED_ATTRIBUTE"));
////                assertEquals(resultSet.getBoolean("FIXED_PREC_SCALE"), sqlResultSet.getBoolean("FIXED_PREC_SCALE"));
////                assertEquals(resultSet.getBoolean("AUTO_INCREMENT"), sqlResultSet.getBoolean("AUTO_INCREMENT"));
////                assertEquals(resultSet.getString("LOCAL_TYPE_NAME"), sqlResultSet.getString("LOCAL_TYPE_NAME"));
////                assertEquals(resultSet.getShort("MINIMUM_SCALE"), sqlResultSet.getShort("MINIMUM_SCALE"));
////                assertEquals(resultSet.getShort("MAXIMUM_SCALE"), sqlResultSet.getShort("MAXIMUM_SCALE"));
////                assertEquals(resultSet.getInt("SQL_DATA_TYPE"), sqlResultSet.getInt("SQL_DATA_TYPE"));
////                assertEquals(resultSet.getInt("SQL_DATETIME_SUB"), sqlResultSet.getInt("SQL_DATETIME_SUB"));
////                assertEquals(resultSet.getInt("NUM_PREC_RADIX"), sqlResultSet.getInt("NUM_PREC_RADIX"));
//            	System.out.println(resultSet.getString("TYPE_NAME"));
//            	System.out.println(resultSet.getInt("DATA_TYPE"));
//            	System.out.println(resultSet.getInt("PRECISION"));
//            	System.out.println(resultSet.getString("LITERAL_PREFIX"));
//            	System.out.println(resultSet.getString("LITERAL_SUFFIX"));
//            	System.out.println(resultSet.getString("CREATE_PARAMS"));
//            	System.out.println(resultSet.getShort("NULLABLE"));
//            	System.out.println(resultSet.getBoolean("CASE_SENSITIVE"));
//            	System.out.println(resultSet.getShort("SEARCHABLE"));
//            	System.out.println(resultSet.getBoolean("UNSIGNED_ATTRIBUTE"));
//            	System.out.println(resultSet.getBoolean("FIXED_PREC_SCALE"));
//            	System.out.println(resultSet.getBoolean("AUTO_INCREMENT"));
//            	System.out.println(resultSet.getString("LOCAL_TYPE_NAME"));
//            	System.out.println(resultSet.getShort("MINIMUM_SCALE"));
//            	System.out.println(resultSet.getShort("MAXIMUM_SCALE"));
//            	System.out.println(resultSet.getInt("SQL_DATA_TYPE"));
//            	System.out.println(resultSet.getInt("SQL_DATETIME_SUB"));
//            	System.out.println(resultSet.getInt("NUM_PREC_RADIX"));
//            	System.out.println();
//            }
//
//            // Ensure both result sets have been fully traversed
////            assertFalse(resultSet.next());
////            assertFalse(sqlResultSet.next());
//        }
//    }
}