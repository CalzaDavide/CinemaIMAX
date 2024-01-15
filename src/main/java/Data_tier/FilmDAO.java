package Data_tier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmDAO {

    public static void addFilm() throws SQLException{

        Connection con = ConPool.getConnection();
        //TEST
        String insert = "INSERT INTO FILM(Titolo, Descrizione, Attori, Genere, Durata, Locandina) VALUES\n" +
                "('King Kong', 'la scimmia gigante', 'Dwayne Johnson', 'azione', 120, 'bimbumbam')";

        con.createStatement().executeUpdate(insert);
    }

    public static Film doRetriveById(int id) throws SQLException{

        Connection con = ConPool.getConnection() ;
        String query = "SELECT * FROM film WHERE Id = '" + id + "'";
        ResultSet rs = con.createStatement().executeQuery(query);
        if(rs.next()){
            Film film = new Film();
            film.setId(rs.getInt(1));
            film.setTitolo(rs.getString(2));
            film.setDescrizione(rs.getString(3));
            film.setAttori((ArrayList<String>) rs.getArray(4));//dubbio
            film.setGenere(rs.getString(5));
            film.setDurata(rs.getInt(6));
            film.setLocandina(rs.getString(7));
            return film;
        }
        return null;

    }

}
