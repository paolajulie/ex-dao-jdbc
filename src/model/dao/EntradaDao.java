package model.dao;

import java.util.List;

import model.entities.Entrada;

public interface EntradaDao {

    void insertEntrada(Entrada obj);
    void update(Entrada obj);
    void deleteById(Integer idEntrada);
    Entrada findById(Integer idEntrada);
    List<Entrada> findAll();
}
