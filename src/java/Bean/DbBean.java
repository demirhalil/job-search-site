package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbBean {

    Connection baglanti;

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            baglanti = DriverManager.getConnection("jdbc:sqlserver://;databaseName=IsBulmaPlatformu", "sa", "Sherlock221");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return baglanti;
    }
}
