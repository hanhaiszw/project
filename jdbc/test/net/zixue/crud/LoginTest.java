package net.zixue.crud;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() throws SQLException, ClassNotFoundException {
        Login login = new Login();
        // login.login("xiaoming", "123");  //成功
        // login.login("xiaoming", "1234");  // 失败

        // sql注入   依然能够登陆成功
        //login.login("a' or 'a'='a","a' or 'a'='a");


        // 防止sql注入后
        //login.login1("a' or 'a'='a","a' or 'a'='a");
        login.login1("xiaoming", "123");  //成功

    }
}