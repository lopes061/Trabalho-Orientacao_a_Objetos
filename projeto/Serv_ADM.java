package projeto;

public class Serv_ADM extends Servidores {
    private String cargo,departamento;

    public Serv_ADM(String matricula_institucional,String nome,String email_institucional
    ,String telefone,String senha,String cargo,
    String departamento)
    {
        super( matricula_institucional, nome, email_institucional
    , telefone, senha);
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public String imprimir() {
         return "Técnico Administrativo: " + nome + "\n" +
               "Email: " + email_institucional + "\n" +
               "Telefone: " + telefone + "\n" +
               "Matrícula Institucional: " + matricula_institucional + "\n" +
               "Cargo: " + cargo + "\n" +
               "Departamento: " + departamento + "\n";
    }
}
