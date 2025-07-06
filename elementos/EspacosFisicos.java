package elementos;
import java.util.List;
public abstract class EspacosFisicos {
    protected String nome , tipo , localizacao;
    protected int capacidade;
    protected List<String> equipamentos;
    protected List<String> horarios;

    public EspacosFisicos( String nome, String tipo, String localizacao, int capacidade,
    List<String> equipamentos,  List<String> horarios )
    {
        this.nome = nome;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.equipamentos = equipamentos;
        this.horarios = horarios;
    }
    public String getNome() {
        return nome;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<String> getEquipamentos() {
        return equipamentos;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }


    public void adicionarEquipamento(String equipamento) {
        equipamentos.add(equipamento);
    }

    public void removerEquipamentos(String equipamentos) {
        this.equipamentos.remove(equipamentos);
    }
}