package Logic_tier;

import Data_tier.Film;
import Data_tier.InterfaceFilm;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VisualizzaModificaFilm", value = "/visualizza-modifica-film")
public class VisualizzaModificaFilmServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceFilm interfaceFilm = new InterfaceFilm();

        try {
            // Recupero del film utilizzando l'ID fornito come parametro nella richiesta
            Film film = interfaceFilm.recuperaFilmViaId(Integer.parseInt(req.getParameter("idFilm")));

            // Impostazione dell'attributo "film" nella richiesta con l'oggetto Film ottenuto
            req.setAttribute("film", film);

            // Ottenimento del dispatcher per la pagina "ModificaFilm.jsp"
            RequestDispatcher dispatcher = req.getRequestDispatcher("ModificaFilm.jsp");

            // Inoltro della richiesta alla pagina "ModificaFilm.jsp"
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
