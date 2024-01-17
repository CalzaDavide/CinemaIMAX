package Logic_tier;

import Data_tier.Film;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Data_tier.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "aggiunguFilmServlet", value = "/aggiungi-film-servlet")
public class AggiungiFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film film = new Film();
        film.setAttori(req.getParameter("attori"));
        film.setDurata(Integer.parseInt(req.getParameter("durata")));
        film.setDescrizione(req.getParameter("descrizione"));
        film.setGenere(req.getParameter("genere"));
        film.setTitolo(req.getParameter("titolo"));
        film.setRegista(req.getParameter("regista"));
        film.setLocandina((String)req.getAttribute("locandina"));
        FilmDAO filmD = new FilmDAO();
        try {
            filmD.addFilm(film);
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
