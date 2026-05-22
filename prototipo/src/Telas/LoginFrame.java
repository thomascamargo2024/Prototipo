package Telas;

import util.UIConfig;

import javax.swing.*;

import modelos.*;

import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        panel.setBackground(UIConfig.BG);

        JTextField cpf = new JTextField();

        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (cpf.getText().length() >= 11) {
                    e.consume();
                }
            }
        });
        JButton entrar = new JButton("Entrar");
        JButton cadastrar = new JButton("Cadastrar");

        estilizar(entrar);
        estilizar(cadastrar);

        panel.add(new JLabel("CPF:"));
        panel.add(cpf);
        panel.add(entrar);
        panel.add(cadastrar);

        add(panel);

        entrar.addActionListener(e -> {
            for (Cadastro c : BancoFake.clientes) {
                if (c.getCpf().equals(cpf.getText())) {
                    new MenuFrame(c);
                    dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Usuário não encontrado");
        });

        cadastrar.addActionListener(e -> {
            new CadastroFrame();
            dispose();
        });

        setVisible(true);
    }

    private void estilizar(JButton b){
        b.setBackground(UIConfig.PRIMARY);
        b.setForeground(UIConfig.TEXT_WHITE);
        b.setFocusPainted(false);
    }
}