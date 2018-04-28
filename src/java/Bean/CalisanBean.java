
package Bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "calisan")
@RequestScoped
public class CalisanBean {
    private int ID;
    private String Ad;
    private String Soyad;
    private String Email;
    private String KullaniciAd;
    private String Parola;
    private Date DogumTarih;
    private boolean AskerlikDurum;
    private boolean SigaraIciyorMu;

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

    public Date getDogumTarih() {
        return DogumTarih;
    }

    public void setDogumTarih(Date DogumTarih) {
        this.DogumTarih = DogumTarih;
    }

    public boolean isAskerlikDurum() {
        return AskerlikDurum;
    }

    public void setAskerlikDurum(boolean AskerlikDurum) {
        this.AskerlikDurum = AskerlikDurum;
    }

    public boolean isSigaraIciyorMu() {
        return SigaraIciyorMu;
    }

    public void setSigaraIciyorMu(boolean SigaraIciyorMu) {
        this.SigaraIciyorMu = SigaraIciyorMu;
    }
}
