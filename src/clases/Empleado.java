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
