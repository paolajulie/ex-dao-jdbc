package application;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

import java.util.List;
import java.util.Scanner;

public class Funcoes {

    static void adicionar(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|     Adicionar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Digite o Nome do Produto:");
        String nome = sc.nextLine();
        System.out.println("Digite o Preco do Produto:");
        String preco = sc.nextLine();
        System.out.println("Digite a Validade do Produto:");
        String vali = sc.nextLine();
        System.out.println("Digite a Unidade de Medida do Produto:");
        String uni = sc.nextLine();
        Produto newProduto = new Produto(null,nome,preco,vali,uni);
        produtoDao.insert(newProduto);
        System.out.println("Adicionado! Novo id: " + newProduto.getId());
        sc.close();
    }

    static void atualizar(){
        Scanner sc = new Scanner(System.in);
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|     Atualizar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID do produto que deseja atualizar:");
        Produto dep2 = produtoDao.findById(sc.nextInt());
        System.out.println("Digite o Nome do Produto:");
        dep2.setNome(sc.nextLine());
        System.out.println("Digite o Preco do Produto:");
        dep2.setPreco(sc.nextLine());
        System.out.println("Digite a Validade do Produto:");
        dep2.setVali(sc.nextLine());
        System.out.println("Digite a Unidade de Medida do Produto:");
        dep2.setUni(sc.nextLine());
        produtoDao.update(dep2);
        System.out.println("Atualizacao Completa!");
        sc.close();
    }

    static void listar(){
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|          Listar           |\n");
        System.out.println("-----------------------------\n");
        List<Produto> list = produtoDao.findAll();
        for (Produto d : list) {
            System.out.println(d);
        }
    }

    static void listarID(){
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("-----------------------------\n");
        System.out.println("|        Listar Produto     |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID a ser exibido:");
        Produto dep = produtoDao.findById(sc.nextInt());
        System.out.println(dep);
        sc.close();
    }

    static void deletar(){
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