package controle;

@SuppressWarnings("serial")
public class ControlException extends Exception {

	public ControlException() {
		super();
	}

	public ControlException(String msg) {
		super(msg);
	}

	public ControlException(Exception e) {
		super(e);

	}
}
