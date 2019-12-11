package facade;

import java.util.ArrayList;

import controle.BLLApartamento;
import controle.BLLCliente;
import controle.BLLReserva;
import controle.BLLTemporada;
import controle.ControlException;
import entidades.Apartamento;
import entidades.Cliente;
import entidades.Reserva;
import entidades.Temporada;
import modelo.DAOException;
import util.ConexaoException;

public class Facade {

	private static Facade instancia;
	private BLLCliente CLIENTE = new BLLCliente();
	private BLLApartamento APTO = new BLLApartamento();;
	private BLLReserva RESERVA = new BLLReserva();;
	private BLLTemporada TEMP = new BLLTemporada();;

	public static Facade getInstancia() throws Exception {
		if (instancia == null)
			instancia = new Facade();
		return instancia;
	}

	// Bloco Cliente

	public void inserirCliente(Cliente cliente) throws ControlException, DAOException, ConexaoException {
		CLIENTE.validarEntrada(cliente);
		CLIENTE.inserir(cliente);
	}

	public void alterarCliente(Cliente cliente) throws ControlException {
		CLIENTE.pesquisar(cliente.getIdCliente());
		CLIENTE.validarAlteracao(cliente);
		CLIENTE.alterar(cliente);
	}

	public void excluirCliente(Cliente cliente) throws ControlException {
		CLIENTE.validarID(cliente);
		CLIENTE.excluir(cliente);
	}

	public ArrayList<Cliente> listarCliente() throws ControlException {
		return CLIENTE.listar();
	}

	public Cliente pesquisarCliente(Cliente cliente) throws ControlException {
		CLIENTE.validarID(cliente);
		return CLIENTE.pesquisar(cliente.getIdCliente());
	}

	// Bloco Apto

	public void alterarApto(Apartamento apto) throws ControlException {
		APTO.validarID(apto);
		APTO.validarAlteracao(apto);
		APTO.alterar(apto);
	}

	public Apartamento pesquisarApto(Apartamento apto) throws ControlException {
		APTO.validarID(apto);
		return pesquisarApto(apto);
	}

	public ArrayList<Apartamento> listarApto() throws ControlException {
		return APTO.listar();
	}

	public ArrayList<Apartamento> listarDisponivel() throws ControlException {
		return APTO.listarDisponivel();
	}

	// Bloco Reserva

	public Reserva pesquisarReserva(String id) throws ControlException {
		return RESERVA.pesquisarReserva(id);
	}

	public Reserva pesquisarData(String dataEntrada) throws ControlException {
		return RESERVA.pesquisarReservaData(dataEntrada);
	}

	public void salvarReserva(Reserva res) throws ControlException {
		RESERVA.validarInserir(res);
		RESERVA.inserirReserva(res);
	}

	public void alterarReserva(Reserva res) throws ControlException {
		RESERVA.verificarAlteracao(res);
		RESERVA.alterarReserva(res);
	}

	public void excluirReserva(Reserva res) throws ControlException {
		RESERVA.verificarAlteracao(res);
		RESERVA.excluirReserva(res);
	}

	public ArrayList<Reserva> listarReserva() throws ControlException {
		return RESERVA.listarReservas();
	}

	// Bloco Temporada

	public Temporada pesquisarTemporada(String temporada) throws ControlException {
		return TEMP.pesquisarTemporada(temporada);
	}

	public void alterarTemporada(Temporada temporada) throws ControlException {
		TEMP.validarID(temporada);
		TEMP.alterarTemporada(temporada);
	}

	public ArrayList<Temporada> listarTemporada() throws ControlException {
		return TEMP.listarTemporadas();
	}
}
