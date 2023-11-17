import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.VendasDao;
import model.entities.Vendas;

    public class VendasTela {
        public JPanel Vendas;

        private JLabel TradeOn;
        private JLabel LabelVendas;
        private JButton addButton;
        private JButton updateButton;
        private JButton listByIdButton;
        private JButton listButton;
        private JButton deleteButton;
        private JButton voltarButton;
        private JTextArea textArea;
        private final VendasDao vendasDao;
        private Vendas vendaSelecionada;

        public VendasTela() {
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    textArea.append("Digite a observacao da venda:\n");
                    String observacao = JOptionPane.showInputDialog("Digite a observacao da venda:");
                    textArea.append("Observacao: " + observacao + "\n");
                    String dataSaidaString = JOptionPane.showInputDialog("Digite a data da venda (no formato dd/MM/yyyy):");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataSaida = null;
                    try {
                        dataSaida = sdf.parse(dataSaidaString);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                        return;
                    }
                    textArea.append("Data de venda: " + sdf.format(dataSaida) + "\n");
                    Vendas novaVenda = vendasDao.insert(new Vendas(null, observacao, dataSaida));
                    textArea.append("Venda adicionada com ID: " + novaVenda.getIdVendas() + "\n");
                }
            });

            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    textArea.append("Informe o ID da venda que deseja atualizar:\n");
                    int idVendas = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da venda que deseja atualizar:"));
                    vendaSelecionada = vendasDao.findById(idVendas);
                    if (vendaSelecionada != null) {
                        vendaSelecionada.setObservacao(JOptionPane.showInputDialog("Digite a observação correta da venda:"));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date novaDataSaida = dateFormat.parse(JOptionPane.showInputDialog("Digite a data correta da venda (dd/MM/yyyy):"));
                            vendaSelecionada.setDataSaida(novaDataSaida);
                            vendasDao.update(vendaSelecionada);
                            textArea.append("Venda com ID " + idVendas + " atualizada com sucesso!\n");
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Formato de data errado, siga (dd/MM.yyyy).\n");
                        }
                    } else {
                        textArea.append("Venda com ID " + idVendas + " não encontrada.\n");
                    }
                }
            });

            listByIdButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    int idVendas = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da venda que deseja listar:"));
                    vendaSelecionada = vendasDao.findById(idVendas);
                    if (vendaSelecionada != null) {
                        textArea.append(vendaSelecionada.toString() + "\n");
                    } else {
                        textArea.append("Venda não encontrada!\n");
                    }
                }
            });

            listButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    List<Vendas> vendas = vendasDao.findAll();
                    if (vendas != null && !vendas.isEmpty()) {
                        for (Vendas venda : vendas) {
                            textArea.append(venda.toString() + "\n");
                        }
                    } else {
                        textArea.setText("Nenhuma venda encontrada!\n");
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    int idVendas = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da venda a ser excluída:"));
                    vendasDao.deleteById(idVendas);
                    textArea.setText("Venda excluída com sucesso!\n");
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

            this.vendasDao = DaoFactory.createVendasDao();
        }

        public void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("VendasTela");
                frame.setContentPane(new VendasTela().Vendas);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            });
        }
    }
