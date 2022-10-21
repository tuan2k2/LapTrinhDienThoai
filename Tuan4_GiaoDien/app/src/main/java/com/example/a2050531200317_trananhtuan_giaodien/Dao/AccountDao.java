package com.example.a2050531200317_trananhtuan_giaodien.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.a2050531200317_trananhtuan_giaodien.Model.Account;

public class AccountDao {
    public Account CheckAccount_317(String username, String password) {
        Connection connect = Connect.getConnection();
        String sql = "select * from tk where username = ? and pass = ?";
        try {
            PreparedStatement pr = connect.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            Account tkk = new Account();
            while (rs.next()) {
                tkk.setUsername(rs.getString("username"));
                tkk.setPassword(rs.getString("pass"));
                return tkk;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account getTaiKhoanByUser(String user) {
        Connection conn = Connect.getConnection();
        String sql = "select * from tk where username = ?";

        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            stm.setString(1,user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account taiKhoanDangNhap_317 = new Account();
                taiKhoanDangNhap_317.setUsername(rs.getString("Username"));
                taiKhoanDangNhap_317.setPassword(rs.getString("pass"));
                return taiKhoanDangNhap_317;
            }

        } catch (Exception  e) {
            e.printStackTrace();
        }
        return null;
    }

    public void taoTaiKhoan(Account tk){
        Connection connection = Connect.getConnection();
        String sql = "INSERT tk (username, pass) VALUES (?,?,?,?,?)";
        try {
            try (PreparedStatement pr = connection.prepareStatement(sql)) {
                pr.setString(1, tk.getUsername());
                pr.setString(2, tk.getPassword());
                int rs = pr.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
