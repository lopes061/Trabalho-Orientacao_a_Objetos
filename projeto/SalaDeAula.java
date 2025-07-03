package projeto;
import java.util.List;
public class SalaDeAula extends EspacosFisicos{
    private boolean arCondicionado;
    private boolean computador;
    private boolean projetor;
    private String tipoDeQuadro;
    public SalaDeAula(String nome,String localizacao,int capacidade,
    List<String> equipamentos,List<String> horarios, boolean arCondicionado,
    boolean computador, boolean projetor, String tipoDeQuadro)
    {
        super(nome, "Sala de Aula",localizacao,capacidade,equipamentos,
        horarios); 
        this.arCondicionado = arCondicionado;
        this.computador = computador;
        this.projetor = projetor;
        this.tipoDeQuadro = tipoDeQuadro; 
    }
    public boolean isArCondicionado()
    {
        return arCondicionado;
    }
    public void setArCondicionado(boolean arCondicionado)
    {
        this.arCondicionado = arCondicionado;
        if(arCondicionado==true && !equipamentos.contains("ar-condicionado"))
        {
            equipamentos.add("ar-condicionado");
        }
    }
    public boolean isComputador()
    {
        return computador;
    }
    public void setComputador(boolean computador)
    {
        this.computador = computador;
        if(computador==true && !equipamentos.contains("computador"))
        {
            equipamentos.add("computador");
        }
    }
    public boolean isProjetor()
    {
        return projetor;
    }
    public void setProjetor(boolean projetor)
    {
        this.projetor = projetor;
        if(projetor==true && !equipamentos.contains("projetor"))
        {
            equipamentos.add("projetor");
        }
    }
    public String getTipoDeQuadro()
    {
        return tipoDeQuadro;
    }
    public void setTipoDeQuadro(String tipoDeQuadro)
    {
        this.tipoDeQuadro = tipoDeQuadro;
    }
    
    public String imprimir()
    {
        return  "Sala de Aula: " + nome + '\n' +
                "Localização: " + localizacao + '\n' +
                "Capacidade: " + capacidade + '\n' +
                "Equipamentos: " + equipamentos + '\n' +
                "Horários: " + horarios;
    }
}    
    