package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO {

    public void Record(Object objeto) throws SQLException;

    public void Insert(Object objeto) throws SQLException;

    public void Alternate(Object objeto) throws SQLException;

    public Object Consult(int codigo) throws SQLException;

    public List<Object> listar() throws SQLException;

    public void Exclude (int codigo) throws SQLException;
}
