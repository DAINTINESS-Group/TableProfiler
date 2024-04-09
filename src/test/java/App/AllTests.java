package App;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Model.ColumnMetadataTest;
import Model.ColumnPrivilegesTest;
import Model.ExportedKeysTest;
import Model.ImportedKeysTest;
import Model.IndexInfoTest;
import Model.PrimaryKeysTest;
import Model.TablePrivilegesTest;
import Model.TablesTest;

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
})
public class AllTests {
    
}