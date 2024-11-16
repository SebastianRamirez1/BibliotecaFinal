package controller;

public abstract class MaterialController {
    
    abstract <T> boolean registrar(T obj);
        
    abstract String buscar (String name);
    
    abstract <T> boolean actualizar (String name, T obj);
    
    abstract boolean eliminar(String name);
    
    abstract String listar();
}
