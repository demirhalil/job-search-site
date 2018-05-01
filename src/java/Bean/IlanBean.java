
package Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ilan")
@RequestScoped
public class IlanBean {
    private int ID;
    private String Pozisyon;
    private String Sektor;
    private String Kategori;
    private String CalismaSekli;
    private String CalismaYeri;
    private String Deneyim;
    private Date IlkYayınlamaTarih;
    private Date SonBasvuruTarih;
    private String IsTanim;
    private String Aciklama;
    private String ArananNitelikler;
    private String FirmaAd;
    ArrayList ilanListesi;
    Connection baglanti;

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

    public Date getIlkYayınlamaTarih() {
        return IlkYayınlamaTarih;
    }

    public void setIlkYayınlamaTarih(Date IlkYayınlamaTarih) {
        this.IlkYayınlamaTarih = IlkYayınlamaTarih;
    }

    public Date getSonBasvuruTarih() {
        return SonBasvuruTarih;
    }

    public void setSonBasvuruTarih(Date SonBasvuruTarih) {
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
}
