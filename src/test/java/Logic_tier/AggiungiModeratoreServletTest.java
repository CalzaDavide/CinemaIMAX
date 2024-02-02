package Logic_tier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AggiungiModeratoreServletTest {

    @Test
    void testServlet() throws Exception {
        // mock HttpServletRequest & HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        // mock the returned value of request.getParameterMap()
        when(request.getParameter("Nome")).thenReturn("Fabio");
        when(request.getParameter("Cognome")).thenReturn("D'Antonio");
        when(request.getParameter("Email")).thenReturn("fabio@dantonio.it");
        when(request.getParameter("Pswd")).thenReturn("briscola420");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);

        //Se si viene indirizzati ad AggiungiModeratore.jsp nuovamente, significa che c'è stato un errore nell'aggiunta del moderatore, e viene lanciata un eccezione
        //Se non viene lanciata nessuna eccezione e si viene indirizzati ad index.jsp vuol dire che l'aggiunta è andata a buon fine
        when(request.getRequestDispatcher("AggiungiModeratore.jsp")).thenThrow(new RuntimeException("Errore, moderatore non aggiunto."));

        (new AggiungiModeratoreServlet()).doGet(request,response);
    }
}
