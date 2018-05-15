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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ilan")
@RequestScoped
public class IlanBean implements Serializable {

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


    public String getArananNitelikler() {
        return ArananNitelikler;
    }

    public void setArananNitelikler(String ArananNitelikler) {
        this.ArananNitelikler = ArananNitelikler;
    }

    @ManagedProperty(value = "#{IsverenBean}")
    private IsverenBean isverenBean;

    public IsverenBean getIsverenBean() {
        return isverenBean;
    }

    public void setIsverenBean(IsverenBean isverenBean) {
        this.isverenBean = isverenBean;
    }

    public String ilanKayit() {
        int result = 0;
        int id = IsverenBean.isverenId;
        try {
            baglanti = DbBean.getConnection();
            PreparedStatement stmt = baglanti.prepareStatement("INSERT INTO Ilan (Pozisyon,Sektor,Kategori,FirmaAd,CalismaSekli,CalismaYeri,Deneyim,IlkYayinlamaTarih,SonBasvuruTarih,IsTanimi,ArananNitelikler,IsverenId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, Pozisyon);
            stmt.setString(2, Sektor);
            stmt.setString(3, Kategori);
            stmt.setString(4, FirmaAd);
            stmt.setString(5, CalismaSekli);
            stmt.setString(6, CalismaYeri);
            stmt.setString(7, Deneyim);
            stmt.setString(8, IlkYayınlamaTarih);
            stmt.setString(9, SonBasvuruTarih);
            stmt.setString(10, IsTanim);
            stmt.setString(11, ArananNitelikler);
            stmt.setInt(12, IsverenId);
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
