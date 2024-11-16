package model;


public class MaterialVideografico extends Material{
    
    private int duracionHrs;
    private int duracionMins;
    
    public MaterialVideografico(String tipoMaterial, String titulo, String autor, String editorial, int yearPublicacion, int catidadCopias, int duracionHrs, int duracionMins) {
        super(tipoMaterial, titulo, autor, editorial, yearPublicacion, catidadCopias);
        
        this.duracionHrs = duracionHrs;
        this.duracionMins = duracionMins;
    }

    public int getDuracionHrs() {
        return duracionHrs;
    }

    public void setDuracionHrs(int duracionHrs) {
        this.duracionHrs = duracionHrs;
    }

    public int getDuracionMins() {
        return duracionMins;
    }

    public void setDuracionMins(int duracionMins) {
        this.duracionMins = duracionMins;
    }
    
}
