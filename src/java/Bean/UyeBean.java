package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import javax.annotation.PostConstruct;

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

    List<UyeBean> sorguSonucu;

    public List<UyeBean> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<UyeBean> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }

    /*
    ***Bir metodun başına get koyduğumuz zaman JSF bunu nesne olarak algılar. Propertilerdeki mantık gibi.
    ***XHTML tarafında metodu çağırarak DataTable ı doldururuz.
    public List<UyeBean> getTablodakiKayitlar(){
        baglanti = DbBean.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        sorguSonucu = new ArrayList<>();
        try {
            preparedStatement = baglanti.prepareStatement("SELECT Ad,Soyad FROM Uye");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                UyeBean uye = new UyeBean();
                uye.setAd(rs.getString("Ad"));
                uye.setSoyad(rs.getString("Soyad"));
                sorguSonucu.add(uye);
            }
        } catch (Exception e) {
            System.err.println("Hata meydana geldi"+e);
        }
        return sorguSonucu;
    }
     */
    
    /*
    ***PostConstruct ile yaparak sayfa yüklendiği zaman verileri getirmiş oluruz.
    ***Burada daha önce tanımladığımız listeye verileri atar XHTML tarafındada datatable a listeyi döndürürüz.
    */
    public UyeBean(){
        
    }
    
    @PostConstruct
    public void kayitlar() {
        baglanti = DbBean.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        sorguSonucu = new ArrayList<>();
        try {
            preparedStatement = baglanti.prepareStatement("SELECT Ad,Soyad FROM Uye");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UyeBean uye = new UyeBean();
                uye.setAd(rs.getString("Ad"));
                uye.setSoyad(rs.getString("Soyad"));
                sorguSonucu.add(uye);
            }
        } catch (Exception e) {
            System.err.println("Hata meydana geldi" + e);
        }
    }
}
