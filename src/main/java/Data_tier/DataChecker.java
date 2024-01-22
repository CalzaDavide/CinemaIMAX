package Data_tier;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DataChecker {

    public static boolean checkModeratoreData(String email) throws SQLException {

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();

    }


    public static boolean checkFilmData(String titolo) throws SQLException {

        Connection con = ConPool.getConnection();

        String query = "SELECT * FROM film WHERE Titolo = '" + titolo + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }


    public static boolean checkProiezioneData(Proiezione p) throws SQLException {

        ArrayList<Proiezione> proiezioni = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Proiezione pro;

        boolean check = false;
        try {
            Connection con = ConPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM proiezione WHERE id_sala = '" + p.getSala().getId() + "' AND " +
                    " Data_Proiezione = '" + p.getData() + "' ORDER BY Orario_Proiezione");
            //resultSet = statement.executeQuery("SELECT * FROM proiezione WHERE id_sala = 1 AND " +
            //        " Data_Proiezione = '22-11-11' ORDER BY Orario_Proiezione");

            while (resultSet.next()) {
                pro = new Proiezione();
                pro.setId(resultSet.getInt(1));
                pro.setData(resultSet.getDate(2));
                pro.setOrario(resultSet.getTime(3));
                pro.setPosti(resultSet.getInt(4));
                pro.setFilm((new FilmDAO()).doRetriveById(resultSet.getInt(5)));
                pro.setSala((new SalaDAO()).doRetrieveById(resultSet.getInt(6)));
                proiezioni.add(pro);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        int numeroCheck = 0;
        if (!resultSet.next()) {
            //se la resultset non è positiva, ovvero non trova spettacoli in quella data e quella sala
            //siginifica che la sala in quel giorno è vuota di spettacoli, e automaticamente
            //può essere inserito una proiezione
            check = true;

        } else {

            //altrimenti controlla per ogni proiezione gia inserita
            for (Proiezione itVar : proiezioni) {

                if (orarioParser(String.valueOf(p.getOrario())) + (p.getFilm().getDurata() / 60) * 100 < orarioParser(String.valueOf(itVar.getOrario()))) {
                    //se gli orari non danno problemi
                    if (numeroCheck < orarioParser(String.valueOf(p.getOrario()))) {
                        check = true;
                    }
                }
                numeroCheck = orarioParser(String.valueOf(itVar.getOrario()) + itVar.getFilm().getDurata() / 60) * 100;
            }
        }

        return check;
    }

    public static int orarioParser(String orario) {
        //time.toString() --> xx:xx:xx
        int temp;
        String finale = String.valueOf(orario.charAt(0) + orario.charAt(1) + orario.charAt(3) + orario.charAt(4));
        temp = parseInt(finale);
        return temp;
    }


}
