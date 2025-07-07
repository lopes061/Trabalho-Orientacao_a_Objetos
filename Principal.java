import javax.swing.JOptionPane;

public class Principal {

	
	public static void main(String[] args) {
		
		int opcao = 0; 
		
		do {
			opcao = MenuInicial.menuOpcoes(); 
			switch (opcao) {
				case 1: 
					MenuAluno.menuAluno(cadAluno); 
				break;
				case 2: 
					JOptionPane.showMessageDialog(null, "Cadastro de professores a ser implementado");
				break;
				case 3: 
					JOptionPane.showMessageDialog(null, "Cadastro de disciplinas a ser implementado");
				break;
				case 4: 
					JOptionPane.showMessageDialog(null, "Cadastro de turmas a ser implementado");
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