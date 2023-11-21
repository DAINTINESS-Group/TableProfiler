package Model;

import DatabaseTasks.DatabaseConnection;
import DatabaseTasks.GetData;

import java.sql.Connection;
import java.util.List;

public class GeneralTableFactory {
		
    public static GeneralTable createGeneralTable(String tableName) {
        Connection connection = DatabaseConnection.connect();
        GetData dataFetcher = new GetData(connection);

        // Fetch column names and data types
        //String sqlScript = "SELECT * FROM " + tableName+";";
        //String sqlScript = "select concat('select * from tables ',' union all select ',  group_concat('''',b.column_type,'''') ) from information_schema.columns b where b.table_name = '" + tableName+"';";
        //String sqlDataTypesScript = "select group_concat('''',replace(b.column_type,'''',''''''),'''')  from information_schema.columns b where b.table_name = 'tables'";
        String sqlScript = "select * from information_schema.tables b where b.table_name = 'tables'";
        List<List<String>> resultData = dataFetcher.fetchData(sqlScript);

        // Create a GeneralTable instance
        GeneralTable generalTable = new GeneralTable(tableName);

        // Extract column names and data types
        List<String> columnNames = resultData.get(0);
        List<String> columnDataTypes = resultData.get(1);

        // Set the column names and data types in the GeneralTable instance
        generalTable.setColumns(columnNames);
        generalTable.setColumnsDataType(columnDataTypes);
        generalTable.setData(resultData);

        // Fetch data for the table
//        sqlScript = "SELECT * FROM " + tableName;
//        List<List<String>> tableData = dataFetcher.fetchData(sqlScript);

        // Set the table data in the GeneralTable instance

        // Close the connection
        DatabaseConnection.closeConnection();

        return generalTable;
    }

    public static void main(String[] args) {
        // Example usage
    	String sqlScript = "SELECT distinct table_name FROM columns a where a.TABLE_SCHEMA = 'information_schema' and a.COLUMN_NAME LIKE 'TABLE_NAME' and a.table_name like 'tables'";
    	
        // Create an instance of GetData
        GetData dataFetcher = new GetData(DatabaseConnection.connect());

        // Fetch data
        List<List<String>> resultData = dataFetcher.fetchData(sqlScript);

        // Process the result
        System.out.println("Data:");
        for (List<String> rowData : resultData) {
            for (String value : rowData) {
                System.out.print(value + "\t");
                if(!value.equals("TABLE_NAME")) {
                	String tableName = value;                  
                	GeneralTable generalTable = GeneralTableFactory.createGeneralTable(tableName);

                    // Access the data
                    System.out.println("Model Name: " + generalTable.getModelName());
                    generalTable.getColumns();
                    generalTable.getColumnsDataTypes();
                    generalTable.getData();
                }                               
            }                      
        }
        /*String tableName = "tables";
        GeneralTable generalTable = GeneralTableFactory.createGeneralTable(tableName);

        // Access the data
        System.out.println("Model Name: " + generalTable.getModelName());
        System.out.println("Columns: " + generalTable.getColumns());
        System.out.println("Columns Data Type: " + generalTable.getColumnsDataType());
        System.out.println("Data: " + generalTable.getData());*/

        //todo pivot for table
    }
}