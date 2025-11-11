// Define el paquete donde se encuentra la clase
package controllers;
/*
 * Autor: Judith Piedra
 * Fecha: 07/11/2025
 * Descripción: Esta clase denominada LoginServlet,
 * modela el servlet de Producto, clase hija de HttpServlet
 * que va a manejar el inicio de sesión
 */
// Importa la clase ServletException para manejar errores de servlet
import jakarta.servlet.ServletException;
// Importa la anotación WebServlet para mapear la URL
import jakarta.servlet.annotation.WebServlet;
// Importa la clase Cookie para manejar las cookies HTTP
import jakarta.servlet.http.Cookie;
// Importa la clase base HttpServlet para manejar peticiones HTTP
import jakarta.servlet.http.HttpServlet;
// Importa la clase HttpServletRequest para manejar las peticiones
import jakarta.servlet.http.HttpServletRequest;
// Importa la clase HttpServletResponse para manejar las respuestas
import jakarta.servlet.http.HttpServletResponse;
// Importa la clase IOException para manejar errores de entrada/salida
import java.io.IOException;
// Importa la clase PrintWriter para enviar la respuesta al cliente
import java.io.PrintWriter;
// Importa la interfaz List de java.util (aunque no se usa, se mantiene el original)
import java.util.List;
// Importa la clase Arrays para utilidades de arrays
import java.util.Arrays;
// Importa la clase Optional para manejar valores que pueden ser nulos
import java.util.Optional;

// Anota el servlet con los paths de URL a los que responde
@WebServlet({"/login", "/login.html"})
// Define la clase LoginServlet que extiende HttpServlet
public class LoginServlet extends HttpServlet {
    // Declaramos e inicializamos una variable constante para el nombre de usuario
    final static String USERNAME = "admin";
    // Declaramos e inicializamos una variable constante para la contraseña
    final static String PASSWORD = "12345";

    // Sobreescribe el método doGet para manejar peticiones GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtenemos un array de objetos Cookie de la petición, o un array vacío si es nulo
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        // Obtenemos la información que está dentro de la cookie usando un stream
        Optional<String> cookieOptional = Arrays.stream(cookies)
                // Filtramos para encontrar la cookie con el nombre "username"
                .filter(c -> "username".equals(c.getName()))
                // Mapeamos el objeto Cookie para obtener solo su valor (el nombre de usuario)
                .map(Cookie :: getValue)
                // Intentamos encontrar el primer elemento
                .findAny();
        // Creamos una condicional preguntando si en la variable optionalCookie
        // Existe información (si el usuario ya ha iniciado sesión previamente)
        if(cookieOptional.isPresent()) {
            // Establece el tipo de contenido y la codificación de la respuesta
            resp.setContentType("text/html;charset=UTF-8");
            // Abre un bloque try-with-resources para obtener el objeto PrintWriter
            try(PrintWriter out = resp.getWriter()){
                // Establece nuevamente el tipo de contenido y codificación (redundante pero incluido)
                resp.setContentType("text/html;charset=UTF-8");
                // Comienza la generación del documento HTML
                out.print("<!DOCTYPE html>");
                // Escribe la etiqueta de apertura del elemento html
                out.println("<html lang=\"es\">");
                // Escribe la etiqueta de apertura del elemento head
                out.println("<head>");
                // Define la codificación de caracteres
                out.println("<meta charset=\"UTF-8\">");
                // Asegura la correcta visualización en dispositivos móviles (viewport)
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                // Agrega el enlace a la hoja de estilos de Bootstrap 5
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                // Escribe el título de la página, incluyendo el usuario de la cookie
                out.println("<title> Login Exitoso: " + cookieOptional.get() +"</title>");
                // Escribe la etiqueta de cierre del elemento head
                out.println("</head>");
                // Escribe la etiqueta de apertura del elemento body con estilo Bootstrap para centrar
                out.println("<body class=\"bg-light d-flex align-items-center justify-content-center\" style=\"height: 100vh;\">");
                // Inicia el contenedor principal centrado
                out.println("<div class=\"container text-center p-5 bg-white shadow-lg rounded-3\">");
                // Escribe un encabezado principal con un estilo de texto de éxito
                out.println("<h1 class=\"mb-4 text-success\">Bienvenido de vuelta a mi sistema</h1>");
                // Escribe un encabezado secundario con el mensaje de éxito de inicio de sesión
                out.println("<h3 class=\"alert alert-success\"> Login exitoso: " + cookieOptional.get() + ", has iniciado sesión con éxito. </h3>" );
                // Escribe la etiqueta de cierre del div contenedor
                out.println("</div>");
                // Escribe la etiqueta de cierre del elemento body
                out.println("</body>");
                // Escribe la etiqueta de cierre del elemento html
                out.println("</html>");
                // Cierra el bloque try-with-resources
            }
            // Si no existe la cookie (no ha iniciado sesión)
        } else{
            // Redirigimos la petición a login.jsp
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        // Cierra el método doGet
    }

    // Sobreescribe el método doPost para manejar peticiones POST (envío de formulario)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creamos la variable para procesar el nombre de usuario del formulario
        String username = req.getParameter("user");
        // Creamos la variable para procesar la contraseña del formulario
        String password = req.getParameter("password");

        // Implementamos una condicional para saber si las credenciales son correctas
        if(username.equals(USERNAME) && password.equals(PASSWORD)){
            // Establece el tipo de contenido y la codificación de la respuesta
            resp.setContentType("text/html;charset=UTF-8");
            // Creamos e instanciamos el objeto Cookie con el nombre de usuario
            Cookie cookie = new Cookie( "username", username);
            // Añadimos la cookie a la respuesta HTTP
            resp.addCookie(cookie);
            // Instanciamos la clase PrintWriter dentro de un bloque try-with-resources
            try(PrintWriter out = resp.getWriter()){
                // Establece nuevamente el tipo de contenido y codificación (redundante pero incluido)
                resp.setContentType("text/html;charset=UTF-8");
                // Comienza la generación del documento HTML
                out.print("<!DOCTYPE html>");
                // Escribe la etiqueta de apertura del elemento html
                out.println("<html lang=\"es\">");
                // Escribe la etiqueta de apertura del elemento head
                out.println("<head>");
                // Define la codificación de caracteres
                out.println("<meta charset=\"UTF-8\">");
                // Asegura la correcta visualización en dispositivos móviles (viewport)
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                // Agrega el enlace a la hoja de estilos de Bootstrap 5
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                // Escribe el título de la página
                out.println("<title> Login Exitoso</title>");
                // Escribe la etiqueta de cierre del elemento head
                out.println("</head>");
                // Escribe la etiqueta de apertura del elemento body con fondo claro y centrado
                out.println("<body class=\"bg-light d-flex align-items-center justify-content-center\" style=\"height: 100vh;\">");
                // Inicia el contenedor principal centrado
                out.println("<div class=\"container text-center p-5 bg-white shadow-lg rounded-3\">");
                // Escribe un encabezado principal con el nombre del usuario y estilo de éxito
                out.println("<h1 class=\"mb-4 text-success\">Bienvenido " + username + "</h1>");
                // Escribe un encabezado secundario con el mensaje de sesión iniciada
                out.println("<h2 class=\"alert alert-success\"> Su sesión ha iniciado con éxito.</h2>");
                // Escribe un enlace para ver productos con estilo de botón primario grande
                out.println("<a href = '" + req.getContextPath() + "/producto' class=\"btn btn-primary btn-lg mt-3\"> Ver Productos </a>" );
                // Escribe un enlace para ir al inicio con estilo de botón secundario grande
                out.println("<a href = '" + req.getContextPath() + "/index.html' class=\"btn btn-secondary btn-lg mt-3 ms-3\"> Ir al Inicio </a>" );
                // Escribe la etiqueta de cierre del div contenedor
                out.println("</div>");
                // Escribe la etiqueta de cierre del elemento body
                out.println("</body>");
                // Escribe la etiqueta de cierre del elemento html
                out.println("</html>");
                // Cierra el bloque try-with-resources
            }
            // Realiza la redirección al índice después de intentar imprimir la página
            // (La impresión anterior puede ser ignorada por el navegador debido a esta redirección)
            resp.sendRedirect(req.getContextPath() + "/index.html");
            // Si las credenciales son incorrectas
        } else{
            // Envía un código de error de No Autorizado (401) con un mensaje
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no tienes acceso. Revisa tus credenciales.");
        }
        // Cierra el métodos doPost
    }
// Cierra la clase LoginServlet
}