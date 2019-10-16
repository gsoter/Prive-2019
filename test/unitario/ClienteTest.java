package unitario;

import static org.junit.Assert.*;
import org.junit.*;

import entidades.Cliente;

public class ClienteTest {

	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente();
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		System.gc();
	}

	/**
	 * <p>
	 * Testar quantidade mínima e máxima de dígitos possíveis que o método
	 * {@code SetTelefone} recebe.
	 * <p>
	 * Os valores limites são 7, 9, 11, 13, 0, null.
	 * <p>
	 * O resultado deve ser positivo apenas p/ números e no mínimo 8, no máximo 12
	 * dígitos
	 */
	@Test
	public void testSetTelefone() {
		// 1A Valor = 7.
		/**
		 * ideia: criar um array com valores possíveis. criar um loop conferindo cada
		 * um. criar condicionais e assertivas
		 */
		String num = "3461180";
		// 2A
		cliente.setTelefone(num);
		// 3A Afirmar que não recebe valor incorreto
		Object expected = null;
		assertEquals(expected, cliente.getTelefone());
		// 1A Valor = 9.
		String num2 = "355222764";
		cliente.setTelefone(num2);
		assertNotNull(cliente.getTelefone());
	}

}
