package modelo;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException() {
		super();
	}

	public DAOException(String e) {
		super(e);
	}

	public DAOException(Exception e) {
		super(e);
	}
}
