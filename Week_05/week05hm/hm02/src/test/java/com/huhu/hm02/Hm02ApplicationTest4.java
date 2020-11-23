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
 * 功能描述: JDBC 批处理
 *
 * @Author: 窦虎
 * @Date: 2020/11/23$ 23:06$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Hm02ApplicationTest4 {

    @Autowired
    private JdbcUtil jdbcUtil;

    // 基本批量操作
    @Test
    public void test1(){
        String sql1 = "insert into test (`name`, age) values('虎宝1', '1')";
        String sql2 = "insert into test (`name`, age) values('虎宝2', '2')";
        String sql3 = "insert into test (`name`, age) values('虎宝3', '3')";
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = jdbcUtil.getConnection();
            stmt = conn.createStatement();

            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);

            stmt.executeBatch();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.release(null, stmt, conn);
        }
    }

    // PreparedStatement batch
    @Test
    public void test2(){
        String sql = "insert into test (`name`, age) values(?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = jdbcUtil.getConnection();
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < 100; i++) {

                stmt.setString(1, "虎宝编号："+i);
                stmt.setInt(2, i);
                stmt.addBatch();
            }

            stmt.executeBatch();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.release(null, stmt, conn);
        }
    }

}
