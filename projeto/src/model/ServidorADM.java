package model;

public class ServidorADM extends Usuario {
    private String funcao;
    private String departamento;

    public ServidorADM(String nomeCompleto, String emailInstitucional, String telefone, 
                     String senha, String matricula, String funcao, String departamento) {
        super(nomeCompleto, emailInstitucional, telefone, senha, matricula);
        this.funcao = funcao;
        this.departamento = departamento;
    }

    public String getTipo() {
        return "ServidorADM";
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Servidor Administrativo");
        System.out.println("Função: " + funcao);
        System.out.println("Departamento: " + departamento);
    }

    public String getFuncao(){ return funcao; }
    public String getDepartamento(){ return departamento; }
}