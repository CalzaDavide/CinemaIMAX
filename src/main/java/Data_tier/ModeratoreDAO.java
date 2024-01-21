package Data_tier;

import java.sql.*;
import java.util.ArrayList;
import Data_tier.DataChecker;
import jakarta.servlet.RequestDispatcher;

public class ModeratoreDAO {

    public static void addModeratore(Moderatore m) throws SQLException
    {
        Connection con = ConPool.getConnection();

        //SERVE PAGINA DOVE INSERIRE I DATI

        if(!DataChecker.checkModeratoreData(m.getEmail())) {
            PreparedStatement statement = con.prepareStatement("INSERT  INTO MODERATORE(Nome, Cognome, Pswd, Email, isAdmin) VALUES\n" +
                    "(?, ?, SHA1(?), ?, ?)");
            statement.setString(1, m.getNome());
            statement.setString(2, m.getCognome());
            statement.setString(3, m.getPassword());
            statement.setString(4, m.getEmail());
            statement.setBoolean(5, false);


            //TEST
            String insert = "INSERT INTO MODERATORE(Nome, Cognome, Pswd, Email) VALUES\n" +
                    "('silvio', 'berlusconi', SHA1('silvietto'), 'mio.padre@cinemaimax.it');";

            if(statement.executeUpdate() != 1){
                throw new SQLException("Errore nell'aggiunta del moderatore");
            }
            con.close();
        }else{
            //popup email già presa
            System.out.println("Mail già esistente.");
        }

    }
    public void updatePassword(String email, String newPassword) throws SQLException{
        try{
            Connection con = ConPool.getConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE moderatore SET Pswd = SHA1(?) WHERE Email = ?");
            statement.setString(1, newPassword);
            statement.setString(2, email);

            if(statement.executeUpdate() != 1){
                throw new SQLException("Update Error.");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean isRegisteredModeratore(String email, String password) throws  SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + password.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public static boolean doDeleteById(int id) throws  SQLException{

        try{
            Connection con = ConPool.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM moderatore WHERE id =?");
            ps.setString(1, String.valueOf(id));

            con.close();
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static Moderatore doRetriveByEmailPass(String email, String pass) throws  SQLException{
        try {
            Connection con = ConPool.getConnection();
            //String query = "SELECT * FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = SHA1(" + pass.toLowerCase() + ")";
            //String query = "SELECT * FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "' AND LOWER(Pswd) = '" + pass.toLowerCase() + "'";

            PreparedStatement query = con.prepareStatement("SELECT * FROM moderatore WHERE LOWER(Email) = ? AND LOWER(Pswd) = SHA1(?)");
            query.setString(1, email);
            query.setString(2, pass);

            ResultSet rs = query.executeQuery();
            if(rs.next()){
                Moderatore moderatore = new Moderatore();
                moderatore.setId(rs.getInt(1));
                moderatore.setNome(rs.getString(2));
                moderatore.setCognome(rs.getString(3));
                moderatore.setPassword(rs.getString(4));
                moderatore.setEmail(rs.getString(5));
                moderatore.setAdmin(rs.getBoolean(6));
                return moderatore;
            }

        }catch(SQLException e){
            e.printStackTrace();
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
