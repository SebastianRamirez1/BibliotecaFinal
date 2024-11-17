package vista;
import java.util.Scanner;
import Dto_Generics.Generic;
import model.*;
import controller.*;

public class TrabajoFinal {

    static Scanner input = new Scanner(System.in);
    static LibroController objLibroController = new LibroController();
    static RevistaController objRevistaController = new RevistaController();
    static MaterialVideoController objMaterialVideoController = new MaterialVideoController(); 
    
    public static void main(String[] args) {
        tipoMaterial();
        
               
    }

    private static void tipoMaterial() {
        byte material;
        
        do{
        System.out.println("Ingrese con que tipo de material desea operar teniendo en cuenta las siguientes opciones: "
        + "\n1:Libro \n2:Revista \n3:Material videográfico");
        material = input.nextByte();          
        
        }while(material < 1 || material > 3);
         
        switch(material){
            
            case 1:      
                registrarLibro();
                buscarLibro();
                actualizarLibro();
                eliminarLibro();
                listarLibros();
                break;
                
            case 2:
                registrarRevista();
                buscarRevista();
                actualizarRevista();
                eliminarRevista();
                listarRevista(); 
                break;
                
            case 3:
                registrarMaterialVideografico();
                buscarMaterialVideografico();
                actualizarMaterialVideografico();
                eliminarMaterialVideografico();
                listarMaterialVideografico();
                break;
        }

        
       
    }

    private static void registrarLibro() {
        
        char sw;
        
        do{
            System.out.println("\nRegistrando libro.");
            
            System.out.println("Ingrese el tipo de material del libro: ");
            String tipoMaterial = input.next();
            System.out.println("Ingrese el título del libro: ");
            String titulo = input.next();
            System.out.println("Ingrese el autor del libro: ");
            String autor = input.next();
            System.out.println("Ingrese la editorial del libro: ");
            String editorial = input.next();
            System.out.println("Ingrese el año de publicación del libro: ");
            int yearPublicacion = input.nextInt();
            System.out.println("Ingrese la cantidad de copias disponible del libro: ");
            int cantidadCopias = input.nextInt();
            
            Libro objLibro = new Libro(tipoMaterial, titulo, autor, editorial, yearPublicacion, cantidadCopias);
            Generic<Libro> objGeneric = new Generic<>();
            objGeneric.setContent(objLibro);
            
            if(objLibroController.registrar(objGeneric.getContent())){
                System.out.println("\nLibro registrado correctamente");
                
            }else{
                System.out.println("\nNo se pudo registrar el libro intente nuevamente.");
            }
            
            System.out.println("\n¿Desea registrar otro libro? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
    }

    private static void buscarLibro() {
        char sw;
        
        do{
            System.out.println("\nBuscando libro.");
            System.out.println("Ingrese el título del libro que desea consultar: ");
            String titulo = input.next();
            
            String result = objLibroController.buscar(titulo);
            if(result != ""){
                System.out.println("Datos del libro: \n" + result);
                
            }else{
                System.out.println("Libro no encontrado, intente nuevamente");
            }
            
            System.out.println("\n¿Desea buscar otro libro? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
            
        }while(sw == 'S');
    }

    private static void actualizarLibro() {
        char sw;
        do{
            System.out.println("\nActualizando libro. ");
            System.out.println("Ingrese el título del libro que desea buscar para actualizar: ");
            String buscarTitulo = input.next();
            
            String result = objLibroController.buscar(buscarTitulo);
            if(result != ""){
                System.out.println("\nDatos del libro: \n" + result);
                
                System.out.println("\n¿Desea actualiazar los datos del libro? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    System.out.println("\nIngrese el tipo de material del libro: ");
                    String tipoMaterial = input.next();
                    System.out.println("Ingrese el título del libro: ");
                    String titulo = input.next();
                    System.out.println("Ingrese el autor del libro: ");
                    String autor = input.next();
                    System.out.println("Ingrese la editorial del libro: ");
                    String editorial = input.next();
                    System.out.println("Ingrese el año de publicación del libro: ");
                    int yearPublicacion = input.nextInt();
                    System.out.println("Ingrese la cantidad de copias disponible del libro: ");
                    int cantidadCopias = input.nextInt();
            
                    Libro objLibro = new Libro(tipoMaterial, titulo, autor, editorial, yearPublicacion, cantidadCopias);
                    Generic<Libro> objGeneric = new Generic<>();
                    objGeneric.setContent(objLibro);
                    
                    if(objLibroController.actualizar(titulo, objGeneric.getContent())){
                        System.out.println("\nLibro actualizado correctamente.");
                        
                    }else{
                        System.out.println("\nNo se pudo actualizar el libro, intentelo de nuevo.");
                        
                    }
    
                }
            }else{
                System.out.println("\nNo se pudo actualizar el libro, intentelo de nuevo.");
            }
            
            System.out.println("\n¿Desea actualiazar los datos de otro libro? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
        
    }

    private static void eliminarLibro() {
        char sw;
        
        do{
            System.out.println("\nEliminando libro.");
            System.out.println("Ingrese el título del libro que desea buscar para eliminar: ");
            String titulo = input.next();
            
            String result = objLibroController.buscar(titulo);
            if(result != ""){
                System.out.println("\nDatos del libro: \n" + result);
                
                System.out.println("\n¿Desea eliminar el libro de la base de datos? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    if (objLibroController.eliminar(titulo)){
                        System.out.println("\nLibro eliminado con exito.");
                        
                    }else{
                        System.out.println("No se pudo eliminar el libro, intentelo de nuevo. ");
                        
                    }
                    
                }
                
            }else{
                System.out.println("No se pudo eliminar el libro, intentelo de nuevo. ");
                
            }
            
            System.out.println("¿Desea elimar otro libro? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        
        }while (sw == 'S');
        
    }
    private static void listarLibros() {
        
        System.out.println("Listando los libros registrados.");
        
        String listLibros = objLibroController.listar();
        
        if (listLibros != ""){
            
            System.out.println("Lista de libros registrado\n" + listLibros);
            
        }else{
            
            System.out.println("No hay libros registrados...");
            
        }
        
    }

    
    
    private static void registrarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void actualizarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void eliminarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void registrarMaterialVideografico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarMaterialVideografico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void actualizarMaterialVideografico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void eliminarMaterialVideografico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listarMaterialVideografico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
