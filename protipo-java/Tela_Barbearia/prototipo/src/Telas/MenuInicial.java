package Telas;

import util.UIConfig;

import javax.swing.*;

import modelos.*;

import java.awt.*;

public class MenuInicial extends JFrame {

    public MenuInicial(){
        setTitle("Menu");
        setSize(350,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        panel.setBackground(UIConfig.BG);

        JLabel titulo = new JLabel("Sejam bem-vindos");

        JButton LoginCliente = new JButton("Cliente");
        JButton LoginBarbeiro = new JButton("Barbeiro");

        estilizar(LoginCliente);
        estilizar(LoginBarbeiro);

        panel.add(titulo);
        panel.add(LoginCliente);
        panel.add(LoginBarbeiro);

        getContentPane().add(panel);

        LoginCliente.addActionListener(e -> new LoginFrame());
        LoginBarbeiro.addActionListener(e -> new BarbeiroFrame());

        setVisible(true);
    }

    private void estilizar(JButton b){
        b.setBackground(UIConfig.PRIMARY);
        b.setForeground(UIConfig.TEXT_WHITE);
    }
}