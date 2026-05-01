package Telas;

import util.UIConfig;

import javax.swing.*;
import java.awt.*;

public class BarbeiroFrame extends JFrame {

    public BarbeiroFrame () {
        setTitle("Login barbeiro");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        panel.setBackground(UIConfig.BG);

        JTextField nome = new JTextField();
        JPasswordField senha = new JPasswordField();
        JButton entrar = new JButton("Entrar");

        estilizar(entrar);

        panel.add(new JLabel("Nome barbeiro"));
        panel.add(nome);
        panel.add(new JLabel("Senha"));
        panel.add(senha);
        panel.add(entrar);

        add(panel);

        entrar.addActionListener(e -> {
            String nomeInput = nome.getText();
            String senhaInput = new String(senha.getPassword());

            if (nomeInput.equals("barbeiro") && senhaInput.equals("12345678")) {
                new ListaFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nome ou senha incorretos");
            }
        });

        setVisible(true);
    }

    private void estilizar(JButton b){
        b.setBackground(UIConfig.PRIMARY);
        b.setForeground(UIConfig.TEXT_WHITE);
        b.setFocusPainted(false);
    }
}