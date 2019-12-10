package entidades;

import org.junit.*;
import static org.junit.Assert.*;


public class ReservaTest {

	private Reserva reserva;

	@Before
	public void setUp() throws Exception {
		this.reserva = returnReserva();
	}

	@After
	public void tearDown() throws Exception {
		reserva = null;
		System.gc();
	}

	@Test
	public void getDataEntrada_setDataEntradaNull() throws Exception {
		reserva.setDataEntrada(null);
		String result = reserva.getDataEntrada();
		assertNotNull(result);
	}

	@Test
	public void getDataSaida_setDataSaidaNull() throws Exception {
		reserva.setDataSaida(null);
		String result = reserva.getDataSaida();
		assertNotNull(result);
	}

	@Test
	public void getDataAbertura_setDataAberturaNull() throws Exception {
		reserva.setDataAberturaConta(null);
		String result = reserva.getDataAberturaConta();
		assertNotNull(result);
	}

	@Test
	public void getNumHospedes_setNumHospedesZero() throws Exception {
		reserva.setnHospedes(0);
		int result = reserva.getnHospedes();
		assertNotNull(result);
	}

	@Test
	public void getCliente_setClienteNull() throws Exception {
		reserva.setCliente(null);
		Cliente result = reserva.getCliente();
		assertNotNull(result);
	}

	@Test
	public void getApto_setAptoNull() throws Exception {
		reserva.setApto(null);
		assertNotNull(reserva.getApto());
	}

	@Test
	public void getTemporada_setTemporadaNull() throws Exception {
		reserva.setTemporada(null);
		assertNotNull(reserva.getTemporada());
	}

	public Cliente returnCliente() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente("001");
		cliente.setNome("Cliente");
		cliente.setSobrenome("Teste");
		cliente.setCpf("06666999400");
		cliente.setTelefone("8199554433");

		return cliente;
	}

	public Reserva returnReserva() throws Exception {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(001);
		reserva.setnHospedes(1);
		reserva.setDataEntrada("01/06/2020");
		reserva.setDataSaida("02/06/2020");
		reserva.setCliente(returnCliente());
		reserva.setTemporada(TemporadaEnum.INVERNO);
		reserva.setApto(TipoApartamentoEnum.PEQUENO);
		reserva.setnCamaExtra(0);
		reserva.setDataAberturaConta("01/06/2020");
		reserva.setValorAdicional(0.00);
		reserva.setValorTotal(70.00);

		return reserva;
	}

}
