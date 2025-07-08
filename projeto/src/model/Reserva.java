package model;

import java.util.UUID;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Reserva {

    private final UUID id;

    private EspacosFisicos espaco;
    private Usuario usuario;
    private LocalDateTime inicio, fim;
    private String status;

    private static DateTimeFormatter dataPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter horaPadrao = DateTimeFormatter.ofPattern("HH:mm");


    // Construtores
    public Reserva(){ this.id = UUID.randomUUID(); }
    public Reserva(EspacosFisicos espaco, Usuario usuario, LocalDateTime inicio, LocalDateTime fim, String status){
        this.id = UUID.randomUUID();
        this.espaco = espaco;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
    }


    // Getters
    protected UUID getId(){ return id; }
    protected EspacosFisicos getEspaco(){ return espaco; }
    protected Usuario getUsuario(){ return usuario; }
    protected LocalDateTime[] getInicioFim(){
        LocalDateTime[] horario = new LocalDateTime[2];
        horario[0] = inicio;
        horario[1] = fim;
        return horario;
    }
    protected String getHorario(){ return inicio.format(dataPadrao) + " das " + inicio.format(horaPadrao) + " às " + fim.format(horaPadrao); }
    protected String getStatus(){ return status; }


    // Setters
    protected void setEspaco(EspacosFisicos local){ espaco = local; }
    protected void setUsuario(Usuario user){ usuario = user; }
    protected void setHorario(LocalDateTime inicio, LocalDateTime fim){
        this.inicio = inicio;
        this.fim = fim;
    }
    protected void setHorario(LocalDateTime inicio, long horas){
        this.inicio = inicio;
        fim = inicio.plusHours(horas);
    }
    protected void setStatus(String status){ this.status = status; }

}
