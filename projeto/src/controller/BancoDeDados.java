package controller;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    private void verificarMatriculaExistente(String matricula) throws MatriculaExistenteException {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                throw new MatriculaExistenteException("Matrícula " + matricula + " já cadastrada.");
            }
        }
    }

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

    public void listarTodos() {
        for (Usuario usuario : usuarios) {
            usuario.exibirInformacoes();
            System.out.println();
        }
    }

    public void listarPorTipo(String tipo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getTipo().equalsIgnoreCase(tipo)) {
                usuario.exibirInformacoes();
                System.out.println();
            }
        }
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
