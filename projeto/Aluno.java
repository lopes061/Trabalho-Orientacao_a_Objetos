package projeto;

public class Aluno extends Usuario {
    private String curso;
    private String matricula;
    private int semestre;

    public Aluno(String nome,String email_institucional
    ,String telefone,String senha,String curso,
    String matricula,int semestre)
    {
        super(nome,email_institucional,telefone,senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
    }

     public String imprimir() {
        return "Aluno: " + nome + "\n" +
               "Email: " + email_institucional + "\n" +
               "Telefone: " + telefone + "\n" +
               "Curso: " + curso + "\n" +
               "Matrícula: " + matricula + "\n" +
               "Semestre: " + semestre + "\n";
    }
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
