package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import modelo.DAOClienteTest;

@RunWith(Suite.class)
@SuiteClasses({ DAOClienteTest.class })
public class SuiteTesteModelo {

}
