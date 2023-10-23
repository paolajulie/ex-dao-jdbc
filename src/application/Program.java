package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class Program extends Funcoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int esc = 0;
        int sair = 0;
        int subSair = 0;

        do {
            System.out.println("Selecione a opção desejada:\n[1] - Entrada\n[2] - Estoque\n[3] - Fornecedor\n[4] - Produto\n[5] - Usuario\n[6] - Vendas\n[0] - Sair\n->");

            esc = scanner.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Entrada           |\n");
                    System.out.println("-----------------------------\n");

                    int entradaOption;
                    do {
                        System.out.println("Selecione a opção de entrada:\n[1] - Adcionar Entrada\n[2] - Atualizar Entrada\n[3] - Listar Entradas\n[4] - Listar por ID\n[5] - Deletar Entrada\n[0] - Voltar\n->");
                        entradaOption = scanner.nextInt();

                        switch (entradaOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Adcionar Entrada      |\n");
                                System.out.println("-----------------------------\n");
                                // adicionarEntrada();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Atualizar Entrada     |\n");
                                System.out.println("-----------------------------\n");
                                // atualizarEntrada();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Listar Entradas     |\n");
                                System.out.println("-----------------------------\n");
                                // listarEntradas();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                // listarIDEntradas();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Deletar Entrada     |\n");
                                System.out.println("-----------------------------\n");
                                // deletarEntrada();
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;

                case 2:
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Estoque           |\n");
                    System.out.println("-----------------------------\n");

                    int estoqueOption;
                    do {
                        System.out.println("Selecione a opção de estoque:\n[1] - Adcionar Estoque\n[2] - Atualizar Estoque\n[3] - Listar Estoques\n[4] - Listar por ID\n[5] - Deletar Estoque\n[0] - Voltar\n->");
                        estoqueOption = scanner.nextInt();

                        switch (estoqueOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Adcionar Estoque      |\n");
                                System.out.println("-----------------------------\n");
                                // adicionarEstoque();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Atualizar Estoque     |\n");
                                System.out.println("-----------------------------\n");
                                // atualizarEstoque();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar Estoque      |\n");
                                System.out.println("-----------------------------\n");
                                // listarEstoque();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                // listarIDEstoque();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Deletar Estoque     |\n");
                                System.out.println("-----------------------------\n");
                                // deletarEstoque();
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;
                case 3:
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Fornecedor        |\n");
                    System.out.println("-----------------------------\n");

                    int fornecedorOption;
                    do {
                        System.out.println("Selecione a opção de fornecedor:\n[1] - Adcionar Fornecedor\n[2] - Atualizar Fornecedor\n[3] - Listar Fornecedor\n[4] - Listar por ID\n[5] - Deletar Fornecedor\n[0] - Voltar\n->");
                        fornecedorOption = scanner.nextInt();

                        switch (fornecedorOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Adcionar Fornecedor   |\n");
                                System.out.println("-----------------------------\n");
                                // adicionarFornecedor();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|    Atualizar Fornecedor   |\n");
                                System.out.println("-----------------------------\n");
                                // atualizarFornecedor();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Listar Fornecedor     |\n");
                                System.out.println("-----------------------------\n");
                                // listarFornecedor();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                // listarIDFornecedor();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Deletar Fornecedor    |\n");
                                System.out.println("-----------------------------\n");
                                // deletarFornecedor();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;
                case 4:
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Produto           |\n");
                    System.out.println("-----------------------------\n");

                    int produtoOption;
                    do {
                        System.out.println("Selecione a opção de produto:\n[1] - Adcionar Produto\n[2] - Atualizar Produto\n[3] - Listar Produto\n[4] - Listar por ID\n[5] - Deletar Produto\n[0] - Voltar\n->");
                        produtoOption = scanner.nextInt();

                        switch (produtoOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Adcionar Produto    |\n");
                                System.out.println("-----------------------------\n");
                                adicionarProduto();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Atualizar Produto     |\n");
                                System.out.println("-----------------------------\n");
                                atualizarProduto();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|      Listar Produto       |\n");
                                System.out.println("-----------------------------\n");
                                listarProduto();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                listarIDProduto();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Deletar Produto     |\n");
                                System.out.println("-----------------------------\n");
                                deletarProduto();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;
                case 5:
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Usuario           |\n");
                    System.out.println("-----------------------------\n");

                    int usuarioOption;
                    do {
                        System.out.println("Selecione a opção de Usuario:\n[1] - Adcionar Usuario\n[2] - Atualizar Usuario\n[3] - Listar PUsuario\n[4] - Listar por ID\n[5] - Deletar Usuario\n[0] - Voltar\n->");
                        usuarioOption = scanner.nextInt();

                        switch (usuarioOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Adcionar Usuario    |\n");
                                System.out.println("-----------------------------\n");
                                // adicionarUsuario();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Atualizar Usuario     |\n");
                                System.out.println("-----------------------------\n");
                                // atualizarUsuario();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|      Listar Usuario       |\n");
                                System.out.println("-----------------------------\n");
                                // listarUsuario();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                // listarIDUsuario();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Deletar Usuario     |\n");
                                System.out.println("-----------------------------\n");
                                // deletarUsuario();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;
                case 6:
                    System.out.println("-----------------------------\n");
                    System.out.println("|          Vendas           |\n");
                    System.out.println("-----------------------------\n");

                    int vendasOption;
                    do {
                        System.out.println("Selecione a opção de Vendas:\n[1] - Adcionar Vendas\n[2] - Atualizar Vendas\n[3] - Listar Vendas\n[4] - Listar por ID\n[5] - Deletar Vendas\n[0] - Voltar\n->");
                        vendasOption = scanner.nextInt();

                        switch (vendasOption) {
                            case 1:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Adcionar Vendas     |\n");
                                System.out.println("-----------------------------\n");
                                // adicionarVendas();
                                break;
                            case 2:
                                System.out.println("-----------------------------\n");
                                System.out.println("|     Atualizar Vendas      |\n");
                                System.out.println("-----------------------------\n");
                                // atualizarVendas();
                                break;
                            case 3:
                                System.out.println("-----------------------------\n");
                                System.out.println("|      Listar Vendas        |\n");
                                System.out.println("-----------------------------\n");
                                // listarVendas();
                                break;
                            case 4:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Listar por ID       |\n");
                                System.out.println("-----------------------------\n");
                                // listarIDVendas();
                                break;
                            case 5:
                                System.out.println("-----------------------------\n");
                                System.out.println("|       Deletar Vendas      |\n");
                                System.out.println("-----------------------------\n");
                                // deletarVendas();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }

                    } while (subSair != 0);

                    break;

                case 0:
                    sair = 1;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (sair != 1);
    }
}