import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;


public class CampoMinado {
    static int linhas = 10;
    static int colunas = 10;
    static Color corDeFundo = new Color(0xd9Dff6);
    static Celula[][] celula = new Celula[linhas][colunas];

    public static void main(String[] args) {

        JFrame frame = new JFrame("Campo Minado");

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(linhas, colunas));


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

            for(int m1 = -1; m1 < 2; m1++){
                    for(int m2 = -1; m2 < 2; m2++){
                        try {
                            if(celula[x+m1][y+m2].temBomba)   //da erro
                            celula[x][y].qtdBomba ++;
                        } catch (Exception e) {}
                    }
                }
            celula[x][y].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton((java.awt.event.MouseEvent) e)) {
                        if (celula[x][y].temBomba) {
                            celula[x][y].setText("💣");
                            // fim de jogo
                        } else {
                            mostrar(x,y);
                            if(celula[x][y].qtdBomba == 0){
                                // for(int m1 = -1; m1 < 2; m1++){
                                //     for(int m2 = -1; m2 < 2; m2++){
                                //         if(celula[x+m1][y+m2].qtdBomba == 0) {  //da erro
                                //             try {
                                //                 celula[x+m1][y+m2].setText(String.valueOf(celula[x][y].qtdBomba));
                                //                 celula[x+m1][y+m2].setFont(new Font("SansSerif", Font.PLAIN, 50)); // Tamanho 24, você pode ajustar
                                //                 celula[x+m1][y+m2].setForeground(Color.BLUE); // Cor vermelha
                                //                 celula[x+m1][y+m2].setBackground(Color.GRAY); // quero que ele desbloqueie todos os 0 por perto igual no campo minado
                                //             } catch (Exception er) {}
                                //     }
                                //     }
                                // }
                                desbloquear(x, y);
                            }
                        }
                    } else if (SwingUtilities.isRightMouseButton((java.awt.event.MouseEvent) e)) {
                        celula[x][y].setText("🚩");
                        celula[x][y].setFont(new Font("SansSerif", Font.PLAIN, 50)); // Tamanho 24, você pode ajustar
                        celula[x][y].setForeground(Color.RED); // Cor vermelha
                    }

                }
            });
            }

        };




        frame.add(painel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void desbloquear(int x, int y) {
        for (int m1 = -1; m1 < 2; m1++) {
            for (int m2 = -1; m2 < 2; m2++) {
                int nx = x + m1;
                int ny = y + m2;
                try {
                    if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
                        if (!celula[nx][ny].getText().equals("")) continue; // já revelada

                        mostrar(nx,ny);

                        if (celula[nx][ny].qtdBomba == 0) {
                            desbloquear(nx, ny); // chamada recursiva
                        }
                    }
                } catch (Exception ignored) {}
            }
        }
    }
    public static void mostrar(int x, int y) {
        Color numero = Color.BLUE;
        if(celula[x][y].qtdBomba == 1 || celula[x][y].qtdBomba == 0) numero = Color.BLUE;
        else if(celula[x][y].qtdBomba == 2) numero = Color.GREEN;
        else if(celula[x][y].qtdBomba == 3) numero = Color.RED;
        else numero = Color.MAGENTA;
        celula[x][y].setText(String.valueOf(celula[x][y].qtdBomba)); // ou contagem de bombas ao redor
        celula[x][y].setFont(new Font("SansSerif", Font.PLAIN, 50));
        celula[x][y].setForeground(numero); // Cor vermelha
        celula[x][y].setBackground(corDeFundo);
    }

}