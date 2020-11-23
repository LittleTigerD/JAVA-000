package com.huhu.hm02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/**
 * 功能描述: JDBC CRUD
 * @Param:
 * @Return:
 * @Author: 窦虎
 * @Date: 2020/11/23 23:18
 */
public class Hm02ApplicationTest1 {

	@Autowired
	private JdbcUtil jdbcUtil;

	@Test
	public void testAdd() {

		Connection conn = null;
		Statement stmt = null;
		try{
			conn = jdbcUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO test (`name`, age) VALUES ('虎宝','18')");
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			jdbcUtil.release(null, stmt, conn);
		}

	}

	@Test
	public void testQuery(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = jdbcUtil.getConnection();
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
			jdbcUtil.release(null, stmt, conn);
		}
	}

	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = jdbcUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE test SET age='19' WHERE uid=1");
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			jdbcUtil.release(null, stmt, conn);
		}
	}


	@Test
	public void testDelete(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = jdbcUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM test WHERE uid=1");
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			jdbcUtil.release(null, stmt, conn);
		}
	}

}
