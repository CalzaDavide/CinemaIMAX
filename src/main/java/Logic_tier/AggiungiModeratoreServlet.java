package Logic_tier;

import Data_tier.Moderatore;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModeratoreDAO;

import java.io.IOException;

@WebServlet(name="AggiungiModeratore", value = "/aggiungi-moderatore")
public class AggiungiModeratoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Moderatore moderatore = new Moderatore();
        moderatore.setNome(req.getParameter("Nome"));
        moderatore.setCognome(req.getParameter("Cognome"));
        moderatore.setEmail(req.getParameter("Email"));
        moderatore.setPassword(req.getParameter("Pswd"));
        //new ModeratoreDAO().addModeratore(moderatore);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
