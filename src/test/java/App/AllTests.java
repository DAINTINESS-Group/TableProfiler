package App;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import DatabaseTasks.DataManagerIntegrationTest;
import DatabaseTasks.DatabaseConnectionJUnitTest;
import Model.ColumnMetadataTest;
import Model.ColumnPrivilegesTest;
import Model.ExportedKeysTest;
import Model.ImportedKeysTest;
import Model.IndexInfoTest;
import Model.PrimaryKeysTest;
import Model.TablePrivilegesTest;
import Model.TablesTest;
import Statistics.DatabaseStatisticsTest;
import Statistics.TableStatisticsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ColumnMetadataTest.class,
	ColumnPrivilegesTest.class,
	ExportedKeysTest.class,
	ImportedKeysTest.class,
	IndexInfoTest.class,
	PrimaryKeysTest.class,
	TablePrivilegesTest.class,
	TablesTest.class,
	DatabaseConnectionJUnitTest.class,
	DataManagerIntegrationTest.class,
	DatabaseStatisticsTest.class,
	TableStatisticsTest.class,
})
public class AllTests {
    
}