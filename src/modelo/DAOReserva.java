package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Apartamento;
import entidades.Cliente;
import entidades.Reserva;
import entidades.TemporadaEnum;
import entidades.TipoApartamentoEnum;
import util.ConexaoException;
import util.GerenciadorConexaoSqlite;
import util.IGerenciadorConexao;

public class DAOReserva implements IDaoGeneric<Reserva> {

	private final IGerenciadorConexao g = GerenciadorConexaoSqlite.getInstancia();
	private Connection c;

	@Override
	public boolean inserir(Reserva r) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "INSERT INTO Reserva (id_cliente, id_apto, id_temp, qtd_hospedes, cama_extra, dt_entrada, dt_saida, dt_abertura, valor_total, valor_add) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, r.getCliente().getIdCliente());
			pst.setString(2, r.getApto().toString());
			pst.setString(3, r.getTemporada().toString());
			pst.setInt(4, r.getnHospedes());
			pst.setInt(5, r.getnCamaExtra());
			pst.setString(6, r.getDataEntrada());
			pst.setString(7, r.getDataSaida());
			pst.setString(7, r.getDataAberturaConta());
			pst.setDouble(8, r.getValorTotal());
			pst.setDouble(9, r.getValorAdicional());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
		return false;

	}

	@Override
	public void alterar(Reserva r) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "UPDATE Reserva SET id_cliente=?, id_apto=?, id_temp=?, qtd_hospedes=?, cama_extra=?, dt_entrada=?, dt_saida=?, dt_abertura=?, valor_total=?, valor_add=? WHERE id=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, r.getCliente().getIdCliente());
			pst.setString(2, r.getApto().name());
			pst.setString(3, r.getTemporada().name());
			pst.setInt(4, r.getnHospedes());
			pst.setInt(5, r.getnCamaExtra());
			pst.setString(6, r.getDataEntrada());
			pst.setString(7, r.getDataSaida());
			pst.setString(8, r.getDataAberturaConta());
			pst.setDouble(9, r.getValorTotal());
			pst.setDouble(10, r.getValorAdicional());
			pst.setInt(11, r.getIdReserva());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}

	}

	@Override
	public void excluir(Integer id) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "DELETE FROM Reserva WHERE id=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}

	}

	@Override
	public Reserva consultar(String dataEntrada) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id_cliente, id_apto, id_temp, qtd_hospedes, cama_extra, dt_entrada, dt_saida, dt_abertura, valor_total, valor_add FROM Reserva WHERE dt_entrada=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, dataEntrada);
			ResultSet result = pst.executeQuery();
			Reserva reserva = null;
			Cliente cliente = new Cliente();
			Apartamento apto = new Apartamento();
			if (result.next()) {
				reserva = new Reserva();
				cliente.setIdCliente(result.getString("id_cliente"));
				apto.setidApto(result.getString("id_apto"));
				reserva.setCliente(cliente);
				reserva.setTemporada(TemporadaEnum.valueOf(result.getString("id_temp")));
				reserva.setnHospedes(result.getInt("qtd_hospedes"));
				reserva.setnCamaExtra(result.getInt("cama_extra"));
				reserva.setDataEntrada(result.getString("dt_entrada"));
				reserva.setDataSaida(result.getString("dt_saida"));
				reserva.setDataAberturaConta(result.getString("dt_abertura"));
				reserva.setValorTotal(result.getDouble("valor_total"));
				reserva.setValorAdicional(result.getDouble("valor_add"));
			}
			return null;

		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public Reserva consultar(Integer id) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id, id_cliente, id_apto, id_temp, qtd_hospedes, cama_extra, dt_entrada, dt_saida, dt_abertura, valor_total, valor_add FROM Reserva WHERE id=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet result = pst.executeQuery();
			Reserva reserva = null;
			Cliente cliente = new Cliente();
			Apartamento apto = new Apartamento();
			if (result.next()) {
				reserva = new Reserva();
				reserva.setIdReserva(result.getInt("id"));
				cliente.setIdCliente(result.getString("id_cliente"));
				apto.setidApto(result.getString("id_apto"));
				reserva.setCliente(cliente);
				reserva.setApto(TipoApartamentoEnum.valueOf(result.getString("apto")));
				reserva.setTemporada(TemporadaEnum.valueOf(result.getString("id_temp")));
				reserva.setnHospedes(result.getInt("qtd_hospedes"));
				reserva.setnCamaExtra(result.getInt("cama_extra"));
				reserva.setDataEntrada(result.getString("dt_entrada"));
				reserva.setDataSaida(result.getString("dt_saida"));
				reserva.setDataAberturaConta(result.getString("dt_abertura"));
				reserva.setValorTotal(result.getDouble("valor_total"));
				reserva.setValorAdicional(result.getDouble("valor_add"));
			}
			return reserva;

		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public ArrayList<Reserva> listar() throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT * FROM Reserva";
		try {
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(sql);
			ArrayList<Reserva> lista = new ArrayList<>();
			Reserva res = new Reserva();
			Cliente cli = new Cliente();
			while (result.next()) {
				cli.setIdCliente(result.getString("id_cliente"));
				res.setIdReserva(result.getInt("id"));
				res.setDataEntrada(result.getString("dt_entrada"));
				res.setDataSaida(result.getString("dt_saida"));
				res.setDataAberturaConta(result.getString("dt_abertura"));
				res.setValorAdicional(result.getDouble("valor_add"));
				res.setValorTotal(result.getDouble("valor_total"));
				res.setApto(TipoApartamentoEnum.valueOf(result.getString("id_apto")));
				res.setCliente(cli);
				res.setTemporada(TemporadaEnum.valueOf(result.getString("id_temp")));
				lista.add(res);
			}
			return lista;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}

	}

}
