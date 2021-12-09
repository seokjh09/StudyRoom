package com.seats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class SeatsDAO {
	private String colNames[] = {"좌석 번호", "이름"};
	private DefaultTableModel seatsmodel = new DefaultTableModel(colNames, 0);
	
	public SeatsDAO() {
		
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
	
	
	public ArrayList<String> useSeats() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			con = getConn();
			
			String sql = "select * from seats where p_num is not null";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	public void updateSeats(String p_num, String name, int s_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update seats set p_num=?, name=? where s_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p_num);
			ps.setString(2, name);
			ps.setInt(3, s_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteSeats(String s_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update seats set p_num=?, name=? where s_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, null);
			ps.setString(3, s_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 좌석 현황 모델
	public DefaultTableModel selectSeatsModel() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select s_num, name from seats where p_num is not null order by s_num";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int s_num = rs.getInt("s_num");
				String name = rs.getString("name");
				
				Object data[] = {s_num, name};
				seatsmodel.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return seatsmodel;
	}
}
