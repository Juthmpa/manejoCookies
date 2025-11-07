// Define el paquete donde se encuentra esta clase
package models;

// Define la clase pública Producto
public class Producto {
    // Declaramos la variable para el ID del producto (tipo Long)
    private Long idProducto;
    // Declaramos la variable para el nombre del producto (tipo String)
    private String nombre;
    // Declaramos la variable para la categoría del producto (tipo String)
    private String categoria;
    // Declaramos la variable para el precio del producto (tipo Double)
    private Double precio;

    // Define el constructor vacío (por defecto) de la clase Producto
    public Producto(){}

    // Define el constructor que inicializa todos los campos de la clase Producto
    public Producto(Long idProducto, String nombre,
                    String categoria, Double precio){
        // Asigna el valor del parámetro 'idProducto' a la variable de instancia 'this.idProducto'
        this.idProducto = idProducto;
        // Asigna el valor del parámetro 'nombre' a la variable de instancia 'this.nombre'
        this.nombre = nombre;
        // Asigna el valor del parámetro 'categoria' a la variable de instancia 'this.categoria'
        this.categoria = categoria;
        // Asigna el valor del parámetro 'precio' a la variable de instancia 'this.precio'
        this.precio = precio;
    }

    // Define el métodos getter para obtener el ID del producto
    public Long getIdProducto() {
        // Retorna el valor de la variable 'idProducto'
        return idProducto;
    }
    // Define el métodos setter para establecer el ID del producto
    public void setIdProducto(Long idProducto) {
        // Asigna el valor del parámetro 'idProducto' a la variable de instancia 'this.idProducto'
        this.idProducto = idProducto;
    }

    // Define el métodos getter para obtener el nombre del producto
    public String getNombre() {
        // Retorna el valor de la variable 'nombre'
        return nombre;
    }
    // Define el métodos setter para establecer el nombre del producto
    public void setNombre(String nombre) {
        // Asigna el valor del parámetro 'nombre' a la variable de instancia 'this.nombre'
        this.nombre = nombre;
    }

    // Define el métodos getter para obtener la categoría del producto
    public String getCategoria() {
        // Retorna el valor de la variable 'categoria'
        return categoria;
    }
    // Define el métodos setter para establecer la categoría del producto
    public void setCategoria(String categoria) {
        // Asigna el valor del parámetro 'categoria' a la variable de instancia 'this.categoria'
        this.categoria = categoria;
    }

    // Define el métodos getter para obtener el precio del producto
    public Double getPrecio() {
        // Retorna el valor de la variable 'precio'
        return precio;
    }
    // Define el métodos setter para establecer el precio del producto
    public void setPrecio(Double precio) {
        // Asigna el valor del parámetro 'precio' a la variable de instancia 'this.precio'
        this.precio = precio;
    }
}
