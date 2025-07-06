package projeto;
import java.util.List;
import java.util.ArrayList;

public class LaboratorioInformatica extends EspacosFisicos {
    private List<String> softwares;
    private String sistemaOperacional;
    private String responsavelTecnico;
    private boolean temInternet;

    public LaboratorioInformatica(String nome, String localizacao, int capacidade,
                                 List<String> equipamentos, List<String> horarios,
                                 List<String> softwares, String sistemaOperacional,
                                 String responsavelTecnico, boolean temInternet) {
        super(nome, "Laboratório de Informática", localizacao, capacidade, equipamentos, horarios);
        this.softwares = softwares != null ? softwares : new ArrayList<>();
        this.sistemaOperacional = sistemaOperacional;
        this.responsavelTecnico = responsavelTecnico;
        this.temInternet = temInternet;
    }

    // Getters específicos
    public List<String> getSoftwares() {
        return softwares;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public String getResponsavelTecnico() {
        return responsavelTecnico;
    }

    public boolean isTemInternet() {
        return temInternet;
    }

    // Setters específicos
    public void setSoftwares(List<String> softwares) {
        this.softwares = softwares;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public void setResponsavelTecnico(String responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    public void setTemInternet(boolean temInternet) {
        this.temInternet = temInternet;
    }

    // Métodos específicos
    public void adicionarSoftware(String software) {
        softwares.add(software);
    }

    public void removerSoftware(String software) {
        softwares.remove(software);
    }

    
    public void exibirInformacoes() {
        System.out.println("=== LABORATÓRIO DE INFORMÁTICA ===");
        System.out.println("Nome: " + nome);
        System.out.println("Localização: " + localizacao);
        System.out.println("Capacidade: " + capacidade + " pessoas");
        System.out.println("Sistema Operacional: " + sistemaOperacional);
        System.out.println("Responsável Técnico: " + responsavelTecnico);
        System.out.println("Internet: " + (temInternet ? "Sim" : "Não"));
        
        System.out.println("Equipamentos:");
        for (String equipamento : equipamentos) {
            System.out.println("  - " + equipamento);
        }
        
        System.out.println("Softwares instalados:");
        for (String software : softwares) {
            System.out.println("  - " + software);
        }
        
        System.out.println("Horários de funcionamento:");
        for (String horario : horarios) {
            System.out.println("  - " + horario);
        }
        System.out.println("================================");
    }
}