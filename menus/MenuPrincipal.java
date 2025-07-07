package menus;

import javax.swing.JOptionPane;

public class MenuPrincipal{
    public static int menuOpcoes(){
        String opcoes = "Por favor, digitar apenas o número correspondente à opção desejada:\n\t0 - Sair\n\t1 - Cadastro\n\t2 - Agendamento";

        String escolha = JOptionPane.showInputDialog(null, opcoes, "Selecione uma opção", JOptionPane.QUESTION_MESSAGE);
        int esc = Integer.parseInt(escolha);

        return esc;
    }
}