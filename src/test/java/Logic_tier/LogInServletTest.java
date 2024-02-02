package Logic_tier;

import Data_tier.InterfaceMod;
import Data_tier.Moderatore;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class LogInServletTest {

    @Test
    void testServlet() throws Exception{
        // mock HttpServletRequest & HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        // mock the returned value of request.getParameterMap()
        when(request.getParameter("email")).thenReturn("alfredo.buonvino@cinemaimax.it");
        when(request.getParameter("password")).thenReturn("AlfredinoTattico23");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);
        //Se si viene reindirizzti di nuovo in Login.jsp vuol dire che le credenziali del moderatore non erano corrette, e quindi si lancia un'eccezione.
        //Se non viene lanciata una RunTimeException vuol dire che le credenziali sono giuste e siamo stati reindirizzati verso index.jsp
        when(request.getRequestDispatcher("Login.jsp")).thenThrow(new RuntimeException("Moderatore non trovato"));
        (new LoginServlet()).doGet(request, response);
    }
}
