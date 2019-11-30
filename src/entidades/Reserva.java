package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * <p>
 * Reserva depende inicialmente de data de entrada e saída, nº de hóspedes. Com
 * isso será definido temporada, apto, nº de camas extra, valor adicional e
 * valor total. Data de abertura serve pra armazenar data de pagamento adiantado
 * da reserva.
 * <p>
 * Por padrão, a reserva deve ser criada da seguinte forma:
 * <p>
 * Reserva(id=001, dt_entrada = 01/06/2020, dt_saida=02/06/2020, nº_hospedes=3,
 * temporada=inverno, apto=pequeno, nº_camas_extra=0, cliente=001,
 * data_abertura=01/06/2020, valor_add=0.00, valorTotal=70.00.
 * 
 * @author Gustavo Soter
 *
 */
public class Reserva {

	private int idReserva;
	private String dataEntrada;
	private String dataSaida;
	private int nHospedes;
	private TemporadaEnum temporada;
	private Apartamento apto;
	private int nCamaExtra;
	private Cliente cliente;
	private String dataAberturaConta;
	private Double valorAdicional;
	private Double valorTotal;

	public Reserva() {

	}

	public Reserva(int idReserva, String dataEntrada, String dataSaida, int nHospedes, TemporadaEnum temporada,
			Apartamento apto, int nCamaExtra, Cliente cliente, String dataAberturaConta, Double valorAdicional,
			Double valorTotal) {
		super();
		this.idReserva = idReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.nHospedes = nHospedes;
		this.temporada = temporada;
		this.apto = apto;
		this.nCamaExtra = nCamaExtra;
		this.cliente = cliente;
		this.dataAberturaConta = dataAberturaConta;
		this.valorAdicional = valorAdicional;
		this.valorTotal = valorTotal;
	}

	/**
	 * @return Data que reserva foi feita. Abertura de débito. Esta data não pode
	 *         ser futuro à data de entrada. No máximo, igual ou anterior. A data
	 *         não pode ter distância maior que 1 ano (365 dias) da data de entrada.
	 */
	public String getDataAberturaConta() {
		return dataAberturaConta;
	}

	/**
	 * @param dataAberturaConta Uma data em números no formato dd MM yyyy Deve
	 *                          reformatar p/ dd/MM/yyyy
	 */
	public void setDataAberturaConta(String dataAberturaConta) {
		if (!(dataAberturaConta == null))
			this.dataAberturaConta = dataAberturaConta;
	}

	/**
	 * @return Valor total da reserva de acordo com temporada, valor adicional e nº
	 *         de hóspedes
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal Um valor em números no formato 00.00. Não pode ser um valor
	 *                   negativo.
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return Valor adicional referente a gastos com cama extra, diárias fora do
	 *         alcance da temporada
	 */
	public Double getValorAdicional() {
		return valorAdicional;
	}

	/**
	 * @param valorAdicional
	 */
	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Apartamento getApto() {
		return apto;
	}

	public void setApto(Apartamento apto) {
		this.apto = apto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		if (notNull(dataEntrada))
			this.dataEntrada = dataEntrada;
	}

	public boolean notNull(Object arg) {
		return (!(arg == null));
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		if (!(dataSaida == null))
			this.dataSaida = dataSaida;
	}

	public TemporadaEnum getTemporada() {
		return temporada;
	}

	public void setTemporada(TemporadaEnum temporada) {
		this.temporada = temporada;
	}

	public int getnHospedes() {
		return nHospedes;
	}

	public void setnHospedes(int nHospedes) {
		this.nHospedes = nHospedes;
	}

	public int getnCamaExtra() {
		return nCamaExtra;
	}

	public void setnCamaExtra(int nCamaExtra) {
		this.nCamaExtra = nCamaExtra;
	}

	public Double formatMoeda(Double valor) {
		DecimalFormat formato = new DecimalFormat("#.##");
		return Double.valueOf(formato.format(valor));
	}

	public String formatData(String dataIncial) {
		String data = null;
		SimpleDateFormat userFormat = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/YYYY");
		try {
			data = newFormat.format(userFormat.parse(dataIncial));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
