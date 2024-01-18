package Logic_tier;

import Data_tier.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

@WebServlet(name = "aggiungiProiezioneServlet", value = "/aggiungi-Proiezione-Servlet")
public class AggiungiProiezioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Proiezione proiezione = new Proiezione();
        Film film = null;

        try {
            FilmDAO filmDAO = new FilmDAO();
            film = filmDAO.doRetriveById(Integer.parseInt(req.getParameter("Film")));

            proiezione.setFilm(film);
            SalaDAO saladao = new SalaDAO();

            Sala sala = saladao.doRetrieveById(Integer.parseInt(req.getParameter("Sala")));
            proiezione.setSala(sala);
            proiezione.setPosti(sala.getMaxPosti());
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date data = dateFormat.parse(req.getParameter("Data"));
            Date dataSQL = new Date(data.getTime());
            proiezione.setData(dataSQL);
            String orario = req.getParameter("Orario");
            orario = orario.concat(":00");
            proiezione.setOrario(Time.valueOf(orario));

            ProiezioneDAO proD = new ProiezioneDAO();
            proD.addProiezione(proiezione);
        } catch (Exception e) {
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
