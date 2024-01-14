package model;

import Data_tier.ConPool;
import Data_tier.Moderatore;

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

    public static boolean doDeleteById(int id) throws  SQLException{
        Connection con = ConPool.getConnection();

        String query = "DELETE FROM moderatore WHERE id = " + id;

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public static Moderatore doRetriveByEmail(String email) throws  SQLException{
        Connection con = ConPool.getConnection();
        String query = "SELECT * FROM moderatore WHERE Email = '" + email.toLowerCase() + "'";
        ResultSet rs = con.createStatement().executeQuery(query);
        if(rs.next()){
            Moderatore moderatore = new Moderatore();
            moderatore.setId(rs.getInt(1));
            moderatore.setNome(rs.getString(2));
            moderatore.setCognome(rs.getString(3));
            moderatore.setPassword(rs.getString(4));
            moderatore.setEmail(rs.getString(5));
            return moderatore;
        }
        return null;
    }


}
