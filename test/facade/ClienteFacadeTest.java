package facade;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controle.BLLCliente;
import entidades.Cliente;
import modelo.DAOCliente;

public class ClienteFacadeTest {

	@InjectMocks
	private static Facade facade;

	@Mock
	private DAOCliente daoMock;

	@InjectMocks
	private BLLCliente service;

	private Cliente cliente;

	public void setService(BLLCliente service) {
		this.service = service;
	}

	@Before
	public void setUp() throws Exception {
		facade = Facade.getInstancia();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		facade = null;
		System.gc();
	}

//	@Test
//	public void testInserirCliente_inserirClienteValido() throws Exception {
//		cliente = returnCliente();
//
//		when(daoMock.inserir(cliente)).thenReturn(true);
//		when(daoMock.consultar(cliente.getCpf())).thenReturn(cliente);
//
//	}

	private Cliente returnCliente() {
		return new Cliente("", "Maria", "Santos", "01234567890", "81987654321");
	}

}
