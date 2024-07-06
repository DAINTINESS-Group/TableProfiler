package Statistics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableStatisticsTest {

    @Test
    public void testSetValues() {
        TableStatistics tableStats = new TableStatistics("TestTable", 5, 2, 3, 1, 100, 4, 3);
        assertEquals(5, tableStats.getColumns());
        assertEquals(2, tableStats.getPrimary_keys());
        assertEquals(3, tableStats.getExported_keys());
        assertEquals(1, tableStats.getImported_keys());
        assertEquals(100, tableStats.getIndxs());
        assertEquals(4, tableStats.getTblPrvs());
        assertEquals(3, tableStats.getColPrvs());
    }

    @Test
    public void testToStringWithZeroValues() {
        TableStatistics tableStats = new TableStatistics("ZeroValuesTable");
        assertEquals(0, tableStats.getColumns());
        assertEquals(0, tableStats.getPrimary_keys());
        assertEquals(0, tableStats.getExported_keys());
        assertEquals(0, tableStats.getImported_keys());
        assertEquals(0, tableStats.getIndxs());
        assertEquals(0, tableStats.getTblPrvs());
        assertEquals(0, tableStats.getColPrvs());
    }

    

    @Test
    public void testSetColumns() {
        TableStatistics tableStats = new TableStatistics("TestTable");
        tableStats.setColumns(2);
        assertEquals(2, tableStats.getColumns());
    }
}