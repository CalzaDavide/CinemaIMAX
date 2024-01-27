package Data_tier;

import java.sql.SQLException;
import java.util.ArrayList;

public class InterfacePro {

    private ProiezioneDAO proDao;

    private SalaDAO salaDao;

    public InterfacePro(){
        this.proDao = new ProiezioneDAO();
        this.salaDao = new SalaDAO();
    }

    public void aggiungiProiezione(Proiezione p) throws SQLException {
        proDao.addProiezione(p);
    }

    public void cancellaProiezioneViaId(int id) throws SQLException {
        proDao.doDeleteById(id);
    }

    public void acquistoBiglietto(String email, String nome, String cognome, Proiezione proiezione, int n) throws SQLException {
        proDao.acquistBiglietto(email, nome, cognome, proiezione, n);
    }

    public Proiezione recuperaProiezioneViaId(int id) throws SQLException {
        return proDao.doRetriveById(id);
    }

    public ArrayList<Proiezione> recuperaProiezioneViaIdFilm(int id) {
        return proDao.doRetrieveByIdFilm(id);
    }


    //FUNZIONI SALA
    public ArrayList<Sala> recuperaSale() {

        return salaDao.doRetrieveAll();
    }

    public Sala recuperaSalaViaId(int id) throws SQLException {
        return salaDao.doRetrieveById(id);
    }
}
