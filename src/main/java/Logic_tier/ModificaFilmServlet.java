package Logic_tier;

import Data_tier.FilmDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="ModificaFilm", value = "/modifica-film")
public class ModificaFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDAO filmDAO = new FilmDAO();
        String attori = req.getParameter("attori");
        System.out.println("attori "+attori);
        String titolo = req.getParameter("titolo");
        System.out.println("titolo "+titolo);
        String descrizione = req.getParameter("descrizione");
        System.out.println("descrizione "+descrizione);
        String generi = req.getParameter("generi");
        System.out.println("generi "+generi);
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id "+id);
        String regista = req.getParameter("regista");
        System.out.println("regista "+regista);
        int durata = Integer.parseInt(req.getParameter("durata"));
        System.out.println("durata "+durata);
        try {
            filmDAO.doUpdateById(id, titolo, descrizione, regista, attori, generi, durata);

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
