import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TradeOn {
    private JPanel Main;
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JButton salvarButton;
    private JButton apagarButton;
    private JButton atualizarButton;
    private JButton procurarButton;
    private JTextField txtId;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TradeOn");
        frame.setContentPane(new TradeOn().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public TradeOn() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}

