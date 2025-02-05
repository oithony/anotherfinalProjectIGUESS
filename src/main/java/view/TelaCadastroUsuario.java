package view;
import model.UsuarioModel;
import repository.UsuarioRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastroUsuario extends JFrame {
    private JPanel painelCadastro;
    private JLabel NomeCompleto;
    private JTextField nomeField;
    private JLabel Sexo;
    private JTextField sexoField;
    private JLabel Celular;
    private JTextField celularField;
    private JLabel Email;
    private JTextField emailField;
    private JButton salvarButton;
    private JButton listarButton;
    private JButton voltarButton;
    private JPanel painelUsuario;

    public TelaCadastroUsuario() {
        this.setTitle("Tela de Cadastro");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(painelUsuario);
        this.setLocationRelativeTo(null);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setNome(nomeField.getText());
                usuario.setSexo(sexoField.getText());
                usuario.setCelular(celularField.getText());
                usuario.setEmail(emailField.getText());

                UsuarioRepository.getInstance().salvar(usuario);
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<UsuarioModel> usuarios = UsuarioRepository.getInstance().listar();
                StringBuilder resultado = new StringBuilder();

                for (UsuarioModel usuario : usuarios) {
                    resultado.append("ID: ").append(usuario.getId())
                            .append(", Nome: ").append(usuario.getNome())
                            .append(", Sexo: ").append(usuario.getSexo())
                            .append(", Celular: ").append(usuario.getCelular())
                            .append(", E-mail: ").append(usuario.getEmail())
                            .append("\n");
                }
                TextField resultadoArea = new TextField();
                resultadoArea.setText(resultado.toString());
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Principal();
            }
        });
    }
}
