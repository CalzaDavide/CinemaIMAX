package Logic_tier;

import Data_tier.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

@WebServlet
public class AggiungiProiezioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Proiezione proiezione = new Proiezione();
        proiezione.setCosto(Integer.parseInt(req.getParameter("costo")));
        Film film = null;

        try {
            film = FilmDAO.doRetriveById(Integer.parseInt(req.getParameter("film")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//forzato da programma, dubbio//

        proiezione.setFilm(film);
        Sala sala = SalaDAO.doRetriveById(req.getParameter("sala"));
        proiezione.setSala(sala);
        proiezione.setPosti(sala.getPosti());
        String data = req.getParameter("Data");
        String[] dataArray = data.split(",");
        String ora = req.getParameter("Orario");
        String[] oraArray = ora.split(":");
        GregorianCalendar data_ora = new GregorianCalendar(
                Integer.parseInt(dataArray[2]),
                Integer.parseInt(dataArray[1]),
                Integer.parseInt(dataArray[0]),
                Integer.parseInt(oraArray[0]),
                Integer.parseInt(oraArray[1]));
        proiezione.setData_ora(data_ora);
        //new ProiezioneDAO.AddProiezione(proiezione);
        ProiezioneDAO proD = new ProiezioneDAO();
        try {
            proD.addProiezione(proiezione);
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
