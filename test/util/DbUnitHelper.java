package util;

import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DbUnitHelper extends DBTestCase {

	public DbUnitHelper(String name) {
		super(name);
		try {
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.sqlite.JDBC");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
					"jdbc:sqlite:/Documents/workspace/Prive-v2019/data/ReservaDB.db");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
//			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "main");

		} catch (Exception e) {
			throw new RuntimeException("Erro ao iniciar DBUnit" + " " + e);
		}
	}

	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config) {
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new DefaultDataTypeFactory());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder()
				.build(new FileInputStream("/Documents/workspace/Prive-v2019/test/modelo/cliente.xml"));
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

}
