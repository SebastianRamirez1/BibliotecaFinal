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
        iniciar();
               
    }

    private static void iniciar() {
        // Presentación del menú de opciones al usuario
        int opcion = 0;
        byte tipo = 0;
        do{
            mostrarMenu();
            opcion = input.nextInt();

            // Ejecuta la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese 1 para libro, 2 para revista, 3 para material");
                    tipo = input.nextByte();
                    switch (tipo) {
                        case 1:
                            registrarLibro();
                            break;
                        case 2:
                            registrarRevista();
                            break;
                        case 3:
                            registrarMaterialVideografico();
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Libros: ");
                    listarLibros();
                    System.out.println("Revistas: ");
                    listarRevista();
                    System.out.println("Material videoGrafico");
                    listarMaterialVideografico();
                    break;
                case 3:
                    System.out.println("Ingrese 1 para libro, 2 para revista, 3 para material");
                    tipo = input.nextByte();
                    switch (tipo) {
                        case 1:
                            eliminarLibro();
                            break;
                        case 2:
                            eliminarRevista();
                            break;
                        case 3:
                            eliminarMaterialVideografico();
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Ingrese 1 para libro, 2 para revista, 3 para material");
                    tipo = input.nextByte();
                    switch (tipo) {
                        case 1:
                            actualizarLibro();
                            break;
                        case 2:
                            actualizarRevista();
                            break;
                        case 3:
                            actualizarMaterialVideografico();
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while(opcion != 5); // El ciclo continúa hasta que el usuario elige salir

        input.close(); // Cierra el escáner al final
    }
    
    private static void mostrarMenu() {
        // Muestra el menú de opciones
        System.out.println("\nBienvenido a la Biblioteca Municipal XYZ");
        System.out.println("1. Agregar Material");
        System.out.println("2. Listar Material");
        System.out.println("3. Eliminar Material");
        System.out.println("4. Actualizar Material");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
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
                System.out.println("\nDatos del libro: \n" + result);
                
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
                
                System.out.println("\n¿Desea actualizar los datos del libro? (S/N)");
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
                    
                    if(objLibroController.actualizar(buscarTitulo, objGeneric.getContent())){
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
                
                System.out.println("\n¿Desea eliminar los datos del libro? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    if (objLibroController.eliminar(titulo)){
                        System.out.println("\nLibro eliminado con exito.");
                        
                    }else{
                        System.out.println("\nNo se pudo eliminar el libro, intentelo de nuevo. ");
                        
                    }
                    
                }
                
            }else{
                System.out.println("\nNo se pudo eliminar el libro, intentelo de nuevo. ");
                
            }
            
            System.out.println("\n¿Desea elimar otro libro? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        
        }while (sw == 'S');
        
    }
    private static void listarLibros() {
        
        System.out.println("Listando los libros registrados.");
        
        String listLibros = objLibroController.listar();
        
        if (listLibros != ""){
            
            System.out.println("\nLista de libros registrados:\n" + listLibros);
            
        }else{
            
            System.out.println("\nNo hay libros registrados...");
            
        }
        
    }

    
    
    private static void registrarRevista() {
    
        char sw;
        
        do{
            System.out.println("\nRegistrando Revista.");
            
            System.out.println("Ingrese el tipo de material de la revista: ");
            String tipoMaterial = input.next();
            System.out.println("Ingrese el título de la revista: ");
            String titulo = input.next();
            System.out.println("Ingrese el autor de la revista: ");
            String autor = input.next();
            System.out.println("Ingrese la editorial de la revista: ");
            String editorial = input.next();
            System.out.println("Ingrese el año de publicación de la revista: ");
            int yearPublicacion = input.nextInt();
            System.out.println("Ingrese la cantidad de copias disponible de la revista: ");
            int cantidadCopias = input.nextInt();
            System.out.println("Ingrese el tipo de la revista: ");
            String tipoRevista = input.next();
            
            Revista objRevista = new Revista(tipoMaterial, titulo, autor, editorial, yearPublicacion, cantidadCopias, tipoRevista);
            Generic<Revista> objGeneric = new Generic<>();
            objGeneric.setContent(objRevista);
            
            if(objRevistaController.registrar(objGeneric.getContent())){
                System.out.println("\nRevista registrada correctamente");
                
            }else{
                System.out.println("\nNo se pudo registrar la revista intente nuevamente.");
            }
            
            System.out.println("\n¿Desea registrar otra revista? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
       
    }

    private static void buscarRevista() {
        char sw;
        
        do{
            System.out.println("\nBuscando Revista.");
            System.out.println("Ingrese el título de la revista que desea consultar: ");
            String titulo = input.next();
            
            String result = objRevistaController.buscar(titulo);
            if(result != ""){
                System.out.println("\nDatos de la revista: \n" + result);
                
            }else{
                System.out.println("Revista no encontrada, intente nuevamente");
            }
            
            System.out.println("\n¿Desea buscar otra revista? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
            
        }while(sw == 'S');
            
    }

    private static void actualizarRevista() {
        char sw;
        
        do{
            System.out.println("\nActualizando Revista. ");
            System.out.println("Ingrese el título de la revista que desea buscar para actualizar: ");
            String buscarTitulo = input.next();
            
            String result = objRevistaController.buscar(buscarTitulo);
            if(result != ""){
                System.out.println("\nDatos de la revista: \n" + result);
                
                System.out.println("\n¿Desea actualizar los datos de la revista? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    System.out.println("\nIngrese el tipo de material de la revista: ");
                    String tipoMaterial = input.next();
                    System.out.println("Ingrese el título de la revista: ");
                    String titulo = input.next();
                    System.out.println("Ingrese el autor de la revista: ");
                    String autor = input.next();
                    System.out.println("Ingrese la editorial de la revista: ");
                    String editorial = input.next();
                    System.out.println("Ingrese el año de publicación de la revista: ");
                    int yearPublicacion = input.nextInt();
                    System.out.println("Ingrese la cantidad de copias disponible de la revista: ");
                    int cantidadCopias = input.nextInt();
                    System.out.println("Ingrese el tipo de la revista: ");
                    String tipoRevista = input.next();
                    
                    Revista objRevista = new Revista(tipoMaterial, titulo, autor, editorial, yearPublicacion, cantidadCopias, tipoRevista);
                    Generic<Revista> objGeneric = new Generic<>();
                    objGeneric.setContent(objRevista);
                    
                    if(objRevistaController.actualizar(buscarTitulo, objGeneric.getContent())){
                        System.out.println("\nRevista actualizada correctamente.");
                        
                    }else{
                        System.out.println("\nNo se pudo actualizar la revista, intentelo de nuevo.");
                        
                    }
    
                }
            }else{
                System.out.println("\nNo se pudo actualizar la revista, intentelo de nuevo.");
            }
            
            System.out.println("\n¿Desea actualiazar los datos de otra revista? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
        
    }

    private static void eliminarRevista() {
        char sw;
        
        do{
            System.out.println("\nEliminando Revista.");
            System.out.println("Ingrese el título de la revista que desea buscar para eliminar: ");
            String titulo = input.next();
            
            String result = objRevistaController.buscar(titulo);
            if(result != ""){
                System.out.println("\nDatos de la revista: \n" + result);
                
                System.out.println("\n¿Desea eliminar los datos de la revista? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    if (objRevistaController.eliminar(titulo)){
                        System.out.println("\nRevista eliminada con exito.");
                        
                    }else{
                        System.out.println("\nNo se pudo eliminar la revista, intentelo de nuevo. ");
                        
                    }
                    
                }
                
            }else{
                System.out.println("\nNo se pudo eliminar la revista, intentelo de nuevo. ");
                
            }
            
            System.out.println("\n¿Desea elimar otra revista? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        
        }while (sw == 'S');
         
    }

    private static void listarRevista() {
        
        System.out.println("Listando las revistas registradas.");
        
        String listRevistas = objRevistaController.listar();
        
        if (listRevistas != ""){
            
            System.out.println("\nLista de revistas registradas:\n" + listRevistas);
            
        }else{
            
            System.out.println("\nNo hay revistas registradas...");
            
        }
        
    }

    
    
    private static void registrarMaterialVideografico() {

        char sw;
        
        do{
            System.out.println("\nRegistrando Material Videografico.");
            
            System.out.println("Ingrese el tipo de material del material videografico: ");
            String tipoMaterial = input.next();
            System.out.println("Ingrese el título del material videografico: ");
            String titulo = input.next();
            System.out.println("Ingrese el autor del material videografico: ");
            String autor = input.next();
            System.out.println("Ingrese la editorial del material videografico: ");
            String editorial = input.next();
            System.out.println("Ingrese el año de publicación del material videografico: ");
            int yearPublicacion = input.nextInt();
            System.out.println("Ingrese la cantidad de copias disponible del material videografico: ");
            int cantidadCopias = input.nextInt();
            System.out.println("Ingrese la cantidad de horas que dura el material videogrico: ");
            int duracionHoras = input.nextInt();
            System.out.println("Ingrese la cantidad de minutos que dura el material videogrico: ");
            int duracionMinutos = input.nextInt();
            System.out.println("Ingrese el formato del material videografico: ");
            String formato = input.next();
            
            MaterialVideografico objMaterialVideografico = new MaterialVideografico(tipoMaterial, titulo, autor, 
                    editorial, yearPublicacion, cantidadCopias, duracionHoras, duracionMinutos, formato);
            
            Generic<MaterialVideografico> objGeneric = new Generic<>();
            objGeneric.setContent(objMaterialVideografico);
            
            if(objMaterialVideoController.registrar(objGeneric.getContent())){
                System.out.println("\nMaterial videografico registrado correctamente");
                
            }else{
                System.out.println("\nNo se pudo registrar el material videografico intente nuevamente.");
            }
            
            System.out.println("\n¿Desea registrar otro material videografico? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
        
        
    }

    private static void buscarMaterialVideografico() {
        char sw;
        
        do{
            System.out.println("\nBuscando Material Videografico.");
            System.out.println("Ingrese el título del material videografico que desea consultar: ");
            String titulo = input.next();
            
            String result = objMaterialVideoController.buscar(titulo);
            if(result != ""){
                System.out.println("\nDatos del material videografico \n" + result);
                
            }else{
                System.out.println("Material videografico no encontrado, intente nuevamente");
            }
            
            System.out.println("\n¿Desea buscar otro material videografico? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
            
        }while(sw == 'S');
     }

    private static void actualizarMaterialVideografico() {
        char sw;
        
        do{
            System.out.println("\nActualizando Material Videografico. ");
            System.out.println("Ingrese el título del material videografico que desea buscar para actualizar: ");
            String buscarTitulo = input.next();
            
            String result = objMaterialVideoController.buscar(buscarTitulo);
            if(result != ""){
                System.out.println("\nDatos del material videografico: \n" + result);
                
                System.out.println("\n¿Desea actualizar los datos del material videografico? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    System.out.println("\nIngrese el tipo de material del material videografico: ");
                    String tipoMaterial = input.next();
                    System.out.println("Ingrese el título del material videografico: ");
                    String titulo = input.next();
                    System.out.println("Ingrese el autor del material videografico: ");
                    String autor = input.next();
                    System.out.println("Ingrese la editorial del material videografico ");
                    String editorial = input.next();
                    System.out.println("Ingrese el año de publicación del material videografico: ");
                    int yearPublicacion = input.nextInt();
                    System.out.println("Ingrese la cantidad de copias disponible de l material videografico: ");
                    int cantidadCopias = input.nextInt();
                    System.out.println("Ingrese la cantidad de horas que dura el material videografico: ");
                    int duracionHoras = input.nextInt();
                    System.out.println("Ingrese la cantidad de minutos que dura el material videografico: ");
                    int duracionMinutos = input.nextInt();                    
                    System.out.println("Ingrese el formato del material videografico: ");
                    String formato = input.next();  
                    
                    MaterialVideografico objMaterialVideografico = new MaterialVideografico(tipoMaterial, titulo, autor, 
                            editorial, yearPublicacion, cantidadCopias, duracionHoras, duracionMinutos, formato);
                    
                    Generic<MaterialVideografico> objGeneric = new Generic<>();
                    objGeneric.setContent(objMaterialVideografico);
                    
                    if(objMaterialVideoController.actualizar(buscarTitulo, objGeneric.getContent())){
                        System.out.println("\nMaterial videografico actualizado correctamente.");
                        
                    }else{
                        System.out.println("\nNo se pudo actualizar el material videografico, intentelo de nuevo.");
                        
                    }
    
                }
            }else{
                System.out.println("\nNo se pudo actualizar el material videografico, intentelo de nuevo.");
            }
            
            System.out.println("\n¿Desea actualiazar los datos de otro material videografico? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        }while(sw == 'S');
    }

    private static void eliminarMaterialVideografico() {
        char sw;
        
        do{
            System.out.println("\nEliminando Material Videografico.");
            System.out.println("Ingrese el título del material videografico que desea buscar para eliminar: ");
            String titulo = input.next();
            
            String result = objMaterialVideoController.buscar(titulo);
            if(result != ""){
                System.out.println("\nDatos del material videografico: \n" + result);
                
                System.out.println("\n¿Desea eliminar los datos del material videografico? (S/N)");
                sw = input.next().toUpperCase().charAt(0);
                
                if(sw == 'S'){
                    if (objMaterialVideoController.eliminar(titulo)){
                        System.out.println("\nMaterial videografico eliminado con exito.");
                        
                    }else{
                        System.out.println("\nNo se pudo eliminar el material videografico, intentelo de nuevo. ");
                        
                    }
                    
                }
                
            }else{
                System.out.println("\nNo se pudo eliminar el material videografico, intentelo de nuevo. ");
                
            }
            
            System.out.println("\n¿Desea elimar otro material videografico? (S/N)");
            sw = input.next().toUpperCase().charAt(0);
        
        }while (sw == 'S');
    }

    private static void listarMaterialVideografico() {
        
        System.out.println("\nListando los materiales videograficos registrados.");
        
        String listMaterialVideografico = objMaterialVideoController.listar();
        
        if (listMaterialVideografico != ""){
            
            System.out.println("Lista de materiales videograficos registrados:\n" + listMaterialVideografico);
            
        }else{
            
            System.out.println("\nNo hay materiales videografico registrados...");
            
        }
    }
}
