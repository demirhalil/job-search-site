
package Bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ilan")
@RequestScoped
public class IlanBean {
    private int ID;
    private String Kod;
    private String PozisyonAd;
    private int PersonelSayisi;
    private Date Tarih;
    private String Sehir;
    private String IsTanim;
    private String Departman;
    private String FirmaAd;
    private String ArananNitelikler;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKod() {
        return Kod;
    }

    public void setKod(String Kod) {
        this.Kod = Kod;
    }

    public String getPozisyonAd() {
        return PozisyonAd;
    }

    public void setPozisyonAd(String PozisyonAd) {
        this.PozisyonAd = PozisyonAd;
    }

    public int getPersonelSayisi() {
        return PersonelSayisi;
    }

    public void setPersonelSayisi(int PersonelSayisi) {
        this.PersonelSayisi = PersonelSayisi;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date Tarih) {
        this.Tarih = Tarih;
    }

    public String getSehir() {
        return Sehir;
    }

    public void setSehir(String Sehir) {
        this.Sehir = Sehir;
    }

    public String getIsTanim() {
        return IsTanim;
    }

    public void setIsTanim(String IsTanim) {
        this.IsTanim = IsTanim;
    }

    public String getDepartman() {
        return Departman;
    }

    public void setDepartman(String Departman) {
        this.Departman = Departman;
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String FirmaAd) {
        this.FirmaAd = FirmaAd;
    }

    public String getArananNitelikler() {
        return ArananNitelikler;
    }

    public void setArananNitelikler(String ArananNitelikler) {
        this.ArananNitelikler = ArananNitelikler;
    }
}
