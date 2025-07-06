package elementos;

public abstract class Servidores extends Usuario {
    protected String matricula_institucional;
    public Servidores(String matricula_institucional,String nome,String email_institucional
    ,String telefone,String senha)
    {
        super(nome,email_institucional,telefone,senha);
        this.matricula_institucional = matricula_institucional;
    }
    public String getMatricula_institucional() {
        return matricula_institucional;
    }

    public void setMatriculaInstitucional(String matricula_institucional) {
        this.matricula_institucional = matricula_institucional;
    }
}
