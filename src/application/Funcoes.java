package application;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.EntradaDao;
import model.dao.EstoqueDao;
import model.dao.UsuarioDao;
import model.entities.Produto;
import model.entities.Entrada;
import model.entities.Estoque;
import model.entities.Usuario;

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





        static void adicionarEstoque(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|    Adicionar Estoque      |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Digite o Custo do Estoque:");
        Float custo = Float.parseFloat(sc.nextLine());
        System.out.println("Digite a Descrição do Estoque:");
        String descricao = sc.nextLine();
        System.out.println("Digite a Quantidade do Estoque:");
        int quantidade = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o Mínimo do Estoque:");
        int min = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o Máximo do Estoque:");
        int max = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o Status do Estoque (true/false):");
        boolean statusEstoque = Boolean.parseBoolean(sc.nextLine());

        Estoque newEstoque = new Estoque(null, custo, descricao, quantidade, min, max, statusEstoque);
        estoqueDao.insert(newEstoque);
        System.out.println("Adicionado! Novo idEstoque: " + newEstoque.getIdEstoque());
        sc.close();
    }

    static void atualizarEstoque(){
        Scanner sc = new Scanner(System.in);
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|    Atualizar Estoque      |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID do estoque que deseja atualizar:");
        Estoque estoque = estoqueDao.findById(sc.nextInt());
        System.out.println("Digite o Custo do Estoque:");
        estoque.setCusto(Float.parseFloat(sc.nextLine()));
        System.out.println("Digite a Descrição do Estoque:");
        estoque.setDescricao(sc.nextLine());
        System.out.println("Digite a Quantidade do Estoque:");
        estoque.setQuantidade(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite o Mínimo do Estoque:");
        estoque.setMin(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite o Máximo do Estoque:");
        estoque.setMax(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite o Status do Estoque (true/false):");
        estoque.setStatusEstoque(Boolean.parseBoolean(sc.nextLine()));
        estoqueDao.update(estoque);
        System.out.println("Atualização Completa!");
        sc.close();
    }

    static void listarEstoque(){
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|        Listar Estoque      |\n");
        System.out.println("-----------------------------\n");
        List<Estoque> list = estoqueDao.findAll();
        for (Estoque estoque : list) {
            System.out.println(estoque);
        }
    }

    static void listarIDEstoque(){
        Scanner sc = new Scanner(System.in);
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|   Listar Estoque por ID    |\n");
        System.out.println("-----------------------------\n");
        System.out.println("Informe o ID do estoque a ser exibido:");
        Estoque estoque = estoqueDao.findById(sc.nextInt());
        System.out.println(estoque);
        sc.close();
    }

    static void deletarEstoque(){
        Scanner sc = new Scanner(System.in);
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|      Deletar Estoque       |\n");
        System.out.println("-----------------------------\n");
        System.out.print("Insira o ID do Estoque a ser Excluído: ");
        int idEstoque = sc.nextInt();
        estoqueDao.deleteById(idEstoque);
        System.out.println("Estoque Excluído!");
        sc.close();
    }
}
//usuario
static void adicionarUsuario() {
    Scanner sc = new Scanner(System.in);
    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.println("Digite o Nome do Usuário:");
    String nome = sc.nextLine();
    System.out.println("Digite o ID do Usuário:");
    int id = sc.nextInt();
    sc.nextLine(); // Limpar a quebra de linha
    System.out.println("Digite a Senha do Usuário:");
    String senha = sc.nextLine();
    System.out.println("Digite o CPF do Usuário:");
    String cpf = sc.nextLine();

    Usuario newUsuario = new Usuario(id, senha, nome, cpf);
    usuarioDao.insert(newUsuario);
    System.out.println("Usuário Adicionado! Novo ID: " + newUsuario.getId());
}

static void atualizarUsuario() {
    Scanner sc = new Scanner(System.in);
    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.println("Informe o ID do usuário que deseja atualizar:");
    int userId = sc.nextInt();
    Usuario usuario = usuarioDao.findById(userId);
    sc.nextLine(); // Limpar a quebra de linha

    if (usuario != null) {
        System.out.println("Digite o Novo Nome do Usuário:");
        usuario.setNome(sc.nextLine());
        System.println("Digite a Nova Senha do Usuário:");
        usuario.setSenha(sc.nextLine());
        System.out.println("Digite o Novo CPF do Usuário:");
        usuario.setCpf(sc.nextLine());

        usuarioDao.update(usuario);
        System.out.println("Atualização Completa!");
    } else {
        System.out.println("Usuário não encontrado.");
    }
}

static void listarUsuarios() {
    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    List<Usuario> userList = usuarioDao.findAll();
    for (Usuario user : userList) {
        System.out.println(user);
    }
}

static void listarUsuarioPorID() {
    Scanner sc = new Scanner(System.in);
    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.println("Informe o ID do usuário a ser exibido:");
    int userId = sc.nextInt();
    Usuario usuario = usuarioDao.findById(userId);

    if (usuario != null) {
        System.out.println(usuario);
    } else {
        System.out.println("Usuário não encontrado.");
    }
}

static void deletarUsuario() {
    Scanner sc = new Scanner(System.in);
    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.print("Insira o ID do Usuário a ser Excluído: ");
    int userId = sc.nextInt();
    boolean deleted = usuarioDao.deleteById(userId);

    if (deleted) {
        System.out.println("Usuário Excluído!");
    } else {
        System.out.println("Usuário não encontrado.");
    }
}
}
