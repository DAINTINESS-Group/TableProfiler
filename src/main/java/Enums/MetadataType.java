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
    CROSS_REFERENCE_UNIQUE("Cross-Reference Unique");

    private final String displayName;

    MetadataType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}