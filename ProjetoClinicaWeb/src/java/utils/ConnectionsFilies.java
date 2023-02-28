package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionsFilies {

    //Connects to Data Base
    public Connection OpenConnection() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection //Password can be different on others computer
                    ("jdbc:postgresql://localhost:5432//CLINICADB", "postgres", "unifunec");
            //Creates exeptions in case of an error
        } catch (SQLException ex) {
            throw new SQLException("Erro connecting to database");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Data base drivers not found");
        }
    }

    //Ending connection
    private void Finish(Connection Connec, PreparedStatement stmt, ResultSet rs) throws SQLException {
        try {
            if (Connec != null) {
                Connec.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new SQLException("Error trying ending connection to Data Base");
        }
    }

    public void EndConnection(Connection Connec, PreparedStatement stmt) throws SQLException {
        Finish(Connec, stmt, null);
    }

    public void EndConnection(Connection Connec, PreparedStatement stmt, ResultSet rs)
            throws SQLException {
        Finish(Connec, stmt, rs);
    }

}