
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "basvuru")
@RequestScoped
public class BasvuruBean {
    private int ID;
    private int CalisanId;
    private int IlanId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCalisanId() {
        return CalisanId;
    }

    public void setCalisanId(int CalisanId) {
        this.CalisanId = CalisanId;
    }

    public int getIlanId() {
        return IlanId;
    }

    public void setIlanId(int IlanId) {
        this.IlanId = IlanId;
    }

   
}
