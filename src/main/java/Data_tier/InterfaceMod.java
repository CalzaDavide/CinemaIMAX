package Data_tier;

import java.sql.SQLException;
import java.util.ArrayList;

public class InterfaceMod {

    private FilmDAO filmDao;
    private ProiezioneDAO proDao;

    private ModeratoreDAO modDao;

    private SalaDAO salaDAO;

    public InterfaceMod(){
        this.filmDao = new FilmDAO();
        this.proDao = new ProiezioneDAO();
        this.modDao = new ModeratoreDAO();
        this.salaDAO = new SalaDAO();
    }

    //FUNZIONI MODERATORE
    public void aggiungiModeratore(Moderatore m) throws SQLException{
        modDao.addModeratore(m);
    }

    public void modificaModeratore(String email, String pass) throws SQLException{
        modDao.updatePassword(email, pass);
    }

    public void cancellaModeratore(int id) throws SQLException{
        modDao.doDeleteById(id);
    }

    public Moderatore recuperaViaEmailPass(String email, String pass) throws SQLException {
        return modDao.doRetriveByEmailPass(email, pass);
    }

    public ArrayList<Moderatore> recuperaModeratori(){
        return modDao.doRetrieveModeratori();
    }


    //FUNZIONI FILM
    public void aggiungiFilm(Film f) throws SQLException {
        filmDao.addFilm(f);
    }

    public void modificaFilm(int id, String titolo, String descrizione, String regista, String attori, String generi, int durata) throws  SQLException{
        filmDao.doUpdateById(id, titolo,descrizione,regista,attori,generi,durata);
    }

    public void cancellaFilm(int id) throws  SQLException{
        filmDao.doDeleteById(id);
    }

    public Film recuperaFilmViaId(int id) throws  SQLException{
        return filmDao.doRetriveById(id);
    }

    public ArrayList<Film> recuperaFilms() throws SQLException {
        return filmDao.doRetrieveAll();
    }



    //FUNZIONI PROIEZIONE
    public void aggiungiProiezione(Proiezione p) throws SQLException{
        proDao.addProiezione(p);
    }

    public void cancellaProiezioneViaId(int id) throws  SQLException{
        proDao.doDeleteById(id);
    }

    public void acquistoBiglietto(String email, String nome, String cognome, Proiezione proiezione, int n) throws SQLException{
        proDao.acquistBiglietto(email,nome,cognome,proiezione,n);
    }

    public Proiezione recuperaProiezioneViaId(int id) throws  SQLException{
        return proDao.doRetriveById(id);
    }

    public ArrayList<Proiezione> recuperaProiezioneViaIdFilm(int id) {
        return proDao.doRetrieveByIdFilm(id);
    }


     //FUNZIONI SALA

    public ArrayList<Sala> recuperaSale(){

        return salaDAO.doRetrieveAll();
    }

    public Sala recuperaSalaViaId(int id) throws SQLException{
        return salaDAO.doRetrieveById(id);
    }

 }
