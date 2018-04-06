package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@ManagedBean(name = "emp")
@SessionScoped
public class EmployeeBean {

    private String Ad;
    private String Soyad;
    private String KullaniciAd;
    private String Email;
    private String Parola;

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

    public Integer kayitEkle() {
        int sonuc = 0;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1; databaseName=IsBulmaPlatformu", "sa", "Sherlock221");
            Statement stmt = con.createStatement();
            sonuc = stmt.executeUpdate("INSERT INTO Eleman(Ad,Soyad,KullaniciAd,Email,Parola) VALUES("+this.Ad+","+this.Soyad+","+this.KullaniciAd+","+this.Email+","+this.Parola+")");
            stmt.close();
            con.close();
            System.out.println(sonuc + "Kayıt eklendi");
        } catch (Exception e) {
            sonuc = -1;
            System.out.println(sonuc + "Kayıt eklenemedi");
            System.out.println(e);
        }
        return sonuc;
    }

    public String submit() {
        if (this.kayitEkle() > 0) {
            return "index";
        } else {
            return "EmployeeSignUp";
        }
    }
}
