package entidades;

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

	public String getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(String dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

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

}
