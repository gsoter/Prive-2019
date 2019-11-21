package entidades;

/**
 * NOME TEMPORADA é um conjunto de constante ACRESCIMO é um adicional ao valor
 * base de um apto. É uma constante
 *
 */
public class Temporada {

	private String nomeTemporada;
	private String dataInicial;
	private String dataFinal;
	private int acrescimo;

	public Temporada() {

	}

	public Temporada(String nomeTemporada, String dataInicial, String dataFinal, int acrescimo) {
		super();
		this.nomeTemporada = nomeTemporada;
		this.dataFinal = dataFinal;
		this.dataInicial = dataInicial;
		this.acrescimo = acrescimo;
	}

	public String getNomeTemporada() {
		return nomeTemporada;
	}

	public void setNomeTemporada(String nomeTemporada) {
		this.nomeTemporada = nomeTemporada;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String periodo) {
		this.dataFinal = periodo;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(int acrescimo) {
		this.acrescimo = acrescimo;
	}

}
