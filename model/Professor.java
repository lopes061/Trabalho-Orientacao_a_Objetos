package projeto.entidades.Usuario;

public class Professor extends Usuario {
    private String curso;
    private String cargoAcademico; // auxiliar, assistente, adjunto, associado ou titular

    public Professor(String nomeCompleto, String emailInstitucional, String telefone, 
                    String senha, String matricula, String curso, String cargoAcademico) {
        super(nomeCompleto, emailInstitucional, telefone, senha, matricula);
        this.curso = curso;
        this.cargoAcademico = cargoAcademico;
    }

    public String getTipo() {
        return "Professor";
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Professor");
        System.out.println("Curso: " + curso);
        System.out.println("Cargo Acadêmico: " + cargoAcademico);
    }
}