package com.testjdbc;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.sql.*;

public class TestJdbcDemo03   {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url, user, password);
//        String sql="update a set name='wangwu' where id='2'";
        String sql="select * from a";
        Statement statement = conn.createStatement();
        boolean flag = statement.execute(sql);
        ResultSet set= null;
        if (flag==true) {
            set=statement.getResultSet();
            while (set.next()){
                String id = set.getString("id");
                String name = set.getString("name");
                System.out.println(id+"======"+name);
            }
        }else {
            int updateCount = statement.getUpdateCount();
            System.out.println(updateCount);
        }
        if (set!=null){
            set.close();
        }
        statement.close();
        conn.close();
    }
}
