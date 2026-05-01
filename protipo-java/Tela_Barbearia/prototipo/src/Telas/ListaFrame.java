package Telas;

import modelos.*;
import javax.swing.*;
import java.awt.*;

public class ListaFrame extends JFrame {

    private JList<Agendamento> lista;
    private DefaultListModel<Agendamento> model;

    // BARBEIRO
    public ListaFrame() {
        montarTela(null);
    }

    // CLIENTE
    public ListaFrame(Cadastro user) {
        montarTela(user);
    }

    private void montarTela(Cadastro user){
        setTitle("Agendamentos");
        setSize(400,300);
        setLocationRelativeTo(null);

        model = new DefaultListModel<>();

        for (Agendamento a : BancoFake.agendamentos) {
            if (user == null || a.getCliente().equals(user)) {
                model.addElement(a);
            }
        }

        lista = new JList<>(model);
        JScrollPane scroll = new JScrollPane(lista);

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");
        JButton excluir = new JButton("Excluir");
        JButton voltar = new JButton("Voltar");

        JPanel botoes = new JPanel();

        // 👉 BARBEIRO
        if(user == null){
            botoes.add(confirmar);
            botoes.add(cancelar);
            botoes.add(excluir);
        }

        botoes.add(voltar);

        add(scroll, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        // 🔥 CONFIRMAR
        confirmar.addActionListener(e -> {
            Agendamento a = lista.getSelectedValue();
            if(a != null){
                a.confirmar();
                lista.repaint();
            }
        });

        // 🔥 CANCELAR
        cancelar.addActionListener(e -> {
            Agendamento a = lista.getSelectedValue();
            if(a != null){
                a.cancelar();
                lista.repaint();
            }
        });

        // 🔥 EXCLUIR
        excluir.addActionListener(e -> {
            Agendamento a = lista.getSelectedValue();
            if(a != null){
                BancoFake.agendamentos.remove(a);
                model.removeElement(a);
            }
        });

        voltar.addActionListener(e -> {
            dispose();
            if(user == null){
                new MenuInicial();
            } else {
                new MenuFrame(user);
            }
        });

        setVisible(true);
    }
}