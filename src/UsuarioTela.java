import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioTela {
    public JPanel Usuario;
    private JLabel TradeOn;
    private JLabel LabelUsuario;
    private JButton addButton;
    private JButton updateButton;
    private JButton listByIdButton;
    private JButton listButton;
    private JButton deleteButton;
    private JButton voltarButton;
    private JTextArea textArea;
    private final UsuarioDao usuarioDao;
    private Usuario usuarioSelecionado;

    public UsuarioTela() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Digite a senha do usuário:\n");
                String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");
                textArea.append("Digite o nome do usuário:\n");
                String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
                textArea.append("Digite o CPF do usuário:\n");
                String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário:");

                // Insira o usuário no banco de dados
                usuarioDao.insert(new Usuario(null, senha, nome, cpf));

                textArea.append("Usuário adicionado com sucesso!\n");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Informe o ID do Usuário que deseja atualizar:\n");
                int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Usuário que deseja atualizar:"));
                usuarioSelecionado = usuarioDao.findById(idUsuario);
                if (usuarioSelecionado != null) {
                    usuarioSelecionado.setSenha(JOptionPane.showInputDialog("Digite a Nova Senha do Usuário:"));
                    usuarioSelecionado.setNome(JOptionPane.showInputDialog("Digite o Novo Nome do Usuário:"));
                    usuarioSelecionado.setCpf(JOptionPane.showInputDialog("Digite o Novo CPF do Usuário:"));
                    usuarioDao.update(usuarioSelecionado);
                    textArea.append("Usuário com ID " + idUsuario + " atualizado com sucesso!\n");
                } else {
                    textArea.append("Usuário com ID " + idUsuario + " não encontrado.\n");
                }
            }
        });

        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do usuário que deseja listar:"));
                usuarioSelecionado = usuarioDao.findById(idUsuario);
                if (usuarioSelecionado != null) {
                    textArea.append(usuarioSelecionado.toString() + "\n");
                } else {
                    textArea.append("Usuário não encontrado!\n");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                List<Usuario> usuarios = usuarioDao.findAll();
                if (usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        textArea.append(usuario.toString() + "\n");
                    }
                } else {
                    textArea.setText("Nenhum Usuário Encontrado!\n");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do Usuário a ser Excluído:"));
                usuarioDao.deleteById(idUsuario);
                textArea.setText("Usuário excluído com Sucesso!\n");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(voltarButton);

                if (jFrame != null) {
                    jFrame.dispose();
                }

                MainTela mainTela = new MainTela();
                JFrame mainFrame = new JFrame("MainTela");
                mainFrame.setContentPane(mainTela.Main);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.pack();
                mainFrame.setVisible(true);
            }
        });

        this.usuarioDao = DaoFactory.createUsuarioDao();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("UsuarioTela");
            UsuarioTela usuarioTela = new UsuarioTela();
            frame.setContentPane(usuarioTela.Usuario);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

