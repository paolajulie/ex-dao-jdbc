package application;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.EntradaDao;
import model.entities.Produto;
import model.entities.Entrada;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Funcoes {

    static void adicionarEntrada(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        EntradaDao entradaDao = DaoFactory.createEntradaDao();

        System.out.println("Digite a Observacao da Entrada:");
        String observacao = sc.nextLine();
        System.out.println("Digite a Data de Entrada (no formato dd/MM/yyyy):");
        String dataEntradaString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = null;
        try {
            dataEntrada = sdf.parse(dataEntradaString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        Entrada newEntrada = new Entrada(null,observacao,dataEntrada);
        entradaDao.insertEntrada(newEntrada);
        System.out.println("Adicionado! Novo id: " + newEntrada.getIdEntrada());
    }

    static void atualizarEntrada(){
        Scanner sc = new Scanner(System.in);
        EntradaDao entradaDao = DaoFactory.createEntradaDao();

        System.out.println("Informe o ID do produto que deseja atualizar:");
        Entrada dep2 = entradaDao.findById(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite a Observacao da Entrada:");
        dep2.setObservacao(sc.nextLine());
        System.out.println("Digite a Data de Entrada :");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dep2.setDataEntrada(formatoData.parse(sc.nextLine()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        entradaDao.update(dep2);
        System.out.println("Atualizacao Completa!");
    }

    static void listarEntrada(){
        EntradaDao entradaDao = DaoFactory.createEntradaDao();

        List<Entrada> list = entradaDao.findAll();
        for (Entrada d : list) {
            System.out.println(d);
        }
    }

    static void listarIDEntrada(){
        Scanner sc = new Scanner(System.in);

        EntradaDao entradaDao = DaoFactory.createEntradaDao();

        System.out.println("Informe o ID a ser exibido:");
        Entrada dep = entradaDao.findById(sc.nextInt());
        System.out.println(dep);
    }

    static void deletarEntrada(){
        Scanner sc = new Scanner(System.in);

        EntradaDao entradaDao = DaoFactory.createEntradaDao();

        System.out.print("Insira o ID da Entrada a ser Excluido: ");
        int id = sc.nextInt();
        entradaDao.deleteById(id);
        System.out.println("Produto Excluido!");
    }






    static void adicionarProduto(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("Digite o Nome do Produto:");
        String nome = sc.nextLine();
        System.out.println("Digite o Preco do Produto:");
        Float preco = Float.parseFloat(sc.nextLine());
        System.out.println("Digite a Validade do Produto (no formato dd/MM/yyyy):");
        String valiString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date vali = null;
        try {
            vali = sdf.parse(valiString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Digite a Unidade de Medida do Produto:");
        String uni = sc.nextLine();
        Produto newProduto = new Produto(null,nome,preco,vali,uni);
        produtoDao.insert(newProduto);
        System.out.println("Adicionado! Novo id: " + newProduto.getId());
    }

    static void atualizarProduto(){
        Scanner sc = new Scanner(System.in);
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("Informe o ID do produto que deseja atualizar:");
        Produto dep2 = produtoDao.findById(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite o Nome do Produto:");
        dep2.setNome(sc.nextLine());
        System.out.println("Digite o Preco do Produto:");
        dep2.setPreco(Float.parseFloat(sc.nextLine()));
        System.out.println("Digite a Validade do Produto:");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dep2.setVali(formatoData.parse(sc.nextLine()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Digite a Unidade de Medida do Produto:");
        dep2.setUni(sc.nextLine());
        produtoDao.update(dep2);
        System.out.println("Atualizacao Completa!");

    }

    static void listarProduto(){
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        List<Produto> list = produtoDao.findAll();
        for (Produto d : list) {
            System.out.println(d);
        }
    }

    static void listarIDProduto(){
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.println("Informe o ID a ser exibido:");
        Produto dep = produtoDao.findById(sc.nextInt());
        System.out.println(dep);
    }

    static void deletarProduto(){
        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        System.out.print("Insira o ID do Produto a ser Excluido: ");
        int id = sc.nextInt();
        produtoDao.deleteById(id);
        System.out.println("Produto Excluido!");
    }

}