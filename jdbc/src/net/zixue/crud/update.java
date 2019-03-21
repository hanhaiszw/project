package net.zixue.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        update();
    }

    public static void update() throws ClassNotFoundException, SQLException {
        /**
         * 1、注册数据库的驱动
         */
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 2、获取数据库连接
         */
        String url = "jdbc:mysql://localhost:3306/mall";   // mysql的url
        Connection connection = DriverManager.getConnection(url, "root", "1117");


        /**
         * 3、获取数据库操作的对象
         */
        Statement statement = connection.createStatement();

        // 插入
        // String sql = "insert into product values(null,'HTC',2300,'http',1)";

        // 删除
        //String sql = "delete from product where p_id=7";

        // 更新（修改）
        String sql = "update product set p_price=4000 where p_name='小米8'";

        // result是插入成功的行数
        int result = statement.executeUpdate(sql);

        System.out.println(result);

        // 关闭操作对象
        statement.close();
        /**
         * 4、关闭数据库
         */
        connection.close();
    }
}
