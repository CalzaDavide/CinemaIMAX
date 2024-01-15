package Data_tier;

import java.sql.*;
import java.util.ArrayList;

public class FilmDAO {

    public void addFilm(Film f) throws SQLException{

        Connection con = ConPool.getConnection();
        //TEST
        //String insert = "INSERT INTO FILM(Titolo, Descrizione, Attori, Genere, Durata, Locandina) VALUES\n" +
        //        "('King Kong', 'la scimmia gigante', 'Dwayne Johnson, Morgan Freeman', 'azione', 120, 'bimbumbam')";

        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO FILM(Titolo, Descrizione, Attori, Genere, Durata, Locandina) VALUES\n" +
                "(?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, f.getTitolo());
        statement.setString(2, f.getDescrizione());
        statement.setString(3, f.getAttori());
        statement.setString(4, f.getGenere());
        statement.setInt(5, f.getDurata());
        statement.setString(6, f.getLocandina());

        if(statement.executeUpdate() != 1){
            throw new SQLException("Errore nell'acquisto");
        }
        con.close();
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
            film.setAttori(rs.getString(4));
            film.setGenere(rs.getString(5));
            film.setDurata(rs.getInt(6));
            film.setLocandina(rs.getString(7));
            return film;
        }
        return null;
    }

    public ArrayList<Film> doRetrieveAll() {
        ArrayList<Film> films = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Film f;

        try{
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM film");

            while (resultSet.next()) {
                f = new Film();
                f.setId(resultSet.getInt(1));
                f.setTitolo(resultSet.getString(2));
                f.setDescrizione(resultSet.getString(3));
                f.setGenere(resultSet.getString(4));
                f.setDurata(Integer.parseInt(resultSet.getString(5)));
                f.setLocandina(resultSet.getString(6));
                films.add(f);
            }
            con.close();
            return films;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


}
