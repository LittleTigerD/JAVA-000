package com.huhu.hm02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/22$ 23:30$
 */
@Configuration
public class JdbcUtil {

    private String url = "jdbc:mysql://rm-8vb7s52v8a502z2i120800.mysql.zhangbei.rds.aliyuncs.com/m_pay";
    private String username = "m_pay";
    private String password = "bZYMBv5Q8zZgZGd0";

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: 获取JDBC连接
     * @Param: []
     * @Return: java.sql.Connection
     * @Author: 窦虎
     * @Date: 2020/11/22 23:32
     */
    public Connection getConnection() throws Exception{
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 功能描述: 释放JDBC连接
     * @Param: [rs, stmt, conn]
     * @Return: void
     * @Author: 窦虎
     * @Date: 2020/11/22 23:32
     */
    public void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
