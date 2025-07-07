package menus;

import javax.swing.JOptionPane;

import elementos.Aluno;
import elementos.Usuario;
import servicos.CadastroUsuario;

public class MenuAluno extends MenuUsuarios{
    
	public static Aluno dadosNovoAluno() {
		String nome = lerNome();
		String email = lerEmail();
		String telefone = lerTelefone();
        String senha = lerSenha();
		String matricula = lerMatricula(); 
		String curso = lerCurso();
        int semestre = lerSemestre();
		return new Aluno(nome, email, telefone, senha, curso, matricula, semestre);
	}

	private static String lerCurso() {
		return JOptionPane.showInputDialog("Informe o curso do aluno: ");
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

	private static String lerMatricula() {
		return JOptionPane.showInputDialog("Informe a matricula do aluno: ");
	}

	private static String lerSenha() {
		return JOptionPane.showInputDialog("Informe a senha do aluno: ");
	}
    
	private static int lerSemestre() {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe o semestre do aluno: "));
	}


	public void menu(CadastroUsuario cadAluno) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar aluno\n"
				+ "2 - Pesquisar aluno\n"
				+ "3 - Atualizar aluno\n"
				+ "4 - Remover aluno\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Aluno novoAluno = dadosNovoAluno();
				cadAluno.cadastrarUsuario(novoAluno);
				break;
				
			case 2: 
				String email = lerEmail();
				Usuario a = cadAluno.pesquisarUsuario(email);
				if (a != null)
					JOptionPane.showMessageDialog(null, a.toString());
				break;
				
			case 3: 
				email = lerEmail(); 
				Aluno novoCadastro = dadosNovoAluno();
				boolean atualizado = cadAluno.atualizarUsuario(email, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				email = lerEmail();
				Usuario remover = cadAluno.pesquisarUsuario(email);
				boolean removido = cadAluno.removerUsuario(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Aluno removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
