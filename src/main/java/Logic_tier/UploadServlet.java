
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

@MultipartConfig
@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {
    private static final String CARTELLA_UPLOAD = "upload";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String descrizione = request.getParameter("descrizione");

        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String destinazione = CARTELLA_UPLOAD + File.separator + fileName;
        Path pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));

        // se un file con quel nome esiste già, gli cambia nome
        for (int i = 2; Files.exists(pathDestinazione); i++) {
            destinazione = CARTELLA_UPLOAD + File.separator + i + "_" + fileName;
            pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));
        }

        InputStream fileInputStream = filePart.getInputStream();
        // crea CARTELLA_UPLOAD, se non esiste
        Files.createDirectories(pathDestinazione.getParent());
        // scrive il file
        Files.copy(fileInputStream, pathDestinazione);

        request.setAttribute("uploaded", destinazione);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AggiungiFilm.jsp");
        requestDispatcher.forward(request, response);
    }
}
