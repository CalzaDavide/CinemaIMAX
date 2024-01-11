package Logic_tier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static model.AdminDAO.isRegisteredAdmin;
import static model.ModeratoreDAO.isRegisteredModeratore;
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

        //AdminDAO service = new AdminDAO();


        String address;

        try {
            System.out.println(pass);
            System.out.println(email);
            //addAdmin();

            if(isRegisteredAdmin(email,pass)){
                address = "ListaModeratori.jsp";
            }else if (isRegisteredModeratore(email,pass)){
                address = "AggiungiFilm.jsp";
            }else {
                address = "index.jsp";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}