package view;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import controller.BancoDeDados;
import model.EspacosFisicos;

public class view {

	// Menu de boas-vindas inicial
	public static int menuInicial() {
		String opcoes = "Olá! Bem-vindo(a) ao nosso sistema de cadastro e agendamento.\n"
					  + "Por favor, escolha o que você quer fazer:\n"
					  + "1 - Quero me cadastrar como um novo usuário\n"
				      + "2 - Já tenho cadastro, quero fazer login\n"
				      + "0 - Sair do sistema";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		// Se o usuário fechar a caixa ou não digitar nada
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Essa não é uma opção válida. Por favor, digite um número.");
			return -1;
		}
	}
	// Opções para quem está se cadastrando
	public static int cadastroOpcoes() {
		String opcoes = "Você quer se cadastrar como?\n"
				      + "1 - Um(a) novo(a) aluno(a)\n"
                      + "2 - Um(a) novo(a) professor(a)\n"
                      + "3 - Um(a) novo(a) servidor(a)\n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		// Se o usuário fechar a caixa ou não digitar nada
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Essa não é uma opção válida. Por favor, digite um número.");
			return -1;
		}
	}

	// Pede o nome completo
	public static String lerNome(){
		return JOptionPane.showInputDialog("Qual é o seu nome completo?");
	}

	// Pede o e-mail institucional
	public static String lerEmail(){
		return JOptionPane.showInputDialog("Por favor, digite seu e-mail institucional:");
	}

	// Pede o telefone
	public static String lerTelefone(){
		return JOptionPane.showInputDialog("Qual é o seu telefone?");
	}

	// Pede a senha
	public static String lerSenha(){
		return JOptionPane.showInputDialog("Agora, crie uma senha:");
	}

	// Pede a matrícula
	public static String lerMatricula(){
		return JOptionPane.showInputDialog("Qual é o número da sua matrícula?");
	}

	// Pede o curso (para alunos/professores)
	public static String lerCurso(){
		return JOptionPane.showInputDialog("Qual é o seu curso?");
	}

	// Pede o semestre (apenas para alunos)
	public static int lerSemestre(){
		String semestreStr = JOptionPane.showInputDialog("Em qual semestre do ano você entrou?\n(1 ou 2)");
		if (semestreStr == null || semestreStr.trim().isEmpty()) {
            return -1;
        }
		int semestre = Integer.parseInt(semestreStr);
		return semestre;
	}

	// Pede o cargo (para professores)
	public static String lerCargo(){
		return JOptionPane.showInputDialog("Qual é o seu cargo?");
	}

	// Pede a função (para servidores)
	public static String lerFuncao(){
		return JOptionPane.showInputDialog("Qual é a sua função?");
	}

	// Pede o departamento (para servidores)
	public static String lerDepartamento(){
		return JOptionPane.showInputDialog("A qual departamento você pertence?");
	}

	// Menu após o login bem-sucedido
	public static int loginSucesso() {
		String opcoes = "Login bem sucedido.\n"
                      + "Escolha uma das seguintes opcoes:\n"
				      + "1 - Cadastro de um espaço fisico \n"
                      + "2 - Agendamento de um espaço fisico \n"
					  + "3 - Exportar dados(.txt)\n"
				      + "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		// Se o usuário fechar a caixa ou não digitar nada
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Essa não é uma opção válida. Por favor, digite um número.");
			return -1;
		}
	}

	// Menu para agendamento de espaços
	public static int menuAgendamento(){
		String opcoes = "Que tipo de espaço você quer agendar?\n"
				      + "1 - Uma sala de aula\n"
                      + "2 - Um laboratório\n"
                      + "3 - Uma sala de estudos\n"
				      + "0 - Voltar";

		String strOpcao = JOptionPane.showInputDialog(opcoes);
		// Se o usuário fechar a caixa ou não digitar nada
		if (strOpcao == null || strOpcao.trim().isEmpty()) {
            return -1;
        }
		try {
			int opcao = Integer.parseInt(strOpcao);
			return opcao;
		} catch (NumberFormatException e) {
			exibirMensagem("Essa não é uma opção válida. Por favor, digite um número.");
			return -1;
		}
	}

	// Lista os espaços disponíveis e pede para o usuário escolher um
	public static int listarEspacos(String espacosFormatados){
        String input = JOptionPane.showInputDialog(null, espacosFormatados + "\nDigite o número do espaço que você quer:");
        if (input == null || input.trim().isEmpty()) {
            return -1;
        }
        try {
            int i = Integer.parseInt(input);
            return i;
        } catch (NumberFormatException e) {
            exibirMensagem("Essa entrada não é um número válido. Por favor, digite o número do espaço.");
            return -1;
        }
    }

	public static int informarEspacos(String nome){
		int i = JOptionPane.showConfirmDialog(null, BancoDeDados.getEspaco(nome), "Confirmar espaço selecionado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		return i;
	}

	// Mensagem de confirmação de agendamento
	public static void confirmacaoAgendamento(){
		JOptionPane.showMessageDialog(null, "Agendamento feito com sucesso! :D");
	}

	// Uma função geral para mostrar mensagens para o usuário
	public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

	// Pede o tipo de sala para cadastro de um novo espaço
	public static String lerTipoSala() {
		int i;
		String resposta = "";
		do{
			String opcoes = "Que tipo de sala você quer cadastrar?\n"
						  + "1 - Sala de aula\n"
						  + "2 - Laboratório\n"
						  + "3 - Sala de estudos\n";

			String strOpcao = JOptionPane.showInputDialog(opcoes);
			if (strOpcao == null || strOpcao.trim().isEmpty()) {
				exibirMensagem("Você não escolheu nenhum tipo de sala. A operação foi cancelada.");
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
					exibirMensagem("Essa não é uma opção válida. Por favor, digite 1, 2 ou 3.");
				}
			} catch (NumberFormatException e) {
				exibirMensagem("Entrada inválida. Por favor, digite um número.");
				i = 0;
			}
		} while (true);
	}

	// Pede o nome da sala (para cadastro)
	public static String lerNomeSala(){
		return JOptionPane.showInputDialog("Qual o nome da sala?");
	}
	public static String lerLocalSala(){
		return JOptionPane.showInputDialog("Digite a localização da sala: ");
	}

	// Pede a capacidade da sala (quantas pessoas cabem)
	public static int lerCapacidadeSala(){
		String respStr = JOptionPane.showInputDialog("Quantas pessoas cabem nessa sala?");
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

	// Pede os equipamentos da sala
	public static List<String> lerEquipamentos(){
		List<String> lista = new ArrayList<>();
		String equipamento;
		int saida = 1;

		do{
			equipamento = JOptionPane.showInputDialog("Quais equipamentos essa sala tem? (Digite '0' e Enter quando terminar):");

			if (equipamento == null) { // Se o usuário apertar Cancelar
				saida = 0;
			} else if (equipamento.trim().equals("0")) { // Se ele digitar '0'
				saida = 0;
			} else {
				lista.add(equipamento.trim());
			}
		}while(saida != 0);

		return lista;
	}


    // Mostra os detalhes de um espaço e pede pra você confirmar se é esse mesmo
    public static boolean confirmarDetalhesEspaco(EspacosFisicos espaco) {
        StringBuilder detalhes = new StringBuilder("Deixa eu te mostrar os detalhes do espaço que você escolheu:\n");
        detalhes.append("Nome: ").append(espaco.getNome()).append("\n");
        detalhes.append("Localização: ").append(espaco.getLocal()).append("\n");
        detalhes.append("Tipo: ").append(espaco.getTipo()).append("\n");
        detalhes.append("Capacidade: ").append(espaco.getCapacidade()).append(" pessoas\n");
        detalhes.append("Equipamentos: ").append(String.join(", ", espaco.getEquip())).append("\n\n");
        detalhes.append("Confirma que é esse espaço que você quer agendar?");

        int confirmacao = JOptionPane.showConfirmDialog(null, detalhes.toString(),
                "Confirme o Espaço", JOptionPane.YES_NO_OPTION);
        return confirmacao == JOptionPane.YES_OPTION;
    }

    // Se você for um servidor administrativo, pode escolher agendar por mais dias
    public static int solicitarQuantidadeDias() {
        String input = JOptionPane.showInputDialog("Oi, Servidor Administrativo! Quantos dias você quer agendar (de 1 a 7)?");
        if (input == null || input.trim().isEmpty()) {
            return 0; // Se cancelar ou não digitar nada
        }
        try {
            int dias = Integer.parseInt(input);
            if (dias >= 1 && dias <= 7) {
                return dias;
            } else {
                exibirMensagem("A quantidade de dias está fora do permitido. Por favor, digite um número entre 1 e 7.");
                return 0;
            }
        } catch (NumberFormatException e) {
            exibirMensagem("Isso não é um número válido. Por favor, digite quantos dias você quer.");
            return 0;
        }
    }

    // Pede para você escolher uma data para o agendamento
    public static LocalDate selecionarDataAgendamento(LocalDate dataInicial, LocalDate dataFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder("Escolha uma data para o seu agendamento (formato dd/MM/aaaa):\n");
        sb.append("Período liberado: de ").append(dataInicial.format(formatter)).append(" até ").append(dataFinal.format(formatter)).append("\n");

        String input = JOptionPane.showInputDialog(sb.toString());
        if (input == null || input.trim().isEmpty()) {
            return null; 
        }
        try {
            LocalDate dataSelecionada = LocalDate.parse(input.trim(), formatter);
            // Checa se a data que você escolheu está dentro do período permitido
            if (dataSelecionada.isBefore(dataInicial) || dataSelecionada.isAfter(dataFinal)) {
                exibirMensagem("Essa data não está disponível. Por favor, escolha uma data entre " + dataInicial.format(formatter) + " e " + dataFinal.format(formatter) + ".");
                return null;
            }
            return dataSelecionada;
        } catch (DateTimeParseException e) {
            exibirMensagem("Formato de data incorreto. Por favor, use dd/MM/aaaa (ex: 09/07/2025).");
            return null;
        }
    }

    // Mostra os horários livres e pede para você escolher um
    public static LocalTime[] selecionarHorario(List<LocalTime[]> horariosDisponiveis) {
        if (horariosDisponiveis.isEmpty()) {
            exibirMensagem("Poxa, não tem horários disponíveis para este dia. :(");
            return null;
        }

        StringBuilder sb = new StringBuilder("Aqui estão os horários livres:\n");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        int i = 1;
        for (LocalTime[] slot : horariosDisponiveis) {
            sb.append(i).append(" - De ").append(slot[0].format(timeFormatter)).append(" às ").append(slot[1].format(timeFormatter)).append("\n");
            i++;
        }

        String input = JOptionPane.showInputDialog(sb.toString() + "\nQual horário você quer? Digite o número:");
        if (input == null || input.trim().isEmpty()) {
            return null; 
        }
        try {
            int escolha = Integer.parseInt(input);
            // Verifica se o número escolhido está na lista de horários
            if (escolha > 0 && escolha <= horariosDisponiveis.size()) {
                return horariosDisponiveis.get(escolha - 1);
            } else {
                exibirMensagem("Essa opção de horário não existe. Por favor, digite um número da lista.");
                return null;
            }
        } catch (NumberFormatException e) {
            exibirMensagem("Isso não é um número válido. Por favor, digite o número do horário.");
            return null;
        }
    }

    // Mostra um resumo do agendamento e pede a confirmação final
    public static boolean confirmarAgendamentoFinal(String detalhes) {
        int confirmacao = JOptionPane.showConfirmDialog(null, detalhes + "\nEstá tudo certo? Posso confirmar seu agendamento?",
                "Confirme seu Agendamento", JOptionPane.YES_NO_OPTION);
        return confirmacao == JOptionPane.YES_OPTION;
    }
}