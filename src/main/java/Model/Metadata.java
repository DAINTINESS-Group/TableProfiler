package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import Enums.MetadataType;

public class Metadata {

	private String tableName;
    private ArrayList<ResultSet> metadataMap;
    private ArrayList<String> metadataTypes;

    public Metadata(String tableName) {
        this.tableName = tableName;
        this.metadataMap = new ArrayList<ResultSet>();
        this.metadataTypes = new ArrayList<String>();
    }

    public int addList(MetadataType typeOfData, ResultSet resultSet) throws SQLException { 
    	metadataMap.add(resultSet);
    	metadataTypes.add(typeOfData.toString());
        return 0;
    }
    
    public ResultSet getResultSet(String name) {
    	for(int i = 0 ; i < metadataTypes.size() ; i++) {
    		if(metadataTypes.get(i).equals(name)) {
    			return metadataMap.get(i);
    		}
    	}
    	return null;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ResultSet resultSet : metadataMap) {
            try {
                result.append(resultSetToString(resultSet)).append("\n");
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
        return result.toString();
    }

    private String resultSetToString(ResultSet resultSet) throws SQLException {
        StringBuilder result = new StringBuilder();
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Append column names
        for (int i = 1; i <= columnCount; i++) {
            result.append(metaData.getColumnName(i)).append("\t");
        }
        result.append("\n");

        // Append data
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                result.append(resultSet.getString(i)).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }

	public String getTableName() {		
		return this.tableName;
	}	
	
}