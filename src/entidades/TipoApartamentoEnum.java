package entidades;

public enum TipoApartamentoEnum {

	PEQUENO(3), 
	GRANDE(6);

	private int maxHospedes;

	private TipoApartamentoEnum(int maxHospedes) {
		this.maxHospedes = maxHospedes;
	}

	public int getMaxHospedes() {
		return maxHospedes;
	}
	
}
