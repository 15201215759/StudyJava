package com.testjdbc;

import java.sql.*;

public class TestJdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //注册驱动类
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Class.forName("com.mysql.jdbc.Driver");
        //获取链接url
        String url="jdbc:mysql://localhost:3306/test";
        //获取用户名密码
        String user="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url, user, password);
        //发送sql语句对象
        Statement statement = conn.createStatement();
        //发送sql，返回结果
        String sql="select * from a";
        ResultSet resultSet = statement.executeQuery(sql);
        //返回结果
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println(id+"======"+name);
        }
        //释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }
}
