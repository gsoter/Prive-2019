package controle;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class BLLClienteTest extends ChromeDriverConfig {

	private static ChromeDriver driver;

	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(true);
	}

}
