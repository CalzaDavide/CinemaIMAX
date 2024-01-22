package Logic_tier;

import Data_tier.FilmDAO;
import Data_tier.InterfaceMod;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificaFilm", value = "/modifica-film")
public class ModificaFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InterfaceMod interfaceMod = new InterfaceMod();
        String attori = req.getParameter("attori");
        String titolo = req.getParameter("titolo");
        String descrizione = req.getParameter("descrizione");
        String generi = req.getParameter("generi");
        int id = Integer.parseInt(req.getParameter("id"));
        String regista = req.getParameter("regista");
        int durata = Integer.parseInt(req.getParameter("durata"));
        try {
            interfaceMod.modificaFilm(id, titolo, descrizione, regista, attori, generi, durata);

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
