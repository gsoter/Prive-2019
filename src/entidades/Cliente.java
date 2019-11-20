package entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (!(nome == null))
			if (!numFinder(nome))
				this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		if (!(sobrenome == null))
			if (!numFinder(sobrenome))
				this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (!(cpf == null))
			if (!letterFinder(cpf))
				this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (!(telefone == null))
			this.telefone = telefone;
	}

	public boolean numFinder(String s) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		return m.find();
	}

	public boolean letterFinder(String s) {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(s);
		return m.find();
	}
}
