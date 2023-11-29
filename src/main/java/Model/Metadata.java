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

    public void addList(MetadataType typeOfData, ResultSet resultSet) throws SQLException {
        List<Map<String, String>> metadataList = new ArrayList<>();
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = resultSet.getString(i);
                row.put(columnName, columnValue);
            }
            metadataList.add(row);
        }

        metadataMap.put(typeOfData.toString(), metadataList);
    }

    public String getAllMetadata() {
        StringBuilder metadatas = new StringBuilder();
        for (Map.Entry<String, List<Map<String, String>>> entry : metadataMap.entrySet()) {
            String typeOfData = entry.getKey();
            List<Map<String, String>> resultSets = entry.getValue();
            metadatas.append(printResultSets(typeOfData, resultSets));
        }
        return metadatas.toString();
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