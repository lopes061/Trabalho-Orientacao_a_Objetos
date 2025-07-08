package View;

import javax.swing.JOptionPane;

public class CadastroMenu {
    public static int CadastroOpcoes() {
		String opcoes = "Informe a opção desejada \n"
				      + "1 - Cadastro de um novo aluno \n"
                      + "2 - Cadastro de um novo professor \n"
                      + "3 - Cadastro de um novo servidor \n"
					  + "4 - Cadastro de um espaco fisico \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}

	public static String lerNome(){
		return JOptionPane.showInputDialog("Digite o nome completo:");
	}

	public static String lerEmail(){
		return JOptionPane.showInputDialog("Digite o e-mail: ");
	}

	public static String lerTelefone(){
		return JOptionPane.showInputDialog("Digite o e-mail: ");
	}

	public static String lerSenha(){
		return JOptionPane.showInputDialog("Digite a senha: ");
	}

	public static String lerMatricula(){
		return JOptionPane.showInputDialog("Digite a matricula: ");
	}

	public static String lerCurso(){
		return JOptionPane.showInputDialog("Digite o curso: ");
	}

	public static String lerSemestre(){
		return JOptionPane.showInputDialog("Digite o semestre: ");
	}

	public static String lerCargo(){
		return JOptionPane.showInputDialog("Digite o cargo do professor: ");
	}

	public static String lerFuncao(){
		return JOptionPane.showInputDialog("Digite a funcao do servidor publico: ");
	}

	public static String lerDepartamento(){
		return JOptionPane.showInputDialog("Digite o departamento do servidor publico: ");
	}

}
