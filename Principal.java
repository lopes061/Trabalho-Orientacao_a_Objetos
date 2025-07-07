import javax.swing.JOptionPane;

import menus.MenuPrincipal;

public class Principal {
    public static void main(String[] args) {
        int opcao = 0;

        do{
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 0:                    
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Por favor aguarde, cadastro em desenvolvimento", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Por favor aguarde, agendamento em desenvolvimento", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 0);

        return;
    }
}
