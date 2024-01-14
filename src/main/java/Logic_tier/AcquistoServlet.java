package Logic_tier;

import Data_tier.Biglietto;
import Data_tier.Proiezione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BigliettoDAO;
import model.ProiezioneDAO;

import java.io.IOException;

@WebServlet(name = "acquistoServlet", value = "/acquisto-servlet")
public class AcquistoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigliettoDAO bigliettoDAO = new BigliettoDAO();
        ProiezioneDAO proiezioneDAO = new ProiezioneDAO();
        int proiezioneId = Integer.parseInt(req.getParameter("proiezione"));
        Proiezione proiezione = proiezioneDAO.doRetriveById(proiezioneId);
        //if(proiezione.getPosti>0){
            Biglietto biglietto = new Biglietto();
            biglietto.setNome(req.getParameter("nome"));
            biglietto.setCognome(req.getParameter("cognome"));
            //biglietto.setProiezione(proiezione);
            //biglietto.setPosto(proiezione.getPosti());
            //proiezioneDAO.rimuoviPosto(proiezioneId);
            //bigliettoDAO.doSave(biglietto);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/AcquistoEffettuato.jsp");
            dispatcher.forward(req, resp);
        //}else
            //mostra pagina errore(posti esauriti);
        //}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
