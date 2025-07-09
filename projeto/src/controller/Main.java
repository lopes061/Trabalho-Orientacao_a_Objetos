package controller;

import javax.swing.JOptionPane;

import view.*;

public class Main {
    public static void main(String[] args) {
        int opcao = view.menuInicial();

        while (opcao != 0){
            switch(opcao) {
                case 1:
                    // Cadastro usuario
                    String nome, email, telefone, senha, matricula, curso, cargo, funcao, departamento;
                    int semestre;
                    opcao = view.cadastroOpcoes();
                    while(opcao != 0){
                        if(opcao < 0 || opcao > 3){
                            opcaoInv();
                            break;
                        }
                        nome = view.lerNome();
                        email = view.lerEmail();
                        telefone = view.lerTelefone();
                        senha = view.lerSenha();
                        matricula = view.lerMatricula();
                        switch (opcao) {
                            case 1:
                                // Aluno
                                curso = view.lerCurso();
                                semestre = view.lerSemestre();
                                BancoDeDados.cadastrarAluno(nome, email, telefone, senha, matricula, curso, semestre);
                                break;
                            case 2:
                                // Professor
                                curso = view.lerCurso();
                                cargo = view.lerCargo();
                                BancoDeDados.cadastrarProfessor(nome, email, telefone, senha, matricula, cursoP, cargo);
                                break;
                            case 3:
                                // Servidor ADM
                                funcao = view.lerFuncao();
                                departamento = view.lerDepartamento();
                                BancoDeDados.cadastrarServidorADM(nome, email, telefone, senha, matricula, funcao, departamento);
                                break;
                        }
                    }

                    break;
                case 2:
                    // Login
                case 0:
                    break;
                default:
                    opcaoInv();
                    break;
            }
            opcao = view.menuInicial();
        }
    }

    public static void opcaoInv(){ JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro!", JOptionPane.ERROR_MESSAGE); }
}
