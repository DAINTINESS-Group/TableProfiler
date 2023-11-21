package DatabaseTaskTests;

import org.junit.jupiter.api.Test;

import DatabaseTasks.DatabaseConnection;
import DatabaseTasks.GetData;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class GetDataTest {

    @Test
    void testFetchTableData() {
        try (Connection connection = DatabaseConnection.connect()) {
            GetData dataFetcher = new GetData(connection);

            // Replace "your_table_name" with the actual table name you want to test
            String tableName = "countries";
            
            List<List<String>> tableData = dataFetcher.fetchData(tableName);

            // Replace these assertions with actual expectations based on your data
            assertNotNull(tableData);
            assertFalse(tableData.isEmpty());
            
            // Example: Assert that the first row has at least one value
            assertFalse(tableData.get(0).isEmpty());

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to connect to the database.");
        }
    }
}
