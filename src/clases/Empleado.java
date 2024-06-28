    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package clases;

    import java.sql.Connection;
import java.sql.PreparedStatement;
    import java.sql.ResultSet;
import java.sql.SQLException;
    import java.sql.Statement;
import javax.swing.JOptionPane;

    /**
     *
     * @author diego
     */
    public class Empleado extends Conexion {
        int id;
        String usuario;
        String contrasenia;
        char turno;
        String nombre;
        String apePaterno;
        String apeMaterno;
        char estatusEmpleado;
        int tipo;


     public Empleado(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado,int tipo) {
            this.id = id;
            this.usuario = usuario;
            this.contrasenia = contrasenia;
            this.turno = turno;
            this.nombre = nombre;
            this.apePaterno = apePaterno;
            this.apeMaterno = apeMaterno;
            this.estatusEmpleado = estatusEmpleado;
            this.tipo=tipo;

        }
          public void agregarNuevoLibro(Libro libro) {
        String query2 = "SELECT id FROM editorial WHERE editorial = ?";
        String query3 = "SELECT id FROM categoria WHERE categoria = ?";
        String query = "INSERT INTO libro (\"tituloLibro\", \"isbnLibro\", \"resumenLibro\", \"precioLibro\", \"stockLibro\", \"descuento\", \"portadalibro\", \"editorial_id\", \"categoria_id\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query4 = "SELECT id FROM autor WHERE autor = ?";
        String query5 = "INSERT INTO autor_libros (\"libro_id\", \"autor_id\") VALUES (?, ?)";
        String query6 = "SELECT MAX(id) as id from libro";

        int idEditorial = 0;
        int idCategoria = 0;
        try (Connection conn = establecerConexion()) {
            PreparedStatement pst2 = conn.prepareStatement(query2);
            PreparedStatement pst3 = conn.prepareStatement(query3);

            pst2.setString(1, libro.getEditorial());
            try (ResultSet rs = pst2.executeQuery()) {
                if (rs.next()) {
                    idEditorial = rs.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la editorial: " + libro.getEditorial());
                    return;
                }
            }

            pst3.setString(1, libro.getCategoria());
            try (ResultSet rs2 = pst3.executeQuery()) {
                if (rs2.next()) {
                    idCategoria = rs2.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la categoría: " + libro.getCategoria());
                    return;
                }
            }

            PreparedStatement pst6 = conn.prepareStatement(query6);
            ResultSet rs3 = pst6.executeQuery();
            int identity = -1;
            if (rs3.next()) {
                identity = rs3.getInt("id") + 1;
            }

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, libro.getTituloLibro());
            pst.setString(2, libro.getIsbnLibro());
            pst.setString(3, libro.getResumenLibro());
            pst.setDouble(4, libro.getPrecioLibro());
            pst.setInt(5, libro.getStockLibro());
            pst.setDouble(6, libro.getDescuento());
            pst.setString(7, libro.getPortadaLibro());
            pst.setInt(8, idEditorial);
            pst.setInt(9, idCategoria);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Libro creado exitosamente");
            }

            for (String autor : libro.getAutores().split(", ")) {
                int autorId = 0;
                PreparedStatement pst4 = conn.prepareStatement(query4);
                pst4.setString(1, autor);
                try (ResultSet rs4 = pst4.executeQuery()) {
                    if (rs4.next()) {
                        autorId = rs4.getInt("id");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el autor: " + autor);
                        continue;
                    }
                }
                PreparedStatement pst5 = conn.prepareStatement(query5);
                pst5.setInt(1, identity);
                pst5.setInt(2, autorId);
                pst5.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   public boolean insertarAutorEnBD(String autor) {
    String query = "INSERT INTO autor (autor) VALUES (?)";
    try (Connection conn = establecerConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, autor);
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
   }
   
   public boolean insertarEditorialEnBD(String editorial) {
    String query = "INSERT INTO editorial (editorial) VALUES (?)";
    try (Connection conn = establecerConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, editorial);
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    
}

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public void setEstatusEmpleado(char estatusEmpleado) {
        this.estatusEmpleado = estatusEmpleado;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }





    }
