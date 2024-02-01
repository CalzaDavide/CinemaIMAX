package Data_tier;

import java.sql.SQLException;
import java.util.ArrayList;

public class InterfaceFilm {

    private final FilmDAO filmDao;

    public InterfaceFilm(){
        this.filmDao = new FilmDAO();
    }

    public void aggiungiFilm(Film f) throws SQLException {
        filmDao.addFilm(f);
    }

    public void modificaFilm(int id, String titolo, String descrizione, String regista, String attori, String generi, int durata) throws SQLException {
        filmDao.doUpdateById(id, titolo, descrizione, regista, attori, generi, durata);
    }

    public void cancellaFilm(int id) throws SQLException {
        FilmDAO.doDeleteById(id);
    }

    public Film recuperaFilmViaId(int id) throws SQLException {
        return filmDao.doRetriveById(id);
    }

    public ArrayList<Film> recuperaFilms() throws SQLException {
        return filmDao.doRetrieveAll();
    }
}
