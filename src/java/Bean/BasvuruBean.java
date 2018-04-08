
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "basvuru")
@RequestScoped
public class BasvuruBean {
    private int ID;
    private int ElemanId;
    private int IlanId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getElemanId() {
        return ElemanId;
    }

    public void setElemanId(int ElemanId) {
        this.ElemanId = ElemanId;
    }

    public int getIlanId() {
        return IlanId;
    }

    public void setIlanId(int IlanId) {
        this.IlanId = IlanId;
    }
}
