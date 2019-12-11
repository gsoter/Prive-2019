package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SuiteTesteEntidade.class, SuiteTestControle.class, SuiteTesteModelo.class })
public class SuiteAllTest {

}
