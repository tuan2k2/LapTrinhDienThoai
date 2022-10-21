package com.example.a2050531200317_trananhtuan_giaodien.Service;

import com.example.a2050531200317_trananhtuan_giaodien.Dao.AccountDao;
import com.example.a2050531200317_trananhtuan_giaodien.Model.Account;

public class AccountService {
    AccountDao taiKhoandao;
    public AccountService(){
        taiKhoandao = new AccountDao();
    }
    public Account CheckAccount_317(String username, String password){
        return taiKhoandao.CheckAccount_317(username,password);
    }
    public Account getTaiKhoanByUser(String user) {
        return taiKhoandao.getTaiKhoanByUser(user);
    }

    public void TaoTaiKhoan(Account taiKhoanDangNhap_324) {
        taiKhoandao.taoTaiKhoan(taiKhoanDangNhap_324);
    }
}
