package model;


public class MaterialVideografico extends Material{
    
    private int duracionHoras;
    private int duracionMinutos;
    private String formato;
    
    public MaterialVideografico(String tipoMaterial, String titulo, String autor, String editorial, int yearPublicacion, int catidadCopias, int duracionHoras, int duracionMinutos, String formato) {
        super(tipoMaterial, titulo, autor, editorial, yearPublicacion, catidadCopias);
        
        this.duracionHoras = duracionHoras;
        this.duracionMinutos = duracionMinutos;
        this.formato = formato;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
  
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
