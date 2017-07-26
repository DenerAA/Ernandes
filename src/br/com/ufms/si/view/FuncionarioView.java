package br.com.ufms.si.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ufms.si.model.Endereco;
import br.com.ufms.si.model.Funcionario;
import br.com.ufms.si.repo.FuncionarioRepositorio;
import br.com.ufms.si.resource.FuncionarioResource;

public class FuncionarioView extends JPanel {
	private JTextField nome;
	private JTextField nascimento;
	private JTextField email;
	private JTextField celular;
	private JTextField cpf;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtMatricula;
	private JTextField txtSenha;

	FuncionarioResource resource;

	/**
	 * Create the panel.
	 */
	public FuncionarioView() {

		setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 27, 46, 14);
		add(lblNome);

		nome = new JTextField();
		nome.setBounds(59, 24, 184, 20);
		add(nome);
		nome.setColumns(10);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(301, 52, 91, 14);
		add(lblNascimento);

		nascimento = new JTextField();
		nascimento.setBounds(387, 49, 124, 20);
		add(nascimento);
		nascimento.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(253, 27, 46, 14);
		add(lblEmail);

		email = new JTextField();
		email.setText("d");
		email.setBounds(327, 24, 184, 20);
		add(email);
		email.setColumns(10);

		celular = new JTextField();
		celular.setBounds(186, 49, 105, 20);
		add(celular);
		celular.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(134, 52, 59, 14);
		add(lblCelular);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 52, 46, 14);
		add(lblCpf);

		cpf = new JTextField();
		cpf.setBounds(41, 49, 86, 20);
		add(cpf);
		cpf.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 138, 126, 14);
		add(lblEndereo);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 163, 46, 14);
		add(lblRua);

		txtRua = new JTextField();
		txtRua.setText("rua");
		txtRua.setBounds(41, 160, 240, 20);
		add(txtRua);
		txtRua.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 204, 66, 14);
		add(lblCidade);

		JLabel identificador = new JLabel("");
		identificador.setBounds(271, 244, 46, 14);
		add(identificador);

		txtCidade = new JTextField();
		txtCidade.setBounds(66, 201, 215, 20);
		add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(289, 163, 46, 14);
		add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setText("bairro");
		txtBairro.setBounds(337, 160, 157, 20);
		add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(289, 204, 46, 14);
		add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(337, 201, 157, 20);
		add(txtCep);
		txtCep.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 90, 66, 14);
		add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setText("matricula");
		txtMatricula.setBounds(71, 87, 86, 20);
		add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(167, 90, 46, 14);
		add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setText("senha");
		txtSenha.setBounds(213, 87, 86, 20);
		add(txtSenha);
		txtSenha.setColumns(10);

		JCheckBox situacao = new JCheckBox("Ativo");
		situacao.setBounds(356, 108, 59, 23);
		add(situacao);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E2o:");
		lblSituao.setBounds(346, 90, 86, 14);
		add(lblSituao);

		JCheckBox chckbxDesatvado = new JCheckBox("Desatvado");
		chckbxDesatvado.setBounds(417, 108, 94, 23);
		add(chckbxDesatvado);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					resource = new FuncionarioResource();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();

				endereco.setBairro(txtBairro.getText());
				endereco.setCep(txtCep.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setRua(txtRua.getText());

				funcionario.setCelular(celular.getText());
				funcionario.setCpf(cpf.getText());
				funcionario.setEmail(email.getText());
				funcionario.setEndereco(endereco);
				funcionario.setMatricula(txtMatricula.getText());
				String[] dataString = nascimento.getText().split("/");
				int dia = Integer.parseInt(dataString[0]);
				int mes = Integer.parseInt(dataString[1]);
				int ano = Integer.parseInt(dataString[2]);

				Date date = new Date(ano, mes, dia);

				funcionario.setNascimento(date);

				funcionario.setNome(nome.getText());
				funcionario.setSenha(txtSenha.getText());
				funcionario.setSituacao(situacao.isSelected());

				resource.create(funcionario);

				Integer id = resource.loadMax();
				funcionario.setId(id);
				identificador.setText(id.toString());

			}
		});
		btnSalvar.setBounds(41, 244, 89, 23);
		add(btnSalvar);

		JLabel lblIdentificador = new JLabel("Identificador:");
		lblIdentificador.setBounds(167, 248, 94, 14);
		add(lblIdentificador);

	}
}
