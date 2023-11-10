import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.Fornecedor;

public class FornecedorTela {
    public JPanel Fornecedor;
    private JLabel TradeOn;
    private JLabel LabelFornecedor;
    private JButton addButton;
    private JButton updateButton;
    private JButton listByIdButton;
    private JButton listButton;
    private JButton deleteButton;
    private JButton voltarButton;
    private JTextArea textArea;
    private final FornecedorDao fornecedorDao;
    private Fornecedor fornecedorSelecionada;

    public FornecedorTela() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Digite o nome do fornecedor:\n");
                String nome = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
                textArea.append("Digite o cnpj do Fornecedor:\n");
                String cnpj = JOptionPane.showInputDialog("Digite o cnpj do fornecedor:");
                textArea.append("Digite a localização do Fornecedor:\n");
                String localizacao = JOptionPane.showInputDialog("Digite a localização do fornecedor:");
                textArea.append("Digite o contato do Fornecedor:\n");
                String contato = JOptionPane.showInputDialog("Digite o contato do fornecedor:");
                textArea.append("Nome: " + nome + "\n");
                textArea.append("Cnpj: " + cnpj + "\n");
                textArea.append("Localizacao: " + localizacao + "\n");
                textArea.append("Contato: " + contato + "\n");
                Fornecedor novoFornecedor = fornecedorDao.insert(new Fornecedor(null, nome, cnpj, localizacao, contato));
                textArea.append("Fornecedor adicionado com ID: " + novoFornecedor.getIdFornecedor() + "\n");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Informe o ID do Fornecedor que deseja atualizar:\n");
                int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Fornecedor que deseja atualizar:"));
                fornecedorSelecionada = fornecedorDao.findById(idFornecedor);
                if (fornecedorSelecionada != null) {
                    fornecedorSelecionada.setNome(JOptionPane.showInputDialog("Digite o Novo Nome do Fornecedor:"));
                    fornecedorSelecionada.setCnpj(JOptionPane.showInputDialog("Digite o Novo Cnpj do Fornecedor:"));
                    fornecedorSelecionada.setLocalizacao(JOptionPane.showInputDialog("Digite a Nova Localização do Fornecedor:"));
                    fornecedorSelecionada.setContato(JOptionPane.showInputDialog("Digite o Novo Contato do Fornecedor:"));
                    textArea.append("Fornecedor com ID " + idFornecedor + " atualizado com sucesso!\n");
                } else {
                    textArea.append("Fornecedor com ID " + idFornecedor + " não encontrado.\n");
                }
            }
        });

        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog( "Informe o ID da entrada que deseja listar:"));
                fornecedorSelecionada = fornecedorDao.findById(idFornecedor);
                if (fornecedorSelecionada != null) {
                    textArea.append(fornecedorSelecionada.toString() + "\n");
                } else {
                    textArea.append("Fornecedor não encontrado!\n");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                List<Fornecedor> fornecedores = fornecedorDao.findAll();
                if (fornecedores != null && !fornecedores.isEmpty()) {
                    for (Fornecedor fornecedor : fornecedores) {
                        textArea.append(fornecedor.toString() + "\n");
                    }
                } else {
                    textArea.setText("Nenhum Fornecedor Encontrado!\n");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do Fornecedor a ser Excluido:"));
                fornecedorDao.deleteById(idFornecedor);
                textArea.setText("Fornecedor excluido com Sucesso!\n");
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

        this.fornecedorDao = DaoFactory.createFornecedorDao();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FornecedorTela");
            FornecedorTela fornecedorTela = new FornecedorTela();
            frame.setContentPane(fornecedorTela.Fornecedor);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}