package Logic_tier;

import Data_tier.Proiezione;
import Data_tier.ProiezioneDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="VisualizzaPaginaProiezione", value = "/visualizza-pagina-proiezione")
public class VisualizzaPaginaProiezioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProiezioneDAO proiezioneDAO = new ProiezioneDAO();
        Proiezione p = null;
        try{
            p =proiezioneDAO.doRetriveById(Integer.parseInt(req.getParameter("idProiezione")));
        }catch(SQLException e){
            e.printStackTrace();
        }
        req.setAttribute("proiezione", p);

        RequestDispatcher dispatcher = req.getRequestDispatcher("PaginaProiezione.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
