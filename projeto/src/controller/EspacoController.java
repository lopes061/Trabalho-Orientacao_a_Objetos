package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.EspacosFisicos;
import model.Reserva;

public abstract class EspacoController {

    private static final int HORA_INICIO_DIA = 7;
    private static final int HORA_FIM_DIA = 19; // Gera horários até 19:00

    public static String getHorariosSemana(UUID id){

        final long DIAS_A_EXIBIR = 7L;
        final LocalDate hoje = LocalDate.now();
        final LocalDate dataFinal = hoje.plusDays(DIAS_A_EXIBIR);

        // Busca o espaço e suas reservas para a semana
        EspacosFisicos espaco = BancoDeDados.getEspacoPorId(id);
        List<Reserva> ocupados = BancoDeDados.getReserva(espaco, hoje, dataFinal);

        // --- 2. PRÉ-PROCESSAMENTO DOS DADOS ---
        // Cria um mapa onde a chave é o dia e o valor é um conjunto com as horas ocupadas
        Map<LocalDate, Set<Integer>> slotsOcupados = new HashMap<>();

        for (Reserva reserva : ocupados) {
            LocalDateTime cursor = reserva.getInicioFim()[0];
            while (cursor.isBefore(reserva.getInicioFim()[1])) {
                LocalDate dia = cursor.toLocalDate();
                int hora = cursor.getHour();

                // Adiciona a hora ao conjunto de horas ocupadas daquele dia
                slotsOcupados.computeIfAbsent(dia, k -> new HashSet<>()).add(hora);

                cursor = cursor.plusHours(1); // Avança para a próxima hora
            }
        }

        // --- 3. MONTAGEM DA STRING DA TABELA ---
        StringBuilder tabela = new StringBuilder();

        // Monta o cabeçalho com os dias
        tabela.append(String.format("| %-9s |", "Horários"));
        for (long i = 0; i < DIAS_A_EXIBIR; i++) {
            tabela.append(String.format("  %s   |", hoje.plusDays(i).format(Reserva.dataPadrao)));
        }
        tabela.append("\n");

        // Monta as linhas, uma para cada hora do dia
        for (int hora = HORA_INICIO_DIA; hora <= HORA_FIM_DIA; hora++) {
            tabela.append(String.format("|   %s   |", LocalTime.of(hora, 0).format(Reserva.horaPadrao)));

            // Monta as colunas, verificando o status de cada slot (dia, hora)
            for (long diaOffset = 0; diaOffset < DIAS_A_EXIBIR; diaOffset++) {
                LocalDate diaAtual = hoje.plusDays(diaOffset);

                // Consulta o mapa pré-processado
                boolean ocupado = slotsOcupados.getOrDefault(diaAtual, Collections.emptySet()).contains(hora);

                String status = ocupado ? "Ocupado" : "  Livre ";
                tabela.append(String.format(" %-8s|", status));
            }
            tabela.append("\n");
        }

        return tabela.toString();
    }

    public static String getHorariosDia(UUID id, LocalDate dia){
        EspacosFisicos espaco = BancoDeDados.getEspacoPorId(id);
        List<Reserva> ocupados = BancoDeDados.getReserva(espaco, dia);

        // --- 2. PRÉ-PROCESSAMENTO DOS DADOS (SIMPLIFICADO) ---
        // Cria um conjunto (Set) apenas com as horas que estão ocupadas.
        Set<Integer> slotsOcupados = new HashSet<>();

        for (Reserva reserva : ocupados) {
            LocalDateTime cursor = reserva.getInicioFim()[0];
            while (cursor.isBefore(reserva.getInicioFim()[1])) {
                if (cursor.toLocalDate().equals(dia)) {
                    slotsOcupados.add(cursor.getHour());
                }
                cursor = cursor.plusHours(1);
            }
        }

        // --- 3. MONTAGEM DA STRING DA TABELA ---
        StringBuilder tabela = new StringBuilder();

        // Título
        tabela.append(String.format("Agenda para o Espaço: %s em %s\n", espaco.getNome(), dia.format(Reserva.dataPadrao)));
        tabela.append("-".repeat(23)).append("\n");

        // Cabeçalho
        tabela.append(String.format("| %-8s | %-8s |\n", "Horário", "Status"));
        tabela.append("|----------|----------|\n");

        // Linhas da tabela
        for (int hora = HORA_INICIO_DIA; hora <= HORA_FIM_DIA; hora++) {
            LocalTime horaAtual = LocalTime.of(hora, 0);

            // A consulta agora é um simples 'contains' no Set, muito rápido.
            boolean ocupado = slotsOcupados.contains(hora);
            String status = ocupado ? "Ocupado" : "Livre";
            
            tabela.append(String.format("| %-8s | %-8s |\n", horaAtual.format(Reserva.horaPadrao), status));
        }
        tabela.append("-".repeat(23)).append("\n");

        return tabela.toString();
    }
}