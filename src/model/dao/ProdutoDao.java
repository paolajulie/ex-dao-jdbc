package model.dao;

import java.util.List;

import model.entities.Produto;

public interface ProdutoDao {

    void adcionar(Produto obj);
    void atualizar(Produto obj);
    void deletar(Integer id);
    Produto listarId(Integer id);
    List<Produto> listar();
}
