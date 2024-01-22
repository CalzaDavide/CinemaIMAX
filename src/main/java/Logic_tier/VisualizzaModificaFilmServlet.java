package Logic_tier;

import Data_tier.Film;
import Data_tier.FilmDAO;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDAO filmDAO = new FilmDAO();
        try {
            Film film = filmDAO.doRetriveById(Integer.parseInt(req.getParameter("idFilm")));
            req.setAttribute("film", film);
            RequestDispatcher dispatcher = req.getRequestDispatcher("ModificaFilm.jsp");
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
