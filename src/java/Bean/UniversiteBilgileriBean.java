
package Bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "universiteBilgileri")
@RequestScoped
public class UniversiteBilgileriBean {
    private int ID;
    private String UniversiteAd;
    private String FakulteAd;
    private String Bolum;
    private Date BaslangisTarih;
    private Date BitisTarih;
    private int CalisanId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUniversiteAd() {
        return UniversiteAd;
    }

    public void setUniversiteAd(String UniversiteAd) {
        this.UniversiteAd = UniversiteAd;
    }

    public String getFakulteAd() {
        return FakulteAd;
    }

    public void setFakulteAd(String FakulteAd) {
        this.FakulteAd = FakulteAd;
    }

    public String getBolum() {
        return Bolum;
    }

    public void setBolum(String Bolum) {
        this.Bolum = Bolum;
    }

    public Date getBaslangisTarih() {
        return BaslangisTarih;
    }

    public void setBaslangisTarih(Date BaslangisTarih) {
        this.BaslangisTarih = BaslangisTarih;
    }

    public Date getBitisTarih() {
        return BitisTarih;
    }

    public void setBitisTarih(Date BitisTarih) {
        this.BitisTarih = BitisTarih;
    }

    public int getCalisanId() {
        return CalisanId;
    }

    public void setCalisanId(int CalisanId) {
        this.CalisanId = CalisanId;
    }
}
