package controle;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import entidades.Cliente;
import modelo.DAOCliente;

public class BLLClienteUnitTest {

	private Cliente cliente;

	@InjectMocks
	private BLLCliente service;

	@Mock
	private DAOCliente daoMock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		cliente = returnCliente();
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		System.gc();
	}

	@Test
	public void testInserirCliente_inserirClienteValido() throws Exception {
		// Preparar Mock para retorno válido
		when(daoMock.inserir(cliente)).thenReturn(true);
		when(daoMock.consultar(cliente.getCpf())).thenReturn(returnCliente());

		// Testa o método da classe de teste
		assertThat(service.inserir(cliente), is(true));

		// Verifica se método foi chamado uma vez
		verify(daoMock, times(1)).inserir(any());

	}

	@Test
	public void testConsultarClienteCpf_pesquisaValida() throws Exception {
		// Preparar Mock para retorno válido
		when(daoMock.consultar(cliente.getCpf())).thenReturn(returnCliente());

		// Testa se o método da classe de teste retorna objeto esperado
		assertThat(service.pesquisar("01234567890"), is(returnCliente()));
		// Verificar se este método é acessado uma vez
		verify(daoMock, times(1)).consultar(anyString());

	}

	public void testAlterarCliente_alterarClienteValido() {
		// TODO
	}

	public void testExcluirCliente_excluirClienteValido() {
		// TODO
	}

	public void testListarClientes_listarClientesValido() {
		// TODO
	}

	private Cliente returnCliente() {
		return new Cliente("001", "Maria", "Santos", "01234567890", "81987654321");
	}
}
