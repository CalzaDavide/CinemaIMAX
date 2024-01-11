package model;

import Data_tier.ConPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ModeratoreDAO {

    public static void addModeratore() throws SQLException
    {
        Connection con = ConPool.getConnection();

        //SERVE PAGINA DOVE INSERIRE I DATI


        //TEST
        String insert = "INSERT INTO MODERATORE(Nome, Cognome, Pswd, Email) VALUES\n" +
                "('silvio', 'berlusconi', SHA1('silvietto'), 'mio.padre@cinemaimax.it');";

        con.createStatement().executeUpdate(insert);

    }

    public static boolean isRegisteredModeratore(String email, String password) throws  SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + password.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public static boolean deleteModeratore(String email, String password) throws  SQLException{
        Connection con = ConPool.getConnection();

        String query = "DELETE FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + password.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public static void modifyAccount(){

    }


}
