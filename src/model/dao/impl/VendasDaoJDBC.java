import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    "INSERT INTO Vendas (observacao, dataEntrada, idUsuario) VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getObservacao());
            st.setDate(2, new java.sql.Date(obj.getDataEntrada().getTime()));
            st.setInt(3, obj.getIdUsuario());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdVendas(id);
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
    public void update(Vendas obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Vendas " +
                            "SET observacao = ?, dataEntrada = ?, idUsuario = ? " +
                            "WHERE idVendas = ?");

            st.setString(1, obj.getObservacao());
            st.setDate(2, new java.sql.Date(obj.getDataEntrada().getTime()));
            st.setInt(3, obj.getIdUsuario());
            st.setInt(4, obj.getIdVendas());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Vendas> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Vendas ORDER BY idVendas");
            rs = st.executeQuery();

            List<Vendas> list = new ArrayList<>();

            while (rs.next()) {
                Vendas obj = new Vendas();
                obj.setIdVendas(rs.getInt("idVendas"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataEntrada(rs.getDate("dataEntrada"));
                obj.setIdUsuario(rs.getInt("idUsuario"));

                list.add(obj);
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
    public Vendas findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Vendas WHERE idVendas = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Vendas obj = new Vendas();
                obj.setIdVendas(rs.getInt("idVendas"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setDataEntrada(rs.getDate("dataEntrada"));
                obj.setIdUsuario(rs.getInt("idUsuario"));
                return obj;
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
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM Vendas WHERE idVendas = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }
}
