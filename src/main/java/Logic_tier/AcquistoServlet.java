package Logic_tier;

import Data_tier.InterfaceMod;
import Data_tier.Proiezione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("ALL")
@WebServlet(name = "acquistoServlet", value = "/acquisto-servlet")
public class AcquistoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InterfaceMod interfaceMod = new InterfaceMod();
        int proiezioneId = Integer.parseInt(req.getParameter("proiezione"));
        Proiezione proiezione;
        try {
            proiezione = interfaceMod.recuperaProiezioneViaId(proiezioneId);
            if (proiezione != null && proiezione.getPosti() >= Integer.parseInt(req.getParameter("numeroBiglietti"))) {
                String email = req.getParameter("email");
                String nome = req.getParameter("nome");
                String cognome = req.getParameter("cognome");
                int nPosti = Integer.parseInt(req.getParameter("numeroBiglietti"));
                interfaceMod.acquistoBiglietto(email, nome, cognome, proiezione, nPosti);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
