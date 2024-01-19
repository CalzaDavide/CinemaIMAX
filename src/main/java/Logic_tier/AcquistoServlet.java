package Logic_tier;

import Data_tier.Proiezione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Data_tier.ProiezioneDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "acquistoServlet", value = "/acquisto-servlet")
public class AcquistoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProiezioneDAO proiezioneDAO = new ProiezioneDAO();
        int proiezioneId = Integer.parseInt(req.getParameter("proiezione"));
        Proiezione proiezione;
        try {
            proiezione = proiezioneDAO.doRetriveById(proiezioneId);
            if (proiezione != null && proiezione.getPosti() >= Integer.parseInt(req.getParameter("numeroPosti"))) {
                String email = req.getParameter("email");
                String nome = req.getParameter("nome");
                String cognome = req.getParameter("cognome");
                int nPosti = Integer.parseInt(req.getParameter("numeroBiglietti"));
                proiezioneDAO.acquistBiglietto(email, nome, cognome, proiezione, nPosti);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
