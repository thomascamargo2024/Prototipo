package Telas;

import util.UIConfig;

import javax.swing.*;

import modelos.*;

import java.awt.*;

public class CadastroFrame extends JFrame {

    public CadastroFrame() {
        setTitle("Cadastro");
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        panel.setBackground(UIConfig.BG);

        JTextField nome = new JTextField();
        nome.setBounds(94, 20, 216, 36);
        JTextField fone = new JTextField();
        fone.setBounds(94, 66, 216, 36);
        JTextField cpf = new JTextField();
        cpf.setBounds(94, 113, 216, 36);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(47, 160, 224, 36);
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(47, 214, 224, 36);

        estilizar(cadastrar);
        estilizar(voltar);
        panel.setLayout(null);

        panel.add(nome);
        panel.add(fone);
        panel.add(cpf);
        panel.add(cadastrar);
        panel.add(voltar);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Nome");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(25, 30, 50, 14);
        panel.add(lblNewLabel);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTelefone.setBounds(25, 77, 63, 14);
        panel.add(lblTelefone);
        
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCpf.setBounds(25, 124, 50, 14);
        panel.add(lblCpf);

        cadastrar.addActionListener(e -> {
            BancoFake.clientes.add(new Cadastro(
                nome.getText(), fone.getText(), cpf.getText()
            ));
            JOptionPane.showMessageDialog(this,"Cadastrado!");
            dispose();
            new LoginFrame();
        });

        voltar.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    private void estilizar(JButton b){
        b.setBackground(UIConfig.PRIMARY);
        b.setForeground(UIConfig.TEXT_WHITE);
        b.setFocusPainted(false);
    }
}