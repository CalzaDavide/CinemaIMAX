package Logic_tier;

import Data_tier.InterfaceMod;
import Data_tier.Moderatore;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AggiungiModeratore", value = "/aggiungi-moderatore")
public class AggiungiModeratoreServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di Moderatore
        Moderatore moderatore = new Moderatore();

        // Impostazione dei dati del moderatore utilizzando i parametri forniti nella richiesta
        moderatore.setNome(req.getParameter("Nome"));
        moderatore.setCognome(req.getParameter("Cognome"));
        moderatore.setEmail(req.getParameter("Email"));
        moderatore.setPassword(req.getParameter("Pswd"));

        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceMod interfaceMod = new InterfaceMod();
        try {
            // Aggiunta del moderatore nel database
            interfaceMod.aggiungiModeratore(moderatore);
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            throw new RuntimeException(e);
        }

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
