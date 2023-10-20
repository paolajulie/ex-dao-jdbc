package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Produto obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO produto (nome, preco, vali, uni) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getNome());
            st.setFloat(2, obj.getPreco());
            st.setDate(3, new java.sql.Date(obj.getVali().getTime()));
            st.setString(4, obj.getUni());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
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
    }


    @Override
    public void update(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE produto " +
                            "SET Nome = ?, Preco = ?, Vali = ?, Uni = ? " +
                            "WHERE Id = ?");

            st.setString(1, obj.getNome());
            st.setFloat(2, obj.getPreco());
            st.setDate(3, (Date) obj.getVali());
            st.setString(4, obj.getUni());
            st.setInt(5, obj.getId());


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
    public List<Produto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM produto ORDER BY Id");
            rs = st.executeQuery();

            List<Produto> list = new ArrayList<>();

            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setVali(rs.getDate("vali"));
                obj.setUni(rs.getString("uni"));

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
    public Produto findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM produto WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Produto obj = new Produto();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setVali(rs.getDate("vali"));
                obj.setUni(rs.getString("uni"));
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
                    "DELETE FROM produto WHERE Id = ?");

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