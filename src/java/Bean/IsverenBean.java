package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "isveren")
@RequestScoped
public class IsverenBean {

    private int ID;
    private String FirmaYetkiliAd;
    private String Soyad;
    private String Unvan;
    private String Email;
    private String Sifre;
    private String FirmaAd;
    private String FirmaTel;
    private String PersonelSayisi;
    private String WebAdresi;
    Connection baglanti ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
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

    public String getPersonelSayisi() {
        return PersonelSayisi;
    }

    public void setPersonelSayisi(String PersonelSayisi) {
        this.PersonelSayisi = PersonelSayisi;
    }

    public String getWebAdresi() {
        return WebAdresi;
    }

    public void setWebAdresi(String WebAdresi) {
        this.WebAdresi = WebAdresi;
    }

    public String isverenKayit() {
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO IsVeren (FirmaYetkiliAd,Soyad,Unvan,Email,Sifre,FirmaAd,FirmaTel,PersonelSayisi,WebAdresi) VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, FirmaYetkiliAd);
            stmt.setString(2, Soyad);
            stmt.setString(3, Unvan);
            stmt.setString(4, Email);
            stmt.setString(5, Sifre);
            stmt.setString(6, FirmaAd);
            stmt.setString(7, FirmaTel);
            stmt.setString(8, PersonelSayisi);
            stmt.setString(9, WebAdresi);
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "isverenLogin.xhtml?faces-redirect=true";
        } else {
            return "isverenKayit.xhtml?faces-redirect=true";
        }
    }
}
