package model.dao;

import db.DB;
import model.dao.impl.EntradaDaoJDBC;
import model.dao.impl.FornecedorDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.EstoqueDaoJDBC;

public class DaoFactory {

    public static ProdutoDao createProdutoDao() {return new ProdutoDaoJDBC(DB.getConnection());
    }

    public static EntradaDao createEntradaDao() {return new EntradaDaoJDBC(DB.getConnection());
    }

    public static EstoqueDao createEstoqueDao() {
        return new EstoqueDaoJDBC(DB.getConnection());
    }

    public static FornecedorDao createFornecedorDao() {return new FornecedorDaoJDBC(DB.getConnection());}
}
