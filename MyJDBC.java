package org.example.servlet;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author TNT-df
 * @Date 2021/1/31 23:01
 * @Description
 */
public class MyJDBC {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Properties properties = null;

    public void init() throws IOException, SQLException {
        getProperties();
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl(properties.getProperty("url"));
        ds.setUser(properties.getProperty("username"));
        ds.setPassword(properties.getProperty("password"));
        connection = ds.getConnection();
    }

    public void getProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileReader(new File("F:\\java\\ss_test\\src\\main\\java\\org\\example\\servlet\\my.properties")));
    }

    public boolean Query(String username, String pw) throws SQLException {
        String sql = "select password from user " + " where username = ?";
        statement = connection.prepareStatement(sql);
        statement.setNString(1, username);
        resultSet = statement.executeQuery();
        String ps = "";
        while (resultSet.next()) {
            ps = resultSet.getInt("password") + "";
        }
        if (ps.equals(pw)) return true;
        else return false;
    }

    public void close() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
