package Model;

import DatabaseTasks.DataManager;
import Enums.MetadataType;
import Repoter.FileUtils;
import Statistics.DatabaseStatistics;
import Statistics.TableStatistics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetadataManager {

	private ArrayList<Metadata> metadataList;
	public DatabaseStatistics databaseStatistics = new DatabaseStatistics();

	public MetadataManager() {
		metadataList = new ArrayList<>();
	}

	public ArrayList<Metadata> getMetadataList() {
		return metadataList;
	}
	
	public boolean isTableExistsInMetadataList(String tableName){
		for (Metadata metadata : metadataList) {
			return metadata.getTableName().equals(tableName);
		}
		return false;
	}
	
	public Metadata getMetadataObject(String tableName) {
		for (Metadata metadata : metadataList) {
			if (metadata.getTableName().equals(tableName)) {
				return metadata;
			}
		}
		return null;
	}

	public void createMetadata(String ip, String schema, String username, String password, ArrayList<MetadataType> typeOfDataList, String schemaName, String tableName)
			throws SQLException {
		DataManager dataManager = new DataManager(ip, schema, username, password);
		TableStatistics tStats = null ;
		if (tableName.equals("ALL")) {
			ResultSet allTableNames = dataManager.extractTableMetadata( MetadataType.TABLES, schemaName, tableName);
			while (allTableNames.next()) {
				String tableNameS = allTableNames.getString("TABLE_NAME");
				//System.out.println("while (allTableNames.next()) { -- >>"+tableNameS);
				tStats = new TableStatistics(tableNameS, 0, 0, 0, 0, 0, 0, 0);
				Metadata metadata;
				if (!isTableExistsInMetadataList(tableName)) {
					metadata = new Metadata(tableNameS);					
				}else {
					metadata = getMetadataObject(tableName);
				}
				for (MetadataType typeOfData : typeOfDataList) {
					ResultSet resultSet = dataManager.extractTableMetadata(typeOfData, schemaName, tableNameS);
					metadata.addList(typeOfData, resultSet);
					resultSet.last();
					switch (typeOfData) {
					case TABLES:						
						break;
					case COLUMNS:
						tStats.setColumns(resultSet.getRow());
						resultSet.first();
						break;
					case PRIMARY_KEYS:
						tStats.setPrimary_keys(resultSet.getRow());
						resultSet.first();
						break;
					case IMPORTED_KEYS:
						tStats.setImported_keys(resultSet.getRow());//setReferedPks(counter);
						resultSet.first();
						break;
					case EXPORTED_KEYS:
						tStats.setExported_keys(resultSet.getRow());
						resultSet.first();
						break;
					case COLUMN_PRIVILEGES:
						tStats.setColPrvs(resultSet.getRow());
						resultSet.first();
						break;
					case TABLE_PRIVILEGES:
						tStats.setTblPrvs(resultSet.getRow());
						resultSet.first();
						break;
					case INDEXES:
						tStats.setIndxs(resultSet.getRow());
						resultSet.first();
						break;
					default:
						System.out.println("Invalid typeOfData provided: "+ typeOfData +" on table: "+schemaName+"."+tableName);
						break;
					}
				}				
				metadataList.add(metadata);
				databaseStatistics.addTableStatistics(tStats);
			}
		} else {
			tStats = new TableStatistics(tableName, 0, 0, 0, 0, 0, 0, 0);
			Metadata metadata;
			if (!isTableExistsInMetadataList(tableName)) {
				metadata = new Metadata(tableName);					
			}else {
				metadata = getMetadataObject(tableName);
			}			
			for (MetadataType typeOfData : typeOfDataList) {
				//System.out.println("Insite metadata manager ---> "+typeOfData.toString());
				ResultSet resultSet = dataManager.extractTableMetadata(typeOfData, schemaName, tableName);
				metadata.addList(typeOfData, resultSet);
				resultSet.last();
				switch (typeOfData) {
				case TABLES:						
					break;
				case COLUMNS:
					tStats.setColumns(resultSet.getRow());
					resultSet.first();
					break;
				case PRIMARY_KEYS:
					tStats.setPrimary_keys(resultSet.getRow());
					resultSet.first();
					break;
				case IMPORTED_KEYS:
					tStats.setImported_keys(resultSet.getRow());//setReferedPks(counter);
					resultSet.first();
					break;
				case EXPORTED_KEYS:
					tStats.setExported_keys(resultSet.getRow());
					resultSet.first();
					break;
				case COLUMN_PRIVILEGES:
					tStats.setColPrvs(resultSet.getRow());
					resultSet.first();
					break;
				case TABLE_PRIVILEGES:
					tStats.setTblPrvs(resultSet.getRow());
					resultSet.first();
					break;
				case INDEXES:
					tStats.setIndxs(resultSet.getRow());
					resultSet.first();
					break;
				default:
					System.out.println("Invalid typeOfData provided: "+ typeOfData +" on table: "+schemaName+"."+tableName);
					break;
				}				
			}
			metadataList.add(metadata);
			databaseStatistics.addTableStatistics(tStats);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder retValue = new StringBuilder();
		retValue.append(databaseStatistics.toString()).append("\n");
		for (Metadata metadata : metadataList) {	
			retValue.append(metadata.toString()).append("\n"); 
		}		
		return retValue.toString();	
	}
	
//	public void printMetadatalistTables() {
//		for (Metadata met : metadataList) {
//			System.out.println("inside MetadataManager ---> "+met.getTableName());
////			for(String res : metadataTypes) {
////				System.out.println(met.getTableName());
////			}
//		}
//	}
	
	public void writeToFile(String metadata, String filePath) {
		FileUtils.writeToFile(metadata, filePath);
	}

}
