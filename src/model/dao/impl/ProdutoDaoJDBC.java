package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void adcionar(Produto produto) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO produto " +
                            "(nome, preco, validade, unidade) " +
                            "VALUES " +
                            "(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, produto.getNome());
            st.setString(2, produto.getPreco());
            st.setString(3, produto.getValidade());
            st.setString(4, produto.getUnidade());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    produto.setId(id);
                }
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Produto> listar() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM produto ORDER BY Id");
            rs = st.executeQuery();

            List<Produto> list = new ArrayList<>();

            while (rs.next()) {
                Produto produto = instantiateProduto(rs);
                list.add(produto);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


    @Override
    public void atualizar(Produto produto) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE produto " +
                            "SET nome = ?, preco = ?, validade = ?, unidade = ? " +
                            "WHERE Id = ?");

            st.setString(1, produto.getNome());
            st.setString(2, produto.getPreco());
            st.setString(3, produto.getValidade());
            st.setString(4, produto.getUnidade());
            st.setInt(5, produto.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Produto listarId(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM produto WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                return instantiateProduto(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void deletar(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM produto WHERE Id = ?");
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("Produto não encontrado para o ID: " + id);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    // Helper method to instantiate a Produto object from a ResultSet
    private Produto instantiateProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getInt("Id"));
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getString("preco"));
        produto.setValidade(rs.getString("validade"));
        produto.setUnidade(rs.getString("unidade"));
        return produto;
    }
}