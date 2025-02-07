package view;

import model.UsuarioModel;
import repository.UsuarioRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaBuscaUsuario extends JFrame {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JTable tableBuscaUsuario;
    private JButton buscarButton;
    private JScrollPane scrollPaneUsuario;
    private JButton voltarButton;
    private JButton removerButton;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");
    private EntityManager entityManager = emf.createEntityManager();
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public TelaBuscaUsuario() {
        this.setTitle("Tela de Busca de Usuário");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(painelPrincipal);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaCadastroUsuario();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });
    }

    private void atualizarTabela() {
        List<UsuarioModel> usuarios = buscar();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nome", "Email"}, 0);

        for (UsuarioModel usuario : usuarios) {
            model.addRow(new Object[]{usuario.getId(), usuario.getNome(), usuario.getEmail()});
        }

        tableBuscaUsuario.setModel(model);
    }

    public List<UsuarioModel> buscar() {
        try {
            return entityManager.createQuery("from UsuarioModel", UsuarioModel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
