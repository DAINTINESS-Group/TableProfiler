package Statistics;

public class TableStatistics {
	private String tableName="";
	private int columns = 0;
	private int primary_keys = 0;
	private int exported_keys = 0;
	private int imported_keys=0;
	private int indxs = 0;
	private int tblPrvs = 0;
	private int colPrvs =0;
	
		
	public TableStatistics(String tableName, int columns, int primary_keys, int exported_keys, int imported_keys, int indxs,int tblPrvs,int colPrvs ) {		
		this.tableName = tableName;
		this.columns = columns;
		this.exported_keys = exported_keys;
		this.primary_keys = primary_keys;
		this.imported_keys = imported_keys;
		this.indxs = indxs;
		this.tblPrvs = tblPrvs;
		this.colPrvs = colPrvs;
	}
	
	public TableStatistics(String tableName) {
		this.tableName = tableName;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getPrimary_keys() {
		return primary_keys;
	}

	public void setPrimary_keys(int primary_keys) {
		this.primary_keys = primary_keys;
	}

	public int getExported_keys() {
		return exported_keys;
	}

	public void setExported_keys(int exported_keys) {
		this.exported_keys = exported_keys;
	}

	public int getImported_keys() {
		return imported_keys;
	}

	public void setImported_keys(int imported_keys) {
		this.imported_keys = imported_keys;
	}
	
	public int getIndxs() {
		return indxs;
	}

	public void setIndxs(int indxs) {
		this.indxs = indxs;
	}

	public String getTableName() {
		return tableName;
	}
	
	public int getColPrvs() {
		return colPrvs;
	}

	public void setColPrvs(int colPrvs) {
		this.colPrvs = colPrvs;
	}

	public int getTblPrvs() {
		return tblPrvs;
	}

	public void setTblPrvs(int tblPrvs) {
		this.tblPrvs = tblPrvs;
	}
	
	
	@Override
	public String toString() {
		return "The Table "+tableName+" has :"+columns+"  columns,\t"+primary_keys+" primary keys, \t"+exported_keys+" exported keys,\t"+imported_keys+" imported keys"+ ", \t"+ indxs+" indexes, \t"+colPrvs+" column privileges, \t"+tblPrvs+" table privileges.";
	}	
}
