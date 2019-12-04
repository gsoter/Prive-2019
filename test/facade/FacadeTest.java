package facade;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import util.ChromeDriverConfig;

public class FacadeTest extends ChromeDriverConfig {

	private static ChromeDriver driver;
	private static Facade facade;

	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	@Before
	public void setUp() throws Exception {
		facade = Facade.getInstancia();
	}

	@After
	public void tearDown() throws Exception {
		facade = null;
		System.gc();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
