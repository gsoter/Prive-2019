package modelo;

import org.junit.*;
import entidades.Cliente;
import static org.junit.Assert.*;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

public class DAOClienteTest extends DbUnit {

	private IDatabaseConnection connection;
	private DAOCliente dao;
	private Cliente cliente;

	public DAOClienteTest(String name) {
		super(name);
	}

	@BeforeClass
	public void initClass() throws Exception {
		connection = getConnection();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		cliente = new Cliente("001", "Maria", "Santos", null, null);
		IDataSet dataSet = getDataSet();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		} finally {
			connection.close();
		}
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testInserirCliente_ClienteValido() throws Exception {
		dao.inserir(cliente);
		verificarBanco("dados.xml", "cliente");
	}

//	@Test
//	public void testInserirCliente_ClienteNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testInserirCliente_CpfRepetido() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testInserirCliente_IdRepedita() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testAlterarCliente_ClienteNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testAlterarCliente_ClienteNaoCadastrado() throws Exception {
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
//	public void testExcluirCliente_ClienteNaoCadastrado() throws Exception {
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
//	public void testConsultarClientePorId_ParametroNulo() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testConsultarClientePorId_IdInexistente() throws Exception {
//		assertTrue(true);
//	}
//
//	@Test
//	public void testConsultarClientePorId_IdExistente() throws Exception {
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
