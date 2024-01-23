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

@WebServlet(name = "ModificaFilm", value = "/modifica-film")
public class ModificaFilmServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceMod interfaceMod = new InterfaceMod();

        // Ottiene i parametri dalla richiesta
        String attori = req.getParameter("attori");
        String titolo = req.getParameter("titolo");
        String descrizione = req.getParameter("descrizione");
        String generi = req.getParameter("generi");
        int id = Integer.parseInt(req.getParameter("id"));
        String regista = req.getParameter("regista");
        int durata = Integer.parseInt(req.getParameter("durata"));

        try {
            // Modifica le informazioni del film utilizzando i parametri forniti
            interfaceMod.modificaFilm(id, titolo, descrizione, regista, attori, generi, durata);

            // Ottenimento del dispatcher per la pagina "index.jsp"
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

            // Inoltro della richiesta alla pagina "index.jsp"
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            throw new RuntimeException(e);
        }
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
