package Telas;

import util.UIConfig;

import javax.swing.*;

import modelos.*;

import java.awt.*;

public class MenuFrame extends JFrame {

    public MenuFrame(Cadastro user){
        setTitle("Menu");
        setSize(350,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        panel.setBackground(UIConfig.BG);

        JLabel titulo = new JLabel("Bem-vindo " + user.getNome());

        JButton agendar = new JButton("Agendar");
        JButton lista = new JButton("Agendamentos");
        JButton sair = new JButton("Sair");

        estilizar(agendar);
        estilizar(lista);
        estilizar(sair);

        panel.add(titulo);
        panel.add(agendar);
        panel.add(lista);
        panel.add(sair);

        add(panel);

        agendar.addActionListener(e -> new AgendarFrame(user));
        lista.addActionListener(e -> new ListaFrame(user));
        sair.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    public MenuFrame() {
		// TODO Auto-generated constructor stub
	}

	private void estilizar(JButton b){
        b.setBackground(UIConfig.PRIMARY);
        b.setForeground(UIConfig.TEXT_WHITE);
    }
}