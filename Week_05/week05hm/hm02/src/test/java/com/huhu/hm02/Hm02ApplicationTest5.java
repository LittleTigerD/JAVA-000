package com.huhu.hm02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;

/**
 * 功能描述: Hikari 连接池实现crud
 *
 * @Author: 窦虎
 * @Date: 2020/11/23$ 23:17$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Hm02ApplicationTest5 {

    @Autowired
    private HikariUtil dataSource;

    @Test
    public void add()
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO test (`name`, age) VALUES ('虎宝','18')");
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.createStatement();
            stmt.executeQuery("select * from test WHERE uid = 1");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("------------------");
                System.out.println(rs.getObject("uid"));
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("age"));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE test SET age='19' WHERE uid=1");
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }


    @Test
    public void testDelete(){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM test WHERE uid=1");
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }

    @Test
    public void txTest()
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
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
            dataSource.release(null, stmt, conn);
        }
    }

    @Test
    public void preAdd() {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.prepareStatement("INSERT INTO test (`name`, age) VALUES (?,?)");
            stmt.setString(1, "虎宝宝");
            stmt.setInt(2, 100);
            stmt.execute();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }

    // 基本批量操作
    @Test
    public void test1(){
        String sql1 = "insert into test (`name`, age) values('虎宝1', '1')";
        String sql2 = "insert into test (`name`, age) values('虎宝2', '2')";
        String sql3 = "insert into test (`name`, age) values('虎宝3', '3')";
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
            stmt = conn.createStatement();

            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);

            stmt.executeBatch();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            dataSource.release(null, stmt, conn);
        }
    }

    // PreparedStatement batch
    @Test
    public void test2(){
        String sql = "insert into test (`name`, age) values(?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = dataSource.getDataSource().getConnection();
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
            dataSource.release(null, stmt, conn);
        }
    }

}
