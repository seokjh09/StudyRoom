package com.membership.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChargeDAO {
	
	public ChargeDAO() {
		
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
	
	// ������ �̸� ����Ʈ
	public ArrayList<String> charge() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			con = getConn();
			
			String sql = "select * from charge order by price asc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// ���� �ҷ�����
	public int price(String c_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int price = 0;

		try {
			con = getConn();
			
			String sql = "select * from charge where c_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, c_num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(2).equals(c_num))
					price = rs.getInt(3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return price;
	}
	
	// ��ȣ �ҷ�����
	public int num(String c_num) {
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int num = 0;

		try {
			con = getConn();
				
			String sql = "select * from charge where c_num=?";
				
			ps = con.prepareStatement(sql);
			ps.setString(1, c_num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(2).equals(c_num))
					num = rs.getInt(1);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return num;
	}

	
}
