import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTela {
    public JPanel Main;
    private JLabel TradeOn;
    private JButton entradaButton;
    private JButton estoqueButton;
    private JButton fornecedorButton;
    private JButton produtoButton;
    private JButton usuarioButton;
    private JButton vendasButton;

    public MainTela() {
        entradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(entradaButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }
                SwingUtilities.invokeLater(() ->{
                    JFrame entradaFrame = new JFrame("EntradaTela");
                    EntradaTela entradaTela = new EntradaTela();
                    entradaFrame.setContentPane(entradaTela.Entrada);
                    entradaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    entradaFrame.pack();
                    entradaFrame.setVisible(true);
                });
            }
        });
        estoqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(estoqueButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }

                SwingUtilities.invokeLater(() -> {
                    JFrame estoqueFrame = new JFrame("EstoqueTela");
                    EstoqueTela estoqueTela = new EstoqueTela();
                    estoqueFrame.setContentPane(estoqueTela.Estoque);
                    estoqueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    estoqueFrame.pack();
                    estoqueFrame.setVisible(true);
                });
            }
        });
        fornecedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(entradaButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }

                SwingUtilities.invokeLater(() -> {
                    JFrame fornecedorFrame = new JFrame("FornecedorTela");
                    FornecedorTela fornecedorTela = new FornecedorTela();
                    fornecedorFrame.setContentPane(fornecedorTela.Fornecedor);
                    fornecedorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    fornecedorFrame.pack();
                    fornecedorFrame.setVisible(true);
                });
            }
        });
        produtoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(produtoButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }

                SwingUtilities.invokeLater(() -> {
                    JFrame produtoFrame = new JFrame("ProdutoTela");
                    ProdutoTela produtoTela = new ProdutoTela();
                    produtoFrame.setContentPane(produtoTela.Produto);
                    produtoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    produtoFrame.pack();
                    produtoFrame.setVisible(true);
                });
            }
        });
        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(produtoButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }

                SwingUtilities.invokeLater(() -> {
                    JFrame usuarioFrame = new JFrame("UsuarioTela");
                    UsuarioTela usuarioTela = new UsuarioTela();
                    usuarioFrame.setContentPane(usuarioTela.Usuario);
                    usuarioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    usuarioFrame.pack();
                    usuarioFrame.setVisible(true);
                });
            }
        });
        vendasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(produtoButton);
                if (mainFrame != null) {
                    mainFrame.dispose();
                }

                SwingUtilities.invokeLater(() -> {
                    JFrame vendasFrame = new JFrame("VendasTela");
                    VendasTela vendasTela = new VendasTela();
                    vendasFrame.setContentPane(vendasTela.Vendas);
                    vendasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    vendasFrame.pack();
                    vendasFrame.setVisible(true);
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MainTela");
            MainTela mainTela = new MainTela();
            frame.setContentPane(mainTela.Main);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}