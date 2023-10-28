package model.dao;

import db.DB;
import model.dao.impl.EntradaDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.EstoqueDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

    public static ProdutoDao createProdutoDao() {
        return new ProdutoDaoJDBC(DB.getConnection());
    }

    public static EntradaDao createEntradaDao() {
        return new EntradaDaoJDBC(DB.getConnection());
    }

    public static EstoqueDao createEstoqueDao() {
        return new EstoqueDaoJDBC(DB.getConnection());
    }
<<<<<<< HEAD

=======
   
>>>>>>> da7da01266ab8afe7ce18557b06113101d3fcec7
    public static UsuarioDao createUsuarioDao() {
        return new UsuarioDaoJDBC(DB.getConnection());
    }
}
