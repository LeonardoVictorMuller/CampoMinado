import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CampoMinado {
    protected static boolean comp;
    protected static double tempoInicio;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Campo Minado");
        Painel painelJogo = new Painel();
        painelJogo.gerar_celulas();

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.botaoIniciar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                frame.remove(menuPrincipal.painelMenuPrincipal);
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
        menuPrincipal.botaoCompetitivo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                tempoInicio = System.currentTimeMillis();
                comp = true;
                frame.remove(menuPrincipal.painelMenuPrincipal);
                frame.add(painelJogo.painel);
                
                // Garante que o componente seja re-renderizado corretamente
                frame.revalidate();
                frame.repaint();
                
            }
        });

        frame.add(menuPrincipal.painelMenuPrincipal);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}