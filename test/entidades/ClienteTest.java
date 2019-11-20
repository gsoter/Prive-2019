package entidades;

import static org.junit.Assert.*;
import org.junit.*;

import entidades.Cliente;

public class ClienteTest {

	private Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("001", "Ed", "Motta", "066.666.666-00", "1187654321");
	}

	@Test
	public void testGetNome_setNomeNull() throws Exception {
		cliente.setNome(null);
		String result = cliente.getNome();
		assertEquals("Ed", result);
	}

	@Test
	public void testGetSobrenome_SetSobrenomeNull() throws Exception {
		cliente.setSobrenome(null);
		String result = cliente.getSobrenome();
		assertEquals("Motta", result);
	}

	@Test
	public void testGetCPF_SetCPFNull() throws Exception {
		cliente.setCpf(null);
		String result = cliente.getCpf();
		assertEquals("066.666.666-00", result);
	}

	@Test
	public void testGetTelefone_SetTelefoneNull() throws Exception {
		cliente.setTelefone(null);
		String result = cliente.getTelefone();
		assertEquals("1187654321", result);
	}

	@Test
	public void testGetNome_SetNomeComNumero() throws Exception {
		cliente.setNome("Ed66");
		String result = cliente.getNome();
		assertEquals("Ed", result);
	}

	@Test
	public void testGetSobrenome_SetSobrenomeComNumero() throws Exception {
		cliente.setSobrenome("Motta99");
		String result = cliente.getSobrenome();
		assertEquals("Motta", result);
	}

	@Test
	public void testGetCPF_SetCPFComLetras() throws Exception {
		cliente.setCpf("069.669.994-LL");
		String result = cliente.getCpf();
		assertEquals("066.666.666-00", result);
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		System.gc();
	}

}
