package projeto.servicos.Cadastro;

import projeto.entidades.Usuario.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public CadastroUsuario() {
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
}