package model.dao;

import db.DB;
import model.dao.impl.EntradaDaoJDBC;
import model.dao.impl.EstoqueDaoJDBC;
import model.dao.impl.FornecedorDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;
import model.dao.impl.VendasDaoJDBC;

public class DaoFactory {

    public static EntradaDao createEntradaDao() {
        return new EntradaDaoJDBC(DB.getConnection());
    }
    public static EstoqueDao createEstoqueDao() {
        return new EstoqueDaoJDBC(DB.getConnection());
    }
    public static UsuarioDao createUsuarioDao() {
        return new UsuarioDaoJDBC(DB.getConnection());
    }
    public static FornecedorDao createFornecedorDao() { return new FornecedorDaoJDBC(DB.getConnection()); }
    public static ProdutoDao createProdutoDao() { return new ProdutoDaoJDBC(DB.getConnection()); }
    public static VendasDao createVendasDao() { return new VendasDaoJDBC(DB.getConnection()); }
}

