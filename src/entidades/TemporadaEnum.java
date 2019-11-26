package entidades;

public enum TemporadaEnum {

	CARNAVAL(100), ANO_NOVO(100), SEMANA_SANTA(100), VERAO(50), INVERNO(0);

	private int acrescimo;

	private TemporadaEnum(int acrescimo) {
		this.acrescimo = acrescimo;
	}

	public int getAcrescimo() {
		return acrescimo;
	}
	
}
