import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**
         * 1、注册数据库的驱动
         */
        //
        // 方法一
        //Driver driver = new com.mysql.jdbc.Driver();
        // 不用写了    com.mysql.jdbc.Driver()加载时已经注册了
        //DriverManager.registerDriver(driver);   // 注册数据库

        // 方法二   只需要加载类就可以了    static方法会自动注册
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 2、获取数据库连接
         */
        String url = "jdbc:mysql://localhost:3306/mall";   // mysql的url
        Connection connection = DriverManager.getConnection(url,"root","1117");

        /**
         * 3、关闭数据库
         */
        connection.close();
    }
}
