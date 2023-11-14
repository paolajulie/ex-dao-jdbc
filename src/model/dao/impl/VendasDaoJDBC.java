package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.VendasDao;
import model.entities.Vendas;

public class VendasDaoJDBC implements VendasDao {

    private Connection conn;

    public VendasDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Vendas obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO Vendas (observacao, dataSaida) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getObservacao());
            st.setDate(2, new java.sql.Date(obj.getDataSaida().getTime()));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdVendas(id);
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
    public void update(Vendas obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Vendas " +
                            "SET observacao = ?, dataSaida = ?" +
                            "WHERE IdVendas = ?");

            st.setString(1, obj.getObservacao());
            java.util.Date utilDate = obj.getDataSaida();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(2, sqlDate);
            st.setInt(3, obj.getIdVendas());

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
    public List<Vendas> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Vendas ORDER BY IdVendas");
            rs = st.executeQuery();

            List<Vendas> list = new ArrayList<>();

            while (rs.next()) {
                Vendas obj = new Vendas();
                obj.setIdVendas(rs.getInt("IdVendas"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataSaida(rs.getDate("dataSaida"));

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
    public Vendas findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Vendas WHERE IdVendas = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Vendas obj = new Vendas();
                obj.setIdVendas(rs.getInt("IdEntrada"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataEntrada(rs.getDate("dataSaida"));
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
                    "DELETE FROM Vendas WHERE IdVendas = ?");

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

