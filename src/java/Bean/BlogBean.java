/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "blog")
@RequestScoped
public class BlogBean {
    private int ID;
    private String Baslik;
    private String Detay;
    private int AdminId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String Baslik) {
        this.Baslik = Baslik;
    }

    public String getDetay() {
        return Detay;
    }

    public void setDetay(String Detay) {
        this.Detay = Detay;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }
}
