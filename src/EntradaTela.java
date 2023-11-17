import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.EntradaDao;
import model.entities.Entrada;

public class EntradaTela {
    public JPanel Entrada;
    private JLabel TradeOn;
    private JLabel LabelEntrada;
    private JButton addButton;
    private JButton updateButton;
    private JButton listByIdButton;
    private JButton listButton;
    private JButton deleteButton;
    private JButton voltarButton;
    private JTextArea textArea;
    private final EntradaDao entradaDao;
    private Entrada entradaSelecionada;

    public EntradaTela() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Digite a observacao da entrada:\n");
                String observacao = JOptionPane.showInputDialog("Digite a observacao da entrada:");
                textArea.append("Observacao: " + observacao + "\n");
                String dataEntradaString = JOptionPane.showInputDialog("Digite a data de entrada (no formato dd/MM/yyyy):");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataEntrada = null;
                try {
                    dataEntrada = sdf.parse(dataEntradaString);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                    return;
                }
                textArea.append("Data de entrada: " + sdf.format(dataEntrada) + "\n");
                Entrada novoEntrada = entradaDao.insertEntrada(new Entrada(null, observacao, dataEntrada));
                textArea.append("Entrada adicionada com ID: " + novoEntrada.getIdEntrada() + "\n");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("Informe o ID da entrada que deseja atualizar:\n");
                int idEntrada = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da entrada que deseja atualizar:"));
                entradaSelecionada = entradaDao.findById(idEntrada);
                if (entradaSelecionada != null) {
                    entradaSelecionada.setObservacao(JOptionPane.showInputDialog("Digite a observação correta da Entrada:"));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date novaDataEntrada = dateFormat.parse(JOptionPane.showInputDialog("Digite a data correta da entrada (dd/MM/yyyy):"));
                        entradaSelecionada.setDataEntrada(novaDataEntrada);
                        entradaDao.update(entradaSelecionada);
                        textArea.append("Entrada com ID " + idEntrada + " atualizada com sucesso!\n");
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Formato de data errado, siga (dd/MM.yyyy).\n");
                    }
                } else {
                    textArea.append("Entrada com ID " + idEntrada + " não encontrada.\n");
                }
            }
        });
        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idEntrada = Integer.parseInt(JOptionPane.showInputDialog( "Informe o ID da entrada que deseja listar:"));
                entradaSelecionada = entradaDao.findById(idEntrada);
                if (entradaSelecionada != null) {
                    textArea.append(entradaSelecionada.toString() + "\n");
                } else {
                    textArea.append("Entrada não encontrada!\n");
                }
            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                List<Entrada> entradas = entradaDao.findAll();
                if (entradas != null && !entradas.isEmpty()) {
                    for (Entrada entrada : entradas) {
                        textArea.append(entrada.toString() + "\n");
                    }
                } else {
                    textArea.setText("Nenhuma entrada encontrada!\n");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int idEntrada = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da entrada a ser excluida:"));
                entradaDao.deleteById(idEntrada);
                textArea.setText("Entrada excluida com Sucesso!\n");
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
        this.entradaDao = DaoFactory.createEntradaDao();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EntradaTela");
            frame.setContentPane(new EntradaTela().Entrada);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}