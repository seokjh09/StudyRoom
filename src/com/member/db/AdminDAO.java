package com.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDAO {

	// �⺻ ������
	public AdminDAO() {
		
	}
	
	public Connection getConn() {
		// DB�� Ŀ�ؼ��� ���� Connection ��ü
		Connection con = null;
		
		try {
			// JDBC ����̹� �ε�
			Class.forName("org.mariadb.jdbc.Driver");
			// Ŀ�ؼ� ��ü ���
			con = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/mydb", "sjh", "0909");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	// ������ ��� �Է�
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
