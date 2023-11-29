package Model;

import DatabaseTasks.DataManager;
import Enums.MetadataType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetadataManager {

    private ArrayList<Metadata> metadataList;

    public MetadataManager() {
        metadataList = new ArrayList<>();
    }

    public ArrayList<Metadata> getMetadataList() {
        return metadataList;
    }

    public void createMetadata(ArrayList<MetadataType> typeOfDataList, String tableName, Connection connection) throws SQLException {
    	DataManager dataManager = new DataManager();
    	if (tableName.isEmpty()) {
    		ResultSet allTableNames = dataManager.extractTableMetadata(connection, null, null);
    		while (allTableNames.next()) {
    			String tableNameS = allTableNames.getString("TABLE_NAME");
    			Metadata metadata = new Metadata(tableNameS) ;
    			for(MetadataType typeOfData : typeOfDataList) {        	
        			ResultSet resultSet = dataManager.extractTableMetadata(connection, typeOfData, tableName);     
        			metadata.addList(typeOfData,resultSet);        	
        		}    		
        		metadataList.add(metadata);
    		}
    	}  		
    	else {
    		
    		Metadata metadata = new Metadata(tableName) ;
    		for(MetadataType typeOfData : typeOfDataList) {        	
    			ResultSet resultSet = dataManager.extractTableMetadata(connection, typeOfData, tableName);     
    			metadata.addList(typeOfData,resultSet);        	
    		}    		
    		metadataList.add(metadata);
    	}
    }   
}


