package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaEmpleados extends Conexion {
    
    public List<Empleado> Empleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT e.id, e.\"nombresEmpleado\", e.\"apellidoPaternoEmpleado\", e.\"apellidoMaternoEmpleado\", e.\"usuarioEmpleado\", e.\"contraseniaEmpleado\", " +
                       "e.\"turnoEmpleado\", e.\"estatusEmpleado\", te.\"tipoempleado_id\" " +
                       "FROM empleado e " +
                       "JOIN \"tipoEmpleado_empleados\" te ON e.id = te.\"empleado_id\"";

        try (Connection conn = establecerConexion();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombresEmpleado = rs.getString("nombresEmpleado");
                String apellidoPaternoEmpleado = rs.getString("apellidoPaternoEmpleado");
                String apellidoMaternoEmpleado = rs.getString("apellidoMaternoEmpleado");
                String usuarioEmpleado = rs.getString("usuarioEmpleado");
                String contraseniaEmpleado = rs.getString("contraseniaEmpleado");
                char turnoEmpleado = rs.getString("turnoEmpleado").charAt(0);
                char estatusEmpleado = rs.getString("estatusEmpleado").charAt(0);
                int tipoEmpleadoId = rs.getInt("tipoempleado_id");

                Empleado empleado = new Empleado(id, usuarioEmpleado,contraseniaEmpleado,turnoEmpleado,nombresEmpleado, apellidoPaternoEmpleado , apellidoMaternoEmpleado, estatusEmpleado, tipoEmpleadoId);
                empleados.add(empleado);
            }

            // Ordenar la lista de empleados por id
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }

        return empleados;
    }
}
