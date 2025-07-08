package View;

import javax.swing.JOptionPane;

public class Login {
    public static String lerMaticula(){
		return JOptionPane.showInputDialog("Digite a matricula: ");
	}

    public static String lerSenha(){
		return JOptionPane.showInputDialog("Digite a sua senha: ");
	}

    public static int LoginSucesso() {
		String opcoes = "Login bem sucedido.\n" 
                      + "Escolha uma das seguintes opcoes:\n"
				      + "1 - Cadastro de um espaço fisico \n"
                      + "2 - Agendamento de um espaço fisico \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}
}
