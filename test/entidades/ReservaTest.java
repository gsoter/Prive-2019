package entidades;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * <p>
 * Testar criação de reserva padrão, caso parametros nulos.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReservaTest {
	@InjectMocks
	private Reserva reserva;

	@Mock
	private Apartamento apto;

	@Mock
	private Cliente cli;

	@Before
	public void setUp() throws Exception {
		this.reserva = this.returnReserva();
	}

	@After
	public void tearDown() throws Exception {
		reserva = null;
		apto = null;
		cli = null;
		System.gc();
	}

	@Test
	public void getDataEntrada_setDataEntradaNull() throws Exception {
		reserva.setDataEntrada(null);
		String result = reserva.getDataEntrada();
		String expect = this.returnReserva().getDataEntrada();
		assertEquals(expect, result);
	}

	@Test
	public void getDataSaida_setDataSaidaNull() throws Exception {
		reserva.setDataSaida(null);
		String result = reserva.getDataSaida();
		String expect = this.returnReserva().getDataSaida();
		assertEquals(expect, result);
	}

	@Test
	public void getDataAbertura_setDataAberturaNull() throws Exception {
		reserva.setDataAberturaConta(null);
		String result = reserva.getDataAberturaConta();
		String expect = this.returnReserva().getDataAberturaConta();
		assertEquals(expect, result);
	}

	@Test
	public void getNumHospedes_setNumHospedesZero() throws Exception {
		reserva.setnHospedes(0);
		int result = reserva.getnHospedes();
		assertEquals(returnReserva().getnHospedes(), result);
	}

//	public void getAptoGrande_setNumHospedeMaxPermitido() throws Exception {
//		reserva.setnHospedes(6);
//		Apartamento apartamento = reserva.getApto();
//		when(apto.getTipoApto()).thenReturn(TipoApartamentoEnum.GRANDE);
//		assertEquals(apto.getTipoApto(), apartamento.getTipoApto());
//	}
//
//	public void getAptoPequeno_setNumHospedesMinPermitido() throws Exception {
//
//	}
//
//	private void getTemporadaCarnaval_setDataEntradaNoPeriodo() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getTemporadaSemanaSanta_setDataEntradaNoPeriodo() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getTemporadaAnoNovo_setDataEntradaNoPeriodo() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getTemporadaVerao_setDataEntradaNoPeriodo() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getNumCamaExtra_setNumHospedesMaxAptoPequeno() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getNumCamaExtra_setNumHospedesMaxAptoGrande() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getValorAdicional_setCamaExtraMax() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getValorAdicional_setCamaExtraMin() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getValorTotal_setDataEntradaSaidaMax() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void getValorTotal_setDataEntradaSaidaMin() {
//		// TODO Auto-generated method stub
//
//	}

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
		reserva.setCliente(returnCliente());
		reserva.setTemporada(TemporadaEnum.INVERNO);
		reserva.setApto(returnApto());
		reserva.setnCamaExtra(0);
		reserva.setDataAberturaConta("01/06/2020");
		reserva.setValorAdicional(0.00);
		reserva.setValorTotal(70.00);

		return reserva;
	}

}
