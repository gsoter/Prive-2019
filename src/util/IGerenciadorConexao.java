package util;

import java.sql.Connection;

public interface IGerenciadorConexao{
	
	public Connection conectar() throws ConexaoException;
	
	public void desconectar(Connection c) throws ConexaoException;

}
