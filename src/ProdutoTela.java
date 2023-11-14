import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoTela {
    public JPanel Produto;
    private JButton updateButton;
    private JButton listByIfButton;
    private JButton listButton;
    private JButton deleteButton;
    private JButton voltarButton;
    private JTextArea textArea;
    private JButton addButton;

    private final ProdutoDao produtoDao;
    private Produto produtoSelecionado;

    public ProdutoTela() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Digite o nome do Produto:\n");
                String nome = JOptionPane.showInputDialog("Digite o nome do Produto:");
                textArea.append("Nome: " + nome + "\n");
                textArea.append("Digite o preço do Produto:\n");
                Float preco =  Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do Produto:"));
                textArea.append("Preço: " + preco + "\n");
                String valiString = JOptionPane.showInputDialog("Digite a validade do Produto (no formato dd/MM/yyyy):");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date vali = null;
                try {
                    vali = sdf.parse(valiString);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                    return;
                }
                textArea.append("Digite a unidade de medida do Produto:\n");
                String uni = JOptionPane.showInputDialog("Digite a unidade de medida do Produto:");
                textArea.append("Unidade: " + uni + "\n");
                textArea.append("Data de validade: " + sdf.format(vali) + "\n");
                Produto novoProduto = produtoDao.insert(new Produto(null, nome, preco, vali, uni));
                textArea.append("Produto adicionado com ID: " + novoProduto.getId() + "\n");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Informe o ID do produto que deseja atualizar:\n");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja atualizar:"));
                produtoSelecionado = produtoDao.findById(id);
                if (produtoSelecionado != null) {
                        produtoSelecionado.setNome(JOptionPane.showInputDialog("Digite o nome correto do Produto:"));
                        produtoSelecionado.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preço correto do Produto:")));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date novaValiString = dateFormat.parse(JOptionPane.showInputDialog("Digite a validade correta do Produto(dd/MM/yyyy):"));
                        produtoSelecionado.setVali(novaValiString);
                        produtoDao.update(produtoSelecionado);
                        textArea.append("Produto com ID " + id + " atualizada com sucesso!\n");
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Formato de data errado, siga (dd/MM.yyyy).\n");
                    }
                    produtoSelecionado.setUni(JOptionPane.showInputDialog("Digite a  unidade de medida correta do Produto:"));
                } else {
                    textArea.append("Produto com ID " + id + " não encontrado.\n");
                }

            }
        });
        listByIfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int id = Integer.parseInt(JOptionPane.showInputDialog( "Informe o ID do produto que deseja listar:"));
                produtoSelecionado = produtoDao.findById(id);
                if (produtoSelecionado != null) {
                    textArea.append(produtoSelecionado.toString() + "\n");
                } else {
                    textArea.append("Produto não encontrada!\n");
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do produto a ser excluído:"));
                produtoDao.deleteById(id);
                textArea.setText("Produto excluído com Sucesso!\n");

            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                List<Produto> produtos = produtoDao.findAll();
                if (produtos != null && !produtos.isEmpty()) {
                    for (Produto produto : produtos) {
                        textArea.append(produto.toString() + "\n");
                    }
                } else {
                    textArea.setText("Nenhuma produto encontrado!\n");
                }

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
        this.produtoDao = DaoFactory.createProdutoDao();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProdutoTela");
        frame.setContentPane(new ProdutoTela().Produto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
