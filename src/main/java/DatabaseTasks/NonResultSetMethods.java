package DatabaseTasks;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class NonResultSetMethods {

	public void nonResultMethodValues(Connection connection) {
		try {
			DatabaseMetaData dmd = (DatabaseMetaData) connection.getMetaData();
			
			//Method Summary
			//boolean
			dmd.getConnection();// Retrieves the connection that produced this metadata object. Connection	
			dmd.allProceduresAreCallable();// Retrieves whether the current user can call all the procedures returned by the method getProcedures.
			dmd.allTablesAreSelectable();// Retrieves whether the current user can use all the tables returned by the method getTables in a SELECT statement.
			dmd.autoCommitFailureClosesAllResultSets();// Retrieves whether a SQLException while autoCommit is true indicates that all open ResultSets are closed, even ones that are holdable.
			dmd.dataDefinitionCausesTransactionCommit();// Retrieves whether a data definition statement within a transaction forces the transaction to commit.
			dmd.dataDefinitionIgnoredInTransactions();// Retrieves whether this database ignores a data definition statement within a transaction.
			dmd.doesMaxRowSizeIncludeBlobs();// Retrieves whether the return value for the method getMaxRowSize includes the SQL data types LONGVARCHAR and LONGVARBINARY.
			dmd.generatedKeyAlwaysReturned();// Retrieves whether a generated key will always be returned if the column name(s) or index(es) specified for the auto generated key column(s) are valid and the statement succeeds.			
			dmd.isCatalogAtStart();// Retrieves whether a catalog appears at the start of a fully qualified table name.
			dmd.isReadOnly();// Retrieves whether this database is in read-only mode.
			dmd.locatorsUpdateCopy();// Indicates whether updates made to a LOB are made on a copy or directly to the LOB.
			dmd.nullPlusNonNullIsNull();// Retrieves whether this database supports concatenations between NULL and non-NULL values being NULL.
			dmd.nullsAreSortedAtEnd();// Retrieves whether NULL values are sorted at the end regardless of sort order.
			dmd.nullsAreSortedAtStart();// Retrieves whether NULL values are sorted at the start regardless of sort order.
			dmd.nullsAreSortedHigh();// Retrieves whether NULL values are sorted high.
			dmd.nullsAreSortedLow();// Retrieves whether NULL values are sorted low.			
			dmd.storesLowerCaseIdentifiers();// Retrieves whether this database treats mixed case unquoted SQL identifiers as case insensitive and stores them in lower case.
			dmd.storesLowerCaseQuotedIdentifiers();// Retrieves whether this database treats mixed case quoted SQL identifiers as case insensitive and stores them in lower case.
			dmd.storesMixedCaseIdentifiers();// Retrieves whether this database treats mixed case unquoted SQL identifiers as case insensitive and stores them in mixed case.
			dmd.storesMixedCaseQuotedIdentifiers();// Retrieves whether this database treats mixed case quoted SQL identifiers as case insensitive and stores them in mixed case.
			dmd.storesUpperCaseIdentifiers();// Retrieves whether this database treats mixed case unquoted SQL identifiers as case insensitive and stores them in upper case.
			dmd.storesUpperCaseQuotedIdentifiers();// Retrieves whether this database treats mixed case quoted SQL identifiers as case insensitive and stores them in upper case.
			dmd.supportsAlterTableWithAddColumn();// Retrieves whether this database supports ALTER TABLE with add column.
			dmd.supportsAlterTableWithDropColumn();// Retrieves whether this database supports ALTER TABLE with drop column.
			dmd.supportsANSI92EntryLevelSQL();// Retrieves whether this database supports the ANSI92 entry level SQL grammar.
			dmd.supportsANSI92FullSQL();// Retrieves whether this database supports the ANSI92 full SQL grammar supported.
			dmd.supportsANSI92IntermediateSQL();// Retrieves whether this database supports the ANSI92 intermediate SQL grammar supported.
			dmd.supportsBatchUpdates();// Retrieves whether this database supports batch updates.
			dmd.supportsCatalogsInDataManipulation();// Retrieves whether a catalog name can be used in a data manipulation statement.
			dmd.supportsCatalogsInIndexDefinitions();// Retrieves whether a catalog name can be used in an index definition statement.
			dmd.supportsCatalogsInPrivilegeDefinitions();// Retrieves whether a catalog name can be used in a privilege definition statement.
			dmd.supportsCatalogsInProcedureCalls();// Retrieves whether a catalog name can be used in a procedure call statement.
			dmd.supportsCatalogsInTableDefinitions();// Retrieves whether a catalog name can be used in a table definition statement.
			dmd.supportsColumnAliasing();// Retrieves whether this database supports column aliasing.
			dmd.supportsConvert();// Retrieves whether this database supports the JDBC scalar function CONVERT for the conversion of one JDBC type to another.
			dmd.supportsCoreSQLGrammar();// Retrieves whether this database supports the ODBC Core SQL grammar.
			dmd.supportsCorrelatedSubqueries();// Retrieves whether this database supports correlated subqueries.
			dmd.supportsDataDefinitionAndDataManipulationTransactions();// Retrieves whether this database supports both data definition and data manipulation statements within a transaction.
			dmd.supportsDataManipulationTransactionsOnly();// Retrieves whether this database supports only data manipulation statements within a transaction.
			dmd.supportsDifferentTableCorrelationNames();// Retrieves whether, when table correlation names are supported, they are restricted to being different from the names of the tables.
			dmd.supportsExpressionsInOrderBy();// Retrieves whether this database supports expressions in ORDER BY lists.
			dmd.supportsExtendedSQLGrammar();// Retrieves whether this database supports the ODBC Extended SQL grammar.
			dmd.supportsFullOuterJoins();// Retrieves whether this database supports full nested outer joins.
			dmd.supportsGetGeneratedKeys();// Retrieves whether auto-generated keys can be retrieved after a statement has been executed
			dmd.supportsGroupBy();// Retrieves whether this database supports some form of GROUP BY clause.
			dmd.supportsGroupByBeyondSelect();// Retrieves whether this database supports using columns not included in the SELECT statement in a GROUP BY clause provided that all of the columns in the SELECT statement are included in the GROUP BY clause.
			dmd.supportsGroupByUnrelated();// Retrieves whether this database supports using a column that is not in the SELECT statement in a GROUP BY clause.
			dmd.supportsIntegrityEnhancementFacility();// Retrieves whether this database supports the SQL Integrity Enhancement Facility.
			dmd.supportsLikeEscapeClause();// Retrieves whether this database supports specifying a LIKE escape clause.
			dmd.supportsLimitedOuterJoins();// Retrieves whether this database provides limited support for outer joins.
			dmd.supportsMinimumSQLGrammar();// Retrieves whether this database supports the ODBC Minimum SQL grammar.
			dmd.supportsMixedCaseIdentifiers();// Retrieves whether this database treats mixed case unquoted SQL identifiers as case sensitive and as a result stores them in mixed case.
			dmd.supportsMixedCaseQuotedIdentifiers();// Retrieves whether this database treats mixed case quoted SQL identifiers as case sensitive and as a result stores them in mixed case.
			dmd.supportsMultipleOpenResults();// Retrieves whether it is possible to have multiple ResultSet objects returned from a CallableStatement object simultaneously.
			dmd.supportsMultipleResultSets();// Retrieves whether this database supports getting multiple ResultSet objects from a single call to the method execute.
			dmd.supportsMultipleTransactions();// Retrieves whether this database allows having multiple transactions open at once (on different connections).
			dmd.supportsNamedParameters();// Retrieves whether this database supports named parameters to callable statements.
			dmd.supportsNonNullableColumns();// Retrieves whether columns in this database may be defined as non-nullable.
			dmd.supportsOpenCursorsAcrossCommit();// Retrieves whether this database supports keeping cursors open across commits.
			dmd.supportsOpenCursorsAcrossRollback();// Retrieves whether this database supports keeping cursors open across rollbacks.
			dmd.supportsOpenStatementsAcrossCommit();// Retrieves whether this database supports keeping statements open across commits.
			dmd.supportsOpenStatementsAcrossRollback();// Retrieves whether this database supports keeping statements open across rollbacks.
			dmd.supportsOrderByUnrelated();// Retrieves whether this database supports using a column that is not in the SELECT statement in an ORDER BY clause.
			dmd.supportsOuterJoins();// Retrieves whether this database supports some form of outer join.
			dmd.supportsPositionedDelete();// Retrieves whether this database supports positioned DELETE statements.
			dmd.supportsPositionedUpdate();// Retrieves whether this database supports positioned UPDATE statements.
			dmd.supportsRefCursors();// Retrieves whether this database supports REF CURSOR.			
			dmd.supportsSavepoints();// Retrieves whether this database supports savepoints.
			dmd.supportsSchemasInDataManipulation();// Retrieves whether a schema name can be used in a data manipulation statement.
			dmd.supportsSchemasInIndexDefinitions();// Retrieves whether a schema name can be used in an index definition statement.
			dmd.supportsSchemasInPrivilegeDefinitions();// Retrieves whether a schema name can be used in a privilege definition statement.
			dmd.supportsSchemasInProcedureCalls();// Retrieves whether a schema name can be used in a procedure call statement.
			dmd.supportsSchemasInTableDefinitions();// Retrieves whether a schema name can be used in a table definition statement.
			dmd.supportsSelectForUpdate();// Retrieves whether this database supports SELECT FOR UPDATE statements.
			dmd.supportsStatementPooling();// Retrieves whether this database supports statement pooling.
			dmd.supportsStoredFunctionsUsingCallSyntax();// Retrieves whether this database supports invoking user-defined or vendor functions using the stored procedure escape syntax.
			dmd.supportsStoredProcedures();// Retrieves whether this database supports stored procedure calls that use the stored procedure escape syntax.
			dmd.supportsSubqueriesInComparisons();// Retrieves whether this database supports subqueries in comparison expressions.
			dmd.supportsSubqueriesInExists();// Retrieves whether this database supports subqueries in EXISTS expressions.
			dmd.supportsSubqueriesInIns();// Retrieves whether this database supports subqueries in IN expressions.
			dmd.supportsSubqueriesInQuantifieds();// Retrieves whether this database supports subqueries in quantified expressions.
			dmd.supportsTableCorrelationNames();// Retrieves whether this database supports table correlation names.
			dmd.supportsTransactions();// Retrieves whether this database supports transactions.
			dmd.supportsUnion();// Retrieves whether this database supports SQL UNION.
			dmd.supportsUnionAll();// Retrieves whether this database supports SQL UNION ALL.
			dmd.usesLocalFilePerTable();// Retrieves whether this database uses a file for each table.
			dmd.usesLocalFiles();// Retrieves whether this database stores tables in a local file.
//			dmd.supportsResultSetConcurrency(int type, int concurrency);// Retrieves whether this database supports the given concurrency type in combination with the given result set type.
//			dmd.supportsResultSetHoldability(int holdability);// Retrieves whether this database supports the given result set holdability.
//			dmd.supportsResultSetType(int type);// Retrieves whether this database supports the given result set type.
//			dmd.supportsTransactionIsolationLevel(int level);// Retrieves whether this database supports the given transaction isolation level.
//			dmd.updatesAreDetected(int type);// Retrieves whether or not a visible row update can be detected by calling the method ResultSet.rowUpdated.
//			dmd.supportsConvert(int fromType, int toType);// Retrieves whether this database supports the JDBC scalar function CONVERT for conversions between the JDBC types fromType and toType.
//			dmd.othersDeletesAreVisible(int type);// Retrieves whether deletes made by others are visible.
//			dmd.othersInsertsAreVisible(int type);// Retrieves whether inserts made by others are visible.
//			dmd.othersUpdatesAreVisible(int type);// Retrieves whether updates made by others are visible.
//			dmd.ownDeletesAreVisible(int type);// Retrieves whether a result set's own deletes are visible.
//			dmd.ownInsertsAreVisible(int type);// Retrieves whether a result set's own inserts are visible.
//			dmd.ownUpdatesAreVisible(int type);// Retrieves whether for the given type of ResultSet object, the result set's own updates are visible.
//			dmd.insertsAreDetected(int type);// Retrieves whether or not a visible row insert can be detected by calling the method ResultSet.rowInserted.
			
			//ResultSet	and ResultSet related
		    //dmd.deletesAreDetected(int type);// Retrieves whether or not a visible row delete can be detected by calling the method ResultSet.rowDeleted.
//			ResultSet	getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern);// Retrieves a description of the given attribute of the given type for a user-defined type (UDT) that is available in the given schema and catalog.
//			ResultSet	getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable);// Retrieves a description of a table's optimal set of columns that uniquely identifies a row.
//			ResultSet	getCatalogs();// Retrieves the catalog names available in this database.
//			ResultSet	getClientInfoProperties();// Retrieves a list of the client info properties that the driver supports.
//			ResultSet	getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern);// Retrieves a description of the access rights for a table's columns.
//			ResultSet	getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern);// Retrieves a description of table columns available in the specified catalog.
//			ResultSet	getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable);// Retrieves a description of the foreign key columns in the given foreign key table that reference the primary key or the columns representing a unique constraint of the parent table (could be the same or a different table).
//			ResultSet	getExportedKeys(String catalog, String schema, String table);// Retrieves a description of the foreign key columns that reference the given table's primary key columns (the foreign keys exported by a table).
//			ResultSet	getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern);// Retrieves a description of the given catalog's system or user function parameters and return type.
//			ResultSet	getFunctions(String catalog, String schemaPattern, String functionNamePattern);// Retrieves a description of the system and user functions available in the given catalog.
//			ResultSet	getImportedKeys(String catalog, String schema, String table);// Retrieves a description of the primary key columns that are referenced by the given table's foreign key columns (the primary keys imported by a table).
//			ResultSet	getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate);// Retrieves a description of the given table's indices and statistics.
//			ResultSet	getPrimaryKeys(String catalog, String schema, String table);// Retrieves a description of the given table's primary key columns.
//			ResultSet	getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern);// Retrieves a description of the given catalog's stored procedure parameter and result columns.
//			ResultSet	getProcedures(String catalog, String schemaPattern, String procedureNamePattern);// Retrieves a description of the stored procedures available in the given catalog.
//			ResultSet	getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern);// Retrieves a description of the pseudo or hidden columns available in a given table within the specified catalog and schema.
//			ResultSet	getSchemas();// Retrieves the schema names available in this database.
//			ResultSet	getSchemas(String catalog, String schemaPattern);// Retrieves the schema names available in this database.
//			ResultSet	getSuperTables(String catalog, String schemaPattern, String tableNamePattern);// Retrieves a description of the table hierarchies defined in a particular schema in this database.
//			ResultSet	getSuperTypes(String catalog, String schemaPattern, String typeNamePattern);// Retrieves a description of the user-defined type (UDT) hierarchies defined in a particular schema in this database.
//			ResultSet	getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern);// Retrieves a description of the access rights for each table available in a catalog.
//			ResultSet	getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types);// Retrieves a description of the tables available in the given catalog.
//			ResultSet	getTableTypes();// Retrieves the table types available in this database.
//			ResultSet	getTypeInfo();// Retrieves a description of all the data types supported by this database.
//			ResultSet	getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types);// Retrieves a description of the user-defined types (UDTs) defined in a particular schema.
//			ResultSet	getVersionColumns(String catalog, String schema, String table);// Retrieves a description of a table's columns that are automatically updated when any value in a row is updated.
			
			//int
			dmd.getDatabaseMajorVersion();// Retrieves the major version number of the underlying database.
			dmd.getDatabaseMinorVersion();// Retrieves the minor version number of the underlying database.			
			dmd.getDefaultTransactionIsolation();// Retrieves this database's default transaction isolation level.
			dmd.getDriverMajorVersion();// Retrieves this JDBC driver's major version number.
			dmd.getDriverMinorVersion();// Retrieves this JDBC driver's minor version number.			
			dmd.getJDBCMajorVersion();// Retrieves the major JDBC version number for this driver.
			dmd.getJDBCMinorVersion();// Retrieves the minor JDBC version number for this driver.
			dmd.getMaxBinaryLiteralLength();// Retrieves the maximum number of hex characters this database allows in an inline binary literal.
			dmd.getMaxCatalogNameLength();// Retrieves the maximum number of characters that this database allows in a catalog name.
			dmd.getMaxCharLiteralLength();// Retrieves the maximum number of characters this database allows for a character literal.
			dmd.getMaxColumnNameLength();// Retrieves the maximum number of characters this database allows for a column name.
			dmd.getMaxColumnsInGroupBy();// Retrieves the maximum number of columns this database allows in a GROUP BY clause.
			dmd.getMaxColumnsInIndex();// Retrieves the maximum number of columns this database allows in an index.
			dmd.getMaxColumnsInOrderBy();// Retrieves the maximum number of columns this database allows in an ORDER BY clause.
			dmd.getMaxColumnsInSelect();// Retrieves the maximum number of columns this database allows in a SELECT list.
			dmd.getMaxColumnsInTable();// Retrieves the maximum number of columns this database allows in a table.
			dmd.getMaxConnections();// Retrieves the maximum number of concurrent connections to this database that are possible.
			dmd.getMaxCursorNameLength();// Retrieves the maximum number of characters that this database allows in a cursor name.
			dmd.getMaxIndexLength();// Retrieves the maximum number of bytes this database allows for an index, including all of the parts of the index.
			dmd.getMaxProcedureNameLength();// Retrieves the maximum number of characters that this database allows in a procedure name.
			dmd.getMaxRowSize();// Retrieves the maximum number of bytes this database allows in a single row.
			dmd.getMaxSchemaNameLength();// Retrieves the maximum number of characters that this database allows in a schema name.
			dmd.getMaxStatementLength();// Retrieves the maximum number of characters this database allows in an SQL statement.
			dmd.getMaxStatements();// Retrieves the maximum number of active statements to this database that can be open at the same time.
			dmd.getMaxTableNameLength();// Retrieves the maximum number of characters this database allows in a table name.
			dmd.getMaxTablesInSelect();// Retrieves the maximum number of tables this database allows in a SELECT statement.
			dmd.getMaxUserNameLength();// Retrieves the maximum number of characters this database allows in a user name.
			dmd.getResultSetHoldability();// Retrieves this database's default holdability for ResultSet objects.
			dmd.getSQLStateType();// Indicates whether the SQLSTATE returned by SQLException.getSQLState is X/Open (now known as Open Group) SQL CLI or SQL:2003.
			
			//long
			dmd.getMaxLogicalLobSize();// Retrieves the maximum number of bytes this database allows for the logical size for a LOB.
			//string
			dmd.getRowIdLifetime();// Indicates whether or not this data source supports the SQL ROWID type, and if so the lifetime for which a RowId object remains valid.
			//dmd.		
			dmd.getCatalogTerm();// Retrieves the database vendor's preferred term for "catalog".
			dmd.getCatalogSeparator();// Retrieves the String that this database uses as the separator between a catalog and table name.
			dmd.getDatabaseProductName();// Retrieves the name of this database product.
			dmd.getDatabaseProductVersion();// Retrieves the version number of this database product.
			dmd.getDriverName();// Retrieves the name of this JDBC driver.
			dmd.getDriverVersion();// Retrieves the version number of this JDBC driver as a String.
			dmd.getExtraNameCharacters();// Retrieves all the "extra" characters that can be used in unquoted identifier names (those beyond a-z, A-Z, 0-9 and _).
			dmd.getIdentifierQuoteString();// Retrieves the string used to quote SQL identifiers.
			dmd.getNumericFunctions();// Retrieves a comma-separated list of math functions available with this database.			
			dmd.getProcedureTerm();// Retrieves the database vendor's preferred term for "procedure".
			dmd.getSchemaTerm();// Retrieves the database vendor's preferred term for "schema".
			dmd.getSearchStringEscape();// Retrieves the string that can be used to escape wildcard characters.
			dmd.getSQLKeywords();// Retrieves a comma-separated list of all of this database's SQL keywords that are NOT also SQL:2003 keywords.
			dmd.getStringFunctions();// Retrieves a comma-separated list of string functions available with this database.
			dmd.getSystemFunctions();// Retrieves a comma-separated list of system functions available with this database.
			dmd.getTimeDateFunctions();// Retrieves a comma-separated list of the time and date functions available with this database.
			dmd.getUserName();// Retrieves the user name as known to this database.
			dmd.getURL();// Retrieves the URL for this DBMS.
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
