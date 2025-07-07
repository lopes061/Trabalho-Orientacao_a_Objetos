package View;

import javax.swing.JOptionPane;

public class CadastroUsuarioMenu {
    public static int CadastroOpcoes() {
		String opcoes = "Informe a opção desejada \n"
				      + "1 - Cadastro de um novo aluno \n"
                      + "2 - Cadastro de um novo professor \n"
                      + "3 - Cadastro de um novo servidor \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}
}
