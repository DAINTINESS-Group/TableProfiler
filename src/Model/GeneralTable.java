package Model;

import java.util.ArrayList;
import java.util.List;

public class GeneralTable {
	
	private String modelName;		
 	private ArrayList<String> columns;
	private ArrayList<String> columnsDataTypes;
	private List<List<String>> data = new ArrayList<>();
	
	public GeneralTable(String modelName) {
		this.modelName = modelName;
	}

	public void setData(List<List<String>> data) {		
		for(List<String> dataRow : data) {
			List<String> row = new ArrayList<String>(dataRow);
			this.data.add(row);
		}		
	}

	public void setColumnsDataType(List<String> columnDataTypes) {
		this.columnsDataTypes = new ArrayList<String>(columnDataTypes);		
	}

	public String getModelName() {		
		return modelName;
	}

	public void getColumns() {
		for(String columnName : columns) {
			System.out.println(columnName);
		}
	}

	public void getColumnsDataTypes() {
		for(String columnDataType : columnsDataTypes) {
			System.out.println(columnDataType);
		}
	}

	public void getData() {
		for(List<String> dataRow : data) {
			for(String value : dataRow) {
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	}

	public void setColumns(List<String> columnNames) {
		this.columns = new ArrayList<String>(columnNames);		
	}	
}


