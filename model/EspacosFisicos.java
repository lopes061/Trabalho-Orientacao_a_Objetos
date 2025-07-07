package model;

import java.util.Date;
import java.util.Calendar;

public class EspacosFisicos{
    private String nome, localizacao;
    private int capacidade;
    private String[] equipamentos = new String[1000];
    private int qtdEq = 0;
    private Date[] hOcupados = new Date[1000];
    private int horariosUtilizados = 0;
    
    public EspacosFisicos(){}
    public EspacosFisicos(String nome, String localizacao, int capacidade)
    {
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
    }
    public EspacosFisicos(String nome, String localizacao, int capacidade, String[] equipamentos, int qtdEq)
    {
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        setEquip(equipamentos, qtdEq);
    }

    protected String getNome(){
        return nome;
    }
    protected void setNome(String nome){
        this.nome = nome;
    }

    protected String getLocal(){
        return localizacao;
    }
    protected void setLocal(String local){
        localizacao = local;
    }

    protected int getCapacidade(){
        return capacidade;
    }
    protected void setCapacidade(int max){
        capacidade = max;
    }

    protected String[] getEquip(){
        String[] equip = new String[qtdEq];
        for(int i = 0; i < qtdEq; i++){
            equip[i] = equipamentos[i];
        }
        return equip;
    }
    protected void setEquip(String[] equip, int qtdEquip){
        int inicial = qtdEq;
        for(int i = 0; i < qtdEquip; i++){
            equipamentos[inicial + i] = equip[i];
            qtdEq++;
        }
    }
}