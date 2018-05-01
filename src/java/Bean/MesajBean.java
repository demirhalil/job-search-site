package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@ManagedBean(name = "mesaj")
@RequestScoped
public class MesajBean {

    private int ID;
    private String Ad;
    private String Soyad;
    private String Telefon;
    private String Email;
    private String Mesaj;
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

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMesaj() {
        return Mesaj;
    }

    public void setMesaj(String Mesaj) {
        this.Mesaj = Mesaj;
    }

    public String mesajGonder() {
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Mesaj(Ad,Soyad,Telefon,Email,Mesaj) VALUES(?,?,?,?,?)");
            stmt.setString(1, Ad);
            stmt.setString(2, Soyad);
            stmt.setString(3, Telefon);
            stmt.setString(4, Email);
            stmt.setString(5, Mesaj);
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "index.xhtml?faces-redirect=true";
        } else {
            return "iletisim.xhtml?faces-redirect=true";
        }
    }
}
