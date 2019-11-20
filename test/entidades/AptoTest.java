package entidades;

import static org.junit.Assert.*;
import org.junit.*;

public class AptoTest {

	private Apartamento apto;

	@Before
	public void setUp() throws Exception {
		apto = new Apartamento("101.1", true, 70.0, TipoApartamentoEnum.PEQUENO);
	}

	@After
	public void tearDown() throws Exception {
		apto = null;
		System.gc();
	}

	@Test
	public void testGetIdApto_SetIdAptoNull() throws Exception {
		apto.setidApto(null);
		String result = apto.getidApto();
		assertNotNull(result);
	}

	@Test
	public void testGetValor_SetValorNull() throws Exception {
		apto.setValorBase(null);
		Double result = apto.getValorBase();
		assertNotNull(result);
	}

}
