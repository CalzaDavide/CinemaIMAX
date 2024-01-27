package Data_tier;

import java.sql.SQLException;
import java.util.ArrayList;

public class InterfaceMod {

    private ModeratoreDAO modDao;

    public InterfaceMod() {

        this.modDao = new ModeratoreDAO();
    }

    //FUNZIONI MODERATORE
    public void aggiungiModeratore(Moderatore m) throws SQLException {
        modDao.addModeratore(m);
    }

    public void modificaModeratore(String email, String pass) throws SQLException {
        modDao.updatePassword(email, pass);
    }

    public void cancellaModeratore(int id) throws SQLException {
        modDao.doDeleteById(id);
    }

    public Moderatore recuperaViaEmailPass(String email, String pass) throws SQLException {
        return modDao.doRetriveByEmailPass(email, pass);
    }

}
