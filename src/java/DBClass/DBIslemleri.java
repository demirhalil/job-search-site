package DBClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBIslemleri {

    private static DBIslemleri dbNesne = new DBIslemleri();

    private DBIslemleri() {

    }

    public static DBIslemleri getDbObject() {
        return dbNesne;
    }

    public Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection baglanti = DriverManager.getConnection("jdbc:sqlserver://;databaseName=IsBulmaPlatformu","sa","Sherlock221");
            return baglanti;
        } catch (Exception e) {
            return null;
        }
    }

    public int command(String sqlCumle) {
        int result = 0;
        try {
            Connection baglanti = dbNesne.connect();
            Statement sorgu = baglanti.createStatement();
            result = sorgu.executeUpdate(sqlCumle);
            sorgu.close();
            baglanti.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = -1;
        }
        return result;
    }

    public ResultSet getResultSet(String sqlCumle) {
        ResultSet rset = null;
        try {
            Connection baglanti = dbNesne.connect();
            Statement sorgu = baglanti.createStatement();
            rset = sorgu.executeQuery(sqlCumle);
        } catch (Exception e) {
            rset = null;
        }
        return rset;
    }
}
