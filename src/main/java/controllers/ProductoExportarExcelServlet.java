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

// Mapea este Servlet a la URL "/productos-excel"
@WebServlet("/productos-excel")
// Define la clase ProductoExportarExcelServlet que extiende de HttpServlet
public class ProductoExportarExcelServlet extends HttpServlet {

    // Sobrescribe el métodos doGet para manejar las peticiones HTTP GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Crea una instancia de la implementación del servicio de productos
        ProductoService service = new ProductoServiceImplement();
        // Llama al métodos listar() del servicio para obtener la lista de productos
        List<Producto> productos = service.listar();

        // Establece el tipo de contenido como Excel (MIME Type para archivos XLS antiguos)
        resp.setContentType("application/vnd.ms-excel");
        // Establece el encabezado para forzar la descarga del archivo
        resp.setHeader("Content-Disposition", "attachment;filename=productos.xls");

        // Abre un bloque try-with-resources para asegurar que el PrintWriter se cierre automáticamente
        try(PrintWriter out = resp.getWriter()) {

            // Define el separador de columnas (se usa la tabulación \t para formato TSV de Excel)
            String separador = "\t";

            // Escribe la fila de encabezados
            out.println("ID PRODUCTO" + separador + "NOMBRE" + separador + "CATEGORIA" + separador + "PRECIO");

            // Itera sobre la lista de productos
            productos.forEach(p -> {
                // Escribe los valores de cada columna separados por tabulaciones
                out.print(p.getIdProducto());
                out.print(separador);
                out.print(p.getNombre());
                out.print(separador);
                out.print(p.getCategoria());
                out.print(separador);
                out.println(p.getPrecio());
            });
        }
    }
}
