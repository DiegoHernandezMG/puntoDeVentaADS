package clases;

public class Libro {
    
    private int id;
    
    private String tituloLibro;
    private double precioLibro;
    private String resumenLibro;
    private String isbnLibro;
    private String editorial;
    private String categoria;
    private int stockLibro;
    private double descuento;
    
    public Libro(int id, String tituloLibro, double precioLibro, int stockLibro, String resumenLibro, String isbnLibro, String editorial, String categoria, double descuento) {
        this.id = id;
        
        this.tituloLibro = tituloLibro;
        this.precioLibro = precioLibro;
        this.resumenLibro = resumenLibro;
        this.isbnLibro = isbnLibro;
        this.editorial = editorial;
        this.categoria = categoria;
        this.stockLibro = stockLibro;
        this.descuento = descuento;
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
    
    

}
