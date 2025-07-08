package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    // Listas estáticas de dados
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<EspacosFisicos> espacos = new ArrayList<>();
    private static final List<Reserva> reservas = new ArrayList<>();

    private void verificarMatriculaExistente(String matricula) throws MatriculaExistenteException {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                throw new MatriculaExistenteException("Matrícula " + matricula + " já cadastrada.");
            }
        }
    }
    private boolean verificarEspacoExiste(String nome, String localizacao){ return false; }

    // Adicionar dados
    public void cadastrarAluno(String nomeCompleto, String email, String telefone, 
                             String senha, String matricula, String curso, int semestre) throws MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new Aluno(nomeCompleto, email, telefone, senha, matricula, curso, semestre));
    }
    public void cadastrarProfessor(String nomeCompleto, String email, String telefone, 
                                 String senha, String matricula, String curso, String cargoAcademico) throws MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new Professor(nomeCompleto, email, telefone, senha, matricula, curso, cargoAcademico));
    }
    public void cadastrarServidorADM(String nomeCompleto, String email, String telefone, 
                                   String senha, String matricula, String funcao, String departamento) throws MatriculaExistenteException {
        verificarMatriculaExistente(matricula);
        usuarios.add(new ServidorADM(nomeCompleto, email, telefone, senha, matricula, funcao, departamento));
    }
    public void cadastrarSalaDeAula(){}
    public void cadastrarLaboratorio(){}
    public void cadastrarSalaDeEstudo(){}

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

    // Pesquisa de dados
    public Usuario getUsuarioEmail(String email){ return usuarios.get(0); }
    public Usuario getUsuarioMatricula(String mat){ return usuarios.get(0); }
    public EspacosFisicos getEspaco(String nome){ return espacos.get(0); }
    public EspacosFisicos getEspaco(int capacidade){ return espacos.get(0); }
    public List<Reserva> getReservasUsuario(Usuario u){ return reservas; }
    public List<Reserva> getReservasEspaco(EspacosFisicos e){ return reservas; }
    public List<Reserva> getReserva(Usuario u, LocalDate data){ return reservas; }
    public List<Reserva> getReserva(EspacosFisicos e, LocalDate data){ return reservas; }
    public List<Reserva> getReserva(Usuario u, EspacosFisicos e){ return reservas; }
}
