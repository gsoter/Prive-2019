package entidades;

public enum TemporadaEnum {

	CARNAVAL(100, "29/02/2020", "04/03/2020"), ANO_NOVO(100, "30/12/2020", "03/01/2021"),
	SEMANA_SANTA(100, "05/04/2020", "11/04/2020"), VERAO(50, "01/01/2020", "31/05/2020"),
	INVERNO(0, "01/06/2020", "30/10/2020");

	private int acrescimo;
	private String dataInicio;
	private String dataFim;

	private TemporadaEnum(int acrescimo, String dataInicio, String dataFim) {
		this.acrescimo = acrescimo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getAcrescimo() {
		return acrescimo;
	}

	public String getInicio() {
		return dataInicio;
	}

	public String getFim() {
		return dataFim;
	}

}
