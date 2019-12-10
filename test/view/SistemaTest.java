package view;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ChromeDriverConfig;

public class SistemaTest extends ChromeDriverConfig{

	private static ChromeDriver driver;

	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
