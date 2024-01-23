package Logic_tier;

import Data_tier.InterfaceMod;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "eliminaModeratore", value = "/elimina-moderatore")
public class EliminaModeratoreServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doPost per gestire la richiesta anche quando è di tipo GET
        doPost(req, resp);
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
            InterfaceMod interfaceMod = new InterfaceMod();

            // Cancella il moderatore utilizzando l'ID fornito come parametro nella richiesta
            interfaceMod.cancellaModeratore(Integer.parseInt(req.getParameter("id")));

            // Ottenimento del dispatcher per la pagina "ListaModeratori.jsp"
            RequestDispatcher dispatcher = req.getRequestDispatcher("ListaModeratori.jsp");

            // Inoltro della richiesta alla pagina "ListaModeratori.jsp"
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
        }
    }
}
