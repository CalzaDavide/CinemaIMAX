package Logic_tier;

import Data_tier.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "aggiungiProiezioneServlet", value = "/aggiungi-Proiezione-Servlet")
public class AggiungiProiezioneServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creazione di un'istanza di Proiezione
        Proiezione proiezione = new Proiezione();
        Film film;

        try {
            // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
            InterfacePro interfacePro = new InterfacePro();
            InterfaceFilm interfaceFilm = new InterfaceFilm();

            // Recupero del film utilizzando l'ID fornito come parametro nella richiesta
            film = interfaceFilm.recuperaFilmViaId(Integer.parseInt(req.getParameter("Film")));
            proiezione.setFilm(film);

            // Recupero della sala utilizzando l'ID fornito come parametro nella richiesta
            Sala sala = interfacePro.recuperaSalaViaId(Integer.parseInt(req.getParameter("Sala")));
            proiezione.setSala(sala);

            // Impostazione del numero di posti sulla base del numero massimo di posti disponibili nella sala
            proiezione.setPosti(sala.getMaxPosti());

            // Formattazione e impostazione della data
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date data = dateFormat.parse(req.getParameter("Data"));
            Date dataSQL = new Date(data.getTime());
            proiezione.setData(dataSQL);

            // Formattazione e impostazione dell'orario
            String orario = req.getParameter("Orario");
            orario = orario.concat(":00");
            proiezione.setOrario(Time.valueOf(orario));

            // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
            InterfacePro interfacepro = new InterfacePro();

            // Aggiunta della proiezione nel database
            interfacepro.aggiungiProiezione(proiezione);
        } catch (Exception e) {
            // Gestione dell'eccezione se si verifica un errore durante l'esecuzione delle operazioni
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
