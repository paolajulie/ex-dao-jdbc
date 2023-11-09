import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.EntradaDao;
import model.entities.Entrada;

public class EntradaTela {
    private JFrame frame;
    private JButton addButton, updateButton, listButton, listByIdButton, deleteButton;
    private JTextArea outputTextArea;

    private EntradaDao entradaDao;
    private Entrada entradaSelecionada;
    private JTextField TxtTradeOn;

    public EntradaTela() {
        frame = new JFrame("Entrada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        addButton = new JButton("Adicionar Entrada");
        updateButton = new JButton("Atualizar Entrada");
        listButton = new JButton("Listar Todas as Entradas");
        listByIdButton = new JButton("Listar Entrada por ID");
        deleteButton = new JButton("Deletar Entrada");

        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarEntrada();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEntrada();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarEntrada();
            }
        });

        listByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarIDEntrada();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarEntrada();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(updateButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(listButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(listByIdButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(deleteButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(new JScrollPane(outputTextArea), gbc);

        frame.add(panel);
        frame.setVisible(true);

        this.entradaDao = DaoFactory.createEntradaDao();
    }

    private void adicionarEntrada() {
        outputTextArea.setText("");
        outputTextArea.append("Digite a Observacao da Entrada:\n");
        String observacao = JOptionPane.showInputDialog(frame, "Digite a Observacao da Entrada:");
        outputTextArea.append("Digite a Data de Entrada (no formato dd/MM/yyyy):\n");
        String dataEntradaString = JOptionPane.showInputDialog(frame, "Digite a Data de Entrada (no formato dd/MM/yyyy):");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = null;
        try {
            dataEntrada = sdf.parse(dataEntradaString);
        } catch (ParseException ex) {
            outputTextArea.append(ex.getMessage() + "\n");
        }
        entradaDao.insertEntrada(new Entrada(null, observacao, dataEntrada));
        outputTextArea.append("Adicionado!\n");
    }

    private void atualizarEntrada() {
        outputTextArea.setText("");
        outputTextArea.append("Informe o ID da entrada que deseja atualizar:\n");
        int idEntrada = Integer.parseInt(JOptionPane.showInputDialog(frame, "Informe o ID da entrada que deseja atualizar:"));
        entradaSelecionada = entradaDao.findById(idEntrada);
        if (entradaSelecionada != null) {
            outputTextArea.append("Digite a Observacao da Entrada:\n");
            entradaSelecionada.setObservacao(JOptionPane.showInputDialog(frame, "Digite a Observacao da Entrada:"));
            outputTextArea.append("Digite a Data de Entrada (no formato dd/MM/yyyy):\n");
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            try {
                entradaSelecionada.setDataEntrada(formatoData.parse(JOptionPane.showInputDialog(frame, "Digite a Data de Entrada:")));
                entradaDao.update(entradaSelecionada);
                outputTextArea.append("Atualizacao Completa!\n");
            } catch (ParseException ex) {
                outputTextArea.append(ex.getMessage() + "\n");
            }
        } else {
            outputTextArea.append("Entrada não encontrada!\n");
        }
    }

    private void listarEntrada() {
        outputTextArea.setText("");
        List<Entrada> entradas = entradaDao.findAll();
        if (entradas != null && !entradas.isEmpty()) {
            for (Entrada entrada : entradas) {
                outputTextArea.append(entrada.toString() + "\n");
            }
        } else {
            outputTextArea.append("Nenhuma entrada encontrada!\n");
        }
    }

    private void listarIDEntrada() {
        outputTextArea.setText("");
        int idEntrada = Integer.parseInt(JOptionPane.showInputDialog(frame, "Informe o ID da entrada que deseja listar:"));
        entradaSelecionada = entradaDao.findById(idEntrada);
        if (entradaSelecionada != null) {
            outputTextArea.append(entradaSelecionada.toString() + "\n");
        } else {
            outputTextArea.append("Entrada não encontrada!\n");
        }
    }

    private void deletarEntrada() {
        outputTextArea.setText("");
        int idEntrada = Integer.parseInt(JOptionPane.showInputDialog(frame, "Insira o ID da entrada a ser Excluida:"));
        entradaDao.deleteById(idEntrada);
        outputTextArea.append("Entrada Excluida!\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EntradaTela();
            }
        });
    }
}
