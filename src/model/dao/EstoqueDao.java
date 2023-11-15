package model.dao;

import java.util.List;

import model.entities.Entrada;
import model.entities.Estoque;

public interface EstoqueDao {

    Estoque insertEstoque(Estoque obj);
    void update(Estoque obj);
    void deleteById(Integer idEstoque);
    Estoque findById(Integer idEstoque);
    List<Estoque> findAll();
}
