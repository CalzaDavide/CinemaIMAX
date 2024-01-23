package Logic_tier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Rimuove l'attributo "utente" dalla sessione (logout)
        req.getSession().removeAttribute("utente");

        // Ottenimento del dispatcher per la pagina "index.jsp"
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

        // Inoltro della richiesta alla pagina "index.jsp"
        dispatcher.forward(req, resp);
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
