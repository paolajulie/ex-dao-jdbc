package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        sc.close();
    }
}
