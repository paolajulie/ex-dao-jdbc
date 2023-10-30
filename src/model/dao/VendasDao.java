package model.dao;

import java.util.List;
import model.entities.Vendas;

public interface VendasDao {

    void insert(Vendas obj);
    void update(Vendas obj);
    void deleteById(Integer id);
    Vendas findById(Integer id);
    List<Vendas> findAll();
}
