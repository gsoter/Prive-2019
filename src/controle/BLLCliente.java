package controle;

import java.util.ArrayList;

import entidades.Cliente;
import modelo.DAOCliente;
import modelo.DAOException;
import util.ConexaoException;

public class BLLCliente {

	private DAOCliente dao;

	public BLLCliente() {
		this.dao = new DAOCliente();
	}

	public boolean inserir(Cliente cliente) throws ControlException, DAOException, ConexaoException {
		if (verificarDuplicidade(cliente.getCpf())) {
			return false;
		}
		return dao.inserir(cliente);
	}

	public Cliente pesquisar(int id) throws ControlException {
		try {
			return dao.consultar(id);

		} catch (ConexaoException e) {
			throw new ControlException("Erro: Conex�o com BD inv�lida");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}

	}

	public Cliente pesquisar(String cpf) throws ControlException {
		try {
			return dao.consultar(cpf);
		} catch (ConexaoException e) {
			throw new ControlException("Erro: Conex�o com BD inv�lida");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public void alterar(Cliente cliente) throws ControlException {
		try {
			dao.alterar(cliente);

		} catch (ConexaoException e) {
			throw new ControlException("Erro: Conex�o com BD inv�lida");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public void excluir(Cliente cliente) throws ControlException {
		try {
			dao.excluir(Integer.parseInt(cliente.getIdCliente()));

		} catch (ConexaoException e) {
			throw new ControlException("Erro: Conex�o com BD inv�lida");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public ArrayList<Cliente> listar() throws ControlException {
		try {
			return dao.listar();

		} catch (ConexaoException e) {
			throw new ControlException("Erro: Conex�o com BD inv�lida");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}

	}

	/*
	 * Cliente v�lido: Nome/Sobrenome - Escrita correta, sem n�meros Campos
	 * preenchidos(NOT NULL), CPF correto (Apenas n�meros, sem espa�o vazio, NOT
	 * NULL) telefone correto(NOT NULL, sem vazio, s� n�meros)
	 */

	public void validarID(Cliente cliente) throws ControlException {
		if (cliente == null)
			throw new ControlException("Erro: Cliente inv�lido");

		if (cliente.getIdCliente() == null || cliente.getIdCliente().isEmpty())
			throw new ControlException("Erro: Cliente inv�lido");
	}

	public boolean verificarDuplicidade(String cpf) throws ControlException {
		try {
			pesquisar(cpf).getCpf().contains(cpf);
		} catch (Exception e) {
			throw new ControlException(e.getMessage());
		}
		return false;
	}

	public void validarEntrada(Cliente cliente) throws ControlException {
		if (cliente == null)
			throw new ControlException("Erro: Cliente inv�lido");

		if (cliente.getNome() == null || cliente.getNome().isEmpty() || cliente.getNome().trim().length() < 2
				|| temNumeros(cliente.getNome()))
			throw new ControlException("Erro: Nome inv�lido");

		if (cliente.getSobrenome() == null || cliente.getSobrenome().isEmpty()
				|| cliente.getSobrenome().trim().length() < 2 || temNumeros(cliente.getSobrenome()))
			throw new ControlException("Erro: Sobrenome inv�lido");

		if (cliente.getCpf() == null || cliente.getCpf().isEmpty() || cliente.getSobrenome().trim().length() < 2
				|| temLetras(cliente.getCpf()))
			throw new ControlException("Erro: CPF inv�lido");
	}

	public void validarAlteracao(Cliente cliente) throws ControlException {
		if (cliente == null)
			throw new ControlException("Erro: Cliente inv�lido");

		if (cliente.getNome() == null || cliente.getNome().isEmpty() || cliente.getNome().trim().length() < 2
				|| temNumeros(cliente.getNome()))
			throw new ControlException("Erro: Nome inv�lido");

		if (cliente.getSobrenome() == null || cliente.getSobrenome().isEmpty()
				|| cliente.getSobrenome().trim().length() < 2 || temNumeros(cliente.getSobrenome()))
			throw new ControlException("Erro: Sobrenome inv�lido");

		if (cliente.getCpf() == null || cliente.getCpf().isEmpty() || cliente.getSobrenome().trim().length() < 2
				|| temLetras(cliente.getCpf()))
			throw new ControlException("Erro: CPF inv�lido");

		if (pesquisar(cliente.getIdCliente()) == null) {
			throw new ControlException("Erro: ID n�o encontrada");
		}

	}

	public boolean temLetras(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				return true;
		}
		return false;
	}

	public boolean temNumeros(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)))
				return true;
		}
		return false;
	}
}
