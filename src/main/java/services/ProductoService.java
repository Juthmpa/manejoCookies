// Define el paquete donde se encuentra esta interfaz
package services;

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