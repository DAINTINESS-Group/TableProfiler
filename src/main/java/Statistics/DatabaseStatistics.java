package Statistics;

import java.util.ArrayList;

import Enums.MetadataType;

public class DatabaseStatistics {
	private ArrayList<TableStatistics> databaseStats = new ArrayList<>();;
	
	public void addTableStatistics(TableStatistics tStats) {
		databaseStats.add(tStats);		
	}
	
	public void addTableStatistics(String TableName, int columns, int primary_keys, int exported_keys, int imported_keys, int indxs, int tblPrvs, int colPrvs) {
		TableStatistics ts = new TableStatistics(TableName, columns, primary_keys, exported_keys, imported_keys, indxs, tblPrvs, colPrvs);		
		databaseStats.add(ts);
	}
	
	public ArrayList<TableStatistics> getDatabaseStats() {
		return databaseStats;
	}
	
	@Override
	public String toString() {
		StringBuilder retString = new StringBuilder();
		for (TableStatistics tableStats : databaseStats) {
			retString.append(tableStats.toString()).append("\n");			
		}
		return retString.toString();
	}

	public void updateValue(MetadataType typeOfData, int value, String tableName) {
		for(TableStatistics tName : databaseStats) {
			if(tName.getTableName().equals(tableName)) {
				switch(typeOfData) {
					case COLUMNS:
						tName.setColumns(value);
						break;
					case PRIMARY_KEYS:
						tName.setPrimary_keys(value);
						break;
					case EXPORTED_KEYS:
						tName.setExported_keys(value);
						break;
					case IMPORTED_KEYS:
						tName.setImported_keys(value);
						break;
					case INDEXES:
						tName.setIndxs(value);
						break;
					case COLUMN_PRIVILEGES:
						tName.setColPrvs(value);
						break;
					case TABLE_PRIVILEGES:
						tName.setTblPrvs(value);
						break;
					default:
						System.out.println("False value on DatabaseStatistics at updateValue method on table: "+tableName);						
				}
			}
		}		
	}	
}
