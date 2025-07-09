package controller;

import model.EspacosFisicos;
import projeto.View.view;
import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class Agendamento {

    // caso nao tenha espacos disponiveis 
    public static UUID getIdEspacoSelecionado(List<EspacosFisicos> espacos, String tipoEspaco) {
        if (espacos == null || espacos.isEmpty()) {
            view.exibirMensagem("Não há espaços físicos do tipo " + tipoEspaco + " disponíveis para agendamento.");
            return null;
        }
        // mapa para pode associar o numero do usuario com o numero do objeto
        Map<Integer, EspacosFisicos> mapaEspacos = new HashMap<>();
        StringBuilder sb = new StringBuilder("Espaços Físicos do tipo " + tipoEspaco + " disponíveis:\n");
        int i = 1;
        for (EspacosFisicos espaco : espacos) {
            sb.append(i).append(" - ").append(espaco.getNome()).append(" (Capacidade: ").append(espaco.getCapacidade()).append(")\n");
            mapaEspacos.put(i, espaco);
            i++;
        }
        // pegar escolha do usuario 
        int escolhaUsuario = view.listarEspacos(sb.toString());
        // se a escolha for válida retorna o id do objeto espaço físico 
        if (mapaEspacos.containsKey(escolhaUsuario)) {
            return mapaEspacos.get(escolhaUsuario).getId();
        } else if (escolhaUsuario != -1){
            view.exibirMensagem("Opção inválida. Por favor, selecione um número da lista.");
            return null;
        } else {
            return null;
        }
    }
}