package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.EspacosFisicos;
import model.Reserva;

public abstract class EspacoController {

    public static String getHorariosSemana(UUID id){

        final int HORA_INICIO_DIA = 7;
        final int HORA_FIM_DIA = 19; // Gera horários até 19:00
        final long DIAS_A_EXIBIR = 7L;
        final LocalDate hoje = LocalDate.now();
        final LocalDate dataFinal = hoje.plusDays(DIAS_A_EXIBIR);

        // Busca o espaço e suas reservas para a semana
        EspacosFisicos espaco = getEspaco(UUID id);
        List<Reserva> ocupados = getReserva(espaco, hoje, dataFinal);

        // --- 2. PRÉ-PROCESSAMENTO DOS DADOS (A GRANDE OTIMIZAÇÃO) ---
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
            tabela.append(String.format("  %s   |", hoje.plusDays(i).format(formatadorData)));
        }
        tabela.append("\n");

        // Monta as linhas, uma para cada hora do dia
        for (int hora = HORA_INICIO_DIA; hora <= HORA_FIM_DIA; hora++) {
            tabela.append(String.format("|   %s   |", LocalTime.of(hora, 0).format(formatadorHora)));

            // Monta as colunas, verificando o status de cada slot (dia, hora)
            for (long diaOffset = 0; diaOffset < DIAS_A_EXIBIR; diaOffset++) {
                LocalDate diaAtual = hoje.plusDays(diaOffset);

                // Consulta o mapa pré-processado (muito rápido!)
                boolean ocupado = slotsOcupados.getOrDefault(diaAtual, Collections.emptySet()).contains(hora);

                String status = ocupado ? "Ocupado" : "  Livre ";
                tabela.append(String.format(" %-8s|", status));
            }
            tabela.append("\n");
        }

        return tabela.toString();


        String horarios = "| Horários |  ";
        for(long i = 0L; i < 7L; i++){
            horarios += LocalDate.now().plusDays(i).format(Reserva.dataPadrao) + "  |  ";
        }
        horarios += "\n";
        for(int i = 7; i < 20; i++){
            horarios += "|   " + LocalTime.of(i, 0).format(Reserva.horaPadrao);
        }
    }
}
