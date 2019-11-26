package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Temporada;
import entidades.TemporadaEnum;
import util.ConexaoException;
import util.GerenciadorConexaoSqlite;
import util.IGerenciadorConexao;

public class DAOTemporada implements IDaoGeneric<Temporada> {
	private Connection c;
	private final IGerenciadorConexao g = GerenciadorConexaoSqlite.getInstancia();

	@Override
	public void alterar(Temporada temp) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "UPDATE Temporada SET temporada, dt_inicial, dt_final";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, temp.getNomeTemporada().name());
			pst.setString(4, temp.getDataInicial());
			pst.setString(2, temp.getDataFinal());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public ArrayList<Temporada> listar() throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT * FROM Temporada";
		try {
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(sql);
			ArrayList<Temporada> lista = new ArrayList<>();
			Temporada temp = null;
			while (result.next()) {
				temp = new Temporada();
				temp.setNomeTemporada(TemporadaEnum.valueOf(result.getString("temporada")));
				temp.setDataInicial(result.getString("dt_inicial"));
				temp.setDataFinal(result.getString("dt_final"));
				lista.add(temp);
			}
			return lista;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public Temporada consultar(String nomeTemporada) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT temporada, dt_inicial, dt_final, acrescimo  FROM Temporada WHERE temporada=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, nomeTemporada);
			ResultSet result = pst.executeQuery();
			Temporada t = null;
			if (result.next()) {
				t = new Temporada();
				t.setNomeTemporada(TemporadaEnum.valueOf(result.getString("temporada")));
				t.setDataInicial(result.getString("dt_inicial"));
				t.setDataFinal(result.getString("dt_final"));

			}
			return t;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public Temporada consultar(Integer id) throws DAOException, ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer id) throws DAOException, ConexaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserir(Temporada temp) throws DAOException, ConexaoException {
		// TODO Auto-generated method stub

	}

}
