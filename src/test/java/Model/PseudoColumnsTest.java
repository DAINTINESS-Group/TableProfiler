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

public class PseudoColumnsTest {

    @Test
    public void testPseudoColumns() throws SQLException {
        Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
        MetadataManager metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        tableTypes.add(MetadataType.PSEUDO_COLUMNS);
        metaManager.createMetadata(tableTypes, "adventureworks", "", connection);
        ResultSet resultSet = metaManager.getMetadataList().get(0).getResultSet("PSEUDO_COLUMNS");

        // Execute the SQL query
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM information_schema.PSEUDO_COLUMNS");
             ResultSet sqlResultSet = statement.executeQuery()) {

            // Loop through the result sets and compare values
            while (resultSet.next() && sqlResultSet.next()) {
                // Compare each pseudo column description
                assertEquals(resultSet.getString("TABLE_CAT"), sqlResultSet.getString("TABLE_CAT"));
                assertEquals(resultSet.getString("TABLE_SCHEM"), sqlResultSet.getString("TABLE_SCHEM"));
                assertEquals(resultSet.getString("TABLE_NAME"), sqlResultSet.getString("TABLE_NAME"));
                assertEquals(resultSet.getString("COLUMN_NAME"), sqlResultSet.getString("COLUMN_NAME"));
                assertEquals(resultSet.getInt("DATA_TYPE"), sqlResultSet.getInt("DATA_TYPE"));
                assertEquals(resultSet.getInt("COLUMN_SIZE"), sqlResultSet.getInt("COLUMN_SIZE"));
                assertEquals(resultSet.getInt("DECIMAL_DIGITS"), sqlResultSet.getInt("DECIMAL_DIGITS"));
                assertEquals(resultSet.getInt("NUM_PREC_RADIX"), sqlResultSet.getInt("NUM_PREC_RADIX"));
                assertEquals(resultSet.getString("COLUMN_USAGE"), sqlResultSet.getString("COLUMN_USAGE"));
                assertEquals(resultSet.getString("REMARKS"), sqlResultSet.getString("REMARKS"));
                assertEquals(resultSet.getInt("CHAR_OCTET_LENGTH"), sqlResultSet.getInt("CHAR_OCTET_LENGTH"));
                assertEquals(resultSet.getString("IS_NULLABLE"), sqlResultSet.getString("IS_NULLABLE"));
            }

            // Ensure both result sets have been fully traversed
            assertFalse(resultSet.next());
            assertFalse(sqlResultSet.next());
        }
    }
}