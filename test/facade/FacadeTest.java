package facade;

import static org.junit.Assert.*;
import org.junit.*;

public class FacadeTest {

	private static Facade facade;

	@Before
	public void setUp() throws Exception {
		facade = Facade.getInstancia();
	}

	@After
	public void tearDown() throws Exception {
		facade = null;
		System.gc();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
