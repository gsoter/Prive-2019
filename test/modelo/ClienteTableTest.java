package modelo;

import util.DbUnitHelper;

import java.io.FileInputStream;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.Assertion;

public class ClienteTableTest extends DbUnitHelper {

	IDatabaseConnection connection;

	public ClienteTableTest(String name) {
		super(name);
	}

	public void setUp() throws Exception {
		super.setUp();
		connection = getConnection();
	}

	public void tearDown() throws Exception {
		super.tearDown();
		connection.close();
	}

	public void testInserirCliente() throws Exception {
		try {
			// dados do banco
			IDataSet dataSetBanco = connection.createDataSet();
			ITable dadosBanco = dataSetBanco.getTable("cliente");

			// dados esperados de um dataset XML
			IDataSet dataSetEsperado = new FlatXmlDataSetBuilder()
					.build(new FileInputStream("/Documents/workspace/Prive-v2019/test/modelo/cliente2.xml"));
			ITable dadosEsperados = dataSetEsperado.getTable("cliente");

			// verifica se os dados esperados correspondem aos dados do banco
			Assertion.assertEquals(dadosEsperados, dadosBanco);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testQtdRegistrosTabela() throws Exception {
		IDataSet dataSetBanco = connection.createDataSet();
		int rowCount = dataSetBanco.getTable("cliente").getRowCount();
		assertEquals(3, rowCount);
	}

	public void testProcurarRegistro() throws Exception {
		ITable actualJoinData = connection.createQueryTable("c", "SELECT nome FROM cliente WHERE cpf='012345678933'");
		assertEquals("João", actualJoinData.getValue(0, "nome"));
	}

}
