package projeto.menus;

import projeto.servicos.Cadastro.CadastroUsuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroUsuario cadastro = new CadastroUsuario();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU DE CADASTRO ===");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Servidor Administrativo");
            System.out.println("4 - Listar Todos");
            System.out.println("5 - Listar por Tipo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome Completo: ");
                    String nomeAluno = sc.nextLine();
                    System.out.print("Email Institucional: ");
                    String emailAluno = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneAluno = sc.nextLine();
                    System.out.print("Senha: ");
                    String senhaAluno = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matriculaAluno = sc.nextLine();
                    System.out.print("Curso: ");
                    String cursoAluno = sc.nextLine();
                    System.out.print("Semestre: ");
                    int semestreAluno = sc.nextInt();
                    sc.nextLine();
                    cadastro.cadastrarAluno(nomeAluno, emailAluno, telefoneAluno, 
                                          senhaAluno, matriculaAluno, cursoAluno, semestreAluno);
                    break;

                case 2:
                    System.out.print("Nome Completo: ");
                    String nomeProf = sc.nextLine();
                    System.out.print("Email Institucional: ");
                    String emailProf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneProf = sc.nextLine();
                    System.out.print("Senha: ");
                    String senhaProf = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matriculaProf = sc.nextLine();
                    System.out.print("Curso: ");
                    String cursoProf = sc.nextLine();
                    System.out.print("Cargo Acadêmico (auxiliar/assistente/adjunto/associado/titular): ");
                    String cargoProf = sc.nextLine();
                    cadastro.cadastrarProfessor(nomeProf, emailProf, telefoneProf, 
                                              senhaProf, matriculaProf, cursoProf, cargoProf);
                    break;

                case 3:
                    System.out.print("Nome Completo: ");
                    String nomeServ = sc.nextLine();
                    System.out.print("Email Institucional: ");
                    String emailServ = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneServ = sc.nextLine();
                    System.out.print("Senha: ");
                    String senhaServ = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matriculaServ = sc.nextLine();
                    System.out.print("Função: ");
                    String funcaoServ = sc.nextLine();
                    System.out.print("Departamento: ");
                    String deptoServ = sc.nextLine();
                    cadastro.cadastrarServidorADM(nomeServ, emailServ, telefoneServ, 
                                                senhaServ, matriculaServ, funcaoServ, deptoServ);
                    break;

                case 4:
                    cadastro.listarTodos();
                    break;

                case 5:
                    System.out.print("Digite o tipo (Aluno/Professor/ServidorADM): ");
                    String tipo = sc.nextLine();
                    cadastro.listarPorTipo(tipo);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}