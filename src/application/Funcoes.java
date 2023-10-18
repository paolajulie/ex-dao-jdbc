package application;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

import java.util.List;
import java.util.Scanner;

public class Funcoes {

    static void adicionar() {
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|     Adicionar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Digite o Nome do Produto:");
        String nome = sc.nextLine();
        System.out.println("Digite o Preco do Produto:");
        String preco = sc.nextLine();
        System.out.println("Digite a Validade do Produto:");
        String validade = sc.nextLine();
        System.out.println("Digite a Unidade de Medida do Produto:");
        String unidade = sc.nextLine();
        Produto produtoNew = new Produto(null, nome, preco, validade, unidade);
        produtoDao.insert(produtoNew);
        System.out.println("Adicionado! Novo id: " + produtoNew.getId());
        sc.close();
    }

    static void atualizar() {
        Scanner sc = new Scanner(System.in);
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|     Atualizar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID do produto que deseja atualizar:");
        int productId = sc.nextInt();
        Produto produtoAtualizado = produtoDao.findById(productId);
        sc.nextLine();  // Consume the newline character
        System.out.println("Digite o Nome do Produto:");
        produtoAtualizado.setNome(sc.nextLine());
        System.out.println("Digite o Preco do Produto:");
        produtoAtualizado.setPreco(sc.nextLine());
        System.out.println("Digite a Validade do Produto:");
        produtoAtualizado.setValidade(sc.nextLine());
        System.out.println("Digite a Unidade de Medida do Produto:");
        produtoAtualizado.setUnidade(sc.nextLine());
        produtoDao.update(produtoAtualizado);
        System.out.println("Atualizacao Completa!");
        sc.close();
    }

    static void listar() {
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|          Listar           |\n");
        System.out.println("-----------------------------\n");
        List<Produto> list = produtoDao.listar();
        for (Produto produto : list) {
            System.out.println(produto);
        }
    }

    static void listarID() {
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|        Listar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID a ser exibido:");
        int productId = sc.nextInt();
        Produto produto = produtoDao.findById(id);
        System.out.println(produto);
        sc.close();
    }

    static void deletar() {
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|       Deletar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.print("Insira o ID do Produto a ser Excluido: ");
        int id = sc.nextInt();
        produtoDao.deleteById(id);
        System.out.println("Produto Excluido!");
        sc.close();
    }
}