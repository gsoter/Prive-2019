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
	private Cliente cli;

	@Before
	public void setUp() throws Exception {
		this.apto = mock(Apartamento.class);
		this.cli = mock(Cliente.class);
	}

	@After
	public void tearDown() throws Exception {
		res = null;
		apto = null;
		cli = null;
		System.gc();
	}

	@Test
	public void getDataEntrada_setDataEntradaNull() throws Exception {
		res = this.returnReserva();
		res.setDataEntrada(null);
		String result = res.getDataEntrada();
		String expect = this.returnReserva().getDataEntrada();
		assertEquals(expect, result);
	}

	@Test
	public void getDataSaida_setDataSaidaNull() {
		res = this.returnReserva();
		res.setDataSaida(null);
		String result = res.getDataSaida();
		String expect = this.returnReserva().getDataSaida();
		assertEquals(expect, result);
	}

	@Test
	public void getDataAbertura_setDataAberturaNull() {
		res = this.returnReserva();
		res.setDataAberturaConta(null);
		String result = res.getDataAberturaConta();
		String expect = this.returnReserva().getDataAberturaConta();
		assertEquals(expect, result);
	}
	
	@Test
	public void getAptoGrande_setNumHospedeMax() {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void getAptoPequeno_setNumHospedesMin() throws Exception {
		
	}
	
	private void getTemporadaCarnaval_setDataEntradaNoPeriodo() {
		// TODO Auto-generated method stub

	}
	
	private void getTemporadaSemanaSanta_setDataEntradaNoPeriodo() {
		// TODO Auto-generated method stub

	}
	
	private void getTemporadaAnoNovo_setDataEntradaNoPeriodo() {
		// TODO Auto-generated method stub

	}
	
	private void getTemporadaVerao_setDataEntradaNoPeriodo() {
		// TODO Auto-generated method stub

	}
	
	private void getNumCamaExtra_setNumHospedesMaxAptoPequeno() {
		// TODO Auto-generated method stub

	}
	
	private void getNumCamaExtra_setNumHospedesMaxAptoGrande() {
		// TODO Auto-generated method stub

	}
	
	private void getValorAdicional_setCamaExtraMax() {
		// TODO Auto-generated method stub

	}
	
	private void getValorAdicional_setCamaExtraMin() {
		// TODO Auto-generated method stub

	}
	
	private void getValorTotal_setDataEntradaSaidaMax() {
		// TODO Auto-generated method stub

	}
	
	private void getValorTotal_setDataEntradaSaidaMin() {
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
		reserva.setCliente(this.cli);
		reserva.setTemporada(TemporadaEnum.INVERNO);
		reserva.setApto(this.apto);
		reserva.setnCamaExtra(0);
		reserva.setDataAberturaConta("01/06/2020");
		reserva.setValorAdicional(0.00);
		reserva.setValorTotal(70.00);

		return reserva;
	}

}
