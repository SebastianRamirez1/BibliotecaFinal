
package model;

public class Revista extends Material{
    private String tipoRevista;
    
    
    public Revista(String tipoMaterial, String titulo, String autor, String editorial, int yearPublicacion, int catidadCopias, String tipoRevista) {
        super(tipoMaterial, titulo, autor, editorial, yearPublicacion, catidadCopias);
        
        this.tipoRevista = tipoRevista;
    }

    public String getTipoRevista() {
        return tipoRevista;
    }

    public void setTipoRevista(String tipoRevista) {
        this.tipoRevista = tipoRevista;
    }
    
}
