package experiments;

import java.sql.SQLException;
import java.util.ArrayList;
import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;
import Model.MetadataManager;
import java.util.List;

public class ExperimentsOverMetadataSize {

    public static void main(String[] args) {
        String username = "reportUser";
        String password = "123456";
        String ip = "localhost:3306";
        String tableName = "ALL";
        List<String> schemaNames = new ArrayList<>();
        schemaNames.add("adventureworks");
        schemaNames.add("schema100");
        schemaNames.add("schema500");
        schemaNames.add("schema1000"); // Add more schema names as needed
        int numTests = 5; // Number of consecutive runs
        
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        for(MetadataType t : MetadataType.values()) {
            tableTypes.add(t);
           // System.out.println(tableTypes.get(0).toString());

        
        //tableTypes.remove(0);
        }
        for (String schemaName : schemaNames) {
            long totalConnectionTime = 0;
            long totalMetadataTime = 0;

            for (int i = 0; i < numTests; i++) {
                long connectionStartTime = System.currentTimeMillis();
                long connectionEndTime = System.currentTimeMillis();
                long connectionElapsedTime = connectionEndTime - connectionStartTime;
                totalConnectionTime += connectionElapsedTime;

                long metadataStartTime = System.currentTimeMillis();
                MetadataManager metaManager = new MetadataManager();
                
                try {
                    metaManager.createMetadata(ip, schemaName, username, password, tableTypes, schemaName, tableName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                long metadataEndTime = System.currentTimeMillis();
                long metadataElapsedTime = metadataEndTime - metadataStartTime;
                totalMetadataTime += metadataElapsedTime;

                System.out.println("Schema: " + schemaName + ", Run " + (i + 1) + " - Connection delay: " + connectionElapsedTime + " ms, Metadata creation time: " + metadataElapsedTime + " ms");
                DatabaseConnection.closeConnection();
            }

            double averageConnectionTime = (double) totalConnectionTime / numTests;
            double averageMetadataTime = (double) totalMetadataTime / numTests;
            System.out.println("Schema: " + schemaName + ", Average connection delay time: " + averageConnectionTime + " ms");
            System.out.println("Schema: " + schemaName + ", Average metadata creation time: " + averageMetadataTime + " ms");
        }
    }
}