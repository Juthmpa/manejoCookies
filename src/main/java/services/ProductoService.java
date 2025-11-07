// Define el paquete donde se encuentra esta interfaz
package services;
/*
 * Autor: Judith Piedra
 * Fecha: 07/11/2025
 * Descripción: Esta clase denominada ProductoService
 * es una clase abstracta que sirve como
 * plantilla que va a utilizar Producto
 * para el uso en el Servlet
 */
// Importa la clase Producto del paquete models
import models.Producto;
// Importa la interfaz List de java.util
import java.util.List;

// Define la interfaz pública ProductoService
public interface ProductoService {
    // Declara el métodos 'listar' que debe ser implementado
    // Este métodos no recibe argumentos y retorna una lista de objetos Producto
    List<Producto> listar();

}