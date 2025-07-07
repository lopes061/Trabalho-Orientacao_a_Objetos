package View;

import javax.swing.JOptionPane;

public class MenuInicial {

	public static int menuOpcoes() {
		String opcoes = "1 - Cadastrar um novo usuario \n"
				      + "2 - Login em um Usuario existente \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}

}