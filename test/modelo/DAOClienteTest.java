package modelo;

import static org.hamcrest.MatcherAssert.*;
import util.DbUnitHelper;
import java.io.FileInputStream;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import entidades.Cliente;

import org.dbunit.Assertion;

public class DAOClienteTest extends DbUnitHelper {

	private DAOCliente dao;
	private Cliente cliente;
	private IDatabaseConnection connection;

	public DAOClienteTest(String name) {
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

	private Cliente returnCliente() {
		return new Cliente("001", "Maria", "Santos", "01234567890", "81987654321");
	}

	public void testInserirCliente() throws Exception {
		try {
			// dados do banco
			IDataSet dataSetBanco = connection.createDataSet();
			ITable dadosBanco = dataSetBanco.getTable("cliente");

			// dados esperados de um dataset XML
			IDataSet dataSetEsperado = new FlatXmlDataSetBuilder()
					.build(new FileInputStream("/Documents/workspace/Prive-v2019/test/modelo/clienteEsperado.xml"));
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
		ITable actualJoinData = connection.createQueryTable("c", "SELECT nome FROM cliente WHERE cpf='01234567893'");
		assertEquals("João", actualJoinData.getValue(0, "nome"));
	}

//	public void testConsultarClienteCpf_CpfCadastrado() throws Exception {
//		cliente = returnCliente();
//		Cliente result = dao.consultar(cliente.getCpf());
//		assertEquals(result, "01234567890");
//	}

//	public void testInserirCliente_ClienteNulo() throws Exception {
//		cliente = returnCliente();
//		assertThat(dao.inserir(cliente), is(false));
//	}

//	@Test
//	public void testAlterarCliente_ClienteNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testAlterarCliente_ClienteCadastrado() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testExcluirCliente_ParametroNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testExcluirCliente_ClienteCadastrado() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testConsultarClientePorCpf_ParametroNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testConsultarClientePorCpf_CpfNaoCadastrado() throws Exception {
//		assertTrue(true);
//	}

//
//	@Test
//	public void testListarClientes_SemClientesCadastrados() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testListarClientes_ClientesCadastrados() throws Exception {
//		assertTrue(true);
//	}
//

}
