package hu.petrik.adatbazisdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Adatbazis {
    /*
        Adatbázis neve
        Kapcsolattípus
        Portszám
        Hostname
        Adatbázisfiók felhasználóneve
        Adatbázisfiók jelszava
     */

    //jdbc = Java DataBase Connection
    private static final String url = "jdbc:mysql://localhost:3306/dolgozok";
    private static final String felhasznalonev = "root";
    private static final String jelszo = "";
    private Connection conn;

    public Adatbazis() throws SQLException {
        conn = DriverManager.getConnection(url, felhasznalonev, jelszo);
    }

    public List<Dolgozo> dolgozokListazasa() throws SQLException {
        String sql = "SELECT * FROM dolgozok";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        while (result.next()) {
            List<Dolgozo> dolgozoLista = new ArrayList<>();

            int id = result.getInt("id");
            int kor = result.getInt("kor");
            int fizetes = result.getInt("fizetes");
            String nev = result.getString("nev");
            String nem = result.getString("nem");

            Dolgozo dolgozo = new Dolgozo(id, nev, nem, kor, fizetes);

            dolgozoLista.add(dolgozo);
        }
        return dolgozokListazasa();
    }
}
