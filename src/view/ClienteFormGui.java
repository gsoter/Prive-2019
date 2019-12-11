package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

public class ClienteFormGui {

	protected Shell shell;
	private Text txtNome;
	private Text txtSobrenome;
	private Text txtCPF;
	private Text txtTelefone;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClienteFormGui window = new ClienteFormGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		shell.setSize(480, 406);
		shell.setText("Cadastro de Cliente");
		shell.setLayout(null);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 442, 347);

		Button btnSalvar = new Button(composite, SWT.PUSH);
		btnSalvar.setLocation(316, 301);
		btnSalvar.setSize(116, 36);
		btnSalvar.setText("Salvar");
		btnSalvar.addSelectionListener(new Salvar());

		Button btnLimpar = new Button(composite, SWT.PUSH);
		btnLimpar.setLocation(168, 301);
		btnLimpar.setSize(116, 36);
		btnLimpar.setText("Limpar");

		Button btnCancelar = new Button(composite, SWT.PUSH);
		btnCancelar.setLocation(10, 301);
		btnCancelar.setSize(116, 36);
		btnCancelar.setText("Cancelar");

		txtNome = new Text(composite, SWT.NONE);
		txtNome.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		txtNome.setLocation(132, 36);
		txtNome.setSize(300, 36);
		txtNome.addVerifyListener(ClienteFormGui::verificaLetrasApenas);

		txtSobrenome = new Text(composite, SWT.NONE);
		txtSobrenome.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		txtSobrenome.setBounds(132, 90, 300, 36);
		txtSobrenome.addVerifyListener(ClienteFormGui::verificaLetrasApenas);

		txtCPF = new Text(composite, SWT.NONE);
		txtCPF.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		txtCPF.setBounds(132, 143, 300, 36);
		txtCPF.addVerifyListener(ClienteFormGui::verificaDigitoApenas);

		txtTelefone = new Text(composite, SWT.NONE);
		txtTelefone.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		txtTelefone.setBounds(132, 196, 300, 36);
		txtCPF.addVerifyListener(ClienteFormGui::verificaDigitoApenas);

		Label lblNome = new Label(composite, SWT.CENTER);
		lblNome.setFont(SWTResourceManager.getFont("Trebuchet MS", 14, SWT.NORMAL));
		lblNome.setBounds(10, 36, 116, 36);
		lblNome.setText("Nome");

		Label lblSobrenome = new Label(composite, SWT.CENTER);
		lblSobrenome.setFont(SWTResourceManager.getFont("Trebuchet MS", 14, SWT.NORMAL));
		lblSobrenome.setText("Sobrenome");
		lblSobrenome.setBounds(10, 90, 116, 36);

		Label lblCPF = new Label(composite, SWT.CENTER);
		lblCPF.setFont(SWTResourceManager.getFont("Trebuchet MS", 14, SWT.NORMAL));
		lblCPF.setText("CPF");
		lblCPF.setBounds(10, 143, 116, 36);

		Label lblTelefone = new Label(composite, SWT.CENTER);
		lblTelefone.setFont(SWTResourceManager.getFont("Trebuchet MS", 14, SWT.NORMAL));
		lblTelefone.setText("Telefone");
		lblTelefone.setBounds(10, 196, 116, 36);

		Label lblMsg = new Label(composite, SWT.SHADOW_NONE | SWT.CENTER);
		lblMsg.setForeground(SWTResourceManager.getColor(199, 205, 209));
		lblMsg.setFont(SWTResourceManager.getFont("Trebuchet MS", 11, SWT.NORMAL));
		lblMsg.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblMsg.setBounds(10, 252, 422, 23);

	}

	private static void verificaLetrasApenas(VerifyEvent e) {
		String string = e.text;
		e.doit = string.matches("\\D*");
		return;
	}

	private static void verificaDigitoApenas(VerifyEvent e) {
		String string = e.text;
		e.doit = string.matches("\\d*");
		return;
	}

	class Salvar implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void widgetSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
