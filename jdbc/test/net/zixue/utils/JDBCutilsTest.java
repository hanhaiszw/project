package net.zixue.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCutilsTest {
    @Test
    public void JDBCTest() throws Exception {
        Connection connection = JDBCutils.getConnection();
        String sql = "select nickname from user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nickname = resultSet.getString("nickname");
            System.out.println(nickname);
        }
        JDBCutils.release(connection, preparedStatement, resultSet);
    }

}