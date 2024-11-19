package controller;
import java.util.ArrayList;
import model.Revista;

public class RevistaController extends MaterialController{
    
    private ArrayList<Revista> listRevista = new ArrayList<>();
    
    @Override
    public <T> boolean registrar(T obj) {
        try{
        
            if(obj == null){
                return false;
            
            }else{
                Revista objRevista = (Revista) obj;
            
                this.listRevista.add(objRevista);
            
                return true;
            }
        }catch (Exception e){   
            return false;
        }
        
    }

    @Override
    public String buscar(String titulo) {
        String result = "";
            
        for (Revista objArrayRevista: this.listRevista){
            
            if (objArrayRevista.getTitulo().equals(titulo)){
                result = objArrayRevista.getTipoMaterial() + " - "
                        + objArrayRevista.getTitulo() + " - "
                        + objArrayRevista.getAutor() + " - "
                        + objArrayRevista.getEditorial() + " - "
                        + objArrayRevista.getYearPublicacion() + " - "
                        + objArrayRevista.getCantidadCopias() + " - "
                        + objArrayRevista.getTipoRevista();
                break;
            }
        }
        
        return result;
    }

    @Override
    public <T> boolean actualizar(String titulo, T obj) {
        
        try{
            if (obj == null){
                return false;
                
            }else{
                Revista objRevista = (Revista) obj;
                
                for (Revista objArrayRevista: this.listRevista){
                    
                    if (objArrayRevista.getTitulo().equals(titulo)){
                        
                        objArrayRevista.setTipoMaterial(objRevista.getTipoMaterial());
                        objArrayRevista.setTitulo(objRevista.getTitulo());
                        objArrayRevista.setAutor(objRevista.getAutor());
                        objArrayRevista.setEditorial(objRevista.getEditorial());
                        objArrayRevista.setYearPublicacion(objRevista.getYearPublicacion());
                        objArrayRevista.setCantidadCopias(objRevista.getCantidadCopias());
                        objArrayRevista.setTipoRevista(objRevista.getTipoRevista());
                        
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
                
                for (Revista objArrayRevista: this.listRevista){

                    if (objArrayRevista.getTitulo().equals(titulo)){
                        
                        this.listRevista.remove(objArrayRevista);
                        
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
        
        String listRevistas = "";
        
        for (Revista objArrayRevista: this.listRevista){
            
            listRevistas += objArrayRevista.getTipoMaterial() + " - "
                        + objArrayRevista.getTitulo() + " - "
                        + objArrayRevista.getAutor() + " - "
                        + objArrayRevista.getEditorial() + " - "
                        + objArrayRevista.getYearPublicacion() + " - "
                        + objArrayRevista.getCantidadCopias() + " - "
                        + objArrayRevista.getTipoRevista() + "\n";
            
        }
        
        return listRevistas;
    }
    
}
