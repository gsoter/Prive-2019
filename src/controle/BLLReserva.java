package controle;

import java.util.ArrayList;

import entidades.Reserva;
import modelo.DAOException;
import modelo.DAOReserva;
import util.ConexaoException;

public class BLLReserva {

	private final DAOReserva dao = new DAOReserva();

	public void validarInserir(Reserva res) throws ControlException {
		if (res == null)
			throw new ControlException("ERRO: Reserva inválida");
//		Verifica Reserva.Apartamento
		if (res.getApto() == null || res.getApto().getidApto() == null || res.getApto().getidApto().isEmpty())
			throw new ControlException("ERRO: Reserva-Apto inválido");
//		Verifica Reserva.Cliente
		if (res.getCliente() == null || res.getCliente().getIdCliente() == null || res.getCliente().getCpf() == null
				|| res.getCliente().getCpf().isEmpty())
			throw new ControlException("ERRO: Reserva-Cliente inválido");
//		Verifica Reserva-Datas
		if (res.getDataEntrada() == null || res.getDataEntrada().isEmpty() || res.getDataSaida() == null
				|| res.getDataSaida().isEmpty())
			throw new ControlException("ERRO: Reserva-Data de Entrada/Saída inválidas");
//		Verifica Reserva-Temporada
		if (res.getTemporada() == null || res.getTemporada().getNomeTemporada() == null
				|| res.getTemporada().getNomeTemporada().equals(null))
			throw new ControlException("ERRO: Reserva-Temporada inválida");
	}

	public void verificarDuplicidade(String id) throws ControlException {
		if (!(pesquisarReserva(id) == null))
			throw new ControlException("ERRO: Reserva existente");
	}

	public void verificarAlteracao(Reserva res) throws ControlException {
		if (res == null)
			throw new ControlException("ERRO: Reserva inválida");
		if (res.getApto() == null || res.getApto().getidApto() == null || res.getApto().getidApto().isEmpty())
			throw new ControlException("ERRO: Reserva-Apto inválido");
//		Verifica Reserva.Cliente
		if (res.getCliente() == null || res.getCliente().getIdCliente() == null || res.getCliente().getCpf() == null
				|| res.getCliente().getCpf().isEmpty())
			throw new ControlException("ERRO: Reserva-Cliente inválido");
//		Verifica Reserva-Datas
		if (res.getDataEntrada() == null || res.getDataEntrada().isEmpty() || res.getDataSaida() == null
				|| res.getDataSaida().isEmpty())
			throw new ControlException("ERRO: Reserva-Data de Entrada/Saída inválidas");
//		Verifica Reserva-Temporada
		if (res.getTemporada() == null || res.getTemporada().getNomeTemporada() == null
				|| res.getTemporada().getNomeTemporada().equals(null))
			throw new ControlException("ERRO: Reserva-Temporada inválida");
	}

	public void inserirReserva(Reserva res) throws ControlException {
		try {
			dao.inserir(res);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reserva inserida inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public void alterarReserva(Reserva res) throws ControlException {
		try {
			dao.alterar(res);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reserva alterada inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public void excluirReserva(Reserva res) throws ControlException {
		try {
			dao.excluir(res.getIdReserva());
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reserva a excluir inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public Reserva pesquisarReserva(String id) throws ControlException {
		try {
			return dao.consultar(id);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reserva a consultar inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public Reserva pesquisarReservaData(String dataEntrada) throws ControlException {
		try {
			return dao.consultar(dataEntrada);
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reserva a consultar inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}
	}

	public ArrayList<Reserva> listarReservas() throws ControlException {
		try {
			return dao.listar();
		} catch (ConexaoException e) {
			throw new ControlException("ERRO: Reservas a listar inválida");
		} catch (DAOException e) {
			throw new ControlException("ERRO: DAO");
		}

	}

}
