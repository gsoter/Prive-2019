package entidades;

import static org.junit.Assert.*;
import org.junit.*;


public class AptoTest {

	private Apartamento apto;

	@Before
	public void setUp() throws Exception {
		apto = new Apartamento();
	}

	@After
	public void tearDown() throws Exception {
		apto = null;
		System.gc();
	}

	@Test
	public void test() throws Exception {
		
	}

}
