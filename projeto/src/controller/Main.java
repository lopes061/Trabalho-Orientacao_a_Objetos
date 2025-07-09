package controller;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.CadastroExceptions.DiasExcedidosException;
import model.CadastroExceptions.HorarioIndisponivelException;
import model.EspacosFisicos;
import model.Reserva;
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
                                    // Exceções para agendamento
                                     try {
                                        Agendamento.iniciarAgendamento(u);
                                    } catch (HorarioIndisponivelException | DiasExcedidosException e) {
                                        view.exibirMensagem("Erro no agendamento: " + e.getMessage());
                                    }
                                    break;
                                case 3:
                                    // Exportar dados
                                    exportarDadosTxt();
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

    private static void exportarDadosTxt() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para exportar (ex: dados.txt):");

        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            view.exibirMensagem("Exportação cancelada. Nome do arquivo não fornecido.");
            return;
        }

        if (!nomeArquivo.toLowerCase().endsWith(".txt")) {
            nomeArquivo += ".txt";
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Escreve os dados dos usuários
            writer.println("===== DADOS DOS USUÁRIOS =====");
            List<Usuario> usuarios = BancoDeDados.getTodosUsuarios(); // Usando getTodosUsuarios()
            if (usuarios.isEmpty()) {
                writer.println("Nenhum usuário cadastrado.");
            } else {
                for (Usuario user : usuarios) {
                    writer.println("Tipo: " + user.getTipo() +
                                   " | Nome: " + user.getNomeCompleto() +
                                   " | Matrícula: " + user.getMatricula() +
                                   " | Email: " + user.getEmailInstitucional() +
                                   " | Telefone: " + user.getTelefone());
                }
            }
            writer.println("\n"); 

            // Escreve os dados das reservas
            writer.println("===== DADOS DAS RESERVAS =====");
            List<Reserva> reservas = BancoDeDados.getTodasReservas(); // Usando getTodasReservas()
            if (reservas.isEmpty()) {
                writer.println("Nenhuma reserva realizada.");
            } else {
                for (Reserva reserva : reservas) {
                    EspacosFisicos espaco = reserva.getEspaco();
                    Usuario usuarioReserva = reserva.getUsuario();

                    writer.println("ID Reserva: " + reserva.getId() +
                                   " | Espaço: " + (espaco != null ? espaco.getNome() : "N/A") +
                                   " | Tipo Espaço: " + (espaco != null ? espaco.getTipo() : "N/A") +
                                   " | Usuário: " + (usuarioReserva != null ? usuarioReserva.getNomeCompleto() : "N/A") +
                                   " | Matrícula Usuário: " + (usuarioReserva != null ? usuarioReserva.getMatricula() : "N/A") +
                                   " | Horário: " + reserva.getHorario() +
                                   " | Status: " + reserva.getStatus());
                }
            }

            view.exibirMensagem("Dados exportados com sucesso para " + nomeArquivo);

        } catch (IOException e) {
            view.exibirMensagem("Erro ao exportar dados: " + e.getMessage()); 
        }
    }
}

