package application;

import java.util.Scanner;

public class Program extends Funcoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int esc;
        int sair = 0;

        do {
            System.out.println("Selecione a opção desejada:\n[1] - Entrada\n[2] - Estoque\n[3] - Fornecedor\n[4] - Produto\n[5] - Usuario\n[6] - Vendas\n[0] - Sair\n->");

            esc = scanner.nextInt();

            switch (esc) {
                case 1 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Entrada           |\n");
                    System.out.println("-----------------------------\n");
                    int entradaOption;
                    System.out.println("Selecione a opção de entrada:\n[1] - Adcionar Entrada\n[2] - Atualizar Entrada\n[3] - Listar Entradas\n[4] - Listar por ID\n[5] - Deletar Entrada\n[0] - Voltar\n->");
                    entradaOption = scanner.nextInt();

                    switch (entradaOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Adcionar Entrada      |\n");
                            System.out.println("-----------------------------\n");
                            adicionarEntrada();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Atualizar Entrada     |\n");
                            System.out.println("-----------------------------\n");
                            atualizarEntrada();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Listar Entradas     |\n");
                            System.out.println("-----------------------------\n");
                            listarEntrada();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDEntrada();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Deletar Entrada     |\n");
                            System.out.println("-----------------------------\n");
                            deletarEntrada();
                        }
                        case 0 -> {
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 2 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Estoque           |\n");
                    System.out.println("-----------------------------\n");
                    int estoqueOption;
                    System.out.println("Selecione a opção de estoque:\n[1] - Adcionar Estoque\n[2] - Atualizar Estoque\n[3] - Listar Estoques\n[4] - Listar por ID\n[5] - Deletar Estoque\n[0] - Voltar\n->");
                    estoqueOption = scanner.nextInt();

                    switch (estoqueOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Adcionar Estoque      |\n");
                            System.out.println("-----------------------------\n");
                            adicionarEstoque();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Atualizar Estoque     |\n");
                            System.out.println("-----------------------------\n");
                            atualizarEstoque();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar Estoque      |\n");
                            System.out.println("-----------------------------\n");
                            listarEstoque();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDEstoque();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Deletar Estoque     |\n");
                            System.out.println("-----------------------------\n");
                            deletarEstoque();
                        }
                        case 0 -> {
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 3 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Fornecedor        |\n");
                    System.out.println("-----------------------------\n");
                    int fornecedorOption;
                    System.out.println("Selecione a opção de fornecedor:\n[1] - Adcionar Fornecedor\n[2] - Atualizar Fornecedor\n[3] - Listar Fornecedor\n[4] - Listar por ID\n[5] - Deletar Fornecedor\n[0] - Voltar\n->");
                    fornecedorOption = scanner.nextInt();

                    switch (fornecedorOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Adcionar Fornecedor   |\n");
                            System.out.println("-----------------------------\n");
                            adicionarFornecedor();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|    Atualizar Fornecedor   |\n");
                            System.out.println("-----------------------------\n");
                            atualizarFornecedor();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Listar Fornecedor     |\n");
                            System.out.println("-----------------------------\n");
                            listarFornecedor();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDFornecedor();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Deletar Fornecedor    |\n");
                            System.out.println("-----------------------------\n");
                            deletarFornecedor();
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 4 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Produto           |\n");
                    System.out.println("-----------------------------\n");
                    int produtoOption;
                    System.out.println("Selecione a opção de produto:\n[1] - Adcionar Produto\n[2] - Atualizar Produto\n[3] - Listar Produto\n[4] - Listar por ID\n[5] - Deletar Produto\n[0] - Voltar\n->");
                    produtoOption = scanner.nextInt();

                    switch (produtoOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Adcionar Produto    |\n");
                            System.out.println("-----------------------------\n");
                            adicionarProduto();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Atualizar Produto     |\n");
                            System.out.println("-----------------------------\n");
                            atualizarProduto();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|      Listar Produto       |\n");
                            System.out.println("-----------------------------\n");
                            listarProduto();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDProduto();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Deletar Produto     |\n");
                            System.out.println("-----------------------------\n");
                            deletarProduto();
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 5 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|         Usuario           |\n");
                    System.out.println("-----------------------------\n");
                    int usuarioOption;
                    System.out.println("Selecione a opção de Usuario:\n[1] - Adcionar Usuario\n[2] - Atualizar Usuario\n[3] - Listar Usuario\n[4] - Listar por ID\n[5] - Deletar Usuario\n[0] - Voltar\n->");
                    usuarioOption = scanner.nextInt();

                    switch (usuarioOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Adcionar Usuario    |\n");
                            System.out.println("-----------------------------\n");
                            adicionarUsuario();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Atualizar Usuario     |\n");
                            System.out.println("-----------------------------\n");
                            atualizarUsuario();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|      Listar Usuario       |\n");
                            System.out.println("-----------------------------\n");
                            listarUsuario();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDUsuario();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Deletar Usuario     |\n");
                            System.out.println("-----------------------------\n");
                            deletarUsuario();
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 6 -> {
                    System.out.println("-----------------------------\n");
                    System.out.println("|          Vendas           |\n");
                    System.out.println("-----------------------------\n");
                    int vendasOption;
                    System.out.println("Selecione a opção de Vendas:\n[1] - Adcionar Vendas\n[2] - Atualizar Vendas\n[3] - Listar Vendas\n[4] - Listar por ID\n[5] - Deletar Vendas\n[0] - Voltar\n->");
                    vendasOption = scanner.nextInt();

                    switch (vendasOption) {
                        case 1 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Adcionar Vendas     |\n");
                            System.out.println("-----------------------------\n");
                            adicionarVendas();
                        }
                        case 2 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|     Atualizar Vendas      |\n");
                            System.out.println("-----------------------------\n");
                            atualizarVendas();
                        }
                        case 3 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|      Listar Vendas        |\n");
                            System.out.println("-----------------------------\n");
                            listarVendas();
                        }
                        case 4 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Listar por ID       |\n");
                            System.out.println("-----------------------------\n");
                            listarIDVendas();
                        }
                        case 5 -> {
                            System.out.println("-----------------------------\n");
                            System.out.println("|       Deletar Vendas      |\n");
                            System.out.println("-----------------------------\n");
                            deletarVendas();
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }

                }
                case 0 -> sair = 1;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (sair != 1);
    }
}