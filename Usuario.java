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
   
}


