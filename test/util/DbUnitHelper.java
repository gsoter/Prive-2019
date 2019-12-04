package util;

import java.io.File;
import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DbUnitHelper extends DBTestCase {

	public DbUnitHelper(String name) {
		super(name);
		try {
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.sqlite.JDBC");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
					"jdbc:sqlite:F:/Documents/workspace/Prive-v2019/data/ReservaDB.db");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");

		} catch (Exception e) {
			throw new RuntimeException("Erro ao iniciar DBUnit" + " " + e);
		}
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("cliente.xml"));
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

}
