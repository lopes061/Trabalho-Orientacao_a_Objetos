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


    public Reserva(){ this.id = UUID.randomUUID(); }
    public Reserva(EspacosFisicos espaco, Usuario usuario, LocalDateTime inicio, LocalDateTime fim, String status){
        this.id = UUID.randomUUID();
        this.espaco = espaco;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
    }

    public UUID getId(){ return id; }
    public EspacosFisicos getEspaco(){ return espaco; }
    public Usuario getUsuario(){ return usuario; }
    public LocalDateTime[] getInicioFim(){
        LocalDateTime[] horario = new LocalDateTime[2];
        horario[0] = inicio;
        horario[1] = fim;
        return horario;
    }
    public String getHorario(){ return inicio.format(dataPadrao) + " das " + inicio.format(horaPadrao) + " às " + fim.format(horaPadrao); }
    public String getStatus(){ return status; }

    protected void setEspaco(EspacosFisicos local){ espaco = local; }
    protected void setUsuario(Usuario user){ usuario = user; }
    protected void setHorario(LocalDateTime inicio, LocalDateTime fim){
        this.inicio = inicio;
        this.fim = fim;
    }
    protected void setStatus(String st){ status = st;}
}