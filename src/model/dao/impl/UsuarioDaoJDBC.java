package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conn;

    public UsuarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Usuario obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO usuario (senha, nome, cpf) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getSenha());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getCpf());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdUsuario(id);
                }
            } else {
                throw new DbException("Erro inesperado! Nenhuma linha afetada!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Usuario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE usuario " +
                            "SET senha = ?, nome = ?, cpf = ? " +
                            "WHERE idUsuario = ?");

            st.setString(1, obj.getSenha());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getCpf());
            st.setInt(4, obj.getIdUsuario());
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
    public List<Usuario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM usuario ORDER BY idUsuario");
            rs = st.executeQuery();

            List<Usuario> list = new ArrayList<>();

            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("idUsuario"));
                obj.setSenha(rs.getString("senha"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));

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
    public Usuario findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM usuario WHERE idUsuario = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("idUsuario"));
                obj.setSenha(rs.getString("senha"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
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
                    "DELETE FROM usuario WHERE idUsuario = ?");
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
