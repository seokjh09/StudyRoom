package com.member.db;

import java.sql.Time;
import java.time.LocalDateTime;

public class MemberDTO {
	private String p_num;
	private String pw;
	private String name;
	private String c_num;
	private LocalDateTime s_time;
	private Time r_time;
	private int l_num;
	private LocalDateTime l_end;
	
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public LocalDateTime getL_end() {
		return l_end;
	}
	public void setL_end(LocalDateTime l_end) {
		this.l_end = l_end;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getS_time() {
		return s_time;
	}
	public void setS_time(LocalDateTime s_time) {
		this.s_time = s_time;
	}
	public Time getR_time() {
		return r_time;
	}
	public void setR_time(Time r_time) {
		this.r_time = r_time;
	}

}

	

