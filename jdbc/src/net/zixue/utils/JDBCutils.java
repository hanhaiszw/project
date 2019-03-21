package net.zixue.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCutils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 获取初始化信息
    static {
        try {
            // 通过类加载器获取配置文件信息
            ClassLoader classLoader = JDBCutils.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        /**
         * 1、注册数据库的驱动
         */
        Connection connection = null;
        try {
            Class.forName(driver);
            /**
             * 2、获取数据库连接
             */
            //String url = "jdbc:mysql://localhost:3306/mall";   // mysql的url
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
