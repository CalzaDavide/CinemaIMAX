package model;

import Data_tier.ConPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public static void addAdmin() throws SQLException
    {
        Connection con = ConPool.getConnection();


        //TEST
        String insert = "INSERT INTO ADMIN(Nome, Cognome, Pswd, Email) VALUES\n" +
                "('papa', 'francesco', SHA1('gerusalemme'), 'ave.maria@cinemaimax.it');";

        con.createStatement().executeUpdate(insert);

    }

    public static boolean isRegisteredAdmin(String email, String password) throws  SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM admin WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + password.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }


    public static void modifyAccount(){

    }

}
