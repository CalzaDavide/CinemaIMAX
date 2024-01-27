package Logic_tier;

import Data_tier.InterfaceMod;
import Data_tier.InterfacePro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EliminaProiezioneServlet", value = "/elimina-proiezione")
public class EliminaProiezioneServlet extends HttpServlet {

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
            InterfacePro interfacePro = new InterfacePro();

            // Cancella la proiezione utilizzando l'ID fornito come parametro nella richiesta
            interfacePro.cancellaProiezioneViaId(Integer.parseInt(req.getParameter("proiezione")));

            // Ottenimento del dispatcher per la pagina "index.jsp"
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
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
