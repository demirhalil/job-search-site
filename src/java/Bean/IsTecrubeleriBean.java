/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "isTecrubeleri")
@RequestScoped
public class IsTecrubeleriBean {
    private int ID;
    private String FirmaAd;
    private String Departman;
    private String Pozisyon;
    private Date BaslangicTarih;
    private Date BitisTarih;
    private String Aciklama;
    private int CalisanId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String FirmaAd) {
        this.FirmaAd = FirmaAd;
    }

    public String getDepartman() {
        return Departman;
    }

    public void setDepartman(String Departman) {
        this.Departman = Departman;
    }

    public String getPozisyon() {
        return Pozisyon;
    }

    public void setPozisyon(String Pozisyon) {
        this.Pozisyon = Pozisyon;
    }

    public Date getBaslangicTarih() {
        return BaslangicTarih;
    }

    public void setBaslangicTarih(Date BaslangicTarih) {
        this.BaslangicTarih = BaslangicTarih;
    }

    public Date getBitisTarih() {
        return BitisTarih;
    }

    public void setBitisTarih(Date BitisTarih) {
        this.BitisTarih = BitisTarih;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String Aciklama) {
        this.Aciklama = Aciklama;
    }

    public int getCalisanId() {
        return CalisanId;
    }

    public void setCalisanId(int CalisanId) {
        this.CalisanId = CalisanId;
    }
}
