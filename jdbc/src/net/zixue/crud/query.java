package net.zixue.crud;

import net.zixue.utils.JDBCutils;

import java.math.BigDecimal;
import java.sql.*;

public class query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        query();
    }

    public static void query() throws ClassNotFoundException, SQLException {
        // 注册方法一
        //Driver driver = new com.mysql.jdbc.Driver();
        //  com.mysql.jdbc.Driver()有static方法 类加载时会执行注册驱动操作
        //DriverManager.registerDriver(driver);
        Connection connection = JDBCutils.getConnection();


        // 3.获取操作数据库的对象
        Statement statement = connection.createStatement();

        String sql = "select * from product";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4. 遍历结果集 取出数据
        while (resultSet.next()) {
            String name = resultSet.getString("p_name");
            BigDecimal price = resultSet.getBigDecimal("p_price");
            System.out.println("商品名称：" + name + "商品价格：" + price);
        }

        JDBCutils.release(connection, statement, resultSet);
    }




}
