package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.EstoqueDao;
import model.entities.Estoque;

public class EstoqueDaoJDBC implements EstoqueDao {

    private Connection conn;

    public EstoqueDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Estoque obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO Estoque (custo, descricao, quantidade, min, max, StatusEstoque) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setFloat(1, obj.getCusto());
            st.setString(2, obj.getDescricao());
            st.setInt(3, obj.getQuantidade());
            st.setInt(4, obj.getMin());
            st.setInt(5, obj.getMax());
            st.setBoolean(6, obj.getStatusEstoque());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int idEstoque = rs.getInt(1);
                    obj.setIdEstoque(idEstoque);
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
    public void update(Estoque obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Estoque " +
                            "SET custo = ?, descricao = ?, quantidade = ?, min = ?, max = ?, StatusEstoque = ? " +
                            "WHERE idEstoque = ?");

            st.setFloat(1, obj.getCusto());
            st.setString(2, obj.getDescricao());
            st.setInt(3, obj.getQuantidade());
            st.setInt(4, obj.getMin());
            st.setInt(5, obj.getMax());
            st.setBoolean(6, obj.getStatusEstoque());
            st.setInt(7, obj.getIdEstoque());

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
    public List<Estoque> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Estoque ORDER BY idEstoque");
            rs = st.executeQuery();

            List<Estoque> list = new ArrayList<>();

            while (rs.next()) {
                Estoque obj = new Estoque();
                obj.setIdEstoque(rs.getInt("idEstoque"));
                obj.setCusto(rs.getFloat("custo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setMin(rs.getInt("min"));
                obj.setMax(rs.getInt("max"));
                obj.setStatusEstoque(rs.getBoolean("StatusEstoque"));

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
    public Estoque findById(Integer idEstoque) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Estoque WHERE idEstoque = ?");
            st.setInt(1, idEstoque);
            rs = st.executeQuery();
            if (rs.next()) {
                Estoque obj = new Estoque();
                obj.setIdEstoque(rs.getInt("idEstoque"));
                obj.setCusto(rs.getFloat("custo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setMin(rs.getInt("min"));
                obj.setMax(rs.getInt("max"));
                obj.setStatusEstoque(rs.getBoolean("StatusEstoque"));
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
    public void deleteById(Integer idEstoque) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM Estoque WHERE idEstoque = ?");

            st.setInt(1, idEstoque);

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