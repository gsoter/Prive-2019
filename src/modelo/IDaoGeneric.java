package modelo;

import java.util.ArrayList;

import util.ConexaoException;

public interface IDaoGeneric<T> {

	public boolean inserir(T o) throws DAOException, ConexaoException;

	public void alterar(T o) throws DAOException, ConexaoException;

	public void excluir(Integer id) throws DAOException, ConexaoException;

	public T consultar(String s) throws DAOException, ConexaoException;

	public T consultar(Integer id) throws DAOException, ConexaoException;

	public ArrayList<T> listar() throws DAOException, ConexaoException;
}
