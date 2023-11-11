package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Fornecedor;
import model.dao.FornecedorDao;

public class FornecedorDaoJDBC implements FornecedorDao {

    private Connection conn;

    public FornecedorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Fornecedor insert(Fornecedor obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO fornecedor (nome, cnpj, localizacao, contato) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getLocalizacao());
            st.setString(4, obj.getContato());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdFornecedor(id);
                }
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return obj;
    }


    @Override
    public void update(Fornecedor obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE fornecedor " +
                            "SET nome = ?, cnpj = ?, localizacao = ?, contato = ? " +
                            "WHERE idFornecedor = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getLocalizacao());
            st.setString(4, obj.getContato());
            st.setInt(5, obj.getIdFornecedor());


            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Fornecedor> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM fornecedor ORDER BY idFornecedor");
            rs = st.executeQuery();

            List<Fornecedor> list = new ArrayList<>();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setLocalizacao(rs.getString("localizacao"));
                obj.setContato(rs.getString("contato"));

                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Fornecedor findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM fornecedor WHERE IdFornecedor = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
               Fornecedor obj = new Fornecedor();
                obj.setIdFornecedor(rs.getInt("IdFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setLocalizacao(rs.getString("localizacao"));
                obj.setContato(rs.getString("contato"));
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM fornecedor WHERE IdFornecedor = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
}

