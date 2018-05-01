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

@ManagedBean(name = "uye")
@RequestScoped
public class UyeBean implements Serializable {

    private int ID;
    private String Ad;
    private String Soyad;
    private String Email;
    private String Sifre;
    private String DogumTarih;
    private String Cinsiyet;
    Connection baglanti;
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public String getDogumTarih() {
        return DogumTarih;
    }

    public void setDogumTarih(String DogumTarih) {
        this.DogumTarih = DogumTarih;
    }

    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String Cinsiyet) {
        this.Cinsiyet = Cinsiyet;
    }

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

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }
    //Üye kayıt işlemi
    public String uyeKayit() {
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Uye (Ad,Soyad,Email,Sifre,DogumTarih,Cinsiyet) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, Ad);
            stmt.setString(2, Soyad);
            stmt.setString(3, Email);
            stmt.setString(4, Sifre);
            stmt.setString(5, DogumTarih);
            stmt.setString(6, Cinsiyet);
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "uyeLogin.xhtml?faces-redirect=true";
        } else {
            return "uyeKayit.xhtml?faces-redirect=true";
        }
    }

    //Login işlemi
    public String login() throws SQLException {
        boolean valid = LoginDAO.validate(Email, Sifre);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("Email", Email);
            return "uyeIndex";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "uyeLogin.xhtml";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }

}
