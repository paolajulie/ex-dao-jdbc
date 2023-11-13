import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.entities.Estoque;

public class EstoqueTela {
    public JPanel Estoque;

    private JLabel TradeOn;
    private JLabel LabelEstoque;
    private JButton addButton;
    private JButton updateButton;
    private JButton listByIdButton;
    private JButton listButton;
    private JButton deleteButton;
    private JButton voltarButton;
    private JTextArea textArea;

    private final EstoqueDao estoqueDao;
    private Estoque estoqueSelecionada;

    public EstoqueTela() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Digite o Custo do Estoque:\n");
                Float custo = Float.parseFloat(JOptionPane.showInputDialog("Digite o Custo do Estoque:"));
                textArea.append("Custo: " + custo + "\n");
                textArea.append("Digite a descrição do Estoque:\n");
                String descricao = JOptionPane.showInputDialog("Digite a descricao do estoque:");
                textArea.append("Descrição: " + descricao + "\n");
                textArea.append("Digite a quantidade do estoque:\n");
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do estoque:"));
                textArea.append("quantidade: " + quantidade + "\n");
                textArea.append("Digite o estoque minimo:\n");
                int min = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque minimo:"));
                textArea.append("Minimo: " + min + "\n");
                textArea.append("Digite o estoque máximo:\n");
                int max = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque máximo:"));
                textArea.append("Máximo: " + max + "\n");
                textArea.append("Digite o status do estoque:\n");
                boolean statusEstoque = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o status do estoque:"));
                textArea.append("Status: " + statusEstoque + "\n");
                Estoque novoEstoque = estoqueDao.insert(new Estoque(null, custo, descricao, quantidade, min, max, statusEstoque));
                textArea.append("Estoque adicionado com ID: " + novoEstoque.getIdEstoque() + "\n");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idEstoque = Integer.parseInt(JOptionPane.showInputDialog( "Informe o ID da entrada que deseja listar:"));
                estoqueSelecionada = estoqueDao.findById(idEstoque);
                if (estoqueSelecionada != null) {
                    textArea.append(estoqueSelecionada.toString() + "\n");
                } else {
                    textArea.append("Estoque não encontrado!\n");
                }
            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                List<Estoque> estoques = estoqueDao.findAll();
                if (estoques!= null && !estoques.isEmpty()) {
                    for (Estoque estoque : estoques) {
                        textArea.append(estoque.toString() + "\n");
                    }
                } else {
                    textArea.setText("Nenhum Estoque Encontrado!\n");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idEstoque = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do Estoque a ser Excluido:"));
                estoqueDao.deleteById(idEstoque);
                textArea.setText("Estoque excluido com Sucesso!\n");
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

        this.estoqueDao = DaoFactory.createEstoqueDao();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("EstoqueTela");
        frame.setContentPane(new EstoqueTela().Estoque);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        });
    }
}