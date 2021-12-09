package com.membership.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.member.db.MemberDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class M_Manage {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_Manage window = new M_Manage();
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
	public M_Manage() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원 관리");
		frame.setBounds(100, 100, 438, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 406);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 400, 343);
		panel.add(scrollPane);
		
		MemberDAO dao = new MemberDAO();
		table = new JTable(dao.selectModel());
		scrollPane.setViewportView(table);
		
		JButton btnMembership = new JButton("\uD68C\uC6D0\uAD8C \uB4F1\uB85D");
		btnMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 회원권 등록 버튼 이벤트
				String p_num = getP_num();
				Membership ms = new Membership(p_num);
				frame.dispose();
			}
		});
		btnMembership.setBounds(308, 363, 104, 23);
		panel.add(btnMembership);
		
		JButton btnHistory = new JButton("\uC774\uC6A9 \uB0B4\uC5ED");
		btnHistory.setBounds(208, 363, 95, 23);
		panel.add(btnHistory);
		
		frame.setVisible(true);
	}
	
	
	private String getP_num() {
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 1);
		//System.out.print("p_num : " + value.toString());
		
		return value.toString();
	}
}
