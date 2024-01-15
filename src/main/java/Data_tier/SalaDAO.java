package Data_tier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalaDAO {
    public static Sala doRetriveById(String sala) {
        return null;
    }

    public ArrayList<Sala> doRetrieveAll() {
        ArrayList<Sala> sala = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Sala s;

        try{
            Connection con = ConPool.getConnection();

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM sala");

            while (resultSet.next()) {

                s = new Sala();

                s.setId(resultSet.getInt(1));

                s.setMaxPosti(resultSet.getInt(2));

                sala.add(s);
            }

            con.close();

            return sala;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}

