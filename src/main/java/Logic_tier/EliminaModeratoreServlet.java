package Logic_tier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModeratoreDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "eliminaModeratore", value = "/elimina-moderatore")
public class EliminaModeratoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ModeratoreDAO moderatoreDAO = new ModeratoreDAO();
            moderatoreDAO.doDeleteById(Integer.parseInt(req.getParameter("id")));
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaModeratori.jsp");
            dispatcher.forward(req, resp);
        }
        catch(SQLException e){
            //Mostra pagina errore
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
