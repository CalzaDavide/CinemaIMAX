package Logic_tier;

import Data_tier.Film;
import Data_tier.InterfaceFilm;
import Data_tier.InterfaceMod;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "FiltraFilm", value = "/filtra-film")
public class FiltraFilmServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
        InterfaceFilm interfaceFilm = new InterfaceFilm();
        ArrayList<Film> film;
        try {
            // Recupero di tutti i film dal database
            film = interfaceFilm.recuperaFilms();
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            throw new RuntimeException(e);
        }

        // Creazione di una nuova lista per i film filtrati
        ArrayList<Film> filmFiltrati = new ArrayList<>();

        // Ottenimento dei parametri di filtro dalla richiesta
        String filtroTitolo = req.getParameter("filtroTitolo");
        String filtroGeneri = req.getParameter("filtroGeneri");
        String[] generiArray = filtroGeneri.trim().split(",");

        // Iterazione attraverso tutti i film per applicare i filtri
        for (Film f : film) {
            boolean toBeRemoved = false;
            String gen = f.getGeneri().toLowerCase();

            // Controllo se il genere del film contiene tutti i generi specificati nei filtri
            for (String g : generiArray)
                if (!gen.contains(g.toLowerCase())) {
                    toBeRemoved = true;
                    break;
                }

            // Se il film supera i filtri, lo aggiunge alla lista filtrata
            if (!toBeRemoved && f.getTitolo().toLowerCase().contains(filtroTitolo.toLowerCase())) {
                filmFiltrati.add(f);
            }
        }

        // Imposta l'attributo "film" nella richiesta con la lista dei film filtrati
        req.setAttribute("film", filmFiltrati);

        // Inoltro della richiesta alla pagina "index.jsp"
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
