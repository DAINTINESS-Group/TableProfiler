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
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3, 4);
        databaseStats.addTableStatistics(tableStats);

        assertEquals(1, databaseStats.getDatabaseStats().size());
    }

    @Test
    public void testToString() {
        TableStatistics tableStats1 = new TableStatistics("Table1", 5, 2, 1, 1, 100, 3, 4);
        databaseStats.addTableStatistics(tableStats1);       

        String expected = "The Table :"+"Table1"+" has :"+5+"  columns,\t"+2+" primary keys, \t"+1+" exported keys,\t"+1+" imported keys"+ ", \t"+ 100+" indexes, \t"+4+" column privileges, \t"+3+" table privileges.\n";
        
        assertEquals(expected, databaseStats.toString());
    }

    @Test
    public void testUpdateValue() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3, 4);
        databaseStats.addTableStatistics(tableStats);        
        // Update the number of columns for "TestTable"
        databaseStats.updateValue(MetadataType.COLUMNS, 10, "TestTable");

        assertEquals(10, databaseStats.getDatabaseStats().get(0).getColumns());
    }

    @Test
    public void testUpdateMultipleValues() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 1, 1, 100, 3, 4);
        databaseStats.addTableStatistics(tableStats);

        // Update multiple values for "TestTable"
        databaseStats.updateValue(MetadataType.COLUMNS, 10, "TestTable");
        databaseStats.updateValue(MetadataType.PRIMARY_KEYS, 3, "TestTable");
        databaseStats.updateValue(MetadataType.EXPORTED_KEYS, 2, "TestTable");

        assertEquals(10, databaseStats.getDatabaseStats().get(0).getColumns());
        assertEquals(3, databaseStats.getDatabaseStats().get(0).getPrimary_keys());
        assertEquals(2, databaseStats.getDatabaseStats().get(0).getExported_keys());
    }

    @Test
    public void testUpdateValueForNonExistingTable() {
        // Try to update values for a table that doesn't exist
        databaseStats.updateValue(MetadataType.COLUMNS, 10, "NonExistingTable");

        assertEquals(0, databaseStats.getDatabaseStats().size());
    }

    // Add more tests as needed
}