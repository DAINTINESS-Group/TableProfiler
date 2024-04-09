package Enums;

public enum MetadataType {
    TABLES("Tables"),
    COLUMNS("Columns"),
    PRIMARY_KEYS("Primary Keys"),
    IMPORTED_KEYS("Imported Keys"),
    EXPORTED_KEYS("Exported Keys"),
    INDEXES("Indexes"),
    //BEST_ROW_IDENTIFIER("Best Row Identifier"),
    TABLE_PRIVILEGES("Table Privileges"),
    COLUMN_PRIVILEGES("Column Privileges");
    //TYPE_INFO("Type Info");
    //CROSS_REFERENCE_UNIQUE("Cross-Reference Unique"),
    //CROSS_REFERENCE("Cross-Reference"),
    //PSEUDO_COLUMNS("Column Privileges"),
    //ATTRIBUTES("Attributes"),
    //VERSION_COLUMNS("Version Columns"),

    private final String displayName;

    MetadataType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
