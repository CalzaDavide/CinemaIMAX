package Logic_tier;

import Data_tier.Film;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Data_tier.FilmDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "aggiunguFilmServlet", value = "/aggiungi-film-servlet")
public class AggiungiFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film film = new Film();
        String attoriString = req.getParameter("attori");
        ArrayList<String> attoriList = new ArrayList<String>(Arrays.asList(attoriString.split(",")));
        film.setAttori(attoriList);
        film.setDurata(Integer.parseInt(req.getParameter("durata")));
        film.setDescrizione(req.getParameter("descrizione"));
        film.setGenere(req.getParameter("genere"));
        film.setTitolo(req.getParameter("titolo"));

        FilmDAO filmDAO = new FilmDAO();
        //filmDAO.addFilm(film);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
