package entidades;

/**
 * NOME TEMPORADA é um conjunto de constante
 * ACRESCIMO é um adicional ao valor base de um apto. É uma constante 
 *
 */
public class Temporada {

	private String nomeTemporada;
	private int periodo;
	private String dataInicial;
	private Double acrescimo;

	public String getNomeTemporada() {
		return nomeTemporada;
	}

	public void setNomeTemporada(String nomeTemporada) {
		this.nomeTemporada = nomeTemporada;
	}

	public int getPeriodoEmDias() {
		return periodo;
	}

	public void setPeriodoEmDias(int periodo) {
		this.periodo = periodo;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

}
