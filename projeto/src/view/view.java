package view;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import controller.BancoDeDados;

public class view {

	public static int menuInicial() {
		String opcoes = "Bem vindo a interface de cadastro de alunos e agendamento de salas.\n"
					  + "Por favor escolha uma das opcoes abaixo:\n"
					  + "1 - Cadastrar um novo usuario \n"
				      + "2 - Login em um Usuario existente \n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Opção inválida. Por favor, digite um número.");
			return -1;
		}
	}
	public static int cadastroOpcoes() {
		String opcoes = "Informe a opção desejada \n"
				      + "1 - Cadastro de um novo aluno \n"
                      + "2 - Cadastro de um novo professor \n"
                      + "3 - Cadastro de um novo servidor \n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Opção inválida. Por favor, digite um número.");
			return -1;
		}
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
		return JOptionPane.showInputDialog("Digite o seu curso: ");
	} // Aluno e Professor

	public static int lerSemestre(){
		String sem = JOptionPane.showInputDialog("Digite o seu semestre de entrada:\n1 - Primeiro semestre\n2 - Segundo semestre");
		return Integer.parseInt(sem);
	} // Aluno

	public static String lerCargo(){
		return JOptionPane.showInputDialog("Digite o seu cargo: ");
	} // Professor

	public static String lerFuncao(){
		return JOptionPane.showInputDialog("Digite a sua funcao: ");
	} // Adm

	public static String lerDepartamento(){
		return JOptionPane.showInputDialog("Digite o seu departamento: ");
	} // Adm

	public static int loginSucesso() {
		String opcoes = "Login bem sucedido.\n"
                      + "Escolha uma das seguintes opcoes:\n"
				      + "1 - Cadastro de um espaço fisico \n"
                      + "2 - Agendamento de um espaço fisico \n"
					  + "3 - Exportar dados(.txt)\n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Opção inválida. Por favor, digite um número.");
			return -1;
		}
	}
	public static int menuAgendamento(){
		String opcoes = "Informe o tipo de sala desejada \n"
				      + "1 - Agendar uma sala de aula \n"
                      + "2 - Agendar um laboratorio \n"
                      + "3 - Agendar uma sala de estudos \n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Opção inválida. Por favor, digite um número.");
			return -1;
		}
	}

	public static int listarEspacos(String espacosFormatados){
        String input = JOptionPane.showInputDialog(null, espacosFormatados + "\nDigite o número do espaço desejado:");
        if (input == null || input.trim().isEmpty()) {
            return -1;
        }
        try {
            int i = Integer.parseInt(input);
            return i;
        } catch (NumberFormatException e) {
            exibirMensagem("Entrada inválida. Por favor, digite um número.");
            return -1;
        }
    }

	public static int informarEspacos(String nome){
		int i = JOptionPane.showConfirmDialog(null, BancoDeDados.getEspaco(nome), "Confirmacao de espaco selecionado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		return i;
	}

	public static void confirmacaoAgendamento(){
		JOptionPane.showMessageDialog(null, "Agendamento de espaco bem sucedida.");
	}

	public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

	public static String lerTipoSala() {
		int i;
		String resposta = "";
		do{
			String opcoes = "Informe o tipo de sala desejada \n"
						  + "1 - Cadastro de uma sala de aula \n"
						  + "2 - Cadastro de um laboratorio \n"
						  + "3 - Cadastro de uma sala de estudos \n";

			String strOpcao = JOptionPane.showInputDialog(opcoes);
			if (strOpcao == null || strOpcao.trim().isEmpty()) {
				exibirMensagem("Nenhum tipo de sala selecionado. Operação cancelada.");
				return null;
			}
			try {
				i = Integer.parseInt(strOpcao);
				if (i >= 1 && i <= 3) {
					if(i == 1) {
						resposta = "Sala de Aula";
					}else if(i == 2) {
						resposta = "Laboratorio";
					}else if(i == 3){
						resposta = "Sala de estudos";
					}
					return resposta;
				} else {
					exibirMensagem("Opção inválida. Por favor, digite 1, 2 ou 3.");
				}
			} catch (NumberFormatException e) {
				exibirMensagem("Entrada inválida. Por favor, digite um número.");
				i = 0;
			}
		} while (true);
	}

	public static String lerNomeSala(){
		return JOptionPane.showInputDialog("Digite o nome da sala: ");
	}
	public static String lerLocalSala(){
		return JOptionPane.showInputDialog("Digite a localização da sala: ");
	}

	public static int lerCapacidadeSala(){
		String respStr = JOptionPane.showInputDialog("Digite a capacidade da sala: ");
		if (respStr == null || respStr.trim().isEmpty()) {
            return -1;
        }
		try {
            int resp = Integer.parseInt(respStr);
            return resp;
        } catch (NumberFormatException e) {
            exibirMensagem("Capacidade inválida. Por favor, digite um número inteiro.");
            return -1;
        }
	}

	public static List<String> lerEquipamentos(){
		List<String> lista = new ArrayList<>();
		String equipamento;
		int saida = 1;

		do{
			equipamento = JOptionPane.showInputDialog("Digite os equipamentos contidos na sala (para parar, digite 0 e pressione Enter): ");

			if (equipamento == null) {
				saida = 0;
			} else if (equipamento.trim().equals("0")) {
				saida = 0;
			} else {
				lista.add(equipamento.trim());
				saida++;
			}
		}while(saida != 0);

		return lista;
	}
}