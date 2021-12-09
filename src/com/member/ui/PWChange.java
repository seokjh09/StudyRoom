package com.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.member.db.AdminDAO;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PWChange {

	private JFrame frame;
	private JPasswordField pf;
	private JPasswordField newpf;
	private JPasswordField newpf2;
	private String pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PWChange window = new PWChange();
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
	public PWChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PW 변경");
		frame.setBounds(100, 100, 300, 278);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPw = new JLabel("\uD604\uC7AC PW");
		lblPw.setBounds(50, 59, 64, 15);
		panel.add(lblPw);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C8 PW");
		lblNewLabel_1.setBounds(50, 92, 76, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C8 PW \uD655\uC778");
		lblNewLabel_2.setBounds(50, 126, 76, 15);
		panel.add(lblNewLabel_2);
		
		pf = new JPasswordField();
		pf.setBounds(126, 56, 108, 21);
		panel.add(pf);
		
		newpf = new JPasswordField();		
		newpf.setBounds(126, 89, 108, 21);
		panel.add(newpf);
		
		newpf2 = new JPasswordField();		
		newpf2.setBounds(126, 123, 108, 21);
		panel.add(newpf2);
		
		AdminDAO dao = new AdminDAO();
		
		JButton btnChange = new JButton("\uBCC0\uACBD");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AdminLogin() == true) {
					String newpw = String.valueOf(newpf.getPassword());
					String newpw2 = String.valueOf(newpf2.getPassword());
					if (newpw.equals(newpw2)) {
						dao.updatePw(newpw);
						JOptionPane.showMessageDialog(frame, "비밀번호가 변경되었습니다.");
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "새비밀번호 불일치");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "기존 비밀번호 틀림.");
				}
			}
		});
		btnChange.setFont(new Font("굴림", Font.PLAIN, 10));
		btnChange.setBounds(120, 173, 54, 23);
		panel.add(btnChange);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancel) {
					frame.dispose();
				}
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 10));
		btnCancel.setBounds(180, 173, 54, 23);
		panel.add(btnCancel);
				
		
		frame.setVisible(true);
	}
	
	private boolean AdminLogin() {

		pw = String.valueOf(pf.getPassword());
		AdminDAO dao = new AdminDAO();
		boolean ok = dao.AdminLogin(pw);
		
		return ok;
	}

}
