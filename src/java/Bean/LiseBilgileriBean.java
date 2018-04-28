/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "liseBilgileri")
@RequestScoped
public class LiseBilgileriBean {
    private int ID;
    private String Ad;
    private Date BaslangicTarih;
    private Date BitisTarih;
    private String Ilce;
    private String Sehir;
    private String Derecesi;
    private int CalisanId;

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

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }

    public String getSehir() {
        return Sehir;
    }

    public void setSehir(String Sehir) {
        this.Sehir = Sehir;
    }

    public String getDerecesi() {
        return Derecesi;
    }

    public void setDerecesi(String Derecesi) {
        this.Derecesi = Derecesi;
    }

    public int getCalisanId() {
        return CalisanId;
    }

    public void setCalisanId(int CalisanId) {
        this.CalisanId = CalisanId;
    }
}
