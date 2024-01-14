package Logic_tier;

import Data_tier.Moderatore;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Data_tier.ModeratoreDAO;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    public String message;

    public void init() {
        message = "Hello";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        try {
            ModeratoreDAO service = new ModeratoreDAO();
            Moderatore moderatore = service.doRetriveByEmail(email);
            if (moderatore != null && moderatore.getPassword().equals(pass))
                request.getSession().setAttribute("utente", moderatore);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        }catch(SQLException e){
            //ERRORE
        }
    }

    public void destroy() {
    }
}