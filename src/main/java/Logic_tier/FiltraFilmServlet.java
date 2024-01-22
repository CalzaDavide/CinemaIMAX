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
import java.util.ArrayList;

@WebServlet(name = "FiltraFilm", value = "/filtra-film")
public class FiltraFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDAO filmDAO = new FilmDAO();
        ArrayList<Film> film = filmDAO.doRetrieveAll();
        ArrayList<Film> filmFiltrati = new ArrayList<>();
        String filtroTitolo = req.getParameter("filtroTitolo");
        String filtroGeneri = req.getParameter("filtroGeneri");
        String[] generiArray = filtroGeneri.trim().split(",");
        for (Film f : film) {
            boolean toBeRemoved = false;
            String gen = f.getGeneri().toLowerCase();
            for (String g : generiArray)
                if (!gen.contains(g.toLowerCase())) {
                    toBeRemoved = true;
                    break;
                }
            if (!toBeRemoved && f.getTitolo().toLowerCase().contains(filtroTitolo.toLowerCase())) {
                filmFiltrati.add(f);
            }
        }
        req.setAttribute("film", filmFiltrati);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
