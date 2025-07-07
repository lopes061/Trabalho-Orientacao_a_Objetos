package View;

import javax.swing.JOptionPane;

public class CadastroEspMenu {
    public static int EspOpcoes() {
		String opcoes = "Informe a opção desejada \n"
				      + "1 - Cadastro de uma sala de aula \n"
                      + "2 - Cadastro de um laboratorio \n"
                      + "3 - Cadastro de uma sala de estudos \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}
}
