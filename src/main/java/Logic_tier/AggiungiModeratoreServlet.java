package Logic_tier;

import Data_tier.Moderatore;
import Data_tier.ModeratoreDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="AggiungiModeratore", value = "/aggiungi-moderatore")
public class AggiungiModeratoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Moderatore moderatore = new Moderatore();
        moderatore.setNome(req.getParameter("Nome"));
        moderatore.setCognome(req.getParameter("Cognome"));
        moderatore.setEmail(req.getParameter("Email"));
        moderatore.setPassword(req.getParameter("Pswd"));

        ModeratoreDAO modD = new ModeratoreDAO();

        try {
            modD.addModeratore(moderatore);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
