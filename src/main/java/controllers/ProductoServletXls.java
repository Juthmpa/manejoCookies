// Define el paquete donde se encuentra esta clase (controladores)
package controllers;

// Importa la clase ServletException del API de Jakarta Servlet
import jakarta.servlet.ServletException;
// Importa la anotación WebServlet para mapear el servlet a una URL
import jakarta.servlet.annotation.WebServlet;
// Importa la clase base HttpServlet
import jakarta.servlet.http.HttpServlet;
// Importa la clase HttpServletRequest para manejar la solicitud HTTP
import jakarta.servlet.http.HttpServletRequest;
// Importa la clase HttpServletResponse para manejar la respuesta HTTP
import jakarta.servlet.http.HttpServletResponse;
// Importa la clase Producto del paquete models
import models.Producto;
// Importa la interfaz ProductoService del paquete services
import services.ProductoService;
// Importa la implementación ProductoServiceImplement del paquete services
import services.ProductoServiceImplement;

// Importa la clase IOException para manejar errores de entrada/salida
import java.io.IOException;
// Importa la clase PrintWriter para enviar la respuesta al cliente
import java.io.PrintWriter;
// Importa la interfaz List de java.util
import java.util.List;

// Mapea este Servlet a la URL "/producto"
@WebServlet("/producto")
// Define la clase ProductoServletXls que extiende de HttpServlet
public class ProductoServletXls extends HttpServlet {

    // Sobrescribe el métodos doGet para manejar las peticiones HTTP GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Crea una instancia de la implementación del servicio de productos
        ProductoService service = new ProductoServiceImplement();
        // Llama al métodos listar() del servicio para obtener la lista de productos
        List<Producto> productos = service.listar();

        // Establece el tipo de contenido de la respuesta como HTML y define la codificación UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        // Abre un bloque try-with-resources para asegurar que el PrintWriter se cierre automáticamente
        try(PrintWriter out = resp.getWriter()) {
            // Comienza a generar la respuesta HTML
            // Escribe la etiqueta de apertura del elemento html
            out.println("<html>");
            // Escribe la etiqueta de apertura del elemento head
            out.println("<head>");
            // CORRECCIÓN: Escribe la metaetiqueta charset completa con sus corchetes angulares
            out.println("<meta charset=\"UTF-8\">");
            // Escribe el título de la página
            out.println("<title>Lista de Productos</title>");
            // Escribe la etiqueta de cierre del elemento head
            out.println("</head>");
            // Escribe la etiqueta de apertura del elemento body
            out.println("<body>");
            // Escribe un encabezado principal
            out.println("<h1>Lista de productos</h1>");

            // CORRECCIÓN: Escribe la etiqueta de apertura del elemento table completa
            out.println("<table>");
            // Escribe la etiqueta de apertura de una fila de tabla (encabezado)
            out.println("<tr>");
            // Escribe la celda de encabezado para el ID del producto
            out.println("<th>ID PRODUCTO</th>");
            // Escribe la celda de encabezado para el nombre
            out.println("<th>NOMBRE</th>");
            // Escribe la celda de encabezado para la categoría
            out.println("<th>CATEGORIA</th>");
            // Escribe la celda de encabezado para el precio
            out.println("<th>PRECIO</th>");
            // CORRECCIÓN: Cierra la fila de encabezado
            out.println("</tr>");

            // Lleno mi tabla con los productos recorriendo la lista
            productos.forEach(p->{
                // Abre una nueva fila de tabla para el producto actual
                out.print("<tr>");
                // Escribe el ID del producto en una celda
                out.println("<td>" + p.getIdProducto() + "</td>");
                // Escribe el nombre del producto en una celda
                out.println("<td>" + p.getNombre() + "</td>");
                // Escribe la categoría del producto en una celda
                out.println("<td>" + p.getCategoria() + "</td>");
                // Escribe el precio del producto en una celda
                out.println("<td>" + p.getPrecio() + "</td>");
                // Cierra la fila de tabla del producto actual
                out.println("</tr>");
            });

            // CORRECCIÓN: Escribe la etiqueta de cierre del elemento table
            out.println("</table>");

            // Escribe la etiqueta de cierre del elemento body
            out.println("</body>");
            // Escribe la etiqueta de cierre del elemento html
            out.println("</html>");

        }
    }
}


