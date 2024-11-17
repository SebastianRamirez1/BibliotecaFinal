package model;

public abstract class Material {
    private String tipoMaterial;
    private String titulo;
    private String autor;
    private String  editorial;
    private int yearPublicacion; 
    private int cantidadCopias;
    
    public Material(String tipoMaterial, String titulo, String autor, String editorial, int yearPublicacion, int cantidadCopias){
        this.tipoMaterial = tipoMaterial;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.yearPublicacion = yearPublicacion;
        this.cantidadCopias = cantidadCopias;
        
    }
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
   
    public String getEditorial() {
        return editorial;
    }
    
    public void setYearPublicacion(int añoPublicacion) {
        this.yearPublicacion = añoPublicacion;
    }

    public int getYearPublicacion() {
        return yearPublicacion;
    }
 
    public void setCantidadCopias(int cantidadCopias){
        this.cantidadCopias = cantidadCopias;
    }
    
    public int getCantidadCopias(){
        return cantidadCopias;
    }

}
