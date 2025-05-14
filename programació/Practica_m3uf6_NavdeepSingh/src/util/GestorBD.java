package util;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.LinkedList;

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
        PreparedStatement ps = conn.prepareStatement("SELECT MAX(id_tasca) FROM tasques");
        ResultSet ra = ps.executeQuery();

        return ra.getInt("id_tasca");
    }

    public boolean existeixTasca(String tasca) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM tasques WHERE id_tasca = " + tasca);
        ResultSet ra = ps.executeQuery();

        return ra.next();
    }

    public void afegirTasca(String tasca) throws SQLException {
        Statement update = conn.createStatement();

        String[] unprocessedTask = tasca.split(",");
        String title = unprocessedTask[0].split("#")[1];
        String description = unprocessedTask[1];
        int level = Integer.parseInt(unprocessedTask[2]);

        String values = "'" + title + "'" + ", '" + description + "' ," + level;
        System.out.println("INSERT INTO tasques (nom, descripcio, nivell) VALUES (" + values + ");");
        update.executeUpdate("INSERT INTO tasques (nom, descripcio, nivell) VALUES (" + values + ");");
    }

    public void eliminarTasca(String tasca) throws SQLException {
        Statement update = conn.createStatement();
        update.executeUpdate("DELETE FROM TABLE WHERE id_tasca = '" + tasca + "';");
    }

    public void actualitzarTasca(String tasca) throws SQLException {
        Statement update = conn.createStatement();
        String[] unformattedTasks = tasca.split(",");
        int taskId = Integer.parseInt(unformattedTasks[0]);
        String newName = unformattedTasks[1];
        String newDescription = unformattedTasks[2];
        int newLevel = Integer.parseInt(unformattedTasks[3]);

        System.out.println("UPDATE tasques SET nom = '" + newName + "', descripcio = '" + newDescription + "', nivell = '" + newLevel + "' WHERE id_tasca = '" + taskId + "';");
        update.executeQuery("UPDATE tasques SET nom = '" + newName + "', descripcio = '" + newDescription + "', nivell = '" + newLevel + "' WHERE id_tasca = '" + taskId + "';");
    }

    public void mostrarTasquesperNivell(String tasca) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM tasques ORDER BY nivell DESC;");
        ResultSet ra = ps.executeQuery();

        int i = 1;
        while (ra.next()) {
            System.out.println(ra.getString(i));
            i++;
        }
    }
}
