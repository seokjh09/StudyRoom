package com.membership.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class SalesDAO {

	private String colNames[] = {"날짜", "30시간권", "50시간권", "100시간권", "150시간권"};
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	
	public SalesDAO() {
		
	}
	
	public Connection getConn() {
		
		//DB와 커넥션을 위한 Connection 객체
		Connection con = null;
		
		try {
			// JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 커넥션 객체 얻기
			// DBMS Server URL, 계정, 비밀번호
			con = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/mydb", "sjh", "0909");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	/*
	public void insertSales(String date, String c_num, int price) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "insert into sales values(?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, date);
			

			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel selectModel() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select date, c_num, price from sales";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String date = rs.getString("date");
				String c_num = rs.getString("c_num");
				int price = rs.getInt("price");
				
				
				
				
				Object data[] = {"date", "", "", "", "", ""};
				model.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}*/
	
}
