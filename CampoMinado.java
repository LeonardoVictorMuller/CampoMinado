import javax.swing.*;
import java.awt.event.MouseEvent; 
import java.util.HashSet;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

public class CampoMinado {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campo Minado");
        int linhas = 10;
        int colunas = 10;
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(linhas, colunas));

        class Celula extends JButton {
            boolean temBomba = false;
            boolean revelada = false;
            boolean marcada = false;

            public Celula() {
                super();
            }
        }
        
        Celula[][] celula = new Celula[linhas][colunas];

        // Inicializa todas as células
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celula[i][j] = new Celula();
                painel.add(celula[i][j]);
            }
        }

        int[] numeros = new int[10];
        HashSet<Integer> usados = new HashSet<>();
        Random rand = new Random();

        int d = 0;
        while (d < 10) {
            int num = rand.nextInt(100); // Gera 10 números entre 0 e 99 que vao ser os lugares da bomba
            if (!usados.contains(num)) {
                usados.add(num);
                numeros[d] = num;
                d++;
            }
        }

        for (int n : numeros) {
            int g = n / 10;
            int h = n % 10;
            celula[g][h].temBomba = true;
        }

        for (int i=0; i < linhas; i++) {
            for ( int j=0; j < colunas; j++) {
            final int x = i;
            final int y = j;
            celula[x][y].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton((java.awt.event.MouseEvent) e)) {
                        if (celula[x][y].temBomba) {
                            celula[x][y].setText("💣");
                            // fim de jogo
                        } else {
                            celula[x][y].setText("0"); // ou contagem de bombas ao redor
                        }
                    } else if (SwingUtilities.isRightMouseButton((java.awt.event.MouseEvent) e)) {
                        celula[x][y].setText("🚩");
                    }
                }
            });
            }
        };
        

        
        frame.add(painel);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
}
