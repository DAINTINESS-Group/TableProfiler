package Model;

import DatabaseTasks.DataManager;
import Enums.MetadataType;
import Statistics.DatabaseStatistics;
import Statistics.TableStatistics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class MetadataManager {

	private ArrayList<Metadata> metadataList;
	public DatabaseStatistics databaseStatistics = new DatabaseStatistics();

	public MetadataManager() {
		metadataList = new ArrayList<>();
	}

	public ArrayList<Metadata> getMetadataList() {
		return metadataList;
	}

	public void createMetadata(ArrayList<MetadataType> typeOfDataList, String tableName, Connection connection)
			throws SQLException {
		DataManager dataManager = new DataManager();
		int counter = 0;
		TableStatistics tStats = null ;
		if (tableName.equals("ALL")) {
			ResultSet allTableNames = dataManager.extractTableMetadata(connection, MetadataType.TABLES, tableName);
			while (allTableNames.next()) {
				String tableNameS = allTableNames.getString("TABLE_NAME");
				tStats = new TableStatistics(tableNameS, 0, 0, 0, 0, 0, 0);
				Metadata metadata = new Metadata(tableNameS);

				for (MetadataType typeOfData : typeOfDataList) {
					ResultSet resultSet = dataManager.extractTableMetadata(connection, typeOfData, tableNameS);
					counter = metadata.addList(typeOfData, resultSet);
					switch (typeOfData) {
					case TABLES:
						tStats.setRows(counter);
						break;
					case COLUMNS:
						tStats.setColumns(counter);
						break;
					case PRIMARY_KEYS:
						tStats.setPks(counter);
						break;
					case IMPORTED_KEYS:
						tStats.setFks(counter);//setReferedPks(counter);
						break;
					case EXPORTED_KEYS:
						tStats.setPksReferedToOtherFks(counter);
						break;
					case CROSS_REFERENCE:
						tStats.setRows(counter);
						break;
					case INDEXES:
						tStats.setInds(counter);
						break;
					case BEST_ROW_IDENTIFIER:
						tStats.setRows(counter);
						break;
					case CROSS_REFERENCE_UNIQUE:
						tStats.setRows(counter);
						break;
					default:
						System.out.println("Invalid typeOfData provided.");
						break;
					}
				}
				metadataList.add(metadata);
				databaseStatistics.addTableStatistics(tStats);
			}
		} else {
			tStats = new TableStatistics(tableName, 0, 0, 0, 0, 0, 0);
			Metadata metadata = new Metadata(tableName);			
			for (MetadataType typeOfData : typeOfDataList) {
				ResultSet resultSet = dataManager.extractTableMetadata(connection, typeOfData, tableName);
				counter = metadata.addList(typeOfData, resultSet);
				System.out.println(typeOfData + " : " + counter);
				switch (typeOfData) {
				case TABLES:
					tStats.setRows(counter);
					break;
				case COLUMNS:
					tStats.setColumns(counter);
					break;
				case PRIMARY_KEYS:
					tStats.setPks(counter);
					break;
				case IMPORTED_KEYS:
					tStats.setFks(counter);//setReferedPks(counter);
					break;
				case EXPORTED_KEYS:
					tStats.setPksReferedToOtherFks(counter);
					break;
				case CROSS_REFERENCE:
					tStats.setRows(counter);
					break;
				case INDEXES:
					tStats.setInds(counter);
					break;
				case BEST_ROW_IDENTIFIER:
					tStats.setRows(counter);
					break;
				case CROSS_REFERENCE_UNIQUE:
					tStats.setRows(counter);
					break;
				default:
					System.out.println("Invalid typeOfData provided.");
					break;
				}
				metadataList.add(metadata);				
			}
			databaseStatistics.addTableStatistics(tStats);
		}
	}
	
	@Override
	public String toString() {
		return databaseStatistics.toString();	
	}

}
