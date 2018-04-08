
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "admin")
@RequestScoped
public class AdminBean {
    private int ID;
    private String Ad;
    private String Soyad;
    private String KullaniciAd;
    private String Parola;
}
