package com.membership.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class SalesDAO {

	private String colNames[] = {"��¥", "30�ð���", "50�ð���", "100�ð���", "150�ð���"};
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	
	public SalesDAO() {
		
	}
	
	public Connection getConn() {
		
		//DB�� Ŀ�ؼ��� ���� Connection ��ü
		Connection con = null;
		
		try {
			// JDBC ����̹� �ε�
			Class.forName("org.mariadb.jdbc.Driver");
			// Ŀ�ؼ� ��ü ���
			// DBMS Server URL, ����, ��й�ȣ
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
