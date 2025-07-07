package model;

public class Usuario {
    protected String nomeCompleto;
    protected String emailInstitucional;
    protected String telefone;
    protected String senha;
    protected String matricula;

    public Usuario(String nomeCompleto, String emailInstitucional, String telefone, 
                 String senha, String matricula) {
        this.nomeCompleto = nomeCompleto;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.senha = senha;
        this.matricula = matricula;
    }

    public String getTipo(){ return "Usuario"; }

    public void exibirInformacoes() {
        System.out.println("\nNome: " + nomeCompleto);
        System.out.println("Email: " + emailInstitucional);
        System.out.println("Telefone: " + telefone);
        System.out.println("Matrícula: " + matricula);
    }

    // Getters
    public String getNomeCompleto() { return nomeCompleto; }
    public String getMatricula() { return matricula; }
    public String getEmailInstitucional() { return emailInstitucional; }
    public String getTelefone() { return telefone; }
    public String getSenha(){ return senha; }
}