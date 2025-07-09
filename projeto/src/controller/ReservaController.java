package controller;

import java.util.UUID;

import model.Reserva;

public class ReservaController {

    public static String exibirInfo(UUID id){
        Reserva reserva = BancoDeDados.getReserva(id);
        String infos = "Reserva " + id + "\n";
        infos += reserva.getEspaco().getTipo() + ": " + reserva.getEspaco().getNome() + "\n";
        infos += "Reservado por: " + reserva.getUsuario().getNomeCompleto() + "\n";
        infos += "Status: " + reserva.getStatus() + "\n";
        infos += "Dia " + reserva.getHorario();
        return infos;
    }
}
