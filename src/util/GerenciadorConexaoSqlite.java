package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexaoSqlite implements IGerenciadorConexao {

	private static GerenciadorConexaoSqlite instancia;
	private final String uri;

	private GerenciadorConexaoSqlite() {
		this.uri = "jdbc:sqlite:F:/Documents/workspace/Prive-v2019/data/ReservaDB.db";
	}

	public static GerenciadorConexaoSqlite getInstancia() {
		if (instancia == null)
			instancia = new GerenciadorConexaoSqlite();
		return instancia;
	}

	@Override
	public Connection conectar() throws ConexaoException {
		try {
			Connection c = DriverManager.getConnection(uri);
			return c;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		}
	}

	@Override
	public void desconectar(Connection c) throws ConexaoException {
		try {
			c.close();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		}

	}

}