package controllers;
/*
 * Autor: Judith Piedra
 * Fecha: 11/11/2025
 * Descripción: Esta clase denominada LogoutServlet,
 * modela el servlet de Producto, clase hija de HttpServlet
 * que va a manejar el cierre de sesión
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Eliminar cookie "username"
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0); // Expira inmediatamente
        cookie.setPath("/"); // Aplica a toda la aplicación
        resp.addCookie(cookie);

        // Redirigir al login
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}

