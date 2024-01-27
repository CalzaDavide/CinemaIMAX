package Logic_tier;

import Data_tier.InterfaceMod;
import Data_tier.InterfacePro;
import Data_tier.Proiezione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VisualizzaPaginaProiezione", value = "/visualizza-pagina-proiezione")
public class VisualizzaPaginaProiezioneServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfacePro interfacePro = new InterfacePro();

        // Inizializzazione di una variabile Proiezione a null
        Proiezione p = null;

        try {
            // Recupero della proiezione utilizzando l'ID fornito come parametro nella richiesta
            p = interfacePro.recuperaProiezioneViaId(Integer.parseInt(req.getParameter("idProiezione")));
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            e.printStackTrace();
        }

        // Impostazione dell'attributo "proiezione" nella richiesta con l'oggetto Proiezione ottenuto
        req.setAttribute("proiezione", p);

        // Ottenimento del dispatcher per la pagina "PaginaProiezione.jsp"
        RequestDispatcher dispatcher = req.getRequestDispatcher("PaginaProiezione.jsp");

        // Inoltro della richiesta alla pagina "PaginaProiezione.jsp"
        dispatcher.forward(req, resp);
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
