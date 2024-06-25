package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Inventario extends Conexion {
    public List<Libro> inventario() {
        List<Libro> inventario = new ArrayList<>();
 String query = "SELECT l.\"id\", l.\"tituloLibro\", l.\"precioLibro\", l.\"stockLibro\", l.\"resumenLibro\", l.\"isbnLibro\", e.\"editorial\" AS \"editorial\", c.\"categoria\" AS \"categoria\", l.\"descuento\" " +
                       "FROM \"public\".\"libro\" l " +
                       "JOIN \"public\".\"editorial\" e ON l.\"editorial_id\" = e.\"id\" " +
                       "JOIN \"public\".\"categoria\" c ON l.\"categoria_id\" = c.\"id\"";
        try (Connection conn = establecerConexion();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("tituloLibro");
              
                double precio = rs.getDouble("precioLibro");
                int stock = rs.getInt("stockLibro");
                String resumen = rs.getString("resumenLibro");
                String isbn = rs.getString("isbnLibro");
                String editorial = rs.getString("editorial");
                String categoria = rs.getString("categoria");
                double descuento = rs.getDouble("descuento");

                Libro libro = new Libro(id, titulo, precio, stock, resumen, isbn, editorial, categoria, descuento);
                inventario.add(libro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }

        return inventario;
    }
}
