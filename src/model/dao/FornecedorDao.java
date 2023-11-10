package model.dao;

import java.util.List;
import model.entities.Fornecedor;

public interface FornecedorDao {

    Fornecedor insert(Fornecedor obj);
    void update(Fornecedor obj);
    void deleteById(Integer idFornecedor);
    Fornecedor findById(Integer idFornecedor);
    List<Fornecedor> findAll();
}
