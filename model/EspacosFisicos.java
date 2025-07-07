package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EspacosFisicos{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome, localizacao, tipo;
    private int capacidade;
    private List<String> equipamentos;
    
    public EspacosFisicos(){}
    public EspacosFisicos(String nome, String localizacao, String tipo, int capacidade, List<String> equipamentos)
    {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.equipamentos = equipamentos;
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

    protected String getTipo(){
        return tipo;
    }
    protected void setTipo(String tp){
        tipo = tp;
    }

    protected int getCapacidade(){
        return capacidade;
    }
    protected void setCapacidade(int max){
        capacidade = max;
    }

    protected List<String> getEquip(){
        return equipamentos;
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