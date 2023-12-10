package Statistics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableStatisticsTest {

    @Test
    public void testSetValues() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 3, 1, 100, 4);
        assertEquals(5, tableStats.getColumns());
        assertEquals(2, tableStats.getPks());
        assertEquals(3, tableStats.getFks());
        assertEquals(1, tableStats.getUks());
        assertEquals(100, tableStats.getRows());
        assertEquals(4, tableStats.getInds());
    }

    @Test
    public void testToStringWithZeroValues() {
        TableStatistics tableStats = new TableStatistics("ZeroValuesTable");
        assertEquals(0, tableStats.getColumns());
        assertEquals(0, tableStats.getPks());
        assertEquals(0, tableStats.getFks());
        assertEquals(0, tableStats.getUks());
        assertEquals(0, tableStats.getRows());
        assertEquals(0, tableStats.getInds());
    }

    

    @Test
    public void testSetColumns() {
        TableStatistics tableStats = new TableStatistics("TestTable");
        tableStats.setColumns(2);
        assertEquals(2, tableStats.getColumns());
    }
}