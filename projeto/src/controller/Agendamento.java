package controller;

import model.*;
import view.*;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agendamento {

    // Pega o ID do espaço que o usuário escolheu
    public static UUID getIdEspacoSelecionado(List<EspacosFisicos> espacos, String tipoEspaco) {
        // Se não tiver espaços desse tipo, a gente avisa
        if (espacos == null || espacos.isEmpty()) {
            view.exibirMensagem("Ops! Não temos espaços do tipo " + tipoEspaco + " disponíveis agora.");
            return null;
        }

        // Monta a lista de espaços para o usuário escolher
        StringBuilder sb = new StringBuilder("Espaços Físicos do tipo " + tipoEspaco + " que você pode agendar:\n");
        int i = 1;
        for (EspacosFisicos espaco : espacos) {
            sb.append(i).append(" - ").append(espaco.getNome()).append(" (Capacidade: ").append(espaco.getCapacidade()).append(" pessoas)\n");
            i++;
        }

        // Pede para o usuário escolher um número da lista
        int escolhaUsuario = view.listarEspacos(sb.toString());

        // Verifica se a escolha é válida e retorna o ID do espaço
        if (escolhaUsuario > 0 && escolhaUsuario <= espacos.size()) {
            return espacos.get(escolhaUsuario - 1).getId(); // Retorna o ID do espaço escolhido
        } else if (escolhaUsuario != -1){ // -1 significa que o usuário cancelou ou digitou algo que não era número
            view.exibirMensagem("Essa opção não existe. Por favor, escolha um número da lista.");
            return null;
        } else {
            return null; // O usuário cancelou ou a entrada foi inválida
        }
    }

    // Começa o processo de agendamento
    public static void iniciarAgendamento(Usuario usuarioLogado) {
        // Primeiro, o usuário escolhe que tipo de espaço quer agendar
        int tipoEscolhido = view.menuAgendamento();
        String tipoEspacoString = "";
        switch (tipoEscolhido) {
            case 1:
                tipoEspacoString = "Sala de Aula";
                break;
            case 2:
                tipoEspacoString = "Laboratorio";
                break;
            case 3:
                tipoEspacoString = "Sala de estudos";
                break;
            case 0:
                view.exibirMensagem("Agendamento cancelado. Volte quando quiser!");
                return;
            default:
                view.exibirMensagem("Essa opção de espaço não existe. Agendamento cancelado.");
                return;
        }

        // Busca os espaços disponíveis desse tipo
        List<EspacosFisicos> espacosFiltrados = BancoDeDados.getEspacoPorTipo(tipoEspacoString);
        // Se não encontrar, avisa e para
        if (espacosFiltrados.isEmpty()) {
            view.exibirMensagem("Poxa, não tem nenhum(a) " + tipoEspacoString + " disponível agora.");
            return;
        }

        EspacosFisicos espacoSelecionado = null;
        // Pega o ID do espaço que o usuário escolheu na lista
        UUID idEspacoSelecionado = getIdEspacoSelecionado(espacosFiltrados, tipoEspacoString);

        // Se o usuário escolheu um espaço válido...
        if (idEspacoSelecionado != null) {
            espacoSelecionado = BancoDeDados.getEspacoPorId(idEspacoSelecionado);
            // Só pra garantir, checa se o espaço existe de verdade no banco
            if (espacoSelecionado == null) {
                view.exibirMensagem("Ops! O espaço que você escolheu não foi encontrado. Tente de novo.");
                return;
            }

            // Mostra os detalhes e pergunta se ele quer confirmar
            boolean confirmado = view.confirmarDetalhesEspaco(espacoSelecionado);
            if (!confirmado) {
                view.exibirMensagem("Sem problemas! Agendamento cancelado.");
                return;
            }
        } else {
            view.exibirMensagem("Você não selecionou um espaço ou a escolha foi inválida. Agendamento cancelado.");
            return;
        }

        // Define o período de agendamento (hoje até 6 dias para frente)
        LocalDate hoje = LocalDate.now();
        LocalDate dataInicialSemana = hoje;
        LocalDate dataFinalSemana = hoje.plusDays(6);

        List<LocalDate> datasEscolhidas = new ArrayList<>();
        int quantidadeDiasAgendamento = 1; // Padrão: 1 dia

        // Se for um servidor administrativo, ele pode agendar para mais dias
        if (usuarioLogado instanceof ServidorADM) {
            quantidadeDiasAgendamento = view.solicitarQuantidadeDias();
            if (quantidadeDiasAgendamento <= 0) {
                view.exibirMensagem("A quantidade de dias está incorreta. Agendamento cancelado.");
                return;
            }
        }

        // Loop para o usuário escolher as datas
        for (int k = 0; k < quantidadeDiasAgendamento; k++) {
            LocalDate dataParaAgendar = null;
            boolean dataValida = false;
            while (!dataValida) {
                // Pede para escolher a data
                dataParaAgendar = view.selecionarDataAgendamento(dataInicialSemana, dataFinalSemana);
                if (dataParaAgendar == null) {
                    view.exibirMensagem("Seleção de data cancelada. Agendamento interrompido.");
                    return;
                }
                // Não pode agendar no passado
                if (dataParaAgendar.isBefore(hoje)) {
                    view.exibirMensagem("Não dá pra agendar no passado. Por favor, escolha uma data a partir de hoje.");
                // Não pode agendar na mesma data duas vezes (se for mais de 1 dia)
                } else if (datasEscolhidas.contains(dataParaAgendar)) {
                    view.exibirMensagem("Você já escolheu essa data. Tente outra!");
                } else {
                    dataValida = true;
                }
            }
            datasEscolhidas.add(dataParaAgendar);
        }

        List<Reserva> novasReservas = new ArrayList<>();

        // Agora, para cada data escolhida, a gente pega o horário
        for (LocalDate dataAgendamento : datasEscolhidas) {
            // Vê as reservas que já existem para esse espaço nesse dia
            List<Reserva> reservasNoDia = BancoDeDados.getReserva(espacoSelecionado, dataAgendamento);
            // Calcula quais horários estão livres
            List<LocalTime[]> horariosDisponiveisNoDia = gerarHorariosDisponiveis(reservasNoDia);

            view.exibirMensagem("Olha os horários disponíveis para " + dataAgendamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ":");
            // Pede para o usuário escolher o horário
            LocalTime[] horarioEscolhido = view.selecionarHorario(horariosDisponiveisNoDia);

            if (horarioEscolhido == null) {
                view.exibirMensagem("Você cancelou a seleção do horário. Agendamento interrompido.");
                return;
            }

            // Cria o objeto de reserva com a data e horário
            LocalDateTime inicioReserva = LocalDateTime.of(dataAgendamento, horarioEscolhido[0]);
            LocalDateTime fimReserva = LocalDateTime.of(dataAgendamento, horarioEscolhido[1]);

            Reserva novaReserva = new Reserva(espacoSelecionado, usuarioLogado, inicioReserva, fimReserva, "Pendente");
            novasReservas.add(novaReserva);
        }

        // Monta um resumo do que foi agendado
        StringBuilder detalhesAgendamento = new StringBuilder("Quase lá! Veja os detalhes do seu agendamento:\n");
        detalhesAgendamento.append("Espaço: ").append(espacoSelecionado.getNome()).append(" (").append(espacoSelecionado.getTipo()).append(")\n");
        detalhesAgendamento.append("Reservado por: ").append(usuarioLogado.getNomeCompleto()).append("\n");
        detalhesAgendamento.append("Datas e Horários:\n");
        for (Reserva r : novasReservas) {
            detalhesAgendamento.append(" - ").append(r.getHorario()).append("\n");
        }

        // Pede a confirmação final
        boolean confirmarFinal = view.confirmarAgendamentoFinal(detalhesAgendamento.toString());
        if (!confirmarFinal) {
            view.exibirMensagem("Agendamento cancelado. Que pena!");
            return;
        }

        // Se tudo ok, adiciona as reservas no banco de dados e confirma!
        for (Reserva r : novasReservas) {
            r.setStatus("Confirmada"); // Muda o status para "Confirmada"
            BancoDeDados.adicionarReserva(r); // Salva no banco
        }
        view.confirmacaoAgendamento(); // Avisa que deu tudo certo!
    }

    // Essa função gera os horários que estão livres para agendar
    private static List<LocalTime[]> gerarHorariosDisponiveis(List<Reserva> reservasNoDia) {
        // Começa com todos os horários possíveis do dia (das 8h às 22h, de hora em hora)
        List<LocalTime[]> todosHorariosDoDia = new ArrayList<>();
        for (int hora = 8; hora < 22; hora++) {
            todosHorariosDoDia.add(new LocalTime[]{LocalTime.of(hora, 0), LocalTime.of(hora + 1, 0)});
        }

        List<LocalTime[]> horariosDisponiveis = new ArrayList<>();
        // Para cada horário possível...
        for (LocalTime[] slot : todosHorariosDoDia) {
            boolean conflitante = false;
            // A gente checa se ele bate com alguma reserva que já existe
            for (Reserva reservaExistente : reservasNoDia) {
                LocalTime inicioExistente = reservaExistente.getInicioFim()[0].toLocalTime();
                LocalTime fimExistente = reservaExistente.getInicioFim()[1].toLocalTime();

                // Se os horários se sobrepõem, ele não está disponível
                if (slot[0].isBefore(fimExistente) && slot[1].isAfter(inicioExistente)) {
                    conflitante = true;
                    break;
                }
            }
            // Se não bateu com nada, adiciona ele como disponível
            if (!conflitante) {
                horariosDisponiveis.add(slot);
            }
        }
        return horariosDisponiveis;
    }
}