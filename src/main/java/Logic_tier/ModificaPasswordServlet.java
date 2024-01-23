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

@WebServlet(name = "ModificaPassword", value = "/modifica-password")
public class ModificaPasswordServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ottiene i parametri dalla richiesta
        String email = req.getParameter("email");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceMod interfaceMod = new InterfaceMod();

        try {
            // Verifica se esiste un moderatore con l'email e la password fornite
            if (interfaceMod.recuperaViaEmailPass(email, oldPassword) != null) {
                // Modifica la password del moderatore
                interfaceMod.modificaModeratore(email, newPassword);
            }

            // Ottenimento del dispatcher per la pagina "index.jsp"
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

            // Inoltro della richiesta alla pagina "index.jsp"
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            e.printStackTrace();
        }
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
