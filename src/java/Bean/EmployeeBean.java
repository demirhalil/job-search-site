package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "emp")
@SessionScoped
public class EmployeeBean {
    private int Id;
    private String Ad;
    private String Soyad;
    private String KullaniciAd;
    private String Email;
    private String Parola;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getKullaniciAd() {
        return KullaniciAd;
    }

    public void setKullaniciAd(String KullaniciAd) {
        this.KullaniciAd = KullaniciAd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String Parola) {
        this.Parola = Parola;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String kayitEkle() throws ClassNotFoundException {
        int sonuc = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection baglanti = DriverManager.getConnection("jdbc:sqlserver://;databaseName=IsBulmaPlatformu", "sa", "Sherlock221");
            PreparedStatement ps = null;
            if (baglanti != null) {
                ps = baglanti.prepareStatement("INSERT INTO Eleman(Ad,Soyad,Email,KullaniciAd,Parola) VALUES(?,?,?,?,?)");
                ps.setString(1, Ad);
                ps.setString(2, Soyad);
                ps.setString(3, Email);
                ps.setString(4, KullaniciAd);
                ps.setString(5, Parola);
                sonuc = ps.executeUpdate();
                baglanti.close();
                ps.close();
            }
        } catch (SQLException e) {
            return e.toString();
        }
        if (sonuc > 0) {
            return "index";
        } else {
            return "EmployeeSignUp";
        }

    }
}
