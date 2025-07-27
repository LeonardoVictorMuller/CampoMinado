import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    JPanel painelMenuPrincipal = new JPanel();
    JButton botaoIniciar = new JButton();
    JButton botaoSair = new JButton();
    JButton botaoCompetitivo = new JButton();

    public MenuPrincipal() {
        painelMenuPrincipal.setSize(300, 300);
        painelMenuPrincipal.setLayout(new BoxLayout(painelMenuPrincipal, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel();
        titulo.setText("Campo minado");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoIniciar.setText("Iniciar");

        botaoSair.setText("Sair");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);

         botaoCompetitivo.setText("Competitivo");
        botaoCompetitivo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelMenuPrincipal.add(Box.createVerticalGlue()); // Alinha verticalmente os componentes
        painelMenuPrincipal.add(titulo);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));
        painelMenuPrincipal.add(botaoIniciar);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));
        painelMenuPrincipal.add(botaoSair);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));
        painelMenuPrincipal.add(botaoCompetitivo);
        painelMenuPrincipal.add(Box.createVerticalGlue()); // Alinha verticalmente os componentes
    }
}
