/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import VISTAS.AgregarNuevoEmpleado;
import static java.lang.invoke.MethodHandles.identity;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lucas
 */
public class Admin extends Empleado {
    
    public Admin(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado,int tipo) {
        super(id, usuario, contrasenia, turno, nombre, apePaterno, apeMaterno, estatusEmpleado,tipo);
    }
    
 
    public void crearNuevoEmpleado() {
        
        String query = "INSERT INTO empleado (\"nombresEmpleado\", \"apellidoPaternoEmpleado\", \"apellidoMaternoEmpleado\", \"usuarioEmpleado\", \"contraseniaEmpleado\", \"turnoEmpleado\", \"estatusEmpleado\") VALUES (?, ?, ?, ?, ?, ?, ?)";
        String query2 = "SELECT nextval('empleado_id_seq') AS id";
         String query3 = "INSERT INTO \"tipoEmpleado_empleados\" (\"tipoempleado_id\", \"empleado_id\") VALUES (?, ?)";

        
        try (Connection conn = establecerConexion();) {
             PreparedStatement pst = conn.prepareStatement(query);
             PreparedStatement pst2 = conn.prepareStatement(query2);
             ResultSet rs = pst2.executeQuery();
             int identity = -1;
             if (rs.next()) {
                identity = rs.getInt("id")+1;
            }
             
            String usuario= nombre.substring(0, 1).toUpperCase() + apePaterno.substring(0, 1).toUpperCase() + "01"+ String.format("%05d", identity);
             
         
             
          
            pst.setString(1, nombre);
            pst.setString(2, apePaterno);
            pst.setString(3, apeMaterno);
            pst.setString(4, usuario);
            pst.setString(5, contrasenia);
            pst.setString(6, String.valueOf(turno));  // Convertimos char a String
            pst.setString(7, String.valueOf(estatusEmpleado));  // Convertimos char a String
            
            
            int rowsAffected = pst.executeUpdate();
            PreparedStatement pst3 = conn.prepareStatement(query3);
            pst3.setInt(1, tipo);
            pst3.setInt(2, identity);
            int rowsAffected2 = pst3.executeUpdate();
            
            if (rowsAffected > 0 && rowsAffected2>0) {
                JOptionPane.showMessageDialog(null, "Empleado creado exitosamente");
            }
            
            
            rs.close();
            pst.close();
            pst2.close();
            pst3.close();
            conn.close();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }
        
        
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
   public boolean nuevoAutor(String autor) {
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
   
   
   
   public boolean nuevaEditorial(String editorial) {
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
 public void eliminarLibro(Libro libro){
      
    String query = "DELETE FROM \"public\".\"libro\" WHERE \"id\" = ?";

    try (Connection conn = establecerConexion();
         PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setInt(1, libro.getId());
        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el libro.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
    }
}
 public void editarEmpleado(Empleado empleado) {
    String query = "UPDATE empleado SET \"nombresEmpleado\" = ?, \"apellidoPaternoEmpleado\" = ?, \"apellidoMaternoEmpleado\" = ?, \"usuarioEmpleado\" = ?, \"contraseniaEmpleado\" = ?, \"turnoEmpleado\" = ?, \"estatusEmpleado\" = ? WHERE id = ?";
    String queryIntermedia = "UPDATE \"tipoEmpleado_empleados\" SET \"tipoempleado_id\" = ? WHERE \"empleado_id\" = ?";

    try (Connection conn = establecerConexion()) {
        String usuario = empleado.getNombre().substring(0, 1).toUpperCase() + empleado.getApePaterno().substring(0, 1).toUpperCase() + "01" + String.format("%05d", empleado.getId());

        // Actualizar los datos del empleado
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, empleado.getNombre());
        pst.setString(2, empleado.getApePaterno());
        pst.setString(3, empleado.getApeMaterno());
        pst.setString(4, usuario);
        pst.setString(5, empleado.getContrasenia());
        pst.setString(6, String.valueOf(empleado.getTurno()));
        pst.setString(7, String.valueOf(empleado.getEstatusEmpleado()));
        pst.setInt(8, empleado.getId());

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente");
        }

        // Actualizar los datos en la tabla intermedia
        PreparedStatement pstIntermedia = conn.prepareStatement(queryIntermedia);
        pstIntermedia.setInt(1, empleado.getTipo());
        pstIntermedia.setInt(2, empleado.getId());

        int rowsAffectedIntermedia = pstIntermedia.executeUpdate();
        if (rowsAffectedIntermedia > 0) {
            JOptionPane.showMessageDialog(null, "Tipo de empleado actualizado exitosamente");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
 }
    public void eliminarEmpleado(Empleado empleado){
      
    String query = "Update empleado set \"estatusEmpleado\"='B' WHERE \"id\" = ?";

    try (Connection conn = establecerConexion();
         PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setInt(1, empleado.getId());
        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el libro.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
    }
}   
    public void actualizarDescuentoLibro(int libroId, double descuento) {
    String query = "UPDATE libro SET \"descuento\" = ? WHERE \"id\" = ?";
    
    try (Connection conn = establecerConexion()) {
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setDouble(1, descuento);
        pst.setInt(2, libroId);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Descuento actualizado exitosamente para el libro con ID: " + libroId);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el libro con ID: " + libroId);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
     
 
  
    
    
    
public void editarLibro(Libro libro) {
    String query2 = "SELECT id FROM editorial WHERE editorial = ?";
    String query3 = "SELECT id FROM categoria WHERE categoria = ?";
    String query = "UPDATE libro SET \"tituloLibro\" = ?, \"isbnLibro\" = ?, \"resumenLibro\" = ?, \"precioLibro\" = ?, \"stockLibro\" = ?, \"descuento\" = ?, \"portadalibro\" = ?, \"editorial_id\" = ?, \"categoria_id\" = ? WHERE id = ?";
    String query4 = "DELETE FROM autor_libros WHERE \"libro_id\" = ?";
    String query5 = "INSERT INTO autor_libros (\"libro_id\", \"autor_id\") VALUES (?, ?)";

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
        pst.setInt(10, libro.getId());

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Libro actualizado exitosamente");
        }

        // Eliminar registros anteriores de la tabla intermedia
        PreparedStatement pst4 = conn.prepareStatement(query4);
        pst4.setInt(1, libro.getId());
        pst4.executeUpdate();

        // Insertar los nuevos autores asociados al libro en la tabla intermedia
        String[] autores = libro.getAutores().split(", ");
        for (String autor : autores) {
            int autorId = obtenerIdAutor(conn, autor); // Método para obtener el ID del autor
            if (autorId != -1) {
                PreparedStatement pst5 = conn.prepareStatement(query5);
                pst5.setInt(1, libro.getId());
                pst5.setInt(2, autorId);
                pst5.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el autor: " + autor);
                continue;
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

private int obtenerIdAutor(Connection conn, String autor) throws SQLException {
    String query = "SELECT id FROM autor WHERE autor = ?";
    try (PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setString(1, autor);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    }
    return -1; // Si no se encontró el autor
}

public void generarReporte(JTable tbl_reporte, Date fechaInicio, Date fechaFin) {
        String sql = "SELECT \"id\", \"tiempoTransaccion\", \"totalTransaccion\", \"cliente_id\", \"empleado_id\", \"tipoTransaccion_id\" " +
                     "FROM \"transaccion\" " +
                     "WHERE \"tiempoTransaccion\" BETWEEN ? AND ?";

        try (Connection conn = this.establecerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

     pstmt.setTimestamp(1, new java.sql.Timestamp(fechaInicio.getTime()));
pstmt.setTimestamp(2, new java.sql.Timestamp(fechaFin.getTime()));
            
            ResultSet rs = pstmt.executeQuery();

            // Llenar la tabla con los datos obtenidos
            DefaultTableModel model = (DefaultTableModel) tbl_reporte.getModel();
            model.setRowCount(0);  // Limpiar la tabla antes de agregar nuevos datos
            
            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getInt("id");
                row[1] = rs.getTimestamp("tiempoTransaccion");
                row[2] = rs.getDouble("totalTransaccion");
                row[3] = rs.getInt("cliente_id");
                row[4] = rs.getInt("empleado_id");
                row[5] = rs.getInt("tipoTransaccion_id");
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public char getEstatusEmpleado() {
        return estatusEmpleado;
    }

    public void setEstatusEmpleado(char estatusEmpleado) {
        this.estatusEmpleado = estatusEmpleado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
   
   
}
