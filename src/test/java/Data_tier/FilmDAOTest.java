package Data_tier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FilmDAOTest {

    @Test
    public void testAddFilm() {
        FilmDAO filmDAO = new FilmDAO();
        Film film = new Film();
        film.setId(11);
        film.setTitolo("Test Fi");
        film.setDescrizione("This is a test film");
        film.setRegista("Test Director");
        film.setAttori("Test Actor 1, Test Actor 2");
        film.setGeneri("Test Genre");
        film.setDurata(120);
        film.setLocandina("test.jpg");

        try {
            filmDAO.addFilm(film);
            // Assert that the film was added successfully
            assertNotNull(filmDAO.doRetriveById(film.getId()));
        } catch (SQLException e) {
            fail("Failed to add film: " + e.getMessage());
        }
    }

    @Test
    public void testDoRetriveById() {
        FilmDAO filmDAO = new FilmDAO();
        int id = 11;

        try {
            Film film = filmDAO.doRetriveById(id);
            assertNotNull(film);
            assertEquals(id, film.getId());
        } catch (SQLException e) {
            fail("Failed to retrieve film by id: " + e.getMessage());
        }
    }


    @Test
    public void testDoRetrieveAll() {
        FilmDAO filmDAO = new FilmDAO();

        try {
            ArrayList<Film> films = filmDAO.doRetrieveAll();
            assertNotNull(films);
            assertFalse(films.isEmpty());
        } catch (Exception e) {
            fail("Failed to retrieve all films: " + e.getMessage());
        }
    }

}