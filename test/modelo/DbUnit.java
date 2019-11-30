package modelo;

import java.io.File;
import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DbUnit extends DBTestCase {

	public DbUnit(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.sqlite.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:sqlite:/data/ReservaDB.db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
	}

	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dados.xml"));
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	public void verificarBanco(String arquivoDadosEsperados, String... tabelas) {
		try {
			for (String tabela : tabelas) {
				// dados do banco
				IDataSet dataSetBanco = getConnection().createDataSet();
				ITable dadosBanco = dataSetBanco.getTable(tabela);

				// dados esperados de um dataset XML
				IDataSet dataSetEsperado = new FlatXmlDataSetBuilder().build(new File(arquivoDadosEsperados));
				ITable dadosEsperados = dataSetEsperado.getTable(tabela);

				// filtra as colunas para corresponder ao XML
				ITable dadosFiltrados = DefaultColumnFilter.includedColumnsTable(dadosBanco,
						dadosEsperados.getTableMetaData().getColumns());

				// se a tabela estiver vazia compara apenas a quantidade
				if (dadosEsperados.getRowCount() == 0)
					assertEquals(dadosFiltrados.getRowCount(), 0);
				else
					// verifica se os dados esperados correspondem aos dados do banco
					assertEquals(dadosEsperados, dadosFiltrados);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
}
