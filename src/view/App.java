package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import entidades.Cliente;
import facade.Facade;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class App {

	protected Shell shell;
	private Text txt_cpf;
	private Text txt_telefone;
	private Text txt_nome;
	private Text txt_sobrenome;
	private Table tbl_cliente;
	private Text txt_id;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
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
		shell.setSize(720, 480);
		shell.setText("Gerenciador de Reservas");
		shell.setLayout(new FillLayout());

		TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

		TabItem tabReserva = new TabItem(tabFolder, SWT.BORDER);
		tabReserva.setText("Reservas");

		TabItem tabCliente = new TabItem(tabFolder, SWT.NONE);
		tabCliente.setText("Clientes");

		Composite composite = new Composite(tabFolder, SWT.BORDER);

		tabCliente.setControl(composite);
		GridLayout gl_composite = new GridLayout(2, true);
		gl_composite.marginHeight = 10;
		gl_composite.marginWidth = 10;
		gl_composite.marginRight = 10;
		gl_composite.marginLeft = 10;
		composite.setLayout(gl_composite);

		Label lblId = new Label(composite, SWT.NONE);
		lblId.setText("ID:");
		new Label(composite, SWT.NONE);

		txt_id = new Text(composite, SWT.BORDER);
		GridData gd_txt_id = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txt_id.widthHint = 54;
		txt_id.setLayoutData(gd_txt_id);
		new Label(composite, SWT.NONE);

		Label lblNome = new Label(composite, SWT.NONE);
		lblNome.setText("Nome:");

		Label lblCpf = new Label(composite, SWT.NONE);
		lblCpf.setText("CPF:");

		txt_nome = new Text(composite, SWT.BORDER);
		GridData gd_txt_nome = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txt_nome.widthHint = 248;
		txt_nome.setLayoutData(gd_txt_nome);

		txt_cpf = new Text(composite, SWT.BORDER);
		GridData gd_txt_cpf = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_txt_cpf.widthHint = 201;
		txt_cpf.setLayoutData(gd_txt_cpf);

		Label lblSobrenome = new Label(composite, SWT.NONE);
		lblSobrenome.setText("Sobrenome:");

		Label lblTelefone = new Label(composite, SWT.NONE);
		lblTelefone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblTelefone.setText("Telefone:");

		txt_sobrenome = new Text(composite, SWT.BORDER);
		GridData gd_txt_sobrenome = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txt_sobrenome.widthHint = 261;
		txt_sobrenome.setLayoutData(gd_txt_sobrenome);

		txt_telefone = new Text(composite, SWT.BORDER);
		GridData gd_txt_telefone = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txt_telefone.widthHint = 199;
		txt_telefone.setLayoutData(gd_txt_telefone);

		Button btnSalvarAlteracao = new Button(composite, SWT.NONE);
		btnSalvarAlteracao.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnSalvarAlteracao.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox msg = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				Facade facade = Facade.getInstancia();
				Cliente cliente = new Cliente();
				try {
					cliente.setNome(txt_nome.getText());
					cliente.setCpf(txt_cpf.getText());
					cliente.setSobrenome(txt_sobrenome.getText());
					cliente.setTelefone(txt_telefone.getText());

					facade.alterarCliente(cliente);

					msg.setMessage("Alterado com Sucesso!");
					msg.open();
				} catch (Exception e2) {
					msg.setMessage("Erro: Verifique se os campos estão preenchidos " + e2.getMessage());
					msg.open();
				}
			}
		});
		btnSalvarAlteracao.setText("Salvar Altera\u00E7\u00E3o");

		Button btnNovoCliente = new Button(composite, SWT.NONE);
		btnNovoCliente.setText("Novo Cliente");

		Button btnLimpar = new Button(composite, SWT.NONE);
		btnLimpar.setText("Limpar");

		Button btnExcluir = new Button(composite, SWT.NONE);
		btnExcluir.setText("Excluir");
		new Label(composite, SWT.NONE);

		Button btnAtualizar = new Button(composite, SWT.NONE);
		btnAtualizar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox msg = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				Facade facade = Facade.getInstancia();
				try {
					for (Cliente c : facade.listarCliente()) {
						TableItem item = new TableItem(tbl_cliente, SWT.NONE);
						item.setText(0, c.getIdCliente().toString());
						item.setText(1, c.getNome());
						item.setText(2, c.getSobrenome());
						item.setText(3, c.getCpf());
						item.setText(4, c.getTelefone().toString());

						msg.setMessage("Pronto!");
						msg.open();
					}

				} catch (Exception e2) {
					msg.setMessage("Erro: Verifique a listagem e tente novamente! " + e2.getMessage());
					msg.open();
				}
			}
		});
		btnAtualizar.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		btnAtualizar.setText("Atualizar");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		TableViewer viewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tbl_cliente = viewer.getTable();
		tbl_cliente.setHeaderVisible(true);

		GridData gd_tbl_cliente = new GridData(SWT.CENTER, SWT.FILL, true, true, 2, 1);
		gd_tbl_cliente.widthHint = 553;
		tbl_cliente.setLayoutData(gd_tbl_cliente);
		tbl_cliente.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event e) {
				Table table = (Table) e.widget;
				TableItem item = table.getItem(table.getSelectionIndex());

				for (int col = 0; col < table.getColumnCount(); col++) {
					if (col == 0)
						txt_id.setText(item.getText(col));

					else if (col == 1)
						txt_nome.setText(item.getText(col));

					else if (col == 2)
						txt_sobrenome.setText(item.getText(col));

					else if (col == 3)
						txt_cpf.setText(item.getText(col));

					else if (col == 4)
						txt_telefone.setText(item.getText(col));
				}
			}
		});

		TableColumn tblclmnId = new TableColumn(tbl_cliente, SWT.LEFT);
		tblclmnId.setResizable(false);
		tblclmnId.setWidth(65);
		tblclmnId.setText("ID");

		TableColumn tblclmnNome = new TableColumn(tbl_cliente, SWT.NONE);
		tblclmnNome.setWidth(130);
		tblclmnNome.setText("Nome");

		TableColumn tblclmnSobrenome = new TableColumn(tbl_cliente, SWT.NONE);
		tblclmnSobrenome.setResizable(false);
		tblclmnSobrenome.setWidth(140);
		tblclmnSobrenome.setText("Sobrenome");

		TableColumn tblclmnCpf = new TableColumn(tbl_cliente, SWT.NONE);
		tblclmnCpf.setWidth(130);
		tblclmnCpf.setText("CPF");

		TableColumn tblclmnTelefone = new TableColumn(tbl_cliente, SWT.NONE);
		tblclmnTelefone.setResizable(false);
		tblclmnTelefone.setWidth(100);
		tblclmnTelefone.setText("Telefone");

		TabItem tabApartamento = new TabItem(tabFolder, SWT.NONE);
		tabApartamento.setText("Apartamentos");

		TabItem tabTemporada = new TabItem(tabFolder, SWT.NONE);
		tabTemporada.setText("Temporadas");

	}
}
