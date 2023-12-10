package DatabaseTasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mysql.cj.jdbc.DatabaseMetaData;
import Enums.MetadataType;
public class DataManager {
	
	 
	
	private void printResultSet(ResultSet resultSet) throws SQLException {
	    while (resultSet.next()) {
	        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	        int columnCount = resultSetMetaData.getColumnCount();

	        for (int i = 1; i <= columnCount; i++) {
	            String columnName = resultSetMetaData.getColumnName(i);
	            String columnValue = resultSet.getString(i);
	           // System.out.println("\t" + columnName + ": " + columnValue);
	        }
	        System.out.println();
	    }
	}
	
	public ResultSet extractTableMetadata(Connection connection, MetadataType typeOfData, String tableName) {
        try {
        	
        		DatabaseMetaData dmd = (DatabaseMetaData) connection.getMetaData();
        		switch (typeOfData) {
                case TABLES:
                  //  System.out.println("Tables Metadata:");
                    if(tableName.equals("ALL")) {
                    	ResultSet tablesResultSet = dmd.getTables(null, null, null, new String[]{"TABLE"});
                    	return tablesResultSet;
                    }
                    ResultSet tablesResultSet = dmd.getTables(null, null, tableName, new String[]{"TABLE"});
                    //printResultSet(tablesResultSet);
                    return tablesResultSet;
                    

                case COLUMNS:
                    //System.out.println("Columns Metadata:");
                    ResultSet columnsResultSet = dmd.getColumns(null, null, tableName, null);
                    //printResultSet(columnsResultSet);
                    return columnsResultSet;
                    

                case PRIMARY_KEYS:
//                    System.out.println("Primary Keys Metadata:");
                    ResultSet primaryKeysResultSet = dmd.getPrimaryKeys(null, null, tableName);
                    //printResultSet(primaryKeysResultSet);
                    return primaryKeysResultSet;
                    

                case IMPORTED_KEYS:
//                    System.out.println("Imported Keys (Foreign Keys) Metadata:");
                    ResultSet importedKeysResultSet = dmd.getImportedKeys(null, null, tableName);
                    //printResultSet(importedKeysResultSet);
                    return importedKeysResultSet;
                    

                case EXPORTED_KEYS:
//                    System.out.println("Exported Keys (Primary Keys of Referencing Tables) Metadata:");
                    ResultSet exportedKeysResultSet = dmd.getExportedKeys(null, null, tableName);
                    //printResultSet(exportedKeysResultSet);
                    return exportedKeysResultSet;
                   

                case CROSS_REFERENCE:
//                    System.out.println("Cross-Reference (Foreign Keys from Referencing Tables) Metadata:");
                    ResultSet crossReferenceResultSet = dmd.getCrossReference(null, null, tableName, null, null, null);
                    //printResultSet(crossReferenceResultSet);
                    return crossReferenceResultSet;
                    

                case INDEXES:
//                    System.out.println("Indexes Metadata:");
                    ResultSet indexesResultSet = dmd.getIndexInfo(null, null, tableName, false, true);
                    //printResultSet(indexesResultSet);
                    return indexesResultSet;
                    

                case BEST_ROW_IDENTIFIER:
//                    System.out.println("Best Row Identifier Metadata:");
                    ResultSet bestRowIdResultSet = dmd.getBestRowIdentifier(null, null, tableName, DatabaseMetaData.bestRowSession, false);
                    //printResultSet(bestRowIdResultSet);
                    return bestRowIdResultSet;
                    

                case CROSS_REFERENCE_UNIQUE:
//                    System.out.println("Cross-Reference (using Unique Constraint) Metadata:");
                    ResultSet crossReferenceUniqueResultSet = dmd.getCrossReference(null, null, tableName, null, null, tableName);
                    //printResultSet(crossReferenceUniqueResultSet);
                    return crossReferenceUniqueResultSet;
                    

                default:
                    System.out.println("Invalid typeOfData provided.");
        		}            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
}