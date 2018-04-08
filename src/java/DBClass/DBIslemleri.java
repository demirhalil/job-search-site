package DBClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBIslemleri {
    
    private Connection baglanti;

    private static DBIslemleri dbNesne = new DBIslemleri();

    private DBIslemleri() {

    }

    public static DBIslemleri getDbObject() {
        return dbNesne;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            baglanti = DriverManager.getConnection("jdbc:sqlserver://;databaseName=IsBulmaPlatformu", "sa", "Sherlock221");
        } catch (Exception e) {
            System.out.println(e);
        }
        return baglanti;
    }
}
