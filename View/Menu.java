package View;
import javax.swing.JOptionPane;

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
							//CadastroNovoAluno();
							JOptionPane.showMessageDialog(null, "Opcao Atualmente indisponivel");
						break;
						case 2:
							//CadastroNovoServidor();
							JOptionPane.showMessageDialog(null, "Opcao Atualmente indisponivel");
						break;
						case 3:
							//CadastroNovoProfessor();
							JOptionPane.showMessageDialog(null, "Opcao Atualmente indisponivel");
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