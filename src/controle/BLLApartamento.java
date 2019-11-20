package controle;

import java.util.ArrayList;

import entidades.Apartamento;
import modelo.DAOApartamento;
import modelo.DAOException;
import modelo.IDaoGeneric;
import util.ConexaoException;

public class BLLApartamento {

	private final IDaoGeneric<Apartamento> dao;

	public BLLApartamento() {

		dao = new DAOApartamento();
	}

	public void validarID(Apartamento apto) throws ControlException {
		if (apto == null)
			throw new ControlException("Erro: Apartamento inv�lido");

		if (apto.getidApto() == null)
			throw new ControlException("Erro: Apartamento inv�lido");

		for (String numApto : Apartamento.getNUMAPTO()) {
			if (apto.getidApto() != numApto)
				throw new ControlException("Erro: N�mero de Apartamento inv�lido");
		}
	}

	public void validarAlteracao(Apartamento apto) throws ControlException {
		if (apto == null)
			throw new ControlException("Erro: Apartamento inv�lido");

		if (apto.getValorBase() == null || apto.getValorBase() <= 0)
			throw new ControlException("Erro: Apartamento inv�lido");

		if (apto.getidApto() == null || apto.getidApto().isEmpty()) {
			throw new ControlException("Erro: Apartamento inv�lido");
		}
	}

	public void alterar(Apartamento apto) throws ControlException {
		try {
			dao.alterar(apto);
			
		} catch (ConexaoException e) {
			throw new ControlException("Erro: N�o foi poss�vel estabelecer conex�o com BD");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public ArrayList<Apartamento> listar() throws ControlException {
		try {
			return dao.listar();

		} catch (ConexaoException e) {
			throw new ControlException("Erro: N�o foi poss�vel estabelecer conex�o com BD");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public ArrayList<Apartamento> listarDisponivel() throws ControlException {
		try {
			ArrayList<Apartamento> lista = new ArrayList<>();
			for (Apartamento apto : dao.listar())
				if (apto.isDisponivel() == true)
					lista.add(apto);

			return lista;
		} catch (ConexaoException e) {
			throw new ControlException("Erro: N�o foi poss�vel estabelecer conex�o com BD");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

	public Apartamento pesquisar(String idApto) throws ControlException {
		try {
			return dao.consultar(idApto);

		} catch (ConexaoException e) {
			throw new ControlException("Erro: N�o foi poss�vel estabelecer conex�o com BD");

		} catch (DAOException e) {
			throw new ControlException("Erro: DAO");
		}
	}

}
