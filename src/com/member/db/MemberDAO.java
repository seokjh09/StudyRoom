package com.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	private String colNames[] = {"이름", "전화번호", "등록일", "종료일"};
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);

	// 기본 생성자
	public MemberDAO() {
		
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
	
	// 회원가입
	public boolean insertMember(MemberDTO dto) {
		
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "insert into member(p_num, pw, name) values(?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getP_num());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			

			int r = ps.executeUpdate();
			
			if (dto.getP_num() == "" || dto.getPw() == "" || dto.getName() == "" ) {
				System.out.println("가입 실패");
			} else if (r > 0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}
	

	// 로그인
	public boolean memberLogin(String p_num, String pw) {
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			String sql = "select * from member where p_num=? and pw=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p_num);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(p_num) && rs.getString(2).equals(pw))
					ok = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}
	
	// 회원 목록 모델
	public DefaultTableModel selectModel() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select p_num, name, s_time, e_time from member order by name";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String p_num = rs.getString("p_num");
				String s_time = rs.getString("s_time");
				String e_time = rs.getString("e_time");
				
				Object data[] = {name, p_num, s_time, e_time};
				model.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	// 충전권, 사물함, 등록 일자, 남은 시간 업데이트
	public void updateMembership(String s_time, String e_time, String p_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update member set s_time=?, e_time=? where p_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, s_time);
			ps.setString(2, e_time);
			ps.setString(3, p_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 좌석 번호 업데이트
	public void updateS_num(int s_num, String p_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update member set s_num=? where p_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, s_num);
			ps.setString(2, p_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 사용자 이름 가져오기
	public String name(String p_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String name = null;
		
		try {
			con = getConn();
			
			String sql = "select * from member where p_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p_num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if (rs.getString(1).equals(p_num))
					name = rs.getString("name");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	// 좌석번호 가져오기
	public String seatsNum(String p_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String s_num = null;
		
		try {
			con = getConn();
			
			String sql = "select * from member where p_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p_num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if (rs.getString(1).equals(p_num))
					s_num = rs.getString(6);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return s_num;
	}
	
	public void deleteS_num(String p_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			String sql = "update member set s_num=? where p_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, p_num);
			ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원권 유무 확인
	public boolean isMembership(String p_num) {
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			String sql = "select * from member where p_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p_num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(4) != null)
					ok = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}
	
	// 회원권 유무 확인
	public boolean isS_num(String p_num) {
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			String sql = "select * from member where p_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p_num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(6) != null)
					ok = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

}
