package controller;
import java.util.ArrayList;
import model.MaterialVideografico;

public class MaterialVideoController extends MaterialController{

    private ArrayList<MaterialVideografico> listMaterialVideografico = new ArrayList<>();
    
    @Override
    public <T> boolean registrar(T obj) {
        try{
        
            if(obj == null){
                return false;
            
            }else{
                MaterialVideografico objMaterialVideografico = (MaterialVideografico) obj;
            
                this.listMaterialVideografico.add(objMaterialVideografico);
            
                return true;
            }
        }catch (Exception e){   
            return false;
        }
     }

    @Override
    public String buscar(String titulo) {
        String result = "";
            
        for (MaterialVideografico objArrayMaterialVideo: this.listMaterialVideografico){
            
            if (objArrayMaterialVideo.getTitulo().equals(titulo)){
                result = objArrayMaterialVideo.getTipoMaterial() + " - "
                        + objArrayMaterialVideo.getTitulo() + " - "
                        + objArrayMaterialVideo.getAutor() + " - "
                        + objArrayMaterialVideo.getEditorial() + " - "
                        + objArrayMaterialVideo.getYearPublicacion() + " - "
                        + objArrayMaterialVideo.getCantidadCopias() + " - "
                        + "Duracion: " + objArrayMaterialVideo.getDuracionHoras() + " horas con "
                        + objArrayMaterialVideo.getDuracionMinutos() + " minutos" + " - "
                        + objArrayMaterialVideo.getFormato();
                break;
            }
        }
        
        return result;    }

    @Override
    public <T> boolean actualizar(String titulo, T obj) {
        
        try{
            if (obj == null){
                return false;
                
            }else{
                MaterialVideografico objMaterialVideografico = (MaterialVideografico) obj;
                
                for (MaterialVideografico objArrayMaterialVideo: this.listMaterialVideografico){
                    
                    if (objArrayMaterialVideo.getTitulo().equals(titulo)){
                        
                        objArrayMaterialVideo.setTipoMaterial(objMaterialVideografico.getTipoMaterial());
                        objArrayMaterialVideo.setTitulo(objMaterialVideografico.getTitulo());
                        objArrayMaterialVideo.setAutor(objMaterialVideografico.getAutor());
                        objArrayMaterialVideo.setEditorial(objMaterialVideografico.getEditorial());
                        objArrayMaterialVideo.setYearPublicacion(objMaterialVideografico.getYearPublicacion());
                        objArrayMaterialVideo.setCantidadCopias(objMaterialVideografico.getCantidadCopias());
                        objArrayMaterialVideo.setDuracionHoras(objMaterialVideografico.getDuracionHoras());
                        objArrayMaterialVideo.setDuracionMinutos(objMaterialVideografico.getDuracionMinutos());
                        objArrayMaterialVideo.setFormato(objMaterialVideografico.getFormato());
                        
                        break;
        
                    }     
                }
                
                return true;
            }
        }catch(Exception e){
            return false;
            
        }
    }

    @Override
    public boolean eliminar(String titulo) {
        
        try{
            if (titulo == ""){
                return false;
                
            }else{
                
                for (MaterialVideografico objArrayMaterialVideo: this.listMaterialVideografico){

                    if (objArrayMaterialVideo.getTitulo().equals(titulo)){
                        
                        this.listMaterialVideografico.remove(objArrayMaterialVideo);
                        
                        break;
                    } 
                }
                
                return true;
                    
            }
            
        }catch (Exception e){
            return false;
        }
     }

    @Override
    public String listar() {
        
        String listMaterialVideografico = "";
        
        for (MaterialVideografico objArrayMaterialVideo: this.listMaterialVideografico){
            
            listMaterialVideografico += objArrayMaterialVideo.getTipoMaterial() + " - "   
                    + objArrayMaterialVideo.getTitulo() + " - "
                    + objArrayMaterialVideo.getAutor() + " - "
                    + objArrayMaterialVideo.getEditorial() + " - "
                    + objArrayMaterialVideo.getYearPublicacion() + " - "
                    + objArrayMaterialVideo.getCantidadCopias() + " - "
                    + "Duración: " + objArrayMaterialVideo.getDuracionHoras() + " horas con "
                    + objArrayMaterialVideo.getDuracionMinutos() + " minutos" + " - "
                    + objArrayMaterialVideo.getFormato() + "\n";
            
        }
        
        return listMaterialVideografico;
    }
        
}
