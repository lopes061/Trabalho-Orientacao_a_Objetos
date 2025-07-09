package controller;

import javax.swing.JOptionPane;
import java.util.List;
import model.Usuario;
import view.*;

public class Main {
    public static void main(String[] args) throws Exception, Exception, Exception, Exception {
        int opcao = view.menuInicial();

        // Menu inicial
        while (opcao != 0){
            String nome, matricula, senha;
            switch(opcao){
                case 1:
                    // Cadastro usuario
                    String email, telefone, curso, cargo, funcao, departamento;
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
                                BancoDeDados.cadastrarProfessor(nome, email, telefone, senha, matricula, curso, cargo);
                                break;
                            case 3:
                                // Servidor ADM
                                funcao = view.lerFuncao();
                                departamento = view.lerDepartamento();
                                BancoDeDados.cadastrarServidorADM(nome, email, telefone, senha, matricula, funcao, departamento);
                                break;
                        }
                        opcao = view.cadastroOpcoes();
                    }
                    break;
                case 2:
                    // Login
                    matricula = view.lerMatricula();
                    senha = view.lerSenha();
                    Usuario u = BancoDeDados.getUsuarioMatricula(matricula);
                    if(u != null && (u.getSenha() != senha)){
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!\nTente novamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        opcao = view.loginSucesso();
                        String tipo, localizacao;
                        int capacidade;
                        List<String> equipamento;
                        while(opcao != 0){
                            switch (opcao) {
                                case 1:
                                    // Cadastro de espaço físico
                                    tipo = view.lerTipoSala();
                                    nome = view.lerNomeSala();
                                    localizacao = view.lerLocalSala();
                                    capacidade = view.lerCapacidadeSala();
                                    equipamento = view.lerEquipamentos();
                                    BancoDeDados.cadastrarEspaco(nome, localizacao, tipo, capacidade, equipamento);
                                    break;
                                case 2:
                                    // Agendamento
                                    break;
                                case 3:
                                    // Exportar dados
                                    break;
                                case 0:
                                    break;
                                default:
                                    opcaoInv();
                                    break;
                            }
                            opcao = view.loginSucesso();
                        }
                    }
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
