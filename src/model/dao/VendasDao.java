package model.dao;

import java.util.List;
import model.entities.Vendas;

public interface VendasDao {

    Vendas insert(Vendas obj);
    void update(Vendas obj);
    void deleteById(Integer idVendas);
    Vendas findById(Integer idVendas);
    List<Vendas> findAll();
}
