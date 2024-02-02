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

    public class AggiungiProiezioneServletTest {

        @Test
        void testServlet() throws Exception{
            // mock HttpServletRequest & HttpServletResponse
            HttpServletRequest request = mock(HttpServletRequest.class);
            HttpServletResponse response = mock(HttpServletResponse.class);
            HttpSession session = mock(HttpSession.class);
            RequestDispatcher dispatcher = mock(RequestDispatcher.class);

            // mock the returned value of request.getParameterMap()
            when(request.getParameter("Film")).thenReturn("1");
            when(request.getParameter("Sala")).thenReturn("1");
            when(request.getParameter("Data")).thenReturn("10-10-2024");
            when(request.getParameter("Orario")).thenReturn("10:10");


            when(request.getSession()).thenReturn(session);
            when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);
            //Se si viene reindirizzti di nuovo in AggiungiProiezione.jsp vuol dire che è avvenuto un errore nell'aggiunta della proiezione, e quindi si lancia un'eccezione.
            //Se non viene lanciata una RunTimeException vuol dire che i dati sono stati inseriti correttamente e siamo stati reindirizzati verso index.jsp
            when(request.getRequestDispatcher("AggiungiProiezione.jsp")).thenThrow(new RuntimeException("Errore nell'aggiunta"));
            (new AggiungiProiezioneServlet()).doGet(request, response);
        }
    }
