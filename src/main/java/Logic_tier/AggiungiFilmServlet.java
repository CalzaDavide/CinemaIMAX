package Logic_tier;

import Data_tier.Film;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Data_tier.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "aggiunguFilmServlet", value = "/aggiungi-film-servlet")
public class AggiungiFilmServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di Film
        Film film = new Film();

        // Impostazione dei dati del film utilizzando i parametri forniti nella richiesta
        film.setAttori(req.getParameter("attori"));
        film.setDurata(Integer.parseInt(req.getParameter("durata")));
        film.setDescrizione(req.getParameter("descrizione"));
        film.setGeneri(req.getParameter("generi"));
        film.setTitolo(req.getParameter("titolo"));
        film.setRegista(req.getParameter("regista"));
        film.setLocandina(req.getParameter("immagine"));

        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceFilm interfaceFilm = new InterfaceFilm();
        try {
            // Aggiunta del film nel database
            interfaceFilm.aggiungiFilm(film);
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
