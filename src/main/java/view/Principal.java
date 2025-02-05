package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JButton livrosButton;
    private JButton usuariosButton;
    private JButton emprestimosButton;
    private JPanel painelPrincipal;

    public Principal(){
        this.setTitle("Sistema Bibliotecário - IFMS");
        this.setSize(640,480);
        this.setContentPane(painelPrincipal);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        livrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroLivro().setVisible(true);
                dispose();
            }
        });

        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
                telaCadastroUsuario.setVisible(true);
                dispose();
            }
        });

        emprestimosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroEmprestimo().setVisible(true);
                dispose();
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
