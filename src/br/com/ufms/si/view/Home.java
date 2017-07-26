package br.com.ufms.si.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Panel;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */

	private boolean isCadastro = false;

	public Home() {
		FuncionarioView funcionario = new FuncionarioView();
		funcionario.setBounds(120, 75, 550, 450);
		funcionario.setVisible(false);
		setLayout(null);

		add(funcionario);


		/*
		 * ###############################CADASTRO######################################
		 */

		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				funcionario.setVisible(true);
			}
		});
		btnFuncionario.setBounds(151, 49, 89, 23);
		btnFuncionario.setVisible(isCadastro);
		add(btnFuncionario);

		JButton btnEvento = new JButton("Evento");
		btnEvento.setBounds(448, 49, 89, 23);
		btnEvento.setVisible(isCadastro);
		add(btnEvento);

		JButton btnProduto = new JButton("Produto");
		btnProduto.setBounds(250, 49, 89, 23);
		btnProduto.setVisible(isCadastro);
		add(btnProduto);

		JButton btnServico = new JButton("Serviço");
		btnServico.setBounds(349, 49, 89, 23);
		btnServico.setVisible(isCadastro);
		add(btnServico);

		/*
		 * #############################################################################
		 */

		JLabel label = new JLabel("Bem vindo ao EventSys");
		label.setBounds(10, 7, 135, 14);
		add(label);

		JButton btnCadastros = new JButton("Cadastros");
		btnCadastros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				isCadastro = !isCadastro;
				btnFuncionario.setVisible(isCadastro);
				btnEvento.setVisible(isCadastro);
				btnProduto.setVisible(isCadastro);
				btnServico.setVisible(isCadastro);
			}
		});
		btnCadastros.setBounds(10, 133, 103, 23);
		add(btnCadastros);

		JButton btnConfigurao = new JButton("Configura\u00E7\u00E3o");
		btnConfigurao.setBounds(10, 167, 103, 23);
		add(btnConfigurao);

		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(10, 99, 103, 23);
		add(btnAgenda);

	}
}
