package controller;

import model.*; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<EspacosFisicos> espacos = new ArrayList<>();
    private static final List<Reserva> reservas = new ArrayList<>();

    private void verificarMatriculaExistente(String matricula) throws CadastroExceptions.MatriculaExistenteException {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                throw new CadastroExceptions.MatriculaExistenteException("Matrícula " + matricula + " já cadastrada.");
            }
        }
    }
    private void verificarEspacoExiste(String nome, String localizacao) throws CadastroExceptions.EspacoExistenteException {
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getNome().equalsIgnoreCase(nome) && espaco.getLocal().equalsIgnoreCase(localizacao)) {
                throw new CadastroExceptions.EspacoExistenteException("Espaço '" + nome + "' em '" + localizacao + "' já existe.");
            }
        }
    }

    // Adicionar dados
    public void cadastrarAluno(String nomeCompleto, String email, String telefone,
                             String senha, String matricula, String curso, int semestre) throws CadastroExceptions.MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new Aluno(nomeCompleto, email, telefone, senha, matricula, curso, semestre));
    }
    public void cadastrarProfessor(String nomeCompleto, String email, String telefone,
                                 String senha, String matricula, String curso, String cargoAcademico) throws CadastroExceptions.MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new Professor(nomeCompleto, email, telefone, senha, matricula, curso, cargoAcademico));
    }
    public void cadastrarServidorADM(String nomeCompleto, String email, String telefone,
                                   String senha, String matricula, String funcao, String departamento) throws CadastroExceptions.MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new ServidorADM(nomeCompleto, email, telefone, senha, matricula, funcao, departamento));
    }

    public void cadastrarEspaco(String nome, String localizacao, String tipo, int capacidade, List<String> equipamentos) throws CadastroExceptions.EspacoExistenteException {
        verificarEspacoExiste(nome, localizacao); // Lança EspacoExistenteException se já existir
        espacos.add(new EspacosFisicos(nome, localizacao, tipo, capacidade, equipamentos));
        System.out.println(tipo + " cadastrado com sucesso!");
    }

    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
    }


    // Acesso aos dados
    public List<Usuario> getTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }
    public List<EspacosFisicos> getTodosEspacos(){
        return new ArrayList<>(espacos);
    }
    public List<Reserva> getTodasReservas(){
        return new ArrayList<>(reservas);
    }

    
    public Usuario getUsuarioEmail(String email){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmailInstitucional().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }
    public Usuario getUsuarioMatricula(String mat){
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(mat)) {
                return usuario;
            }
        }
        return null;
    }
    public EspacosFisicos getEspaco(String nome){
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getNome().equalsIgnoreCase(nome)) {
                return espaco;
            }
        }
        return null;
    }
    public EspacosFisicos getEspaco(int capacidade){
        for (EspacosFisicos espaco : espacos) {
            if (espaco.getCapacidade() >= capacidade) {
                return espaco;
            }
        }
        return null;
    }
    public List<Reserva> getReservasUsuario(Usuario u){
        List<Reserva> reservasDoUsuario = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(u)) {
                reservasDoUsuario.add(reserva);
            }
        }
        return reservasDoUsuario;
    }
    public List<Reserva> getReservasEspaco(EspacosFisicos e){
        List<Reserva> reservasDoEspaco = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getEspaco().equals(e)) {
                reservasDoEspaco.add(reserva);
            }
        }
        return reservasDoEspaco;
    }
    public List<Reserva> getReserva(Usuario u, LocalDate data){
        List<Reserva> reservasFiltradas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(u) && reserva.getInicioFim()[0].toLocalDate().equals(data)) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }
    public List<Reserva> getReserva(EspacosFisicos e, LocalDate data){
        List<Reserva> reservasFiltradas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getEspaco().equals(e) && reserva.getInicioFim()[0].toLocalDate().equals(data)) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }
    public List<Reserva> getReserva(Usuario u, EspacosFisicos e){
        List<Reserva> reservasFiltradas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(u) && reserva.getEspaco().equals(e)) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }
}