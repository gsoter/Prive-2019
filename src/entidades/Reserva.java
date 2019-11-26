package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Reserva {

	private int idReserva;
	private Apartamento apto;
	private Cliente cliente;
	private String dataEntrada;
	private String dataSaida;
	private Temporada temporada;
	private int nHospedes;
	private int nCamaExtra;
	private String dataAberturaConta;
	private Double valorTotal;
	private Double valorAdicional;

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
	 * @param valorTotal Um valor em números no formato 00.00. Não pode ser um valor negativo.
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return Valor adicional referente a gastos com cama extra, diárias fora do alcance da temporada
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
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
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
