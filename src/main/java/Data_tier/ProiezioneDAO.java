package Data_tier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
