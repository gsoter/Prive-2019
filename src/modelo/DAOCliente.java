package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Cliente;
import util.ConexaoException;
import util.GerenciadorConexaoSqlite;
import util.IGerenciadorConexao;

public class DAOCliente implements IDaoGeneric<Cliente> {

	private final IGerenciadorConexao g = GerenciadorConexaoSqlite.getInstancia();
	private Connection c;

	@Override
	public void inserir(Cliente cliente) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "INSERT INTO Cliente (id, nome, sobrenome, cpf, telefone) VALUES (?,?,?,?,?)";
	
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, cliente.getIdCliente());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getSobrenome());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());
			pst.executeUpdate();
	
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	
	}

	@Override
	public void alterar(Cliente cliente) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "UPDATE Cliente SET nome=?, sobrenome=?, cpf=?, telefone=? WHERE id=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getSobrenome());
			pst.setString(3, cliente.getCpf());
			pst.setString(4, cliente.getTelefone());
			pst.setString(5, cliente.getIdCliente());
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
		String sql = "DELETE FROM CLiente WHERE id=?";
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
	public Cliente consultar(String cpf) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id, nome, sobrenome, cpf, telefone FROM Cliente WHERE cpf=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet result = pst.executeQuery();
			Cliente cliente = null;
			if (result.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(result.getString("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setSobrenome(result.getString("sobrenome"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setTelefone(result.getString("telefone"));
			}
			return cliente;

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public Cliente consultar(Integer id) throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id, nome, sobrenome, cpf, telefone FROM Cliente WHERE id=?";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet result = pst.executeQuery();
			Cliente cliente = null;
			if (result.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(result.getString("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setSobrenome(result.getString("sobrenome"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setTelefone(result.getString("telefone"));
			}
			return cliente;

		} catch (SQLException e) {
			throw new DAOException(e);

		} finally {
			g.desconectar(c);
		}
	}

	@Override
	public ArrayList<Cliente> listar() throws DAOException, ConexaoException {
		c = g.conectar();
		String sql = "SELECT id, nome, sobrenome, cpf, telefone FROM Cliente";
		try {
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(sql);
			ArrayList<Cliente> lista = new ArrayList<>();
			Cliente cliente;
			while (result.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(result.getString("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setSobrenome(result.getString("sobrenome"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setTelefone(result.getString("telefone"));
				lista.add(cliente);
			}
			return lista;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			g.desconectar(c);
		}

	}

}
