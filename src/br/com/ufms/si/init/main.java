package br.com.ufms.si.init;

import javax.swing.JFrame;

import br.com.ufms.si.view.Home;

public class main {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Meu primeiro frame em Java");
		

		Home home = new Home();
		
		janela.add(home);
		janela.setSize(800, 500);
		janela.setVisible(true);
		
		System.out.println("teste");
	}

}
