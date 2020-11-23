package com.huhu.hm02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 功能描述: JDBC PreparedStatement
 *
 * @Author: 窦虎
 * @Date: 2020/11/23$ 23:03$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Hm02ApplicationTest3 {

    @Autowired
    private JdbcUtil jdbcUtil;

    @Test
    public void preAdd() {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = jdbcUtil.getConnection();
            stmt = conn.prepareStatement("INSERT INTO test (`name`, age) VALUES (?,?)");
            stmt.setString(1, "虎宝宝");
            stmt.setInt(2, 100);
            stmt.execute();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            jdbcUtil.release(null, stmt, conn);
        }
    }
}
