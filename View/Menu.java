package View;
import javax.swing.JOptionPane;
import controller.UsuarioController;

public class Menu {
	
	public static void menu() {
		
		int opcao = 0; 
		int cad;
		
		do {
			opcao = MenuInicial.menuOpcoes(); 
			switch (opcao) {
				case 1:
					cad = CadastroUsuarioMenu.CadastroOpcoes();
					do{
					switch (cad) {
						case 1:
							
							String nome = JOptionPane.showInputDialog("Digite o nome completo do Aluno: ");	
							String email = JOptionPane.showInputDialog("Digite o e-mail do Aluno: ");
							String Tel = JOptionPane.showInputDialog("Digite o telefone do Aluno: ");
							String senha = JOptionPane.showInputDialog("Digite a senha do Aluno: ");
							String matri = JOptionPane.showInputDialog("Digite a matricula do Aluno: ");
							String curso = JOptionPane.showInputDialog("Digite o curso do Aluno: ");
							String semes = JOptionPane.showInputDialog("Digite o semestre do Aluno: ");
							
							cadastrarAluno(nome, email, Tel, senha, matri, curso, semes);
						break;
						case 2:
							String nomePrf = JOptionPane.showInputDialog("Digite o nome completo do Professor: ");	
							String emailPrf = JOptionPane.showInputDialog("Digite o e-mail do Professor: ");
							String TelPrf = JOptionPane.showInputDialog("Digite o telefone do Professor: ");
							String senhaPrf = JOptionPane.showInputDialog("Digite a senha do Professor: ");
							String matriPrf = JOptionPane.showInputDialog("Digite a matricula do Professor: ");
							String cursoPrf = JOptionPane.showInputDialog("Digite o curso do Professor: ");
							String cargoPrf = JOptionPane.showInputDialog("Digite o semestre do Professor: ");
							cadastrarProfessor(nomePrf, emailPrf, TelPrf, senhaPrf, matriPrf, cursoPrf, cargoPrf);
						break;
						case 3:
							String nomeSer = JOptionPane.showInputDialog("Digite o nome completo do Servidor: ");	
							String emailSer = JOptionPane.showInputDialog("Digite o e-mail do Servidor: ");
							String TelSer = JOptionPane.showInputDialog("Digite o telefone do Servidor: ");
							String senhaSer = JOptionPane.showInputDialog("Digite a senha do Servidor: ");
							String matriSer = JOptionPane.showInputDialog("Digite a matricula do Servidor: ");
							String funcSer = JOptionPane.showInputDialog("Digite a funcao do Servidor: ");
							String deptoSer = JOptionPane.showInputDialog("Digite o departamento do Servidor: ");
							cadastrarServidorADM(nomeSer, emailSer, TelSer, senhaSer, matriSer, funcSer, deptoSer)
						break;
						default:
							JOptionPane.showMessageDialog(null, "Opcao invalida");
							cad = -1;
							break;
					}
				}while(cad != 0);
				break;
				case 2: 
					if (Login.login() == 1) {
						JOptionPane.showMessageDialog(null, "Login bem sucedido.");
					}else{
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");
					}
				break;
				case 0: 
				break;
				default: 
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
				break;
			}
		} while (opcao != 0);
		return;
	}


}