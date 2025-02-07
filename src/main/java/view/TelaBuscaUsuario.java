package view;

import com.sun.jdi.event.ExceptionEvent;
import model.UsuarioModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaBuscaUsuario extends JFrame {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JTable tableBuscaUsuario;
    private JButton buscarButton;
    private JScrollPane scrollPaneUsuario;
    private JButton voltarButton;

    public TelaBuscaUsuario(){
        this.setTitle("Tela de Busca de Usuário");
        this.setSize(640,480);
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

        public List<UsuarioModel> buscar() {
            try{
                List<UsuarioModel> usuarios = entityManager.createQuery("from UsuarioModel").getResultList();
                return usuarios;
            }catch(Exception e){
             return new ArrayList<>();
            }
        }

    }
}
