package controller;

import model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.CadastroExceptions.TelefoneInvalidoException;
import model.CadastroExceptions.MatriculaInvalidaException;
import model.CadastroExceptions.SemestreInvalidoException;
import model.CadastroExceptions.MatriculaExistenteException;
import model.CadastroExceptions.EspacoExistenteException;


public class BancoDeDados {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<EspacosFisicos> espacos = new ArrayList<>();
    private static final List<Reserva> reservas = new ArrayList<>();


    private static void verificarMatriculaExistente(String matricula) throws MatriculaExistenteException {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                throw new MatriculaExistenteException("Matrícula " + matricula + " já cadastrada.");
            }
        }
    }
    private static void verificarEspacoExiste(String nome, String localizacao) throws EspacoExistenteException {
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getNome().equalsIgnoreCase(nome) && espaco.getLocal().equalsIgnoreCase(localizacao)) {
                throw new EspacoExistenteException("Espaço '" + nome + "' em '" + localizacao + "' já existe.");
            }
        }
    }

    private static void validarTelefone(String telefone) throws TelefoneInvalidoException {
        if (!telefone.matches("\\d+")) {
            throw new TelefoneInvalidoException("Telefone deve conter apenas números.");
        }
    }

    private static void validarMatricula(String matricula) throws MatriculaInvalidaException {
        if (!matricula.matches("\\d+")) {
            throw new MatriculaInvalidaException("Matrícula deve conter apenas números.");
        }
    }

    public static void cadastrarAluno(String nomeCompleto, String email, String telefone,
                             String senha, String matricula, String curso, int semestre)
                             throws MatriculaExistenteException, TelefoneInvalidoException, MatriculaInvalidaException, SemestreInvalidoException {
        validarTelefone(telefone);
        validarMatricula(matricula);
        if (semestre != 1 && semestre != 2) {
            throw new SemestreInvalidoException("Semestre deve ser 1 ou 2.");
        }
        verificarMatriculaExistente(matricula);
        usuarios.add(new Aluno(nomeCompleto, email, telefone, senha, matricula, curso, semestre));
    }

    public static void cadastrarProfessor(String nomeCompleto, String email, String telefone,
                                 String senha, String matricula, String curso, String cargoAcademico)
                                 throws MatriculaExistenteException, TelefoneInvalidoException, MatriculaInvalidaException {
        validarTelefone(telefone);
        validarMatricula(matricula);
        verificarMatriculaExistente(matricula);
        usuarios.add(new Professor(nomeCompleto, email, telefone, senha, matricula, curso, cargoAcademico));
    }

    public static void cadastrarServidorADM(String nomeCompleto, String email, String telefone,
                                   String senha, String matricula, String funcao, String departamento)
                                   throws MatriculaExistenteException, TelefoneInvalidoException, MatriculaInvalidaException {
        validarTelefone(telefone);
        validarMatricula(matricula);
        verificarMatriculaExistente(matricula);
        usuarios.add(new ServidorADM(nomeCompleto, email, telefone, senha, matricula, funcao, departamento));
    }

    public static EspacosFisicos cadastrarEspaco(String nome, String localizacao, String tipo, int capacidade, List<String> equipamentos) throws EspacoExistenteException {
        verificarEspacoExiste(nome, localizacao);
        EspacosFisicos e = new EspacosFisicos(nome, localizacao, tipo, capacidade, equipamentos);
        espacos.add(e);
        // System.out.println(tipo + " cadastrado com sucesso!");
        return e;
    }

    public static void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public static List<Usuario> getTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }
    public static List<EspacosFisicos> getTodosEspacos(){
        return new ArrayList<>(espacos);
    }

    public static List<Reserva> getTodasReservas(){
        return new ArrayList<>(reservas);
    }


    public static Usuario getUsuarioEmail(String email){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmailInstitucional().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }
    public static Usuario getUsuarioMatricula(String mat){
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(mat)) {
                return usuario;
            }
        }
        return null;
    }
    public static EspacosFisicos getEspaco(String nome){
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getNome().equalsIgnoreCase(nome)) {
                return espaco;
            }
        }
        return null;
    }

    public static EspacosFisicos getEspacoPorId(UUID id) {
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getId().equals(id)) {
                return espaco;
            }
        }
        return null;
    }

    public static List<EspacosFisicos> getEspacosPorCapacidadeMinima(int capacidade) {
        List<EspacosFisicos> espacosAtendendoCapacidade = new ArrayList<>();
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getCapacidade() >= capacidade) {
                espacosAtendendoCapacidade.add(espaco);
            }
        }
        return espacosAtendendoCapacidade;
    }

    public static List<EspacosFisicos> getEspacoPorTipo(String tipo) {
        List<EspacosFisicos> espacosDoTipo = new ArrayList<>();
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getTipo().equalsIgnoreCase(tipo)) {
                espacosDoTipo.add(espaco);
            }
        }
        return espacosDoTipo;
    }

    public static List<Reserva> getReserva(EspacosFisicos e, LocalDate inicio, LocalDate fim) {
        List<Reserva> reservasFiltradas = new ArrayList<>();

        LocalDateTime inicioPeriodo = inicio.atStartOfDay();
        LocalDateTime fimPeriodo = fim.atTime(23, 59, 59);

        for (Reserva reserva : reservas) {

            if (reserva.getEspaco().equals(e)) {
                LocalDateTime dataReservaInicio = reserva.getInicioFim()[0];
                LocalDateTime dataReservaFim = reserva.getInicioFim()[1];

                
                if (!(dataReservaFim.isBefore(inicioPeriodo) || dataReservaInicio.isAfter(fimPeriodo))) {
                    reservasFiltradas.add(reserva);
                }
            }
        }
        return reservasFiltradas;
    }

    
    public static List<Reserva> getReserva(EspacosFisicos e, LocalDate dia) {
        List<Reserva> reservasFiltradas = new ArrayList<>();
        for (Reserva reserva : reservas) {
           
            if (reserva.getEspaco().equals(e) && reserva.getInicioFim()[0].toLocalDate().equals(dia)) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }


    public static Reserva getReserva(UUID id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }
        return null; 
    }

    public static Usuario fazerLogin(String matricula, String senha){
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                if(usuario.getSenha().equals(senha)){
                    return usuario;
                }
            }
        }
        return null;
    }

    public static List<Reserva> getReservasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        List<Reserva> reservasNoPeriodo = new ArrayList<>();
        LocalDateTime inicioPeriodo = dataInicial.atStartOfDay();
        LocalDateTime fimPeriodo = dataFinal.atTime(23, 59, 59);

        for (Reserva reserva : reservas) {
            LocalDateTime dataReservaInicio = reserva.getInicioFim()[0];
            LocalDateTime dataReservaFim = reserva.getInicioFim()[1];

            if (!(dataReservaFim.isBefore(inicioPeriodo) || dataReservaInicio.isAfter(fimPeriodo))) {
                reservasNoPeriodo.add(reserva);
            }
        }
        return reservasNoPeriodo;
    }
    }

