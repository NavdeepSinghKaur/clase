package util;

import java.sql.*;

public class GestorBD {
    private Connection conn;

    public GestorBD() throws SQLException {
        conn = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/m3uf6Programacio",
                        "root",
                        ""
        );
    }

    public void tancar() throws SQLException {
        conn.close();
    }

    public int getMaxId() throws SQLException {
        PreparedStatement ps = conn.prepareStatement();
        ResultSet ra = ps.executeQuery("SELECT MAX(id_tasca) FROM tasques");
    }

    public boolean existeixTasca(String tasca) {

    }

    public void afegirTasca(String tasca) {

    }

    public void eliminarTasca(String tasca) {

    }

    public void actualitzarTasca(String tasca) {

    }

    public void MostrarTasquesPerNivell(String tasca) {

    }
}
