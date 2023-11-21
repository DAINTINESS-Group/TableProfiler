package Model;

import DatabaseTasks.DatabaseConnection;
import DatabaseTasks.DataManager;

import java.sql.Connection;
import java.util.List;

public class RelationalTableFactory {
		
    public static RelationalTable createGeneralTable(String tableName) {
        Connection connection = DatabaseConnection.connect();
        DataManager dataFetcher = new DataManager(connection);

        // Fetch column names and data types
        //String sqlScript = "SELECT * FROM " + tableName+";";
        //String sqlScript = "select concat('select * from tables ',' union all select ',  group_concat('''',b.column_type,'''') ) from information_schema.columns b where b.table_name = '" + tableName+"';";
        //String sqlDataTypesScript = "select group_concat('''',replace(b.column_type,'''',''''''),'''')  from information_schema.columns b where b.table_name = 'tables'";
        String sqlScript = "select * from information_schema.tables b where b.table_name = 'tables'";
        List<List<String>> resultData = dataFetcher.fetchData(sqlScript);

        // Create a RelationalTable instance
        RelationalTable relationalTable = new RelationalTable(tableName);

        // Extract column names and data types
        List<String> columnNames = resultData.get(0);
        List<String> columnDataTypes = resultData.get(1);

        // Set the column names and data types in the RelationalTable instance
        relationalTable.setColumns(columnNames);
        relationalTable.setColumnsDataType(columnDataTypes);
        relationalTable.setData(resultData);

        // Fetch data for the table
//        sqlScript = "SELECT * FROM " + tableName;
//        List<List<String>> tableData = dataFetcher.fetchData(sqlScript);

        // Set the table data in the RelationalTable instance

        // Close the connection
        DatabaseConnection.closeConnection();

        return relationalTable;
    }

    public static void main(String[] args) {
        // Example usage
    	String sqlScript = "SELECT distinct table_name FROM columns a where a.TABLE_SCHEMA = 'information_schema' and a.COLUMN_NAME LIKE 'TABLE_NAME' and a.table_name like 'tables'";
    	
        // Create an instance of DataManager
        DataManager dataFetcher = new DataManager(DatabaseConnection.connect());

        // Fetch data
        List<List<String>> resultData = dataFetcher.fetchData(sqlScript);

        // Process the result
        System.out.println("Data:");
        for (List<String> rowData : resultData) {
            for (String value : rowData) {
                System.out.print(value + "\t");
                if(!value.equals("TABLE_NAME")) {
                	String tableName = value;                  
                	RelationalTable relationalTable = RelationalTableFactory.createGeneralTable(tableName);

                    // Access the data
                    System.out.println("Model Name: " + relationalTable.getModelName());
                    relationalTable.getColumns();
                    relationalTable.getColumnsDataTypes();
                    relationalTable.getData();
                }                               
            }                      
        }
        /*String tableName = "tables";
        RelationalTable generalTable = RelationalTableFactory.createGeneralTable(tableName);

        // Access the data
        System.out.println("Model Name: " + generalTable.getModelName());
        System.out.println("Columns: " + generalTable.getColumns());
        System.out.println("Columns Data Type: " + generalTable.getColumnsDataType());
        System.out.println("Data: " + generalTable.getData());*/

        //todo pivot for table
    }
}