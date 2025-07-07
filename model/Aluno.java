package projeto.model;

public class Aluno extends Usuario {
    private String curso;
    private int semestre;

    public Aluno(String nomeCompleto, String emailInstitucional, String telefone, 
                String senha, String matricula, String curso, int semestre) {
        super(nomeCompleto, emailInstitucional, telefone, senha, matricula);
        this.curso = curso;
        this.semestre = semestre;
    }

    
    public String getTipo() {
        return "Aluno";
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Aluno");
        System.out.println("Curso: " + curso);
        System.out.println("Semestre: " + semestre);
    }

    public String getCurso() { return curso; }
    public int getSemestre() { return semestre; }
}
