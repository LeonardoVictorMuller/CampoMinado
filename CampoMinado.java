import javax.swing.*;
// import java.awt.event.MouseEvent;
// import java.util.HashSet;
// import java.util.Random;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.GridLayout;
// import java.awt.event.MouseAdapter;

public class CampoMinado {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campo Minado");
        Painel painel = new Painel();
        painel.gerar_celulas();

        frame.add(painel.painel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}