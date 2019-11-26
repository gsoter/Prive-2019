package entidades;

import java.text.SimpleDateFormat;

/**
 * NOME TEMPORADA é um conjunto de constante. ACRESCIMO é um adicional ao valor
 * base de um apto. Adicionar a regra de negócio.
 *
 */
public class Temporada {

	private TemporadaEnum nomeTemporada;
	private String dataInicial;
	private String dataFinal;

	public Temporada() {
	}

	public Temporada(TemporadaEnum nomeTemporada, String dataInicial, String dataFinal) {
		super();
		this.nomeTemporada = nomeTemporada;
		this.dataFinal = dataFinal;
		this.dataInicial = dataInicial;
	}

	public TemporadaEnum getNomeTemporada() {
		return nomeTemporada;
	}

	public void setNomeTemporada(TemporadaEnum nomeTemporada) {
		if (!(nomeTemporada == null))
			this.nomeTemporada = nomeTemporada;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		if (!(dataFinal == null))
			this.dataFinal = formatData(dataFinal.replaceAll("[^0-9]", ""));
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		if (!(dataInicial == null))
			this.dataInicial = formatData(dataInicial.replaceAll("[^0-9]", ""));
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
