package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import entidades.AptoTest;
import entidades.ClienteTest;
import entidades.ReservaTest;
import entidades.TemporadaTest;

@RunWith(Suite.class)
@SuiteClasses({ AptoTest.class, ClienteTest.class, TemporadaTest.class, ReservaTest.class })
public class SuiteTesteEntidade {

}
