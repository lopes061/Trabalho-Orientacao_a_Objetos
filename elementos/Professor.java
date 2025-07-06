package elementos;

public class Professor extends Servidores {
    private String curso;
    private String cargoAcademico;

    public Professor(String nome, String email_institucional, String telefone, String senha,
                 String matricula_institucional, String curso, String cargoAcademico) {
    super(matricula_institucional, nome, email_institucional, telefone, senha);
    this.curso = curso;
    this.cargoAcademico = cargoAcademico;
}



    public String imprimir() {
        return "Professor: " + nome + "\n" +
               "Email: " + email_institucional + "\n" +
               "Telefone: " + telefone + "\n" +
               "Matrícula Institucional: " + matricula_institucional + "\n" +
               "Curso Ministrado: " + curso + "\n" +
               "Cargo Acadêmico: " + cargoAcademico+ "\n";
    }
     public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCargoAcademico() {
        return cargoAcademico;
    }

    public void setCargoAcademico(String cargoAcademico) {
        this.cargoAcademico = cargoAcademico;
    }
}
