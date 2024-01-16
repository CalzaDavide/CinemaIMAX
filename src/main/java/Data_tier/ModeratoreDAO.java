package Data_tier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<Moderatore> doRetrieveAll() {
        ArrayList<Moderatore> moderatori = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Moderatore mod;

        try{
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM moderatore");

            while (resultSet.next()) {
                mod = new Moderatore();
                mod.setId(resultSet.getInt(1));
                mod.setNome(resultSet.getString(2));
                mod.setCognome(resultSet.getString(3));
                mod.setPassword(resultSet.getString(4));
                mod.setEmail(resultSet.getString(5));
                moderatori.add(mod);
            }
            con.close();
            return moderatori;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public ArrayList<Moderatore> doRetrieveModeratori() {
        ArrayList<Moderatore> moderatori = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Moderatore mod;

        try{
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM moderatore WHERE isAdmin = 0");

            while (resultSet.next()) {
                mod = new Moderatore();
                mod.setId(resultSet.getInt(1));
                mod.setNome(resultSet.getString(2));
                mod.setCognome(resultSet.getString(3));
                mod.setPassword(resultSet.getString(4));
                mod.setEmail(resultSet.getString(5));
                moderatori.add(mod);
            }
            con.close();
            return moderatori;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

}
