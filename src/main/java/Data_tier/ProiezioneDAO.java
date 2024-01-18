package Data_tier;

import java.sql.*;
import java.util.ArrayList;

public class ProiezioneDAO {

    public Proiezione doRetriveById(int id) throws SQLException {
        Connection con = ConPool.getConnection();
        ResultSet rs = null;
        String query = "SELECT * FROM proiezione WHERE Id = " + id;
        try {
            rs = con.createStatement().executeQuery(query);
        }catch(SQLException e){
            throw new SQLException(e);
        }
        Proiezione pro;
        if(rs.next()){
            pro = new Proiezione();
            pro.setId(rs.getInt(1));
            pro.setData(rs.getDate(2));
            pro.setOrario(rs.getTime(3));
            pro.setPosti(rs.getInt(4));
            pro.film.setId(rs.getInt(5));
            pro.sala.setId(rs.getInt(6));
            return pro;
        }
        return null;
    }


    public void addProiezione(Proiezione p) throws SQLException {

        if(DataChecker.checkProiezioneData(p)) {

            Connection con = ConPool.getConnection();

            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO PROIEZIONE(Data_Proiezione, Orario_Proiezione, Posti_Disponibili, Id_film, Id_sala) VALUES\n" +
                            "(?, ?, ?, ?, ?)");
            statement.setDate(1, p.getData());
            statement.setTime(2, p.getOrario());
            statement.setInt(3, p.getPosti());
            statement.setInt(4, p.film.getId());
            statement.setInt(5, p.sala.getId());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("Errore nell'acquisto");
            }
            con.close();
        }else{
            //popup di errore
            System.out.println("errore proiezione non inseribile in questa fascia oraria");
        }
    }


    public void acquistBiglietto(String email, String nome, String cognome, Proiezione proiezione, int n) throws SQLException {
        Connection con = ConPool.getConnection();

        PreparedStatement statement = con.prepareStatement("UPDATE proiezione SET posti_disponibili = ? WHERE id_proiezione = ?");
        statement.setInt(1, proiezione.getPosti() - n);
        statement.setInt(2, proiezione.getId());
        //manda email
        System.out.println(nome + " " + cognome + "\n" + email + "\n" + proiezione.getId() + " " + proiezione.getSala() + " " + proiezione.getData().toString());

        if(statement.executeUpdate() != 1){
            throw new SQLException("Errore nell'acquisto");
        }
        con.close();
    }

    public ArrayList<Proiezione> doRetrieveAll() {
        ArrayList<Proiezione> proiezioni = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Proiezione pro;

        try{
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM proiezione");

            while (resultSet.next()) {
                pro = new Proiezione();
                pro.setId(resultSet.getInt(1));
                pro.setData(resultSet.getDate(2));
                pro.setOrario(resultSet.getTime(3));
                pro.setPosti(resultSet.getInt(4));
                pro.film.setId(resultSet.getInt(5));
                pro.sala.setId(resultSet.getInt(6));
                proiezioni.add(pro);
            }
            con.close();
            return proiezioni;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public static boolean doDeleteById(int id) throws  SQLException{
        Connection con = ConPool.getConnection();

        String query = "DELETE FROM proiezione WHERE id = " + id;

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }

    public ArrayList<Proiezione> doRetrieveByIdFilm(int id) {
        ArrayList<Data_tier.Proiezione> proiezioni = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Data_tier.Proiezione pro;

        try{
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM proiezione WHERE id_film = '" + id + "'");

            while (resultSet.next()) {
                pro = new Data_tier.Proiezione();
                pro.setId(resultSet.getInt(1));
                pro.setData(resultSet.getDate(2));
                pro.setOrario(resultSet.getTime(3));
                pro.setPosti(resultSet.getInt(4));
                pro.setFilm((new FilmDAO()).doRetriveById(resultSet.getInt(5)));
                pro.setSala((new SalaDAO()).doRetrieveById(resultSet.getInt(6)));
                proiezioni.add(pro);
            }
            con.close();
            return proiezioni;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
