package entidades;

public class Cliente {

	private String idCliente;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String telefone;

	public Cliente() {
		
	}
	
	public Cliente(String idCliente, String nome, String sobrenome, String cpf, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getClass().getName() + " " + "id:" + " " + getIdCliente() + " " + "nome:" + " " + getNome() + " "
				+ getSobrenome();
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		
		this.telefone = telefone;		
	}

}
