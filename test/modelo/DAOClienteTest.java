package modelo;

import org.junit.*;
import static org.junit.Assert.*;

public class DAOClienteTest extends DbUnit {

	private DAOCliente dao;

	public DAOClienteTest(String name) {
		super(name);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = new DAOCliente();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Test
	public void test() {
		
	}

}
