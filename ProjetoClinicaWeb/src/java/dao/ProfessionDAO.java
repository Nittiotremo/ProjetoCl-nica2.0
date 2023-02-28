package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Profissao;
import utils.ConnectionsFilies;

public class ProfessionDAO implements GenericDAO {

    private Connection connec;

    public ProfessionDAO() throws SQLException, ClassNotFoundException {
        this.connec = new ConnectionsFilies().OpenConnection();
    }

    @Override
    public void Record(Object objeto) throws SQLException {
        Profissao profissao = (Profissao) objeto;
        if (profissao.getCodigoProfissao() == 0) {
            Insert(profissao);

        } else {
            Alternate(profissao);
        }
    }

    @Override
    public void Insert(Object objeto) throws SQLException {
        Profissao profissao = (Profissao) objeto;
        String sql = "insert into profissao values (default, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = connec.prepareStatement(sql);
            stmt.setString(1, profissao.getNomeProfissao());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao inserir profissão");
        } finally {
            new ConnectionsFilies().EndConnection(connec, stmt);
        }

    }

    @Override
    public void Alternate(Object objeto) throws SQLException {
        Profissao profissao = (Profissao) objeto;
        String sql = "update profissao set nomeprofissao = ?"
                + "where codigoprofissao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connec.prepareStatement(sql);
            stmt.setString(1, profissao.getNomeProfissao());
            stmt.setInt(2, profissao.getCodigoProfissao());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar profissão");
        } finally {
            new ConnectionsFilies().EndConnection(connec, stmt);
        }
    }

    @Override
    public Object Consult(int codigo) throws SQLException {
        String sql = "select  * from profissao where codigoprofissao = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profissao profissao = null;
        try {
            stmt = connec.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                profissao = new Profissao(
                        rs.getInt("codigoprofissao"),
                        rs.getString("nomeprofissao"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar profissão");
        } finally {
            new ConnectionsFilies().EndConnection(connec, stmt, rs);
        }
        return profissao;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select  * from profissao";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = connec.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Profissao profissao = new Profissao(
                        rs.getInt("codigoprofissao"),
                        rs.getString("nomeprofissao"));
                lista.add(profissao);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar profissão");
        } finally {
            new ConnectionsFilies().EndConnection(connec, stmt, rs);
        }
        return lista;
    }

    @Override
    public void Exclude(int codigo) throws SQLException {
        String sql = "Delete  from where codigoprofissao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connec.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir profissão");
        } finally {
            new ConnectionsFilies().EndConnection(connec, stmt);
        }
    }

}
