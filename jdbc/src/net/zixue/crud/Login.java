package net.zixue.crud;

import java.sql.*;

public class Login {
    public void login(String account, String password) throws ClassNotFoundException, SQLException {
        /**
         * 1、注册数据库的驱动
         */
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 2、获取数据库连接
         */
        String url = "jdbc:mysql://localhost:3306/mall";   // mysql的url
        Connection connection = DriverManager.getConnection(url, "root", "1117");

// 3.获取操作数据库的对象
        Statement statement = connection.createStatement();

        String sql = "select * from user where account='" + account + "' and password='" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4. 取出数据
        if (resultSet.next()) {
            String nickname = resultSet.getString("nickname");
            System.out.println("登陆成功 nickname = "+nickname);
        }else{
            System.out.println("登陆失败");
        }

        resultSet.close();
        statement.close();

        connection.close();
    }

    public void login1(String account, String password) throws ClassNotFoundException, SQLException {
        /**
         * 1、注册数据库的驱动
         */
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 2、获取数据库连接
         */
        String url = "jdbc:mysql://localhost:3306/mall";   // mysql的url
        Connection connection = DriverManager.getConnection(url, "root", "1117");

        // 3.获取操作数据库的对象
       // Statement statement = connection.createStatement();

        // 防止SQL注入
        // 使用PrepareStatement    预编译声明
        // sql模版  ？为要传入的参数
        String sql = "select * from user where account=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 参数从1开始
        preparedStatement.setString(1,account);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 4. 取出数据
        if (resultSet.next()) {
            String nickname = resultSet.getString("nickname");
            System.out.println("登陆成功 nickname = "+nickname);
        }else{
            System.out.println("登陆失败");
        }

        resultSet.close();
        preparedStatement.close();

        connection.close();

    }
}
