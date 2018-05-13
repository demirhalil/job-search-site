package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ilan")
@RequestScoped
public class IlanBean implements Serializable{

    private int ID;
    private String Pozisyon;
    private String Sektor;
    private String Kategori;
    private String CalismaSekli;
    private String CalismaYeri;
    private String Deneyim;
    private String IlkYayınlamaTarih;
    private String SonBasvuruTarih;
    private String IsTanim;
    private String Aciklama;
    private String ArananNitelikler;
    private String FirmaAd;
    private int IsverenId;

    public int getIsverenId() {
        return IsverenId;
    }

    public void setIsverenId(int IsverenId) {
        this.IsverenId = IsverenId;
    }
    Connection baglanti;
    private final Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public IlanBean() {
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String FirmaAd) {
        this.FirmaAd = FirmaAd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPozisyon() {
        return Pozisyon;
    }

    public void setPozisyon(String Pozisyon) {
        this.Pozisyon = Pozisyon;
    }

    public String getSektor() {
        return Sektor;
    }

    public void setSektor(String Sektor) {
        this.Sektor = Sektor;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String Kategori) {
        this.Kategori = Kategori;
    }

    public String getCalismaSekli() {
        return CalismaSekli;
    }

    public void setCalismaSekli(String CalismaSekli) {
        this.CalismaSekli = CalismaSekli;
    }

    public String getCalismaYeri() {
        return CalismaYeri;
    }

    public void setCalismaYeri(String CalismaYeri) {
        this.CalismaYeri = CalismaYeri;
    }

    public String getDeneyim() {
        return Deneyim;
    }

    public void setDeneyim(String Deneyim) {
        this.Deneyim = Deneyim;
    }

    public String getIlkYayınlamaTarih() {
        return IlkYayınlamaTarih;
    }

    public void setIlkYayınlamaTarih(String IlkYayınlamaTarih) {
        this.IlkYayınlamaTarih = IlkYayınlamaTarih;
    }

    public String getSonBasvuruTarih() {
        return SonBasvuruTarih;
    }

    public void setSonBasvuruTarih(String SonBasvuruTarih) {
        this.SonBasvuruTarih = SonBasvuruTarih;
    }

    public String getIsTanim() {
        return IsTanim;
    }

    public void setIsTanim(String IsTanim) {
        this.IsTanim = IsTanim;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String Aciklama) {
        this.Aciklama = Aciklama;
    }

    public String getArananNitelikler() {
        return ArananNitelikler;
    }

    public void setArananNitelikler(String ArananNitelikler) {
        this.ArananNitelikler = ArananNitelikler;
    }

    public String ilanKayit() {
        int result = 0;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Ilan (Pozisyon,Sektor,Kategori,FirmaAd,CalismaSekli,CalismaYeri,Deneyim,IlkYayinlamaTarih,SonBasvuruTarih,IsTanimi,Aciklama,ArananNitelikler) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, Pozisyon);
            stmt.setString(2, Sektor);
            stmt.setString(3, Kategori);
            stmt.setString(4, FirmaAd);
            stmt.setString(5, FirmaAd);
            stmt.setString(6, CalismaSekli);
            stmt.setString(7, CalismaYeri);
            stmt.setString(8, Deneyim);
            stmt.setString(9, IlkYayınlamaTarih);
            stmt.setString(10, IsTanim);
            stmt.setString(11, ArananNitelikler);
            stmt.setString(12, Aciklama);
            result = stmt.executeUpdate();
            baglanti.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (result > 0) {
            return "/isverenIndex.xhtml?faces-redirect=true";
        } else {
            return "/ilanEkle.xhtml?faces-redirect=true";
        }
    }

    public void ilanSil(int id) {
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("delete from Ilan where ID = " + id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
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
            ilan.setAciklama(rs.getString("Aciklama"));
            ilan.setArananNitelikler(rs.getString("ArananNitelikler"));
            sessionMap.put("i", ilan);
        } catch (SQLException e) {
            System.err.println("Hata meydana geldi" + e);
        } finally {
            stmt.close();
            baglanti.close();
        }
        return "/ilanBilgiler.xhtml?faces-redirect=true";
    }
}
