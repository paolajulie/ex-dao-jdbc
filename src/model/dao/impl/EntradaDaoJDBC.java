package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.EntradaDao;
import model.entities.Entrada;

public class EntradaDaoJDBC implements EntradaDao {

    private final Connection conn;

    public EntradaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Entrada insertEntrada(Entrada obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO entrada (observacao, dataEntrada) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getObservacao());
            st.setDate(2, new java.sql.Date(obj.getDataEntrada().getTime()));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdEntrada(id);
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
    public void update(Entrada obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE entrada " +
                            "SET Observacao = ?, DataEntrada = ?" +
                            "WHERE IdEntrada = ?");

            st.setString(1, obj.getObservacao());
            java.util.Date utilDate = obj.getDataEntrada();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(2, sqlDate);
            st.setInt(3, obj.getIdEntrada());


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
    public List<Entrada> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM entrada ORDER BY IdEntrada");
            rs = st.executeQuery();

            List<Entrada> list = new ArrayList<>();

            while (rs.next()) {
                Entrada obj = new Entrada();
                obj.setIdEntrada(rs.getInt("idEntrada"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataEntrada(rs.getDate("dataEntrada"));

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
    public Entrada findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM entrada WHERE IdEntrada = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Entrada obj = new Entrada();
                obj.setIdEntrada(rs.getInt("IdEntrada"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataEntrada(rs.getDate("dataEntrada"));
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
                    "DELETE FROM entrada WHERE IdEntrada = ?");

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