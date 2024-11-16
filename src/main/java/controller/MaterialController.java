package controller;

public abstract class MaterialController {
    
    abstract <T> boolean registrar(T obj);
        
    abstract String buscar (String titulo);
    
    abstract <T> boolean actualizar (String titulo, T obj);
    
    abstract boolean eliminar(String titulo);
    
    abstract String listar();
}
