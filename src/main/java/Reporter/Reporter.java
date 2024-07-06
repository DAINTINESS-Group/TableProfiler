package Reporter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Enums.MetadataType;
import Model.MetadataManager;

public class Reporter {

	static MetadataManager metaManager;
		
	public Reporter(String ip, String username, String password, ArrayList<MetadataType> tableTypes, String schemaName,String tableName) throws SQLException {
		metaManager = new MetadataManager();
		metaManager.createMetadata(ip, schemaName, username, password, tableTypes, schemaName, tableName);		
	}
	
	public boolean isMetadataManagerEmpty() {
		return metaManager.getMetadataList().isEmpty();
	}
	
	public String getMetadataManagerToString() {
		return metaManager.toString();
	}


	public static void writeToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(metaManager.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}