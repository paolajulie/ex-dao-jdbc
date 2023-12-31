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
import model.dao.FornecedorDao;
import model.dao.VendasDao;
import model.entities.Fornecedor;
import model.entities.Vendas;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Funcoes {

    /* ---------- ENTRADA ---------- */

    static void adicionarEntrada(){
        Scanner sc = new Scanner(System.in);

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
        int idEntrada = sc.nextInt();
        entradaDao.deleteById(idEntrada);
        System.out.println("Produto Excluido!");
    }

    /* ---------- ESTOQUE ---------- */

    static void adicionarEstoque(){
        Scanner sc = new Scanner(System.in);

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
        estoqueDao.insertEstoque(newEstoque);
        System.out.println("Adicionado! Novo idEstoque: " + newEstoque.getIdEstoque());
    }

    static void atualizarEstoque() {
        Scanner sc = new Scanner(System.in);
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.println("-----------------------------\n");
        System.out.println("|    Atualizar Estoque      |\n");
        System.out.println("-----------------------------\n");

        System.out.println("Informe o ID do estoque que deseja atualizar:");
        int idEstoque = sc.nextInt();
        sc.nextLine();

        Estoque estoque = estoqueDao.findById(idEstoque);
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
        System.out.println("Estoque Atualizado com sucesso!");

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

    }

    static void deletarEstoque(){
        Scanner sc = new Scanner(System.in);
        EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();

        System.out.print("Insira o ID do Estoque a ser Excluído: ");
        int idEstoque = sc.nextInt();
        estoqueDao.deleteById(idEstoque);
        System.out.println("Estoque Excluído!");

    }

    /* ---------- FORNECEDOR ---------- */

    static void adicionarFornecedor(){
        Scanner sc = new Scanner(System.in);

        FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

        System.out.println("Digite o nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o Cnpj:");
        String cnpj = sc.nextLine();
        System.out.println("Digite a localizacao:");
        String localizacao = sc.nextLine();
        System.out.println("Digite o contato:");
        String contato = sc.nextLine();

        Fornecedor newFornecedor = new Fornecedor(null,nome,cnpj ,localizacao,contato);
        fornecedorDao.insert(newFornecedor);
        System.out.println("Adicionado! Novo id: " + newFornecedor.getIdFornecedor());
    }

    static void atualizarFornecedor(){
        Scanner sc = new Scanner(System.in);
        FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

        System.out.println("Informe o ID do Fornecedor que deseja atualizar:");
        Fornecedor dep2 = fornecedorDao.findById(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite o Nome do Fornecedor:");
        dep2.setNome(sc.nextLine());
        System.out.println("Digite o Cnpj do Fornecedor:");
        dep2.setCnpj(sc.nextLine());
        System.out.println("Digite a Localização do Fornecedor:");
        dep2.setLocalizacao(sc.nextLine());
        System.out.println("Digite o Contato do Fornecedor:");
        dep2.setContato(sc.nextLine());
        fornecedorDao.update(dep2);
        System.out.println("Atualizacao Completa!");

    }

    static void listarFornecedor() {
        FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

        List<Fornecedor> list = fornecedorDao.findAll();
        for (Fornecedor fornecedor : list) {
            System.out.println(fornecedor);
        }
    }

    static void listarIDFornecedor() {
        Scanner sc = new Scanner(System.in);

        FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

        System.out.println("Informe o ID a ser exibido:");
        Fornecedor fornecedor = fornecedorDao.findById(sc.nextInt());
        System.out.println(fornecedor);
    }

    static void deletarFornecedor() {
        Scanner sc = new Scanner(System.in);
        FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

        System.out.print("Insira o ID do Fornecedor a ser Excluído: ");
        int idFornecedor = sc.nextInt();
        fornecedorDao.deleteById(idFornecedor);
        System.out.println("Fornecedor Excluído!");

    }

    /* ---------- PRODUTO ---------- */

    static void adicionarProduto(){
        Scanner sc = new Scanner(System.in);

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

    /* ---------- USUARIO ---------- */

    static void adicionarUsuario(){
        Scanner sc = new Scanner(System.in);

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        System.out.println("Digite a senha do Usuario:");
        String senha = sc.nextLine();
        System.out.println("Digite o nome do Usuario:");
        String nome = sc.nextLine();
        System.out.println("Digite o cpf do Usuario:");
        String cpf = sc.nextLine();
        Usuario newUsuario = new Usuario(null,nome,senha,cpf);
        usuarioDao.insert(newUsuario);
        System.out.println("Adicionado! Novo id: " + newUsuario.getIdUsuario());
    }

    static void atualizarUsuario(){
        Scanner sc = new Scanner(System.in);

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        System.out.println("Informe o ID do usuario que deseja atualizar:");
        Usuario dep2 = usuarioDao.findById(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite a senha do Usuario:");
        dep2.setSenha(sc.nextLine());
        System.out.println("Digite o nome do Usuario:");
        dep2.setNome(sc.nextLine());
        System.out.println("Digite o cpf do Usuario:");
        dep2.setCpf(sc.nextLine());
        usuarioDao.update(dep2);
        System.out.println("Atualizacao Completa!");

    }

    static void listarUsuario(){
        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        List<Usuario> list = usuarioDao.findAll();
        for (Usuario d : list) {
            System.out.println(d);
        }
    }

    static void listarIDUsuario(){
        Scanner sc = new Scanner(System.in);

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        System.out.println("Informe o ID a ser exibido:");
        Usuario dep = usuarioDao.findById(sc.nextInt());
        System.out.println(dep);
    }

    static void deletarUsuario(){
        Scanner sc = new Scanner(System.in);

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        System.out.print("Insira o ID do Usuario a ser Excluido: ");
        int idUsuario = sc.nextInt();
        usuarioDao.deleteById(idUsuario);
        System.out.println("Produto Excluido!");
    }

    /* ---------- VENDAS ---------- */

    static void adicionarVendas(){
        Scanner sc = new Scanner(System.in);

        VendasDao vendasDao = DaoFactory.createVendasDao();

        System.out.println("Digite a Observacao da Venda:");
        String observacao = sc.nextLine();
        System.out.println("Digite a Data de Venda (no formato dd/MM/yyyy):");
        String dataSaidaString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataSaida = null;
        try {
            dataSaida = sdf.parse(dataSaidaString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        Vendas newVendas = new Vendas(null,observacao,dataSaida);
        vendasDao.insert(newVendas);
        System.out.println("Adicionado! Novo id: " + newVendas.getIdVendas());
    }

    static void atualizarVendas(){
        Scanner sc = new Scanner(System.in);

        VendasDao vendasDao = DaoFactory.createVendasDao();

        System.out.println("Informe o ID da Venda que deseja atualizar:");
        Vendas dep2 = vendasDao.findById(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite a Observacao da Venda:");
        dep2.setObservacao(sc.nextLine());
        System.out.println("Digite a Data da Venda :");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dep2.setDataSaida(formatoData.parse(sc.nextLine()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        vendasDao.update(dep2);
        System.out.println("Atualizacao Completa!");
    }

    static void listarVendas(){
        VendasDao vendasDao = DaoFactory.createVendasDao();

        List<Vendas> list = vendasDao.findAll();
        for (Vendas d : list) {
            System.out.println(d);
        }
    }

    static void listarIDVendas(){
        Scanner sc = new Scanner(System.in);

        VendasDao vendasDao = DaoFactory.createVendasDao();

        System.out.println("Informe o ID a ser exibido:");
        Vendas dep = vendasDao.findById(sc.nextInt());
        System.out.println(dep);
    }

    static void deletarVendas(){
        Scanner sc = new Scanner(System.in);

        VendasDao vendasDao = DaoFactory.createVendasDao();

        System.out.print("Insira o ID da Venda a ser Excluido: ");
        int idVendas = sc.nextInt();
        vendasDao.deleteById(idVendas);
        System.out.println("Venda Excluida!");
    }
}