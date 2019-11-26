package entidades;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TemporadaTest {

	Temporada temp;

	@Before
	public void setUp() throws Exception {
		this.temp = new Temporada(TemporadaEnum.CARNAVAL, "29/02/2020", "04/03/2020");
	}

	@After
	public void tearDown() throws Exception {
		temp = null;
		System.gc();
	}

	@Test
	public void getNomeTemporada_setNomeNull() throws Exception {
		temp.setNomeTemporada(null);
		TemporadaEnum result = temp.getNomeTemporada();
		assertEquals(TemporadaEnum.CARNAVAL, result);
	}

	@Test
	public void getDataInicial_setDataInicialNull() throws Exception {
		temp.setDataInicial(null);
		String result = temp.getDataInicial();
		assertEquals("29/02/2020", result);
	}

	@Test
	public void getDataFinal_setDataFinalNull() throws Exception {
		temp.setDataFinal(null);
		String result = temp.getDataFinal();
		assertEquals("04/03/2020", result);
	}

	@Test
	public void getDataInicial_setDataInicialSoNumeros() throws Exception {
		temp.setDataInicial("27022020");
		String result = temp.getDataInicial();
		assertEquals("27/02/2020", result);
	}

	@Test
	public void getDataFinal_setDataFinalSoNumeros() throws Exception {
		temp.setDataFinal("02032020");
		String result = temp.getDataFinal();
		assertEquals("02/03/2020", result);
	}

	@Test
	public void getDataInicial_setDataInicialComCaracter() throws Exception {
		temp.setDataInicial("27.02.2020");
		String result = temp.getDataInicial();
		assertEquals("27/02/2020", result);
	}

	@Test
	public void getDataFinal_setDataFinalComCaracter() {
		temp.setDataFinal("02-03-2020");
		String result = temp.getDataFinal();
		assertEquals("02/03/2020", result);
	}
}
