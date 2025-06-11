package projeto;

public abstract class Usuario {

    protected String nome,email_institucional,telefone, senha;

    public Usuario( String nome,String email_institucional
    ,String telefone,String senha)
    {
        this.nome = nome;
        this.email_institucional = email_institucional;
        this.telefone = telefone;
        this.senha = senha;
    }

    public String imprimir()
    {
        String resposta = "";
        return resposta;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


