import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CampoMinado {
    static String dificuldadeJogo = "Fácil";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Campo Minado");
        Painel painelJogo = new Painel();

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.botaoIniciar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                frame.remove(menuPrincipal.painelMenuPrincipal);
                painelJogo.setNumeroBombas(dificuldadeJogo);
                painelJogo.gerar_celulas();

                frame.add(painelJogo.painel);

                // Garante que o componente seja re-renderizado corretamente
                frame.revalidate();
                frame.repaint();
            }
        });
        menuPrincipal.botaoSair.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                frame.dispose(); // Fecha a aplicação
            }
        });

        menuPrincipal.opcaoDificuldades.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    dificuldadeJogo = (String) menuPrincipal.opcaoDificuldades.getSelectedItem();
                }
            }
        });

        frame.add(menuPrincipal.painelMenuPrincipal);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}