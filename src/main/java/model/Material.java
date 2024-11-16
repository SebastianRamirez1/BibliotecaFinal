package model;

public abstract class Material {
    private String tipoMaterial;
    private String titulo;
    private String autor;
    private String  editorial;
    private int añoPublicacion; 
    
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }
 
    
    public Material(String tipoMaterial, String titulo, String autor, String editorial, int añoPublicacion){    
        this.tipoMaterial = tipoMaterial;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.añoPublicacion = añoPublicacion;
        
    }
}
