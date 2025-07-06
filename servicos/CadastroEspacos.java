package servicos;

import java.util.ArrayList;
import java.util.List;

import elementos.EspacosFisicos;

public class CadastroEspacos {
    int numEspacos;
    private List<EspacosFisicos> espacos;

    public CadastroEspacos(){
        numEspacos = 0;
        espacos = new ArrayList<EspacosFisicos>();
    }

	public int cadastrarEspaco(EspacosFisicos e) {
		boolean cadastrou = espacos.add(e);
		if (cadastrou) {
			numEspacos = espacos.size();
		}
		return numEspacos;
	}
	
	public EspacosFisicos pesquisarEspaco(String localizacao) {
		for (EspacosFisicos e: espacos) {
			if (e.getLocalizacao().equalsIgnoreCase(localizacao)) {
				return e;
			}
		}
		return null;
	}
	
	public boolean removerEspaco(EspacosFisicos e) {
		boolean removeu = false; 
		if (espacos.contains(e)) {
			removeu = espacos.remove(e);
		}
		return removeu;
	}
	
	public boolean atualizarUsuario(String localizacao, EspacosFisicos u) {
		boolean resposta = false;
		EspacosFisicos remover = pesquisarEspaco(localizacao);
		if (remover != null) {
			espacos.remove(remover);
			resposta = espacos.add(u);
		}
		return resposta;
	}
}
