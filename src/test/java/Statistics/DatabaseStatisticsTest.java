package Statistics;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Enums.MetadataType;

public class DatabaseStatisticsTest {

    private DatabaseStatistics databaseStats;

    @Before
    public void setUp() {
        databaseStats = new DatabaseStatistics();
    }

    @Test
    public void testAddTableStatistics() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3);
        databaseStats.addTableStatistics(tableStats);

        assertEquals(1, databaseStats.getDatabaseStats().size());
    }

    @Test
    public void testToString() {
        TableStatistics tableStats1 = new TableStatistics("Table1", 5, 2, 1, 1, 100, 3);
        TableStatistics tableStats2 = new TableStatistics("Table2", 8, 3, 2, 2, 150, 4);
        databaseStats.addTableStatistics(tableStats1);
        databaseStats.addTableStatistics(tableStats2);

        String expected = "The Table :Table1 has :5  columns, \t2 primary keys, 1 foreign keys,\t 3 indexes, \n"
                + "The Table :Table2 has :8  columns, \t3 primary keys, 2 foreign keys,\t 4 indexes, \n";

        assertEquals(expected, databaseStats.toString());
    }

    @Test
    public void testUpdateValue() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3);
        databaseStats.addTableStatistics(tableStats);

        // Update the number of columns for "TestTable"
        databaseStats.updateValue(MetadataType.COLUMNS, "TestTable", 10, null);

        assertEquals(10, databaseStats.getDatabaseStats().get(0).getColumns());
    }

    @Test
    public void testUpdateMultipleValues() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3);
        databaseStats.addTableStatistics(tableStats);

        // Update multiple values for "TestTable"
        databaseStats.updateValue(MetadataType.COLUMNS, "TestTable", 10, null);
        databaseStats.updateValue(MetadataType.PRIMARY_KEYS, "TestTable", 3, null);
        databaseStats.updateValue(MetadataType.EXPORTED_KEYS, "TestTable", 2, null);

        assertEquals(10, databaseStats.getDatabaseStats().get(0).getColumns());
        assertEquals(3, databaseStats.getDatabaseStats().get(0).getPks());
        assertEquals(2, databaseStats.getDatabaseStats().get(0).getFks());
    }

    @Test
    public void testUpdateValueForNonExistingTable() {
        // Try to update values for a table that doesn't exist
        databaseStats.updateValue(MetadataType.COLUMNS, "NonExistingTable", 10, null);

        assertEquals(0, databaseStats.getDatabaseStats().size());
    }

    // Add more tests as needed
}