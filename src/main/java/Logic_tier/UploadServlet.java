package Logic_tier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Configurazione per gestire richieste multipart (upload di file)
@MultipartConfig
@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {

    // Costante per la cartella di destinazione per l'upload
    private static final String CARTELLA_UPLOAD = "upload";

    // Metodo invocato quando una richiesta di tipo GET viene ricevuta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Richiamo del metodo doPost per gestire la richiesta anche quando è di tipo GET
        doPost(req, resp);
    }

    // Metodo invocato quando una richiesta di tipo POST viene ricevuta
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottiene la parte del file dalla richiesta
        Part filePart = request.getPart("file");

        // Ottiene il nome del file dal Part
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Imposta il percorso di destinazione del file
        String destinazione = CARTELLA_UPLOAD + File.separator + fileName;
        Path pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));

        // Se un file con quel nome esiste già, gli cambia nome aggiungendo un numero
        for (int i = 2; Files.exists(pathDestinazione); i++) {
            destinazione = CARTELLA_UPLOAD + File.separator + i + "_" + fileName;
            pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));
        }

        // Ottiene lo stream di input dal Part del file
        InputStream fileInputStream = filePart.getInputStream();

        // Crea la cartella di destinazione, se non esiste
        Files.createDirectories(pathDestinazione.getParent());

        // Scrive il file nella cartella di destinazione
        Files.copy(fileInputStream, pathDestinazione);

        // Imposta l'attributo "uploaded" nella richiesta con il percorso del file appena caricato
        request.setAttribute("uploaded", destinazione);

        // Ottiene il dispatcher per la pagina "AggiungiFilm.jsp"
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AggiungiFilm.jsp");

        // Inoltro della richiesta alla pagina "AggiungiFilm.jsp"
        requestDispatcher.forward(request, response);
    }
}
