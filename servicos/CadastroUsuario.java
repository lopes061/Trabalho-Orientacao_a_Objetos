package servicos;

import java.util.ArrayList;
import java.util.List;

import elementos.Usuario;

public class CadastroUsuario {
    int numUsuarios;
    private List<Usuario> usuarios;

    public CadastroUsuario(){
        numUsuarios = 0;
        usuarios = new ArrayList<Usuario>();
    }

	public int cadastrarUsuario(Usuario u) {
		boolean cadastrou = usuarios.add(u);
		if (cadastrou) {
			numUsuarios = usuarios.size();
		}
		return numUsuarios;
	}
	
	public Usuario pesquisarUsuario(String email_institucional) {
		for (Usuario u: usuarios) {
			if (u.getEmail_institucional().equalsIgnoreCase(email_institucional)) {
				return u;
			}
		}
		return null;
	}
	
	public boolean removerUsuario(Usuario u) {
		boolean removeu = false; 
		if (usuarios.contains(u)) {
			removeu = usuarios.remove(u);
		}
		return removeu;
	}
	
	public boolean atualizarUsuario(String email_institucional, Usuario u) {
		boolean resposta = false;
		Usuario remover = pesquisarUsuario(email_institucional);
		if (remover != null) {
			usuarios.remove(remover);
			resposta = usuarios.add(u);
		}
		return resposta;
	}
}
