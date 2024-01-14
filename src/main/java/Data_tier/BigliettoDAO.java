package Data_tier;

import java.sql.Connection;
import java.sql.SQLException;

public class BigliettoDAO {

    public static void newBiglietto() throws SQLException{

        Connection con = ConPool.getConnection();

        //id proiezione preso da jsp
        //id sala preso da jsp
        //numero posti preso da proiezione

        //test
        String insert = "INSERT INTO BIGLIETTO(Nome, Cognome, Email, NumeroPosto, id_proiezione, id_film) VALUES\n" +
                "('Silvio', 'Berlusconi', 'silvio@berlusconi.it', 1,1,1);";

        //chiamata a proiezione per diminuire posti disponibili
        //chiamata per prendere l'id della sala (ovvero numero della sala)
        con.createStatement().executeUpdate(insert);
    }

    public static void cancellaBigliettiProiezione(int id_proiezione) throws  SQLException{

    }
}
