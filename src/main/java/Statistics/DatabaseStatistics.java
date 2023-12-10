package Statistics;

import java.util.ArrayList;

import Enums.MetadataType;

public class DatabaseStatistics {
	private ArrayList<TableStatistics> databaseStats = new ArrayList<>();;
	
	public void addTableStatistics(TableStatistics tStats) {
		databaseStats.add(tStats);		
	}
	
	public void addTableStatistics(String TableName, int columns, int pks, int fks, int uks, int rows, int inds) {
		TableStatistics ts = new TableStatistics(TableName, columns, pks, fks, uks, rows, inds);		
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

	public void updateValue(MetadataType typeOfData, String valueType, int value, String tableName) {
		for(TableStatistics tName : databaseStats) {
			if(tName.getTableName().equals(tableName)) {
				switch(typeOfData) {
					case COLUMNS:
						tName.setColumns(value);
					case PRIMARY_KEYS:
						tName.setPks(value);
					case EXPORTED_KEYS:
						tName.setUks(value);
					case IMPORTED_KEYS:
						tName.setFks(value);
					case INDEXES:
						tName.setInds(value);
					default:
						System.out.println("Flase value on DatabaseStatistics at updateValue method");
				}
			}
		}		
	}	
}
