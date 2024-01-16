package Data_tier;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
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

    public Sala doRetrieveById(int id) {
        try{
            Connection con = ConPool.getConnection();

            PreparedStatement statement = con.prepareStatement("SELECT * FROM sala WHERE Id_Sala = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Sala s = null;
            if(rs.next()) {
                s = new Sala();

                s.setId(rs.getInt(1));

                s.setMaxPosti(rs.getInt(2));
            }

            con.close();

            return s;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}

