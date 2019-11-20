package entidades;

import static org.junit.Assert.*;
import org.junit.*;

public class AptoTest {

	private Apartamento apto;

	@Before
	public void setUp() throws Exception {
		apto = new Apartamento("08", true, 70.0, TipoApartamentoEnum.PEQUENO);
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

	@Test
	public void testGetTipoApto_setTipoAptoNull() throws Exception {
		apto.setTipoApto(null);
		TipoApartamentoEnum result = apto.getTipoApto();
		assertEquals(TipoApartamentoEnum.PEQUENO, result);
	}

	@Test
	public void testGetIdApto_setIdAcimaDoLimite() throws Exception {
		apto.setidApto("17");
		String result = apto.getidApto();
		assertEquals("08", result);
	}

	@Test
	public void testGetIdApto_setIdLimiteMax() throws Exception {
		apto.setidApto("16");
		String result = apto.getidApto();
		assertEquals("16", result);
	}

	@Test
	public void testGetIdApto_setIdLimiteMin() throws Exception {
		apto.setidApto("01");
		String result = apto.getidApto();
		assertEquals("01", result);
	}

	@Test
	public void testGetIdApto_setIdAbaixoDoLimite() throws Exception {
		apto.setidApto("00");
		String result = apto.getidApto();
		assertEquals("08", result);
	}
	
	public void testGetTipoApto_setIdDeAptosGrande() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public void testGetTipoApto_setIdDeAptoPequeno() throws Exception {
		// TODO Auto-generated method stub

	}
}
