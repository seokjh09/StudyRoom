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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class MemberProc {

	private JFrame frame;
	private JTextField tfp_num;
	private JTextField tfName;
	private JPasswordField pfPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberProc window = new MemberProc();
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
	public MemberProc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 300, 260);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel p_numLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		p_numLabel.setBounds(36, 46, 58, 15);
		panel.add(p_numLabel);
		
		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setBounds(36, 86, 58, 15);
		panel.add(pwLabel);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(36, 127, 38, 15);
		panel.add(nameLabel);
		
		tfp_num = new JTextField();
		tfp_num.setBounds(106, 43, 142, 21);
		panel.add(tfp_num);
		tfp_num.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(106, 124, 142, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JButton btnProc = new JButton("\uAC00\uC785");
		btnProc.setFont(new Font("굴림", Font.PLAIN, 11));
		btnProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnProc) {
					insertMember();
				}
			}
		});
		btnProc.setBounds(128, 172, 58, 23);
		panel.add(btnProc);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancel) {
					frame.dispose();
				}
			}
		});
		btnCancel.setBounds(190, 172, 58, 23);
		panel.add(btnCancel);
		
		pfPw = new JPasswordField();
		pfPw.setBounds(106, 83, 142, 21);
		panel.add(pfPw);
		
		frame.setVisible(true);
		
	}
	
	public MemberDTO getViewData() {
		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = new MemberDTO();
		String p_num = tfp_num.getText();
		String pw = String.valueOf(pfPw.getPassword());
		String name = tfName.getText();
		
		dto.setP_num(p_num);
		dto.setPw(pw);
		dto.setName(name);
		
		return dto;
	}
	
	private void insertMember() {
		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);
		
		if (ok) {
			JOptionPane.showMessageDialog(frame, "가입이 완료되었습니다.");
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(frame, "이미 등록된 전화번호입니다.");
		}
		
		
	}
	
	
}
