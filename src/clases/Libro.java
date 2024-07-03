package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.sql.ResultSet;

import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Libro extends Conexion {
    
    private int id;
    private List<String> autores;
    private String tituloLibro;
    private double precioLibro;
    private String resumenLibro;
    private String isbnLibro;
    private String editorial;
    private String categoria;
    private int stockLibro;
    private double descuento;
    private String portadaLibro;
    
    public Libro(int id, String tituloLibro, double precioLibro, int stockLibro, String resumenLibro, String isbnLibro, String editorial, String categoria, double descuento, List<String> autores, String portadaLibro) {
        this.id = id;
        this.autores=autores;
        this.tituloLibro = tituloLibro;
        this.precioLibro = precioLibro;
        this.resumenLibro = resumenLibro;
        this.isbnLibro = isbnLibro;
        this.editorial = editorial;
        this.categoria = categoria;
        this.stockLibro = stockLibro;
        this.descuento = descuento;
        this.portadaLibro=portadaLibro;
    }
        public Libro() {
        this.id = 0;
        this.autores = new ArrayList<>();
        this.tituloLibro = "";
        this.precioLibro = 0.0;
        this.resumenLibro = "";
        this.isbnLibro = "";
        this.editorial = "";
        this.categoria = "";
        this.stockLibro = 0;
        this.descuento = 0.0;
        this.portadaLibro="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public String getResumenLibro() {
        return resumenLibro;
    }

    public void setResumenLibro(String resumenLibro) {
        this.resumenLibro = resumenLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStockLibro() {
        return stockLibro;
    }

    public void setStockLibro(int stockLibro) {
        this.stockLibro = stockLibro;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getPortadaLibro() {
        return portadaLibro;
    }

    public void setPortadaLibro(String portadaLibro) {
        this.portadaLibro = portadaLibro;
    }
    
    
    
    
    public String getAutores() {
        StringJoiner joiner = new StringJoiner(", ");
        for (String autor : autores) {
            joiner.add(autor);
        }
        return joiner.toString();
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
    
   
    
    public List<String> autores(){
  List<String> listaAutores = new ArrayList<>();
        String query = "SELECT autor FROM \"public\".\"autor\"";
        try (Connection conn = establecerConexion();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                listaAutores.add(rs.getString("autor"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }
        return listaAutores;
    }
        
    public List<String> editorial(){
  List<String> listaEditorial = new ArrayList<>();
        String query = "SELECT editorial FROM \"public\".\"editorial\"";
        try (Connection conn = establecerConexion();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                listaEditorial.add(rs.getString("editorial"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }
        return listaEditorial;
    }
        public List<String> categoria(){
  List<String> listaCategoria = new ArrayList<>();
        String query = "SELECT categoria FROM \"public\".\"categoria\"";
        try (Connection conn = establecerConexion();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                listaCategoria.add(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }
        return listaCategoria;
    }
        
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + id +
                ", tituloLibro='" + tituloLibro + '\'' +
                ", precioLibro=" + precioLibro +
                ", stockLibro=" + stockLibro +
                ", resumenLibro='" + resumenLibro + '\'' +
                ", isbnLibro='" + isbnLibro + '\'' +
                ", portadaLibro='" + portadaLibro + '\'' +
                ", descuentoLibro=" + descuento +
                ", editorial=" + editorial +
                ", categoria=" + categoria +
                ", autores=" + autores +
                '}';
    }
}