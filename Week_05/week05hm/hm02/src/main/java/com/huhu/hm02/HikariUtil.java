package com.huhu.hm02;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/23$ 23:22$
 */
@Configuration
public class HikariUtil {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: 获取Hikari 数据源
     * @Param: []
     * @Return: com.zaxxer.hikari.HikariDataSource
     * @Author: 窦虎
     * @Date: 2020/11/23 23:43
     */
    public HikariDataSource getDataSource()
    {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:mysql://rm-8vb7s52v8a502z2i120800.mysql.zhangbei.rds.aliyuncs.com/m_pay");
        hikariDataSource.setUsername("m_pay");
        hikariDataSource.setPassword("bZYMBv5Q8zZgZGd0");
        return hikariDataSource;
    }

    /**
     * 功能描述: 释放连接
     * @Param: [rs, stmt, conn]
     * @Return: void
     * @Author: 窦虎
     * @Date: 2020/11/23 23:44
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
