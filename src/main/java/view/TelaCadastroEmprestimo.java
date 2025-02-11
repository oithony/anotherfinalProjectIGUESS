package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.EmprestimoModel;
import model.LivroModel;
import model.UsuarioModel;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import repository.UsuarioRepository;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TelaCadastroEmprestimo extends JFrame {
    private JPanel painelEmprestimo;
    private JTextField idUsuarioField;
    private JLabel GERENCIAMENTODEEMPRESTIMOSDELIVROS;
    private JLabel IDDOUSUARIO;
    private JLabel IDDOLIVRO;
    private JTextField idLivroField;
    private JLabel DATADOEMPRESTIMO;
    private JTextField dataEmprestimoField;
    private JTextField dataDevolucaoField;
    private JButton voltarButton;
    private JButton emprestarButton;
    private JButton devolverButton;
    private JTable table1;
    private JTable table2;
    private JScrollPane scrollPaneUsuario;
    private JScrollPane scrollPaneLivro;
    public Styles styles = new Styles();

    public TelaCadastroEmprestimo() {
        this.setTitle("Gerenciamento de Empréstimos");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(painelEmprestimo);
        this.setLocationRelativeTo(null);
        styles.StyleButton(emprestarButton);
        styles.StyleButton(devolverButton);
        styles.StyleButton(voltarButton);


        emprestarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UsuarioRepository usuarioRepository = new UsuarioRepository();
                    LivroRepository livroRepository = new LivroRepository();
                    EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

                    Long idUsuario = Long.parseLong(idUsuarioField.getText());
                    Long idLivro = Long.parseLong(idLivroField.getText());

                    UsuarioModel usuario = UsuarioRepository.getInstance().buscarPorId(idUsuario);
                    LivroModel livro = LivroRepository.getInstance().buscarPorId(idLivro);

                    if (usuario == null || livro == null) {
                        JOptionPane.showMessageDialog(null, "Usuário ou Livro não encontrados!");
                        return;
                    }

                    if (livro.getQuantidadeExemplares() <= 0) {
                        JOptionPane.showMessageDialog(null, "Livro indisponível!");
                        return;
                    }

                    EmprestimoModel emprestimo = new EmprestimoModel();
                    emprestimo.setUsuario(usuario);
                    emprestimo.setLivro(livro);
                    emprestimo.setDataEmprestimo(new Date());

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        sdf.setLenient(false); // Impede datas inválidas
                        Date dataDevolucao = sdf.parse(dataDevolucaoField.getText());
                        emprestimo.setDataDevolucaoPrevista(dataDevolucao);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Formato de data inválido! Use dd/MM/yyyy");
                        return;
                    }

                    emprestimoRepository.salvar(emprestimo);
                    livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() - 1);
                    livroRepository.atualizar(livro);

                    JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar empréstimo: " + ex.getMessage());
                }
            }
       });

        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
