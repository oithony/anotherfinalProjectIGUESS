package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.LivroModel;
import repository.LivroRepository;

import static java.lang.Integer.*;

public class TelaCadastroLivro extends JFrame {
    private JPanel painelPrincipal;
    private JLabel GERENCIAMENTODELIVROS;
    private JLabel TEMA;
    private JLabel AUTOR;
    private JLabel ISBN;
    private JLabel TITULODOLIVRO;
    private JLabel DATADEPUBLICAÇÃO;
    private JLabel QUANTIDADE;
    private JTextField tituloField;
    private JTextField temaField;
    private JTextField autorField;
    private JTextField isbnField;
    private JTextField dataPublicacaoField;
    private JTextField quantidadeField;
    private JButton salvarButton;
    private JButton listarButton;
    private JButton voltarButton;


    public TelaCadastroLivro(){
        this.setTitle("Gerenciamento de Livros");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(painelPrincipal);
        this.setLocationRelativeTo(null);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivroModel livro = new LivroModel();
                livro.setTitulo(tituloField.getText());
                livro.setTema(temaField.getText());
                livro.setAutor(autorField.getText());
                livro.setIsbn(isbnField.getText());
                livro.setQuantidadeDisponivel(parseInt(quantidadeField.getText()));

                try {
                    livro.setDataPublicacao(new java.text.SimpleDateFormat("dd/MM/yyyy")
                            .parse(dataPublicacaoField.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida!");
                    return;
                }

                LivroRepository.getInstance().salvar(livro);
                JOptionPane.showMessageDialog(null, "Livro salvo com sucesso!");
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<LivroModel> livros = LivroRepository.getInstance().listar();
                StringBuilder resultado = new StringBuilder();

                for (LivroModel livro : livros) {
                    resultado.append("ID: ").append(livro.getId())
                            .append(", Título: ").append(livro.getTitulo())
                            .append(", Tema: ").append(livro.getTema())
                            .append(", Autor: ").append(livro.getAutor())
                            .append(", ISBN: ").append(livro.getIsbn())
                            .append(", Disponíveis: ").append(livro.getQuantidadeDisponivel())
                            .append("\n");
                }
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
