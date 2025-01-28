package Cadastro;

import javax.swing.*;

public class TelaCadastro extends JFrame {
    private JPanel painelCadastro;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JButton salvarButton;
    private JButton cancelarButton;

    public TelaCadastro() {
        this.setTitle("Tela de Cadastro");
        this.setSize(400, 300);
        this.setContentPane(painelCadastro);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelarButton.addActionListener(e -> dispose());
    }
}
