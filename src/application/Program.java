package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class Program  extends Funcoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo:\n");
        System.out.println("1 - Adcionar Produto\n" +
                "2 - Atualizar Produto\n" +
                "3 - Listar Produtos\n" +
                "4 - Listar por ID\n" +
                "5 - Deletar Produto\n" +
                "Digite o numero:");
        Integer escolha = sc.nextInt();

        switch (escolha){
            case 1:
                adicionar();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                listarID();
                break;
            case 5:
                deletar();
                break;
            default:
                System.out.println("escolha invalida");
        }
    }
}

