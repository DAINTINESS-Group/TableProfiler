package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Enums.MetadataType;

public class Metadata {

	private String tableName;
    private Map<String, List<Map<String, String>>> metadataMap;

    public Metadata(String tableName) {
        this.tableName = tableName;
        this.metadataMap = new HashMap<>();
    }

    public int addList(MetadataType typeOfData, ResultSet resultSet) throws SQLException {    	
        List<Map<String, String>> metadataList = new ArrayList<>();
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        ArrayList<String> previousKeys = new ArrayList<String>();
        int counter = 0;
        while (resultSet.next()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = resultSet.getString(i);
                if(typeOfData == MetadataType.IMPORTED_KEYS && columnName.equals("FK_NAME") && !columnValue.isEmpty() && !previousKeys.contains(columnValue)) {
                	previousKeys.add(columnValue);
                	counter++;                	
                }
                if(typeOfData == MetadataType.EXPORTED_KEYS && columnName.equals("FK_NAME") && !columnValue.isEmpty() && !previousKeys.contains(columnValue)) {
                	previousKeys.add(columnValue);
                	counter++;                	
                }
                else if(typeOfData == MetadataType.PRIMARY_KEYS && columnName.equals("PK_NAME") && !columnValue.isEmpty() && !previousKeys.contains(columnValue)) {
                	previousKeys.add(columnValue);
                	counter++;                	
                }
                else if(typeOfData == MetadataType.COLUMNS && columnName.equals("COLUMN_NAME") && !columnValue.isEmpty() && !previousKeys.contains(columnValue)) {
                	previousKeys.add(columnValue);
                	counter++;                	
                }                
                else if(typeOfData == MetadataType.INDEXES && columnName.equals("INDEX_NAME") && !columnValue.isEmpty() && !previousKeys.contains(columnValue)) {
                	previousKeys.add(columnValue);
                	counter++;                	
                }
                else {
                	counter = metadataList.size();
                }
                row.put(columnName, columnValue);
            }
            metadataList.add(row);
        }
        metadataMap.put(typeOfData.toString(), metadataList);
        return counter;
    }

    public String getAllMetadata() {
        StringBuilder metadatas = new StringBuilder();
        for (Map.Entry<String, List<Map<String, String>>> entry : metadataMap.entrySet()) {
            String typeOfData = entry.getKey();
            metadatas.append(entry.getKey().toString());
            List<Map<String, String>> resultSets = entry.getValue();
            metadatas.append(printResultSets(typeOfData, resultSets));
            
        }
        return metadatas.toString();
    }
    
    public String getTabularMetadata() {
        StringBuilder tabularMetadata = new StringBuilder();
        int counter = 0;
        for (Map.Entry<String, List<Map<String, String>>> entry : metadataMap.entrySet()) {
            String typeOfData = entry.getKey();
            tabularMetadata.append(typeOfData).append(" Metadata:\n");

            List<Map<String, String>> resultSets = entry.getValue();

            if (!resultSets.isEmpty()) {
                tabularMetadata.append(getTableHeader(resultSets.get(0))).append("\n");

                for (Map<String, String> row : resultSets) {
                    tabularMetadata.append(getTableRow(row)).append("\n");
                }
            }
        }

        return tabularMetadata.toString();
    }

    private String getTableHeader(Map<String, String> row) {
        StringBuilder header = new StringBuilder();
        for (String columnName : row.keySet()) {
            header.append(String.format("| %-20s ", columnName));
        }
        header.append("|\n");
        return header.toString();
    }

    private String getTableRow(Map<String, String> row) {
        StringBuilder tableRow = new StringBuilder();
        for (String columnValue : row.values()) {
            tableRow.append(String.format("| %-30s ", columnValue));
        }
        tableRow.append("|\n");
        return tableRow.toString();
    }

    private String printResultSets(String typeOfData, List<Map<String, String>> resultSets) {
        StringBuilder retString = new StringBuilder();
        retString.append(typeOfData).append(" Metadata:\n");

        for (Map<String, String> row : resultSets) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String columnName = entry.getKey();
                String columnValue = entry.getValue();
                retString.append("\t").append(columnName).append(": ").append(columnValue).append('\n');
            }
        }

        return retString.toString();
    }

	public String getTableName() {		
		return this.tableName;
	}	
	
}