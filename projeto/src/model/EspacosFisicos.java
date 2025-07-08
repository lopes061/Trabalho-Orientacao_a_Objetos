package model;

import java.util.List;
import java.util.UUID;

public class EspacosFisicos{

    private final UUID id;
    private String nome, localizacao, tipo;
    private int capacidade;
    private List<String> equipamentos;
    

    // Construtores
    public EspacosFisicos(){ this.id = UUID.randomUUID(); }
    public EspacosFisicos(String nome, String localizacao, String tipo, int capacidade, List<String> equipamentos)
    {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.equipamentos = equipamentos;
    }

    // Getters
    protected UUID getId(){ return id; }
    protected String getNome(){ return nome; }
    protected String getLocal(){ return localizacao; }
    protected String getTipo(){ return tipo; }
    protected int getCapacidade(){ return capacidade; }
    protected List<String> getEquip(){ return equipamentos; }


    // Setters
    protected void setNome(String nome){
        this.nome = nome;
    }
    protected void setLocal(String local){
        localizacao = local;
    }
    protected void setTipo(String tp){
        tipo = tp;
    }
    protected void setCapacidade(int max){
        capacidade = max;
    }

    
    protected boolean adicionarUmEquipamento(String equip){
        boolean funcionou = equipamentos.add(equip);
        return funcionou;
    }
    protected boolean adicionarEquipamentos(List<String> equip){
        boolean funcionou = equipamentos.addAll(equip);
        return funcionou;
    }
}