import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    JPanel painelMenuPrincipal = new JPanel();
    JButton botaoIniciar = new JButton();
    JButton botaoSair = new JButton();
    final String[] dificuldades = {"Fácil", "Médio", "Difícil", "Impossível"};
    JComboBox<String> opcaoDificuldades = new JComboBox<>(dificuldades);
    JButton botaoCompetitivo = new JButton();

    public MenuPrincipal() {
        painelMenuPrincipal.setSize(300, 300);
        painelMenuPrincipal.setLayout(new BoxLayout(painelMenuPrincipal, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel();
        titulo.setText("Campo minado");
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoIniciar.setText("Iniciar");
        botaoIniciar.setBackground(new Color(0xe0e0e0));

        botaoSair.setText("Sair");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setBackground(new Color(0xe0e0e0));

        JLabel labelDificuldade = new JLabel();
        labelDificuldade.setText("Escolha a dificuldade: ");
        labelDificuldade.setAlignmentX(Component.CENTER_ALIGNMENT);

        opcaoDificuldades.setMaximumSize(new Dimension(100, 30));

        botaoCompetitivo.setText("Competitivo");
        botaoCompetitivo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCompetitivo.setBackground(new Color(0xe0e0e0));

        // Box.createVerticalStrut serve para colocar um componente em baixo do outro

        painelMenuPrincipal.add(Box.createVerticalGlue()); // Alinha verticalmente os componentes
        painelMenuPrincipal.add(titulo);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));

        painelMenuPrincipal.add(labelDificuldade);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));
        painelMenuPrincipal.add(opcaoDificuldades);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));

        painelMenuPrincipal.add(botaoIniciar);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));

        painelMenuPrincipal.add(botaoCompetitivo);
        painelMenuPrincipal.add(Box.createVerticalStrut(10));

        painelMenuPrincipal.add(botaoSair);
        painelMenuPrincipal.add(Box.createVerticalGlue()); // Alinha verticalmente os componentes
    }
}
