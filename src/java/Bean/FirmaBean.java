package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "firma")
@RequestScoped
public class FirmaBean {

    private Integer ID;
    private String KullaniciAd;
    private String Parola;
    private String FirmaYetkiliAd;
    private String Soyad;
    private String Unvan;
    private String Email;
    private String FirmaAd;
    private String FirmaTel;
    private Integer PersonelSayisi;
    private String WebAdresi;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getKullaniciAd() {
        return KullaniciAd;
    }

    public void setKullaniciAd(String KullaniciAd) {
        this.KullaniciAd = KullaniciAd;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String Parola) {
        this.Parola = Parola;
    }

    public String getFirmaYetkiliAd() {
        return FirmaYetkiliAd;
    }

    public void setFirmaYetkiliAd(String FirmaYetkiliAd) {
        this.FirmaYetkiliAd = FirmaYetkiliAd;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getUnvan() {
        return Unvan;
    }

    public void setUnvan(String Unvan) {
        this.Unvan = Unvan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String FirmaAd) {
        this.FirmaAd = FirmaAd;
    }

    public String getFirmaTel() {
        return FirmaTel;
    }

    public void setFirmaTel(String FirmaTel) {
        this.FirmaTel = FirmaTel;
    }

    public Integer getPersonelSayisi() {
        return PersonelSayisi;
    }

    public void setPersonelSayisi(Integer PersonelSayisi) {
        this.PersonelSayisi = PersonelSayisi;
    }

    public String getWebAdresi() {
        return WebAdresi;
    }

    public void setWebAdresi(String WebAdresi) {
        this.WebAdresi = WebAdresi;
    }

    public String kayitEkle() throws ClassNotFoundException {
        int sonuc = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection baglanti = DriverManager.getConnection("jdbc:sqlserver://;databaseName=IsBulmaPlatformu", "sa", "Sherlock221");
            PreparedStatement ps = null;
            if (baglanti != null) {
                ps = baglanti.prepareStatement("INSERT INTO Firma(KullaniciAdi,Parola,FirmaYetkiliAd,Soyad,Unvan,Email,FirmaAd,FirmaTel,PersonelSayisi,WebAdresi) VALUES(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, KullaniciAd);
                ps.setString(2, Parola);
                ps.setString(3, FirmaYetkiliAd);
                ps.setString(4, Soyad);
                ps.setString(5, Unvan);
                ps.setString(6, Email);
                ps.setString(7, FirmaAd);
                ps.setString(8, FirmaTel);
                ps.setInt(9, PersonelSayisi);
                ps.setString(10, WebAdresi);
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
            return "firmaKayit";
        }
    }
}
