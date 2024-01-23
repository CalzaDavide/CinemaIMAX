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

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    // Variabile di istanza per il messaggio di inizializzazione (non utilizzata nel codice fornito)
    public String message;

    // Metodo di inizializzazione del servlet (non utilizzato nel codice fornito)
    public void init() {
        message = "Hello";
    }

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ottiene i parametri dalla richiesta
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        try {
            // Creazione di un'istanza di InterfaceMod per interagire con il livello dati
            InterfaceMod interfaceMod = new InterfaceMod();

            // Recupera il moderatore utilizzando l'email e la password fornite
            Moderatore moderatore = interfaceMod.recuperaViaEmailPass(email, pass);

            if (moderatore != null) {
                // Se il moderatore esiste, imposta l'utente nella sessione e reindirizza a "index.jsp"
                request.getSession().setAttribute("utente", moderatore);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                // Se il moderatore non esiste, imposta uno status di login errato e reindirizza a "Login.jsp"
                request.setAttribute("logInStatus", "errato");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // Gestione dell'eccezione se si verifica un errore durante l'accesso ai dati
            e.printStackTrace();
            System.out.println("err");
        }
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doGet per gestire la richiesta anche quando è di tipo POST
        doGet(req, resp);
    }
}
