package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import facade.ClienteFacadeTest;

@RunWith(Suite.class)
@SuiteClasses({ ClienteFacadeTest.class })
public class SuiteTesteFacade {

}
