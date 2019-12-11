package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controle.BLLClienteUnitTest;

@RunWith(Suite.class)
@SuiteClasses({ BLLClienteUnitTest.class })
public class SuiteTestControle {

}
