package Model;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;
import Statistics.DatabaseStatistics;
import Statistics.TableStatistics;

public class GeneralTest {
	
	
	@Test
    public void testGeneralFunctionality() throws SQLException {
	Connection connection = DatabaseConnection.connect("localhost:3306", "root", "123456");
	MetadataManager metaManager = new MetadataManager();        
    ArrayList<MetadataType> tableTypes =  new ArrayList<MetadataType>();
    tableTypes.add(MetadataType.COLUMNS);
    tableTypes.add(MetadataType.PRIMARY_KEYS);
    tableTypes.add(MetadataType.IMPORTED_KEYS);
    tableTypes.add(MetadataType.INDEXES);    
    metaManager.createMetadata(tableTypes,"adventureworks", "ALL", connection);
    StringBuilder resultStringBuilder = new StringBuilder();
    DatabaseStatistics fromQuetyDStats = new DatabaseStatistics(); 
    TableStatistics tStats = null;
    
        // Execute the SQL query
        String query = "WITH CTE AS (\r\n"
        		+ "    SELECT TABLE_NAME\r\n"
        		+ "    FROM information_schema.TABLES\r\n"
        		+ "    WHERE TABLE_SCHEMA = 'adventureworks'\r\n"
        		+ ")\r\n"
        		+ "\r\n"
        		+ "SELECT\r\n"
        		+ "    CTE.TABLE_NAME,\r\n"
        		+ "    COUNT(DISTINCT CASE WHEN B.CONSTRAINT_TYPE = 'PRIMARY KEY' THEN B.CONSTRAINT_NAME END) AS Pks,\r\n"
        		+ "    COUNT(DISTINCT C.COLUMN_NAME) AS columns,\r\n"
        		+ "    COUNT(DISTINCT CASE WHEN B.CONSTRAINT_TYPE = 'FOREIGN KEY' THEN B.CONSTRAINT_NAME END) AS fks,\r\n"
        		+ "    COUNT(DISTINCT F.INDEX_ID) AS inds\r\n"
        		+ "FROM CTE\r\n"
        		+ "LEFT JOIN information_schema.TABLE_CONSTRAINTS B ON CTE.Table_name = B.table_name\r\n"
        		+ "LEFT JOIN information_schema.COLUMNS C ON CTE.Table_name = C.table_name\r\n"
        		+ "LEFT JOIN information_schema.INNODB_TABLES E ON E.NAME = CONCAT('adventureworks','/',CTE.Table_name)\r\n"
        		+ "LEFT JOIN information_schema.INNODB_INDEXES F ON F.TABLE_ID = E.TABLE_ID\r\n"
        		+ "GROUP BY CTE.TABLE_NAME;";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Loop through the results and append to the StringBuilder
            while (resultSet.next()) {
            	String pks = resultSet.getString(2);
            	String columns = resultSet.getString(3);
            	String fks = resultSet.getString(4);
            	String inds = resultSet.getString(5);
            	tStats = new TableStatistics(resultSet.getString(1),Integer.valueOf(columns),Integer.valueOf(pks),Integer.valueOf(fks),0,0,Integer.valueOf(inds));
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    resultStringBuilder.append(resultSet.getString(i)).append("\t");
                }
                resultStringBuilder.append("\n"); // Move to the next line for the next row
                fromQuetyDStats.addTableStatistics(tStats);
            }
        }
    

//    System.out.println(resultStringBuilder.toString());
//    System.out.println(fromQuetyDStats.toString());
//    System.out.println(metaManager.databaseStatistics.toString());
    //System.out.println(fromQuetyDStats.toString().equals(metaManager.databaseStatistics.toString()));
        assertEquals(fromQuetyDStats.toString(), metaManager.databaseStatistics.toString());
}		
}

//public static void main(String[] args) throws SQLException {
//	generalTest();
//}
//}
