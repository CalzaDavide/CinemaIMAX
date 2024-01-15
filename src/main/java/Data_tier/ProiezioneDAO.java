package Data_tier;

import java.sql.Connection;
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
}
