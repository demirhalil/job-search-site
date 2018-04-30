package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "calisan")
@RequestScoped
public class CalisanBean implements Serializable {

    private int ID;
    private String Ad;
    private String Soyad;
    private String Email;
    private String KullaniciAd;
    private String Parola;
    private Date DogumTarih;
    private boolean AskerlikDurum;
    private boolean SigaraIciyorMu;
    Connection baglanti;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public Date getDogumTarih() {
        return DogumTarih;
    }

    public void setDogumTarih(Date DogumTarih) {
        this.DogumTarih = DogumTarih;
    }

    public boolean isAskerlikDurum() {
        return AskerlikDurum;
    }

    public void setAskerlikDurum(boolean AskerlikDurum) {
        this.AskerlikDurum = AskerlikDurum;
    }

    public boolean isSigaraIciyorMu() {
        return SigaraIciyorMu;
    }

    public void setSigaraIciyorMu(boolean SigaraIciyorMu) {
        this.SigaraIciyorMu = SigaraIciyorMu;
    }

    //Üye kayıt işlemi
    public String uyeKayit() {
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Calisan(Ad,Soyad,KullaniciAd,Email,Parola) VALUES(?,?,?,?,?)");
            stmt.setString(1, Ad);
            stmt.setString(2, Soyad);
            stmt.setString(3, KullaniciAd);
            stmt.setString(4, Email);
            stmt.setString(5, Parola);
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "login.xhtml?faces-redirect=true";
        } else {
            return "EmployeeSignUp.xhtml?faces-redirect=true";
        }
    }

    //Login işlemi
    public String login() throws SQLException {
        boolean valid = LoginDAO.validate(KullaniciAd, Parola);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", KullaniciAd);
            return "Calisan";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }

}
