package projeto.entidades.Usuario;

public class Aluno extends Usuario {
    private String curso;
    private int semestre;

    public Aluno(String nomeCompleto, String emailInstitucional, String telefone, 
                String senha, String matricula, String curso, int semestre) {
        super(nomeCompleto, emailInstitucional, telefone, senha, matricula);
        this.curso = curso;
        this.semestre = semestre;
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Aluno");
        System.out.println("Curso: " + curso);
        System.out.println("Semestre: " + semestre);
    }
}