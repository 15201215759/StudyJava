package com.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbcDemoUpdate01 {
    // TODO: 2021/01/27 测试更新数据
    public static void main(String[] args)  throws Exception{
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //设置链接信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url, user, password);
        // 获得发送sql的对象
        Statement statement = conn.createStatement();
        // 设置sql语句
        String sql="update  a set name='lisi' where id='2'";
        //执行sql并返回
        /*
        executeUpdate向数据库发送 insert update delete 语句，返回int 类型参数，代表影响记录行数
        execute(sql) 不区分语句 boolean
        true 表示sql是select语句		stmt.getResultset()
        false 表示sql 是非select语句  stmt.getUpdateCount()
         */
        //boolean execute = statement.execute(sql);
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        //查询新数据
        //发送sql，返回结果
        String sql1="select * from a";
        ResultSet resultSet = statement.executeQuery(sql1);
        //返回结果
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println(id+"======"+name);
        }
        //关闭资源
        resultSet.close();
        statement.close();
        conn.close();


    }
}
