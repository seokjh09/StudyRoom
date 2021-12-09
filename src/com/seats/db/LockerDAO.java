package com.seats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class LockerDAO {
	private String colNames[] = {"사물함 번호", "이름"};
	private DefaultTableModel lockermodel = new DefaultTableModel(colNames, 0);
	
	public LockerDAO() {
		
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
	
	public ArrayList<String> emptyLocker() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			con = getConn();
			
			String sql = "select * from locker where p_num is null";
			
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
	
	public ArrayList<String> useLocker() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			con = getConn();
			
			String sql = "select * from locker where p_num is not null";
			
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
	
	// 사물함 현황 모델
	public DefaultTableModel selectLockerModel() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select l_num, name from locker where p_num is not null order by l_num";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int l_num = rs.getInt("l_num");
				String name = rs.getString("name");
				
				Object data[] = {l_num, name};
				lockermodel.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lockermodel;
	}
	
	public void updateLocker(String p_num, String name, int l_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update locker set p_num=?, name=? where l_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p_num);
			ps.setString(2, name);
			ps.setInt(3, l_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
