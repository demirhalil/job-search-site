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
import Bean.IlanBean;
import java.sql.Statement;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "uye")
@RequestScoped
@ViewScoped
@SessionScoped
public class UyeBean implements Serializable {

    private int ID;
    private String Ad;
    private String Soyad;
    private String Email;
    private String Sifre;
    private String DogumTarih;
    private String Cinsiyet;
    Connection baglanti;
    List<IlanBean> ilanList;
    List<IlanBean> ilanListofUser;
    private final Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private static int userId;

    public List<IlanBean> getIlanListofUser() {
        return ilanListofUser;
    }

    public void setIlanListofUser(List<IlanBean> ilanListofUser) {
        this.ilanListofUser = ilanListofUser;
    }

    public UyeBean() {

    }

    public List<IlanBean> getIlanList() {
        return ilanList;
    }

    public void setIlanList(List<IlanBean> ilanList) {
        this.ilanList = ilanList;
    }

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
    @ManagedProperty(value = "#{BasvuruBean}")
    private BasvuruBean basvuruBean;

    public BasvuruBean getBasvuruBean() {
        return basvuruBean;
    }

    public void setBasvuruBean(BasvuruBean basvuruBean) {
        this.basvuruBean = basvuruBean;
    }

    public String basvur(int id) {
        int idofUser = this.userId;
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Basvuru (IlanId,CalisanId) VALUES('" + id + "','" + idofUser + "')");
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "uyeIndex.xhtml?faces-redirect=true";
        } else {
            return "ilanDetay.xhtml?faces-redirect=true";
        }
    }

    public void basvuruSil(int id) {
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("delete from Basvuru where IlanId = '" + id + "' and CalisanId = '" + userId + "' ");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Login işlemi
    public String login() throws SQLException {
        boolean valid = LoginDAO.validate(Email, Sifre);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("Email", Email);
            userId = this.getUserId();
            return "/uyeIndex.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "/uyeLogin.xhtml?faces-redirect=true";
        }
    }

    //Giriş yapan kullanıcının ID sini tutar.
    public int getUserId() {
        UyeBean uye = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            baglanti = DbBean.getConnection();
            ps = baglanti.prepareStatement("SELECT *FROM Uye WHERE Email = '" + Email + "' and Sifre = '" + Sifre + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        }
        return id;
    }

    //Logout işlemi
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/index.xhtml?faces-redirect=true";
    }

    public List<IlanBean> getIlanofUser() throws SQLException {
        baglanti = DbBean.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = this.userId;
        ilanListofUser = new ArrayList<>();
        try {
            ps = baglanti.prepareStatement("select * from Ilan i inner join Basvuru b on b.IlanId = i.ID where b.CalisanId = '" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                IlanBean ilan = new IlanBean();
                ilan.setID(rs.getInt("ID"));
                ilan.setPozisyon(rs.getString("Pozisyon"));
                ilan.setSektor(rs.getString("Sektor"));
                ilan.setKategori(rs.getString("Kategori"));
                ilan.setFirmaAd(rs.getString("FirmaAd"));
                ilan.setCalismaSekli(rs.getString("CalismaSekli"));
                ilan.setCalismaYeri(rs.getString("CalismaYeri"));
                ilan.setDeneyim(rs.getString("Deneyim"));
                ilanListofUser.add(ilan);
            }
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        } finally {
            ps.close();
            baglanti.close();
        }
        return ilanListofUser;
    }

    public List<IlanBean> getIlanlar() throws SQLException {
        baglanti = DbBean.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ilanList = new ArrayList<>();
        try {
            ps = baglanti.prepareStatement("SELECT ID,Pozisyon,Sektor,FirmaAd,CalismaYeri,Kategori,SonBasvuruTarih,CalismaSekli FROM Ilan");
            rs = ps.executeQuery();
            while (rs.next()) {
                IlanBean ilan = new IlanBean();
                ilan.setID(rs.getInt("ID"));
                ilan.setPozisyon(rs.getString("Pozisyon"));
                ilan.setSektor(rs.getString("Sektor"));
                ilan.setFirmaAd(rs.getString("FirmaAd"));
                ilan.setCalismaYeri(rs.getString("CalismaYeri"));
                ilan.setKategori(rs.getString("Kategori"));
                ilan.setSonBasvuruTarih(rs.getString("SonBasvuruTarih"));
                ilan.setCalismaSekli(rs.getString("CalismaSekli"));
                ilanList.add(ilan);
            }
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        } finally {
            ps.close();
            baglanti.close();
        }
        return ilanList;
    }

    public String detay(int id) throws SQLException {
        PreparedStatement ps = null;
        IlanBean ilan = null;
        Statement stmt = null;
        try {
            baglanti = DbBean.getConnection();
            stmt = baglanti.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *FROM Ilan WHERE ID = " + (id));
            rs.next();
            ilan = new IlanBean();
            ilan.setID(rs.getInt("ID"));
            ilan.setPozisyon(rs.getString("Pozisyon"));
            ilan.setSektor(rs.getString("Sektor"));
            ilan.setKategori(rs.getString("Kategori"));
            ilan.setFirmaAd(rs.getString("FirmaAd"));
            ilan.setCalismaSekli(rs.getString("CalismaSekli"));
            ilan.setCalismaYeri(rs.getString("CalismaYeri"));
            ilan.setDeneyim(rs.getString("Deneyim"));
            ilan.setIlkYayınlamaTarih(rs.getString("IlkYayinlamaTarih"));
            ilan.setSonBasvuruTarih(rs.getString("SonBasvuruTarih"));
            ilan.setIsTanim(rs.getString("IsTanimi"));
            ilan.setArananNitelikler(rs.getString("ArananNitelikler"));
            sessionMap.put("i", ilan);
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        } finally {
            stmt.close();
            baglanti.close();
        }
        return "/ilanDetay.xhtml?faces-redirect=true";
    }

    public String kullanici() throws SQLException {
        PreparedStatement ps = null;
        UyeBean uye = null;
        Statement stmt = null;
        try {
            baglanti = DbBean.getConnection();
            stmt = baglanti.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *FROM Uye WHERE ID = '"+userId+"'");
            rs.next();
            uye = new UyeBean();
            uye.setAd(rs.getString("Ad"));
            uye.setSoyad(rs.getString("Soyad"));
            sessionMap.put("u", uye);
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        } finally {
            stmt.close();
            baglanti.close();
        }
        return "Hoşgeldiniz " + uye.Ad +" "+ uye.Soyad;
    }
}
