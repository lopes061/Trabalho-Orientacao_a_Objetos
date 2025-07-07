package menus;

import javax.swing.JOptionPane;

public abstract class MenuUsuarios {

    private String nome, email, telefone, senha;

    public MenuUsuarios(){
		String nome = lerNome();
		String email = lerEmail();
		String telefone = lerTelefone();
        String senha = lerSenha();
	}

	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do aluno: ");
	}

	private static String lerTelefone() {
		return JOptionPane.showInputDialog("Informe o telefone do aluno: ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do aluno: ");
	}

	private static String lerSenha() {
		return JOptionPane.showInputDialog("Informe a senha do aluno: ");
	}
    
}
