package entidades;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * <p>
 * Testar criação de reserva padrão, caso parametros nulos.
 *
 */
public class ReservaTest {

	private Reserva res;
	private Apartamento apto;
	private Temporada temp;
	private Cliente cli;

	@Before
	public void setUp() throws Exception {
		this.res = new Reserva();
		this.apto = mock(Apartamento.class);
		this.temp = mock(Temporada.class);
		this.cli = mock(Cliente.class);

	}

	@After
	public void tearDown() throws Exception {
		res = null;
		apto = null;
		temp = null;
		cli = null;
		System.gc();
	}

	@Test
	public void getDataEntrada_setDataEntradaNull() throws Exception {
		res.setDataEntrada(null);
		String result = res.getDataEntrada();
		String expect = this.returnReserva().getDataEntrada();
		assertEquals(expect, result);
	}
	
	private void getDataSaida_setDataSaidaNull() {
		// TODO Auto-generated method stub

	}
	
	private void getDataAbertura_setDataAberturaNull() {
		// TODO Auto-generated method stub

	}
	
	private void getDataEntrada_setDataEntradaAntesDeAbertura() {
		// TODO Auto-generated method stub

	}
	
	private void getDataSaida_setDataSaidaAntesDeEntrada() {
		// TODO Auto-generated method stub

	}

	private void getDataEntrada_setDataEntradaAnteriorDataAtual() {
		// TODO Auto-generated method stub

	}
	
	private void getDataAbertura_setDataAberturaAnteriorDataAtual() {
		// TODO Auto-generated method stub

	}
	
	
	
	
	public Cliente returnCliente() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente("001");
		cliente.setNome("Teste");
		cliente.setSobrenome("Cliente");
		cliente.setCpf("06666999400");
		cliente.setTelefone("8199554433");

		return cliente;
	}

	public Apartamento returnApto() {
		Apartamento apartamento = new Apartamento();
		apartamento.setidApto("01");
		apartamento.setTipoApto(TipoApartamentoEnum.PEQUENO);
		apartamento.setDisponivel(true);
		apartamento.setValorBase(70.00);

		return apartamento;
	}

	public Reserva returnReserva() {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(001);
		reserva.setnHospedes(3);
		reserva.setDataEntrada("01/06/2020");
		reserva.setDataSaida("02/06/2020");
		reserva.setCliente(this.returnCliente());
		reserva.setTemporada(TemporadaEnum.INVERNO);
		reserva.setApto(this.returnApto());
		reserva.setnCamaExtra(0);	
		reserva.setDataAberturaConta("01/06/2020");			
		reserva.setValorAdicional(0.00);
		reserva.setValorTotal(70.00);

		return reserva;
	}

}
