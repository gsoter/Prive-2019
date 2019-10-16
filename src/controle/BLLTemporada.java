package controle;

import java.util.ArrayList;

import entidades.Temporada;
import modelo.DAOException;
import modelo.DAOTemporada;
import util.ConexaoException;

public class BLLTemporada {

	private final DAOTemporada dao = new DAOTemporada();

	public void validarID(Temporada temp) throws ControlException {
		if (temp == null)
			throw new ControlException("ERRO: Temporada inválida");
		if (temp.getNomeTemporada().isEmpty() || temp.getNomeTemporada() == null)
			throw new ControlException("ERRO: Temporada inválida");
	}	

	public Temporada pesquisarTemporada(String temporada) throws ControlException {
		try {
			return dao.consultar(temporada);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Pesquisar temporada");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}	

	public void alterarTemporada(Temporada temp) throws ControlException {
		try {
			dao.alterar(temp);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Alterar temporada");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public ArrayList<Temporada> listarTemporadas() throws ControlException {
		try {
			return dao.listar();
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Listar temporada");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

}
