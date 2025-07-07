package projeto.controller;

import projeto.model.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarAluno(String nomeCompleto, String email, String telefone, 
                             String senha, String matricula, String curso, int semestre) {
        usuarios.add(new Aluno(nomeCompleto, email, telefone, senha, matricula, curso, semestre));
    }

    public void cadastrarProfessor(String nomeCompleto, String email, String telefone, 
                                 String senha, String matricula, String curso, String cargoAcademico) {
        usuarios.add(new Professor(nomeCompleto, email, telefone, senha, matricula, curso, cargoAcademico));
    }

    public void cadastrarServidorADM(String nomeCompleto, String email, String telefone, 
                                   String senha, String matricula, String funcao, String departamento) {
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

    // Método para obter lista de usuários 
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios); // Retorna uma cópia (nao mod o original)
    }
}