package model.dao;

import java.util.List;
import model.entities.Estoque;

public interface UsuarioDao {

    void insert(Usuario obj);
    void update(Usuario obj);
    void deleteById(Integer idUsuario);
    Estoque findById(Integer idUsuario);
    List<usuario> findAll();
}
