package com.membership.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.member.db.MemberDAO;
import com.membership.db.ChargeDAO;
import com.membership.db.SalesDAO;
import com.seats.db.LockerDAO;

public class Membership {
	private JFrame frame;
	private JTextField textField;
	private static String p_num;
	private int l_num;;
	private String c_num;
	private int price;
	private String e_time;
	private int num;
	private String l_end;

	// 현재 날짜/시간
	LocalDate now = LocalDate.now();
	String s_time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Membership window = new Membership(p_num);
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
	public Membership(String p_num) {	// 생성자
		this.p_num = p_num;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DecimalFormat  formatter = new DecimalFormat("###,###");
		frame = new JFrame();
		frame.setTitle("회원권 등록");
		frame.setBounds(100, 100, 350, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// System.out.println(p_num);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC2DC\uAC04 \uC120\uD0DD");
		lblNewLabel.setBounds(83, 68, 64, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uBB3C\uD568 \uC120\uD0DD");
		lblNewLabel_1.setBounds(83, 112, 76, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uACB0\uC81C\uAE08\uC561");
		lblNewLabel_2.setBounds(83, 156, 52, 15);
		panel.add(lblNewLabel_2);
		
		// 충전권 객체 생성
		ChargeDAO c_dao = new ChargeDAO();
		// 충전권 이름 리스트
		ArrayList<String> CBmenu_1 = c_dao.charge();
		
		JComboBox<String> comboBox1 = new JComboBox(CBmenu_1.toArray(new String[CBmenu_1.size()]));
		comboBox1.setBounds(161, 64, 76, 23);
		panel.add(comboBox1);
		
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(comboBox1)) {
					c_num = comboBox1.getSelectedItem().toString();
					price = c_dao.price(c_num);
					textField.setText(formatter.format(price));
				}
			}
		});
		// 사물함 객체 생성
		LockerDAO l_dao = new LockerDAO();
		// 사물함 번호 리스트
		ArrayList<String> CBmenu_2 = new ArrayList<>();
		CBmenu_2.add("사용안함");
		CBmenu_2.addAll(l_dao.emptyLocker());
		
		JComboBox<String> comboBox2 = new JComboBox(CBmenu_2.toArray(new String[CBmenu_2.size()]));
		comboBox2.setBounds(161, 108, 76, 23);
		panel.add(comboBox2);
		
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(comboBox2)) {
					l_num = Integer.parseInt((String) comboBox2.getSelectedItem());
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(161, 153, 76, 21);
		panel.add(textField);
		textField.setColumns(10);		
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO m_dao = new MemberDAO();
				SalesDAO s_dao = new SalesDAO();
				String name = m_dao.name(p_num);
				num = c_dao.num(c_num);

				if (num == 1) {
					LocalDate end = now.plusDays(1);
					e_time = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
					LocalDate end1 = now.plusDays(1);
					l_end = end1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				} else if(num == 2) {
					LocalDate end = now.plusDays(14);
					e_time = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
					LocalDate end1 = now.plusDays(14);
					l_end = end1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				} else if(num == 3) {
					LocalDate end = now.plusDays(28);
					e_time = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
					LocalDate end1 = now.plusDays(28);
					l_end = end1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				} else if(num == 4) {
					LocalDate end = now.plusDays(56);
					e_time = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
					LocalDate end1 = now.plusDays(56);
					l_end = end1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				}

				m_dao.updateMembership(s_time, e_time, p_num);
				l_dao.updateLocker(p_num, name, l_num);
				//s_dao.insertSales(s_time, c_num, price);
				JOptionPane.showMessageDialog(frame, "등록이 완료되었습니다.");
				frame.dispose();
			}
		});
		btnNewButton.setBounds(173, 184, 64, 23);
		panel.add(btnNewButton);
		
		frame.setVisible(true);
	}
}
