
package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "basvuru")
@RequestScoped
public class BasvuruBean implements Serializable{
    private int ID;
    private int IlanId;
    private int CalisanId;
    Connection baglanti;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIlanId() {
        return IlanId;
    }

    public void setIlanId(int IlanId) {
        this.IlanId = IlanId;
    }

    public int getCalisanId() {
        return CalisanId;
    }

    public void setCalisanId(int CalisanId) {
        this.CalisanId = CalisanId;
    }
 
}
