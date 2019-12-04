package modelo;

import org.junit.*;
import entidades.Cliente;
import util.DbUnitHelper;

import java.io.File;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

public class DAOClienteTest extends DbUnitHelper {

	private DAOCliente dao;
	private Cliente cliente;
	private IDatabaseConnection connection;

	public DAOClienteTest(String name) {
		super(name);
	}

	@BeforeClass
	public void setUpClass() throws Exception {
		connection = getConnection();

	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDataSet dataset = getDataSet();
		getSetUpOperation();
		cliente = new Cliente("001", "Maria", "Santos", "012345678900", "81987654321");
		dao = new DAOCliente();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		getTearDownOperation();
		cliente = null;
		dao = null;
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		connection.close();
	}

	@Test
	public void testInserirCliente_ClienteValido() throws Exception {
		dao.inserir(cliente);
		try {
			// dados do banco
			IDataSet dataSetBanco = getConnection().createDataSet();
			ITable dadosBanco = dataSetBanco.getTable("cliente");

			// dados esperados de um dataset XML
			IDataSet dataSetEsperado = new FlatXmlDataSetBuilder().build(new File("cliente.xml"));
			ITable dadosEsperados = dataSetEsperado.getTable("cliente");

			// filtra as colunas para corresponder ao XML
			ITable dadosFiltrados = DefaultColumnFilter.includedColumnsTable(dadosBanco,
					dadosEsperados.getTableMetaData().getColumns());

			// se a tabela estiver vazia compara apenas a quantidade
			if (dadosEsperados.getRowCount() == 0)
				assertEquals(dadosFiltrados.getRowCount(), 0);
			else
				// verifica se os dados esperados correspondem aos dados do banco
				assertEquals(dadosEsperados, dadosFiltrados);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

//	@Test
//	public void testInserirCliente_ClienteNulo() throws Exception {
//		assertTrue(true);
//	}
//
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
//	public void testConsultarClientePorCpf_CpfCadastrado() throws Exception {
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
}
