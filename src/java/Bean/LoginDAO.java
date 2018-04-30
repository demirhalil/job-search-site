/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginDAO {

    public static boolean validate(String user, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbBean.getConnection();
            ps = con.prepareStatement("Select KullaniciAd, Parola from Calisan where KullaniciAd = ? and Parola = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            con.close();
        }
        return false;
    }
}
