package entidades;

public class Apartamento {

	private String idApto;
	private boolean disponivel;
	private Double valorBase;
	private int maxHospedes;

	private final String[] NUMAPTO = { "101.1", "102.1", "103.1", "104.1", "201.1", "202.1", "203.1", "204.1", "101.2",
			"102.2", "103.2", "104.2", "201.2", "202.2", "203.2", "204.2" };

	public String[] getNUMAPTO() {
		return NUMAPTO;
	}

	public String getidApto() {
		return idApto;
	}

	public void setidApto(String idApto) {
		this.idApto = idApto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase(Double valorBase) {
		this.valorBase = valorBase;
	}

	public int getMaxHospedes() {
		return maxHospedes;
	}

	public void setMaxHospedes(int maxHospedes) {
		this.maxHospedes = maxHospedes;
	}

}
