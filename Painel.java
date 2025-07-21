import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

public class Painel {
    static int linhas = 10;
    static int colunas = 10;
    static int x = 10;
    static int y = 10;

    JPanel painel = new JPanel();

    static Color corDeFundo = new Color(0xd9Dff6);
    Celula[][] celula;
    static int contador = 0;

    public Painel() {
        painel.setLayout(new GridLayout(linhas, colunas));
    }

    public void gerar_celulas() {
        // zera as celulas
        painel.removeAll();
        celula = new Celula[linhas][colunas];

        // Inicializa todas as células
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celula[i][j] = new Celula();
                painel.add(celula[i][j]);
            }
        }

        // Garante que o componente seja re-renderizado corretamente ao recriar as celulas no painel
        painel.revalidate();
        painel.repaint();

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
                            if(contador == 0 && celula[x][y].qtdBomba != 0){
                                return;
                            }

                            if (celula[x][y].temBomba) {
                                celula[x][y].setText("💣");
                                celula[x][y].setFont(new Font("SansSerif", Font.PLAIN, 50)); // Tamanho 24, você pode ajustar
                                celula[x][y].setForeground(Color.black); // Cor vermelha
                                // fim de jogo
                                JOptionPane.showMessageDialog(null, "Você perdeu!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
                                gerar_celulas();
                            } else {
                                mostrar(x,y);
                                if(contador==90)
                                    JOptionPane.showMessageDialog(null, "Você ganhou!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
                                if(celula[x][y].qtdBomba == 0){
                                    desbloquear(x, y);
                                    if(contador==90)
                                        JOptionPane.showMessageDialog(null, "Você ganhou!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
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
    }

    public void desbloquear(int x, int y) {
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
    public void mostrar(int x, int y) {
        contador++;
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