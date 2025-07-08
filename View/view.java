package View;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class view {

//Menu Inicial para o inicio da implementação
	public static int menuInicial() {
		String opcoes = "Bem vindo a interface de cadastro de alunos e agendamento de salas.\n" 
					  + "Por favor escolha uma das opcoes abaixo:\n"
					  + "1 - Cadastrar um novo usuario \n"
				      + "2 - Login em um Usuario existente \n"
				      + "0 - Sair";
	
		String strOpcao = JOptionPane.showInputDialog(opcoes);
		int opcao = Integer.parseInt(strOpcao);
	
		return opcao;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------
//Todas as funções para Cadastro de usuario novo
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
		return JOptionPane.showInputDialog("Digite o seu nome completo:");
	}

	public static String lerEmail(){
		return JOptionPane.showInputDialog("Digite o seu e-mail institucional: ");
	}

	public static String lerTelefone(){
		return JOptionPane.showInputDialog("Digite o seu telfone: ");
	}

	public static String lerSenha(){
		return JOptionPane.showInputDialog("Digite a sua senha: ");
	}

	public static String lerMatricula(){
		return JOptionPane.showInputDialog("Digite a sua matricula: ");
	}

	public static String lerCurso(){
		return JOptionPane.showInputDialog("Digite o seu cursocurso: ");
	}

	public static String lerSemestre(){
		return JOptionPane.showInputDialog("Digite o seu semestre atual: ");
	}

	public static String lerCargo(){
		return JOptionPane.showInputDialog("Digite o seu cargo: ");
	}

	public static String lerFuncao(){
		return JOptionPane.showInputDialog("Digite a sua funcao: ");
	}

	public static String lerDepartamento(){
		return JOptionPane.showInputDialog("Digite o seu departamento: ");
	}

//----------------------------------------------------------------------------------------------------------------------------------------------
//Menu para login
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

//----------------------------------------------------------------------------------------------------------------------------------------------
//Menu para Cadastro de espaços

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
		int resp = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade da sala: "));
		return resp;
	}

	public static List<String> lerEquipamentos(){
		List<String> lista = new ArrayList<>();
		String equipamento;
		int saida = 1;

		do{
			if (saida == 1) {
				equipamento = JOptionPane.showInputDialog("Digite os equipamento contidos na sala(continue digitando, se quiser parar digite apenas 0 e de enter.): ");
			}else{
				equipamento = JOptionPane.showInputDialog("Digite o proximo equipamento contido na sala(Pare digitando apenas 0 na caixa de texto): ");
			}

			if (Integer.parseInt(equipamento) == 0) {
				saida = 0;
			}else{
				lista.add(equipamento);
				saida++;
			}
		}while(saida != 0);

		return lista;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------

}