package DatabaseTasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.DatabaseMetaData;
import Enums.MetadataType;

public class DataManager {
	
	 
	
//	private void printResultSet(ResultSet resultSet) throws SQLException {
//	    while (resultSet.next()) {
//	        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//	        int columnCount = resultSetMetaData.getColumnCount();
//
//	        for (int i = 1; i <= columnCount; i++) {
//	            String columnName = resultSetMetaData.getColumnName(i);
//	            String columnValue = resultSet.getString(i);
//	           // System.out.println("\t" + columnName + ": " + columnValue);
//	        }
//	        System.out.println();
//	    }
//	}
	
	public ResultSet extractTableMetadata(String ip, String schema, String username, String password, MetadataType typeOfData, String schemaName, String tableName) {
        try {
        		Connection connection = DatabaseConnection.connect(ip, schema, username, password);
        		DatabaseMetaData dmd = (DatabaseMetaData) connection.getMetaData();
        		// get tables        		  
        		  //ArrayList<String> databaseTables = new ArrayList(); 
        		  ResultSet tablesResultSet = dmd.getTables(null, schemaName, null, new String[]{"TABLE"});
//        		  while(tablesResultSet.next()) {
//        			  databaseTables.add(tablesResultSet.getString("TABLE_NAME"));
//        		  }
        		switch (typeOfData) {
                case TABLES:
                  //  System.out.println("Tables Metadata:");
                    if(tableName.equals("ALL")) {
                    	tablesResultSet = dmd.getTables(schemaName, schemaName, null, new String[]{"TABLE"});
                    	return tablesResultSet;
                    }
                    tablesResultSet = dmd.getTables(schemaName, schemaName, tableName, new String[]{"TABLE"});
                    //printResultSet(tablesResultSet);
                    return tablesResultSet;
                    

                case COLUMNS:
                    //System.out.println("Columns Metadata:");
                    ResultSet columnsResultSet = dmd.getColumns(schemaName, schemaName, tableName, null);
                    //printResultSet(columnsResultSet);
                    return columnsResultSet;
                    

                case PRIMARY_KEYS:
//                    System.out.println("Primary Keys Metadata:");
                    ResultSet primaryKeysResultSet = dmd.getPrimaryKeys(schemaName, schemaName, tableName);
                    //printResultSet(primaryKeysResultSet);
                    return primaryKeysResultSet;
                    

                case IMPORTED_KEYS:
//                    System.out.println("Imported Keys (Foreign Keys) Metadata:");
                    ResultSet importedKeysResultSet = dmd.getImportedKeys(schemaName, schemaName, tableName);
                    //printResultSet(importedKeysResultSet);
                    return importedKeysResultSet;
                    

                case EXPORTED_KEYS:
//                    System.out.println("Exported Keys (Primary Keys of Referencing Tables) Metadata:");
                    ResultSet exportedKeysResultSet = dmd.getExportedKeys(schemaName, schemaName, tableName);
                    //printResultSet(exportedKeysResultSet);
                    return exportedKeysResultSet;
                   
                // to execute getCrossReference we have to know the relations the exampe thats why we use for
//                case CROSS_REFERENCE:
//                	ResultSet resultSetTemp = connection.getMetaData().getCrossReference(null, null, "contactcreditcard",null, null,"creditcard" );
////                	
//                    return resultSetTemp;
                    

                case INDEXES:
//                    System.out.println("Indexes Metadata:");
                    ResultSet indexesResultSet = dmd.getIndexInfo(schemaName, schemaName, tableName, false, true);                    
                    //printResultSet(indexesResultSet);
                    return indexesResultSet;
                    

//                case BEST_ROW_IDENTIFIER:
////                    System.out.println("Best Row Identifier Metadata:");
//                    ResultSet bestRowIdResultSet = dmd.getBestRowIdentifier(null, schemaName, tableName, DatabaseMetaData.bestRowSession, false);
//                    //printResultSet(bestRowIdResultSet);
//                    return bestRowIdResultSet;s
                    

//                case CROSS_REFERENCE_UNIQUE:
////                    System.out.println("Cross-Reference (using Unique Constraint) Metadata:");
//                    ResultSet crossReferenceUniqueResultSet = dmd.getCrossReference(null, schemaName, tableName, null, null, tableName);
//                    //printResultSet(crossReferenceUniqueResultSet);
//                    return crossReferenceUniqueResultSet;
                    
                    
                case TABLE_PRIVILEGES:
//                  System.out.println("Cross-Reference (using Unique Constraint) Metadata:");
                  ResultSet tablePrivilegesResultSet = dmd.getTablePrivileges(schemaName , schemaName, tableName);
                  //printResultSet(crossReferenceUniqueResultSet);
                  return tablePrivilegesResultSet;
                  
                  
                case COLUMN_PRIVILEGES:
                   // System.out.println("Column Privileges Metadata:");
                    ResultSet columnPrivilegesResultSet = dmd.getColumnPrivileges(connection.getCatalog(), schemaName, tableName, "%");                    
//                    // printResultSet(columnPrivilegesResultSet);
                    return columnPrivilegesResultSet;
                
//                case VERSION_COLUMNS:
//                    System.out.println("Column Versions Metadata:");
//                    ResultSet versionColumns = dmd.getVersionColumns(connection.getCatalog(), schemaName, tableName);                    
////                    // printResultSet(columnPrivilegesResultSet);
//                    return versionColumns;    
                    
//                case TYPE_INFO:
//                    System.out.println("Type Info Metadata:");
//                    ResultSet typeInfo = dmd.getTypeInfo();                    
////                    // printResultSet(columnPrivilegesResultSet);
//                    return typeInfo; 

                default:
                    System.out.println("Invalid typeOfData provided.");
        		}            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
}