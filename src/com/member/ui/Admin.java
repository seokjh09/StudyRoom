package com.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.member.db.AdminDAO;
import com.member.db.AdminDTO;
import com.member.db.MemberDAO;
import com.member.db.MemberDTO;
import com.seats.ui.Seats_a;
import com.seats.ui.Seats_m;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Admin {

	private JFrame frame;
	private JPasswordField pfPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("관리자 PW 입력");
		frame.setBounds(100, 100, 348, 250);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(68, 84, 66, 15);
		panel.add(lblNewLabel);
		
		JButton btnComfirm = new JButton("\uD655\uC778");
		btnComfirm.setFont(new Font("굴림", Font.PLAIN, 10));
		btnComfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnComfirm) {
					if (AdminLogin() == true) {
						frame.dispose();
						System.out.println("관리자 로그인");
						Seats_a sa = new Seats_a();
					} else {
						JOptionPane.showMessageDialog(frame, "비밀번호가 올바르지 않습니다.");
					}
				}
			}
		});
		btnComfirm.setBounds(147, 122, 57, 23);
		panel.add(btnComfirm);
		
		pfPw = new JPasswordField();
		pfPw.setBounds(137, 81, 130, 21);
		panel.add(pfPw);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancel) {
					frame.dispose();
				}
			}
		});
		btnCancel.setBounds(210, 122, 57, 23);
		panel.add(btnCancel);
		
		frame.setVisible(true);
	}
	
	private boolean AdminLogin() {
		// 화면에서 사용자가 입력한 내용을 얻는다.
		String pw = String.valueOf(pfPw.getPassword());
		AdminDAO dao = new AdminDAO();
		boolean ok = dao.AdminLogin(pw);
		
		return ok;
		
	}
}
