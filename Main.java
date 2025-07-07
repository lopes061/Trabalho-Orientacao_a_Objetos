package src;
import javax.swing.JOptionPane;

import Menu.MenuPrincipal;
import Menu.Login;
import Menu.CadastroUsuarioMenu;
//import Cadastro.NovoUsuario;

public class Main {
	
	public static void main(String[] args) {
		
		int opcao = 0; 
		int cad;
		
		do {
			opcao = MenuPrincipal.menuOpcoes(); 
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