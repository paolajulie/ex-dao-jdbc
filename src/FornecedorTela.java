import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.Fornecedor;

public class FornecedorTela {
    private JButton addButton;
    private JPanel Fornecedor;
    private JButton listByIdButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton listButton;
    private JButton voltarButton;
    private JTextArea textArea;
    private JLabel TradeOn;
    private JLabel LabelFornecedor;

    private FornecedorDao fornecedorDao;
    private Fornecedor fornecedorSelecionada;

    public FornecedorTela() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adcionarFornecedor();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarFornecedor();
            }
        });

        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarIDFornecedor();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarFornecedor();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFornecedor();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainTela mainTela = new MainTela();
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Fornecedor);
                currentFrame.dispose();
                mainTela.mostrarTela();
            }
        });

        this.fornecedorDao = DaoFactory.createFornecedorDao();

    }

    private void adcionarFornecedor() {
        textArea.setText("");
        textArea.append("Digite o Nome do Fornecedor:\n");
        String nome = JOptionPane.showInputDialog("Digite o Nome do Fornecedor:");
        textArea.append("Digite o Cnpj do Fornecedor:\n");
        String cnpj = JOptionPane.showInputDialog("Digite o Cnpj do Fornecedor:");
        textArea.append("Digite a Localização do Fornecedor:\n");
        String localizacao = JOptionPane.showInputDialog("Digite a Localização do Fornecedor:");
        textArea.append("Digite o Contato do Fornecedor:\n");
        String contato = JOptionPane.showInputDialog("Digite o Contato do Fornecedor:");
        fornecedorDao.insert(new Fornecedor(null, nome, cnpj, localizacao, contato));
        textArea.append("Adicionado!\n");
    }

    private void atualizarFornecedor() {
        textArea.setText("");
        textArea.append("Informe o ID do Fornecedor que deseja atualizar:\n");
        int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Fornecedor que deseja atualizar:"));
        fornecedorSelecionada = fornecedorDao.findById(idFornecedor);
        if (fornecedorSelecionada != null) {
            fornecedorSelecionada.setNome(JOptionPane.showInputDialog("Digite o Novo Nome do Fornecedor:"));
            fornecedorSelecionada.setCnpj(JOptionPane.showInputDialog("Digite o Novo Cnpj do Fornecedor:"));
            fornecedorSelecionada.setLocalizacao(JOptionPane.showInputDialog("Digite a Nova Localização do Fornecedor:"));
            fornecedorSelecionada.setContato(JOptionPane.showInputDialog("Digite o Novo Contato do Fornecedor:"));
            textArea.append("Atualizado!\n");
        } else {
            textArea.append("Fornecedor não encontrado!\n");
        }
    }

    private void listarIDFornecedor() {
        textArea.setText("");
        int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog( "Informe o ID da entrada que deseja listar:"));
        fornecedorSelecionada = fornecedorDao.findById(idFornecedor);
        if (fornecedorSelecionada != null) {
            textArea.append(fornecedorSelecionada.toString() + "\n");
        } else {
            textArea.append("Fornecedor não encontrado!\n");
        }
    }

    private void listarFornecedor() {
        textArea.setText("");
        List<Fornecedor> fornecedores = fornecedorDao.findAll();
        if (fornecedores != null && !fornecedores.isEmpty()) {
            for (Fornecedor fornecedor : fornecedores) {
                textArea.append(fornecedor.toString() + "\n");
            }
        } else {
            textArea.setText("Nenhuma entrada encontrada!\n");
        }
    }

    private void deleteFornecedor() {
        textArea.setText("");
        int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do Fornecedor a ser Excluido:"));
        fornecedorDao.deleteById(idFornecedor);
        textArea.setText("Fornecedor Excluido!\n");
    }

    public static class MainTela {

        public void mostrarTela() {
            JFrame frame = new JFrame("MainTela");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FornecedorTela");
        frame.setContentPane(new FornecedorTela().Fornecedor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}