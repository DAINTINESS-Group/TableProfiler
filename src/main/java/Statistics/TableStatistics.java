package Statistics;

public class TableStatistics {
	private String tableName="";
	private int columns = 0;
	private int pks = 0;
	private int fks = 0;
	private int uks = 0;
	private int rows = 0;
	private int inds = 0;
	//private int referedPks =0;
	private int pksReferedToOtherFks = 0;
	
	public TableStatistics(String tableName, int columns, int pks, int fks, int uks, int rows, int inds) {
		super();
		this.tableName = tableName;
		this.columns = columns;
		this.fks = fks;
		this.pks = pks;		
		this.uks = uks;
		this.rows = rows;
		this.inds = inds;
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

	public int getPks() {
		return pks;
	}

	public void setPks(int pks) {
		this.pks = pks;
	}

	public int getFks() {
		return fks;
	}

	public void setFks(int fks) {
		this.fks = fks;
	}

	public int getUks() {
		return uks;
	}

	public void setUks(int uks) {
		this.uks = uks;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getInds() {
		return inds;
	}

	public void setInds(int inds) {
		this.inds = inds;
	}

	public String getTableName() {
		return tableName;
	}
	
	@Override
	public String toString() {
		return "The Table :"+tableName+" has :"+columns+"  columns, \t"+pks+" primary keys, "+fks+" foreign keys,\t "+/*, unique keys :"+uks+" number of rows :"+rows+"*/ +inds+" indexes, ";
				/*+"\nReferred Priomary Keys :"+referedPks+" This Tables Primary Keys that are Referred to other table foreign keys :"+pksReferedToOtherFks;*/
	}

//	public void setReferedPks(int counter) {
//		this.referedPks = referedPks;		
//	}

	public void setPksReferedToOtherFks(int pksReferedToOtherFks) {
		this.pksReferedToOtherFks = pksReferedToOtherFks;
	}

	public Object getPksReferedToOtherFks() {
		return pksReferedToOtherFks;
	}
	
}
