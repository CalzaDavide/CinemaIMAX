package Data_tier;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DataChecker {

    public static boolean checkModeratoreData(String email) throws SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT id FROM moderatore WHERE LOWER(Email) = '" + email.toLowerCase() + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();

    }


    public static boolean checkFilmData(String titolo) throws  SQLException{

        Connection con = ConPool.getConnection();

        String query = "SELECT * FROM film WHERE Titolo = '" + titolo + "'";

        ResultSet rs = con.createStatement().executeQuery(query);

        return rs.next();
    }


    public static boolean checkProiezioneData(Proiezione p) throws  SQLException{

        ArrayList<Proiezione> proiezioni = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Proiezione pro;

        boolean check = false;
        try{
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
                pro.setFilm((new InterfaceMod()).recuperaFilmViaId(resultSet.getInt(5)));
                pro.setSala((new InterfaceMod()).recuperaSalaViaId(resultSet.getInt(6)));
                proiezioni.add(pro);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int numeroCheck = 0;
        if(proiezioni.get(0) == null) {
            //se la resultset non è positiva, ovvero non trova spettacoli in quella data e quella sala
            //siginifica che la sala in quel giorno è vuota di spettacoli, e automaticamente
            //può essere inserito una proiezione
            check = true;
        }else{

            //altrimenti controlla per ogni proiezione gia inserita
            for (Proiezione itVar : proiezioni)
            {

                float minutiDecimale = (float) p.getFilm().getDurata() /60;
                float minutiInteri = minutiDecimale*100;
                int minuti = (int) minutiInteri;

                int orarioTemp = orarioParser(p.getOrario().toString()) + minuti;

                float mD = (float) itVar.getFilm().getDurata() /60;
                float mI = mD*100;
                int min = (int) mI;
                //System.out.println("orario iniziale + durata film da inserire " +orarioTemp);
                //System.out.println("numcheck " + numeroCheck);
                if(orarioTemp < orarioParser(itVar.getOrario().toString())){
                    //se gli orari non danno problemi
                    //System.out.println("orario iniziale + durata film nel controllo " + orarioParser(itVar.getOrario().toString()));
                    if(numeroCheck < orarioParser(p.getOrario().toString())){
                        check = true;
                    }
                }
                numeroCheck = orarioParser(itVar.getOrario().toString()) + min;
            }
        }

        if(orarioParser(p.getOrario().toString()) > numeroCheck){
            check = true;
        }

        return check;
    }

    public static int orarioParser(String orario){
        //time.toString() --> xx:xx:xx
        int temp;
        String finale = String.valueOf(orario.charAt(0)+ "" + orario.charAt(1)+ "" +orario.charAt(3)+ "" +orario.charAt(4));
        temp = Integer.parseInt(finale);

        return temp;
    }


}
