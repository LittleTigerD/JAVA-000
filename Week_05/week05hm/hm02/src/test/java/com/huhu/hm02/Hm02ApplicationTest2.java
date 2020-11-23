package com.huhu.hm02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 功能描述: JDBC 事务
 *
 * @Author: 窦虎
 * @Date: 2020/11/23$ 11:23$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Hm02ApplicationTest2 {

    @Autowired
    private JdbcUtil jdbcUtil;

    // 事务处理
    @Test
    public void txTest()
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = jdbcUtil.getConnection();
            stmt = conn.createStatement();
            // 不自动提交事务
            conn.setAutoCommit(false);
            stmt.executeUpdate("UPDATE test SET age='19' WHERE uid=1");

            int i = 0 / 0;
        }catch(Exception e){
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally{
            jdbcUtil.release(null, stmt, conn);
        }
    }
}
