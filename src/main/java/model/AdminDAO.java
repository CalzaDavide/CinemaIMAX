package model;

import Data_tier.ConPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public static void addAdmin() throws SQLException
    {
        Connection con = ConPool.getConnection();

        String insert = "INSERT INTO ADMIN(Nome, Cognome, Pswd, Email) VALUES\n" +
                "('fab', 'dan', SHA1('AlfredinoTattico10'), 'fab.buonvino@cinemaimax.it');";

        con.createStatement().executeUpdate(insert);

    }

    public static boolean isRegistered(String email, String password) throws  SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM admin WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + password.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public static void addMod(){

    }

    public static void modifyAccount(){

    }

}
