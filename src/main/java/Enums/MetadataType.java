package Enums;

public enum MetadataType {
    TABLES("Tables"),
    COLUMNS("Columns"),
    PRIMARY_KEYS("Primary Keys"),
    IMPORTED_KEYS("Imported Keys"),
    EXPORTED_KEYS("Exported Keys"),
    CROSS_REFERENCE("Cross-Reference"),
    INDEXES("Indexes"),
    BEST_ROW_IDENTIFIER("Best Row Identifier"),
    CROSS_REFERENCE_UNIQUE("Cross-Reference Unique"),
    TABLE_PRIVILEGES("Table Privileges"),
    COLUMN_PRIVILEGES("Column Privileges"),
    PSEUDO_COLUMNS("Column Privileges"),
    ATTRIBUTES("Attributes"),
    VERSION_COLUMNS("Version Columns"),
    TYPE_INFO("Type Info");

    private final String displayName;

    MetadataType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
