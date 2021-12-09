package com.member.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.member.db.AdminDAO;
import com.member.db.MemberDAO;
import com.member.db.MemberDTO;
import com.seats.ui.Seats_a;
import com.seats.ui.Seats_m;
public class Login {

	private JFrame frame;
	private JTextField tfId;
	private JPasswordField pfPw;
	private String p_num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 410, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tfId = new JTextField();
		tfId.setBounds(166, 135, 125, 21);
		panel.add(tfId);
		tfId.setColumns(10);
		
		JLabel idLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		idLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		idLabel.setBounds(98, 137, 61, 15);
		panel.add(idLabel);
		
		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		pwLabel.setBounds(98, 175, 61, 19);
		panel.add(pwLabel);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLogin) {
					if (memberLogin() == true) {
						Seats_m sm = new Seats_m(p_num);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "ÀüÈ­¹øÈ£ È¤Àº ºñ¹Ð¹øÈ£ Æ²¸².");
					}
				}
			}
			
		});
		btnLogin.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 10));
		btnLogin.setBounds(162, 242, 75, 23);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("SW \uB3C5\uC11C\uC2E4");
		lblNewLabel_2.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(140, 31, 125, 60);
		panel.add(lblNewLabel_2);
		
		pfPw = new JPasswordField();
		pfPw.setBounds(166, 175, 125, 21);
		panel.add(pfPw);
		
		JButton btnAdmin = new JButton("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAdmin) {
					Admin a = new Admin();
					frame.dispose();
				}
			}
		});
		btnAdmin.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 8));
		btnAdmin.setBounds(242, 242, 75, 23);
		panel.add(btnAdmin);
		
		JButton btnProc = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnProc) {
					MemberProc mp = new MemberProc();
				}			
			}
		});
		btnProc.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 10));
		btnProc.setBounds(81, 242, 75, 23);
		panel.add(btnProc);
		
		frame.setVisible(true);
	}
	
	
	private boolean memberLogin() {

		p_num = tfId.getText();
		String pw = String.valueOf(pfPw.getPassword());
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.memberLogin(p_num, pw);
		
		return ok;
		
	}

	
}
