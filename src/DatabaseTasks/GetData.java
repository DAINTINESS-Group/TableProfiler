package DatabaseTasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetData {

	private Connection connection;

    public GetData(Connection connection) {
        this.connection = connection;
    }
    
    public List<List<String>> fetchData(String sqlScript) {
        List<List<String>> resultData = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlScript);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            // Fetch column names
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNames.add(columnName);
            }
            resultData.add(columnNames);

            // Fetch data
            while (resultSet.next()) {
                List<String> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    rowData.add(columnValue);
                }
                resultData.add(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch data.");
        }

        return resultData;
    }

    public static void main(String[] args) {
        // Example: Fetch data from a SQL script
        String sqlScript = "SELECT table_name FROM tables a where a.TABLE_SCHEMA = 'information_schema'";

        // Create an instance of GetData
        GetData dataFetcher = new GetData(DatabaseConnection.connect());

        // Fetch data
        List<List<String>> resultData = dataFetcher.fetchData(sqlScript);

        // Process the result
        System.out.println("Data:");
        for (List<String> rowData : resultData) {
            for (String value : rowData) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}