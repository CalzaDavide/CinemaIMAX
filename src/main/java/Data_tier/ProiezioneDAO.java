package Data_tier;

import java.sql.*;
import java.util.ArrayList;

public class ProiezioneDAO {

    public Proiezione doRetriveById(int id) throws SQLException {
        Connection con = ConPool.getConnection();
        String query = "SELECT * FROM proiezione WHERE Id = " + id;
        ResultSet rs = con.createStatement().executeQuery(query);
        if(rs.next()){
            Proiezione proiezione = new Proiezione();
            //impostare valori
            return proiezione;
        }
        return null;
    }


    public void addProiezione(Proiezione p) throws SQLException {

        Connection con = ConPool.getConnection();

        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO PROIEZIONE(Data_Proiezione, Orario_Proiezione, Posti_Disponibili, Id_film, Id_sala) VALUES\n" +
                        "(?, ?, ?, ?, ?)");
        statement.setDate(1, p.getData_ora());
        statement.setInt(2,p.getPosti());
        statement.setInt(3,p.film.getId());
        statement.setInt(4,p.sala.getId());

        if(statement.executeUpdate() != 1){
            throw new SQLException("Errore nell'acquisto");
        }
        con.close();
    }


    public void acquistBiglietto(String email, String nome, String cognome, Proiezione proiezione, int n) throws SQLException {
        Connection con = ConPool.getConnection();

        PreparedStatement statement = con.prepareStatement("UPDATE proiezione SET posti_disponibili = ? WHERE id_proiezione = ?");
        statement.setInt(1, proiezione.getPosti() - n);
        statement.setInt(2, proiezione.getId());
        //manda email
        System.out.println(nome + " " + cognome + "\n" + email + "\n" + proiezione.getId() + " " + proiezione.getSala() + " " + proiezione.getData_ora().toString());

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
                //pro.setData_ora(resultSet.getString(2));
                //DA GESTIRE
                //pro.setData_ora(resultSet.getString(2));
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


}
