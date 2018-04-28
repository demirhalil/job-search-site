/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "isveren")
@RequestScoped
public class IsVerenBean {
    private int ID;
    private String KullaniciAd;
    private String Parola;
    private String FirmaYetkiliAd;
    private String Soyad;
    private String Unvan;
    private String Email;
    private String FirmaAd;
    private String FirmaTel;
    private int PersonelSayisi;
    private String WebAdresi;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKullaniciAd() {
        return KullaniciAd;
    }

    public void setKullaniciAd(String KullaniciAd) {
        this.KullaniciAd = KullaniciAd;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String Parola) {
        this.Parola = Parola;
    }

    public String getFirmaYetkiliAd() {
        return FirmaYetkiliAd;
    }

    public void setFirmaYetkiliAd(String FirmaYetkiliAd) {
        this.FirmaYetkiliAd = FirmaYetkiliAd;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getUnvan() {
        return Unvan;
    }

    public void setUnvan(String Unvan) {
        this.Unvan = Unvan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String FirmaAd) {
        this.FirmaAd = FirmaAd;
    }

    public String getFirmaTel() {
        return FirmaTel;
    }

    public void setFirmaTel(String FirmaTel) {
        this.FirmaTel = FirmaTel;
    }

    public int getPersonelSayisi() {
        return PersonelSayisi;
    }

    public void setPersonelSayisi(int PersonelSayisi) {
        this.PersonelSayisi = PersonelSayisi;
    }

    public String getWebAdresi() {
        return WebAdresi;
    }

    public void setWebAdresi(String WebAdresi) {
        this.WebAdresi = WebAdresi;
    }
}
