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

public class BestRowIdentifierTest {

//    @Test
//    public void testBestRowIdentifier() throws SQLException {
//        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
//        MetadataManager metaManager = new MetadataManager();
//        ArrayList<MetadataType> tableTypes = new ArrayList<>();
//        tableTypes.add(MetadataType.BEST_ROW_IDENTIFIER);
//        metaManager.createMetadata(tableTypes, "adventureworks", "contactcreditcard", connection);
//        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("BEST_ROW_IDENTIFIER");
//
//        // Execute the SQL query
//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM information_schema.BEST_ROW_IDENTIFIER WHERE TABLE_NAME = 'contactcreditcard'");
//             ResultSet sqlResultSet = statement.executeQuery()) {
//
//            // Loop through the result sets and compare values
//            while (resultSet.next() && sqlResultSet.next()) {
//                // Compare each column description
//                assertEquals(resultSet.getShort("SCOPE"), sqlResultSet.getShort("SCOPE"));
//                assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
//                assertEquals(resultSet.getInt("DATA_TYPE"), sqlResultSet.getInt("DATA_TYPE"));
//                assertEquals(resultSet.getString("TYPE_NAME"), sqlResultSet.getString("TYPE_NAME"));
//                assertEquals(resultSet.getInt("COLUMN_SIZE"), sqlResultSet.getInt("COLUMN_SIZE"));
//                assertEquals(resultSet.getInt("BUFFER_LENGTH"), sqlResultSet.getInt("BUFFER_LENGTH"));
//                assertEquals(resultSet.getShort("DECIMAL_DIGITS"), sqlResultSet.getShort("DECIMAL_DIGITS"));
//                assertEquals(resultSet.getShort("PSEUDO_COLUMN"), sqlResultSet.getShort("PSEUDO_COLUMN"));
//            }
//
//            // Ensure both result sets have been fully traversed
//            assertFalse(resultSet.next());
//            assertFalse(sqlResultSet.next());
//        }
//    }
}