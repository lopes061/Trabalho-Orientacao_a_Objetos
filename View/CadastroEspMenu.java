package View;

import javax.swing.JOptionPane;

public class CadastroEspMenu {
    public static String lerTipoSala() {
		int i;
		do{
		String opcoes = "Informe o tipo de sala desejada \n"
				      + "1 - Cadastro de uma sala de aula \n"
                      + "2 - Cadastro de um laboratorio \n"
                      + "3 - Cadastro de uma sala de estudos \n";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		i = Integer.parseInt(strOpcao);
		}while (i != 1 || i != 2 || i != 3); 
		String resposta = "";
		if(i == 1) {
			resposta = "Sala de Aula";
		}else if(i == 2) {
			resposta = "Laboratorio";
		}else if(i == 3){
			resposta = "Sala de estudos";
		}
		return resposta;
	}
	
	public static String lerNomeSala(){
		return JOptionPane.showInputDialog("Digite o nome da sala: ");
	}

	public static int lerCapacidadeSala(){
		int resp = Integer.parseInt(JOptionPane.showInputDialog("Digite o nome da sala: "));
		return resp;
	}

}
