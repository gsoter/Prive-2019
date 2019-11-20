package entidades;

/**
 * IDAPTO = NUMAPTO
 * 
 * VALOR BASE depende do apto. (apto 01 a 08 = 70; apto 09 a 16 = 90)
 * 
 * MAX HOSPEDES é um valor constante (apto.1 = 3; apto.2 = 6)
 * 
 * DISPONIVEL qdo ao procurar determinada data entrada X saída e não encontrar
 * reservas registradas
 * 
 */
public class Apartamento {

	private String idApto;
	private boolean disponivel;
	private Double valorBase;
	private TipoApartamentoEnum tipoApto;

	public Apartamento() {

	}

	public Apartamento(String numApto, boolean disponivel, Double valorBase, TipoApartamentoEnum tipo) {
		super();
		this.idApto = numApto;
		this.disponivel = disponivel;
		this.valorBase = valorBase;
		this.setTipoApto(tipo);
	}

	private final static String[] NUMAPTO = { "01", "02", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12",
			"13", "14", "15", "16" };

	public String getidApto() {
		return idApto;
	}

	public void setidApto(String idApto) {
		if (!(idApto == null))
			for (String aptoNum : getNUMAPTO())
				if (idApto == aptoNum)
					this.idApto = idApto;
				else
					idApto = "01";
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
		if (!(valorBase == null))
			this.valorBase = valorBase;
	}

	public static String[] getNUMAPTO() {
		return NUMAPTO;
	}

	public TipoApartamentoEnum getTipoApto() {
		return tipoApto;
	}

	public void setTipoApto(TipoApartamentoEnum tipoApto) {
		this.tipoApto = tipoApto;
	}

}
