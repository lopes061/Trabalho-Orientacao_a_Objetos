package controller;

import javax.swing.JOptionPane;
import model.CadastroExceptions.HorarioIndisponivelException;
import model.CadastroExceptions.DiasExcedidosException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.*;
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
                        do{
                        nome = view.lerNome();
                        email = view.lerEmail();
                        telefone = view.lerTelefone();
                        senha = view.lerSenha();
                        matricula = view.lerMatricula();
                        if (nome == null || email == null || telefone == null || senha == null || matricula == null) {
                            JOptionPane.showMessageDialog(null, "Por favor insira dados validos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                        }
                        }while(nome == null || email == null || telefone == null || senha == null || matricula == null);
                        switch (opcao) {

                            case 1:
                                do{
                                // Aluno
                                curso = view.lerCurso();
                                semestre = view.lerSemestre();
                                
                                    if (curso == null) {
                                        JOptionPane.showMessageDialog(null, "Por favor insira dados validos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                    }
                                }while(curso == null);

                                BancoDeDados.cadastrarAluno(nome, email, telefone, senha, matricula, curso, semestre);

                                break;
                            case 2:
                                do{
                                // Professor
                                curso = view.lerCurso();
                                cargo = view.lerCargo();

                                    if (curso == null || cargo == null) {
                                        JOptionPane.showMessageDialog(null, "Por favor insira dados validos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                    }
                                }while(curso == null || cargo == null);

                                BancoDeDados.cadastrarProfessor(nome, email, telefone, senha, matricula, curso, cargo);

                                break;
                            case 3:
                                do{
                                // Servidor ADM
                                funcao = view.lerFuncao();
                                departamento = view.lerDepartamento();

                                    if (funcao == null || departamento == null) {
                                        JOptionPane.showMessageDialog(null, "Por favor insira dados validos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                    }
                                }while(funcao == null || departamento == null);

                                BancoDeDados.cadastrarServidorADM(nome, email, telefone, senha, matricula, funcao, departamento);

                                break;
                        }

                        opcao = view.cadastroOpcoes();
                    }

                    break;
                case 2:
                    do{
                    // Login
                    matricula = view.lerMatricula();
                    senha = view.lerSenha();
                    if(matricula == null || senha == null){
                        JOptionPane.showMessageDialog(null, "Por favor insira Usuario/Senha validos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(matricula == null || senha == null);
                    Usuario u = BancoDeDados.fazerLogin(matricula, senha);

                    if(u == null){
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!\nTente novamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        opcao = view.loginSucesso();

                        String tipo, localizacao;
                        int capacidade;
                        List<String> equipamento;

                        while(opcao != 0){

                            EspacosFisicos espaco;
                            String msg;
                            switch (opcao) {
                                case 1:
                                    do{
                                    // Cadastro de espaço físico
                                    tipo = view.lerTipoSala();
                                    nome = view.lerNomeSala();
                                    localizacao = view.lerLocalSala();
                                    capacidade = view.lerCapacidadeSala();
                                    equipamento = view.lerEquipamentos();
                                    if (tipo == null || nome == null || localizacao == null || capacidade < 1 || equipamento == null) {
                                        JOptionPane.showMessageDialog(null, "Por favor insira valores validos nos campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                    }

                                    }while(tipo == null || nome == null || localizacao == null || capacidade < 1 || equipamento == null);
                                    espaco = BancoDeDados.cadastrarEspaco(nome, localizacao, tipo, capacidade, equipamento);
                                    msg = EspacoController.getInfoCadastro(espaco);

                                    JOptionPane.showMessageDialog(null, msg, "Cadastro de espaço", JOptionPane.INFORMATION_MESSAGE);
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

