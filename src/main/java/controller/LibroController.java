package controller;
import java.util.ArrayList;
import model.Libro;

public class LibroController extends MaterialController{
    
    private ArrayList<Libro> listLibro = new ArrayList<>();
    
    
    @Override
    public <T> boolean registrar(T obj) {
        try{
        
            if(obj == null){
                return false;
            
            }else{
                Libro objLibro = (Libro) obj;
            
                this.listLibro.add(objLibro);
            
                return true;
            }
        }catch (Exception e){   
            return false;
        }
    
    }

    @Override
    public String buscar(String titulo) {
        String result = "";
            
        for (Libro objArrayLibro: this.listLibro){
            
            if (objArrayLibro.getTitulo().equals(titulo)){
                result = objArrayLibro.getTipoMaterial() + " - "
                        + objArrayLibro.getTitulo() + " - "
                        + objArrayLibro.getAutor() + " - "
                        + objArrayLibro.getEditorial() + " - "
                        + objArrayLibro.getYearPublicacion() + " - "
                        + objArrayLibro.getCantidadCopias();
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
                Libro objLibro = (Libro) obj;
                
                for (Libro objArrayLibro: this.listLibro){
                    
                    if (objArrayLibro.getTitulo().equals(titulo)){
                        
                        objArrayLibro.setTipoMaterial(objLibro.getTipoMaterial());
                        objArrayLibro.setTitulo(objLibro.getTitulo());
                        objArrayLibro.setAutor(objLibro.getAutor());
                        objArrayLibro.setEditorial(objLibro.getEditorial());
                        objArrayLibro.setYearPublicacion(objLibro.getYearPublicacion());
                        objArrayLibro.setCantidadCopias(objLibro.getCantidadCopias());
                        
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
                
                for (Libro objArrayLibro: this.listLibro){

                    if (objArrayLibro.getTitulo().equals(titulo)){
                        
                        this.listLibro.remove(objArrayLibro);
                        
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
        
        String listLibros = "";
        
        for (Libro objArrayLibro: this.listLibro){
            
            listLibros += objArrayLibro.getTipoMaterial() + " - "
                        + objArrayLibro.getTitulo() + " - "
                        + objArrayLibro.getAutor() + " - "
                        + objArrayLibro.getEditorial() + " - "
                        + objArrayLibro.getYearPublicacion() + " - "
                        + objArrayLibro.getCantidadCopias() + "\n";
            
        }
        
        return listLibros;
        
    }
    
}
    
   
