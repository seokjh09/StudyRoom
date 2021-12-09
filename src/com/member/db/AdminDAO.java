package com.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDAO {

	// 기본 생성자
	public AdminDAO() {
		
	}
	
	public Connection getConn() {
		// DB와 커넥션을 위한 Connection 객체
		Connection con = null;
		
		try {
			// JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 커넥션 객체 얻기
			con = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/mydb", "sjh", "0909");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	// 관리자 비번 입력
	public boolean AdminLogin(String pw) {
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			String sql = "select * from admin where pw=?";
		
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(2).equals(pw))
					ok = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}
	
	public void updatePw(String newpw) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update admin set pw=? where num=1";
		
			ps = con.prepareStatement(sql);
			ps.setString(1, newpw);
			ps.executeUpdate();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
