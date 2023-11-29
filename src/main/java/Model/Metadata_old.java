package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Metadata_old {

    private String tableName;
    private List<Map<String, String>> tablesMetadata;
    private List<Map<String, String>> columnsMetadata;
    private List<Map<String, String>> primaryKeysMetadata;
    private List<Map<String, String>> importedKeysMetadata;
    private List<Map<String, String>> exportedKeysMetadata;
    private List<Map<String, String>> crossReferenceMetadata;
    private List<Map<String, String>> indexesMetadata;
    private List<Map<String, String>> tablePrivilegesMetadata;
    private List<Map<String, String>> bestRowIdentifierMetadata;
    private List<Map<String, String>> crossReferenceUniqueMetadata;

  
    public Metadata_old(String tableName, List<Map<String, String>> tablesMetadata, List<Map<String, String>> columnsMetadata,
                    List<Map<String, String>> primaryKeysMetadata, List<Map<String, String>> importedKeysMetadata,
                    List<Map<String, String>> exportedKeysMetadata, List<Map<String, String>> crossReferenceMetadata,
                    List<Map<String, String>> indexesMetadata, List<Map<String, String>> tablePrivilegesMetadata,
                    List<Map<String, String>> bestRowIdentifierMetadata, List<Map<String, String>> crossReferenceUniqueMetadata) {
        this.tableName = tableName;
        this.tablesMetadata = deepCopy(tablesMetadata);
        this.columnsMetadata = deepCopy(columnsMetadata);
        this.primaryKeysMetadata = deepCopy(primaryKeysMetadata);
        this.importedKeysMetadata = deepCopy(importedKeysMetadata);
        this.exportedKeysMetadata = deepCopy(exportedKeysMetadata);
        this.crossReferenceMetadata = deepCopy(crossReferenceMetadata);
        this.indexesMetadata = deepCopy(indexesMetadata);
        this.tablePrivilegesMetadata = deepCopy(tablePrivilegesMetadata);
        this.bestRowIdentifierMetadata = deepCopy(bestRowIdentifierMetadata);
        this.crossReferenceUniqueMetadata = deepCopy(crossReferenceUniqueMetadata);
    }
    
    public void addList(String typeOfData, ResultSet resultSet) {
    	switch (typeOfData) {
        case "Tables":      
        	this.tablesMetadata = deepCopy(tablesMetadata);
        	break;
        	
        case "Columns":
        	this.columnsMetadata = deepCopy(columnsMetadata);
        	break;

        case "PrimaryKeys":            
        	this.primaryKeysMetadata = deepCopy(primaryKeysMetadata);
        	break;

        case "ImportedKeys":
        	this.importedKeysMetadata = deepCopy(importedKeysMetadata);
        	break;

        case "ExportedKeys":
        	this.exportedKeysMetadata = deepCopy(exportedKeysMetadata);
        	break;

        case "CrossReference":            
        	this.crossReferenceMetadata = deepCopy(crossReferenceMetadata);
        	break;
        	
        case "Indexes":            
        	this.indexesMetadata = deepCopy(indexesMetadata);
        	break;
        	
        case "BestRowIdentifier":            
        	 this.bestRowIdentifierMetadata = deepCopy(bestRowIdentifierMetadata);
        	break;
        	
        case "TablePrivileges":            
        	this.tablePrivilegesMetadata = deepCopy(tablePrivilegesMetadata);
        	break;
        	
        case "CrossReferenceUnique":
        	this.crossReferenceUniqueMetadata = deepCopy(crossReferenceUniqueMetadata);
        	break;

        default:
            System.out.println("Invalid typeOfData provided.");
		}
    }
    
    private static List<Map<String, String>> deepCopy(List<Map<String, String>> originalList) {
        if (originalList == null) {
            return new ArrayList<>();
        }

        List<Map<String, String>> copiedList = new ArrayList<>();

        for (Map<String, String> originalMap : originalList) {
            Map<String, String> copiedMap = new HashMap<>(originalMap);            
            copiedList.add(copiedMap);
        }

        return copiedList;
    }

	public String getTableName() {		
		return tableName;
	}

	public String getAllMetadata() throws SQLException {
        StringBuilder metadatas = new StringBuilder();
        if (this.tablesMetadata != null) {
            metadatas.append(printResultSet(tablesMetadata));
        }
        if (this.columnsMetadata != null) {
            metadatas.append(printResultSet(columnsMetadata));
        }
        if (this.primaryKeysMetadata != null) {
            metadatas.append(printResultSet(primaryKeysMetadata));
        }
        if (this.importedKeysMetadata != null) {
            metadatas.append(printResultSet(importedKeysMetadata));
        }
        if (this.exportedKeysMetadata != null) {
            metadatas.append(printResultSet(exportedKeysMetadata));
        }
        if (this.crossReferenceMetadata != null) {
            metadatas.append(printResultSet(crossReferenceMetadata));
        }
        if (this.indexesMetadata != null) {
            metadatas.append(printResultSet(indexesMetadata));
        }
        return metadatas.toString();
    }
	
	private String printResultSet(List<Map<String, String>> resultSet) throws SQLException {
        StringBuilder retString = new StringBuilder();
        for (Map<String, String> row : resultSet) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String columnName = entry.getKey();
                String columnValue = entry.getValue();
                retString.append("\t").append(columnName).append(": ").append(columnValue).append('\n');
            }
        }
        return retString.toString();
    }
}