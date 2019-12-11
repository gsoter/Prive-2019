package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Apartamento;
import entidades.TipoApartamentoEnum;
import util.ConexaoException;
import util.GerenciadorConexaoSqlite;
import util.IGerenciadorConexao;

public class DAOApartamento implements IDaoGeneric<Apartamento> {

	private final IGerenciadorConexao g = GerenciadorConexaoSqlite.getInstancia();
	private Connection c;

//	Modifica o valor booleano da disponibilidade do apto de acordo com a localidade deste (nº + bloco)
	@Override
	public void alterar(Apartamento ap) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "UPDATE Apartamento SET disponivel=? WHERE id_apto=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setBoolean(1, ap.isDisponivel());
			pst.setString(2, ap.getidApto());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

//	Retorna uma lista de apto
	@Override
	public ArrayList<Apartamento> listar() throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id_apto, tipo_apto, valor_base, disponivel FROM Apartamento";
		try {
			Statement st = c.createStatement();
			ResultSet r = st.executeQuery(sql);
			ArrayList<Apartamento> lista = new ArrayList<>();
			Apartamento ap;
			while (r.next()) {
				ap = new Apartamento();
				ap.setidApto(r.getString("id_apto"));
				ap.setTipoApto(TipoApartamentoEnum.valueOf(r.getString("tipo_apto")));
				ap.setValorBase(r.getDouble("valor_base"));
				ap.setDisponivel(r.getBoolean("disponivel"));
				lista.add(ap);
			}
			return lista;

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}

	}

	@Override
	public Apartamento consultar(String idApto) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id_apto, tipo_apto, valor_base, disponivel FROM Apartamento WHERE id_apto=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet r = pst.executeQuery();
			Apartamento ap = new Apartamento();
			if (r.next()) {
				ap.setidApto(r.getString("id_apto"));
				ap.setTipoApto(TipoApartamentoEnum.valueOf(r.getString("tipo_apto")));
				ap.setValorBase(r.getDouble("valor_base"));
				ap.setDisponivel(r.getBoolean("disponivel"));
			}
			return ap;
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public boolean inserir(Apartamento ap) throws DAOException, ConexaoException {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public void excluir(Integer id) throws DAOException, ConexaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public Apartamento consultar(Integer id) throws DAOException, ConexaoException {
		return null;
	}

}
