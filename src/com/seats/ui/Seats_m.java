package com.seats.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import com.member.db.MemberDAO;
import com.member.ui.Admin;
import com.seats.db.SeatsDAO;

import javax.swing.JToggleButton;

public class Seats_m {

	private JFrame frame;
	JToggleButton[] s = new JToggleButton[41];
	private ButtonGroup bg = new ButtonGroup();
	private int i;
	private static String p_num;
	private int s_num;
	private String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats_m window = new Seats_m(p_num);
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
	public Seats_m(String p_num) {
		this.p_num = p_num;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("회원 모드");
		frame.setBounds(100, 100, 680, 484);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		String s_Title[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
							"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
							"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"
							};
		
		for (int i = 0; i < s.length; i++) {
			s[i] = new JToggleButton(s_Title[i]);
		}

		s[0].setBounds(584, 20, 45, 45);
		s[1].setBounds(478, 20, 45, 45);
		s[2].setBounds(366, 20, 45, 45);
		s[3].setBounds(255, 20, 45, 45);
		s[4].setBounds(149, 20, 45, 45);
		s[5].setBounds(37, 20, 45, 45);
		s[6].setBounds(573, 110, 45, 45);
		s[7].setBounds(573, 159, 45, 45);
		s[8].setBounds(573, 209, 45, 45);
		s[9].setBounds(573, 260, 45, 45);
		s[10].setBounds(573, 310, 45, 45);
		s[11].setBounds(523, 110, 45, 45);
		s[12].setBounds(523, 159, 45, 45);
		s[13].setBounds(523, 209, 45, 45);
		s[14].setBounds(523, 260, 45, 45);
		s[15].setBounds(523, 310, 45, 45);
		s[16].setBounds(403, 110, 45, 45);
		s[17].setBounds(403, 159, 45, 45);
		s[18].setBounds(403, 209, 45, 45);
		s[19].setBounds(403, 260, 45, 45);
		s[20].setBounds(403, 310, 45, 45);
		s[21].setBounds(353, 110, 45, 45);
		s[22].setBounds(353, 159, 45, 45);
		s[23].setBounds(353, 209, 45, 45);
		s[24].setBounds(353, 260, 45, 45);
		s[25].setBounds(353, 310, 45, 45);
		s[26].setBounds(224, 110, 45, 45);
		s[27].setBounds(224, 159, 45, 45);
		s[28].setBounds(224, 209, 45, 45);
		s[29].setBounds(224, 260, 45, 45);	
		s[30].setBounds(224, 310, 45, 45);
		s[31].setBounds(174, 110, 45, 45);
		s[32].setBounds(174, 159, 45, 45);
		s[33].setBounds(174, 209, 45, 45);
		s[34].setBounds(174, 260, 45, 45);
		s[35].setBounds(174, 310, 45, 45);
		s[36].setBounds(47, 110, 45, 45);
		s[37].setBounds(47, 159, 45, 45);
		s[38].setBounds(47, 209, 45, 45);
		s[39].setBounds(47, 260, 45, 45);
		s[40].setBounds(47, 310, 45, 45);
		
		
		for (i = 0; i < 41; i++) {
			s[i].setFont(new Font("굴림", Font.PLAIN, 11));
			s[i].setBackground(Color.WHITE);
			panel.add(s[i]);
			bg.add(s[i]);			
		}
		
		MemberDAO m_dao = new MemberDAO();
		// 사용 중인 좌석 리스트 생성 후 색 변경
		SeatsDAO s_dao = new SeatsDAO();
		ArrayList<String> useSeats = s_dao.useSeats();
		for (int i = 0; i < useSeats.size(); i++) {
			int n = Integer.parseInt(useSeats.get(i));
			s[n-1].setBackground(Color.LIGHT_GRAY);
			String a = m_dao.seatsNum(p_num);
			if (a != null) {
				int b = Integer.parseInt(a);
				s[b-1].setBackground(Color.YELLOW);
			}
			s[n-1].setEnabled(false);
		}
			
		
		s[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[0].isSelected()) {
					s_num = 1;		
				}
			}
		});
		
		s[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[1].isSelected()) {
					s_num = 2;
				}
			}
		});
		
		s[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[2].isSelected()) {
					s_num = 3;
				}
			}
		});
		
		s[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[3].isSelected()) {
					s_num = 4;
				}
			}
		});
		
		s[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[4].isSelected()) {
					s_num = 5;
				}
			}
		});
		
		s[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[5].isSelected()) {
					s_num = 6;
				}
			}
		});
		
		s[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[6].isSelected()) {
					s_num = 7;
				}
			}
		});
		
		s[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[7].isSelected()) {
					s_num = 8;
				}
			}
		});
		
		s[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[8].isSelected()) {
					s_num = 9;
				}
			}
		});
		
		s[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[9].isSelected()) {
					s_num = 10;
				}
			}
		});
		
		s[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[10].isSelected()) {
					s_num = 11;
				}
			}
		});
		
		s[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[11].isSelected()) {
					s_num = 12;
				}
			}
		});
		
		s[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[12].isSelected()) {
					s_num = 13;
				}
			}
		});
		
		s[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[13].isSelected()) {
					s_num = 14;
				}
			}
		});
		
		s[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[14].isSelected()) {
					s_num = 15;
				}
			}
		});
		
		s[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[15].isSelected()) {
					s_num = 16;
				}
			}
		});
		
		s[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[16].isSelected()) {
					s_num = 17;
				}
			}
		});
		
		s[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[17].isSelected()) {
					s_num = 18;
				}
			}
		});
		
		s[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[18].isSelected()) {
					s_num = 19;
				}
			}
		});
		
		s[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[19].isSelected()) {
					s_num = 20;
				}
			}
		});
		
		s[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[20].isSelected()) {
					s_num = 21;
				}
			}
		});
		
		s[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[21].isSelected()) {
					s_num = 22;
				}
			}
		});
		
		s[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[22].isSelected()) {
					s_num = 23;
				}
			}
		});
		
		s[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[23].isSelected()) {
					s_num = 24;
				}
			}
		});
		
		s[24].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[24].isSelected()) {
					s_num = 25;
				}
			}
		});
		
		s[25].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[25].isSelected()) {
					s_num = 26;
				}
			}
		});
		
		s[26].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[26].isSelected()) {
					s_num = 27;
				}
			}
		});
		
		s[27].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[27].isSelected()) {
					s_num = 28;
				}
			}
		});
		
		s[28].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[28].isSelected()) {
					s_num = 29;
				}
			}
		});
		
		s[29].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[29].isSelected()) {
					s_num = 30;
				}
			}
		});
		
		s[30].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[30].isSelected()) {
					s_num = 31;
				}
			}
		});
		
		s[31].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[31].isSelected()) {
					s_num = 32;
				}
			}
		});
		
		s[32].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[32].isSelected()) {
					s_num = 33;
				}
			}
		});
		
		s[33].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[33].isSelected()) {
					s_num = 34;
				}
			}
		});
		
		s[34].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[34].isSelected()) {
					s_num = 35;
				}
			}
		});
		
		s[35].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[35].isSelected()) {
					s_num = 36;
				}
			}
		});
		
		s[36].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[36].isSelected()) {
					s_num = 37;
				}
			}
		});
		
		s[37].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[37].isSelected()) {
					s_num = 38;
				}
			}
		});
		
		s[38].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[38].isSelected()) {
					s_num = 39;
				}
			}
		});
		
		s[39].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[39].isSelected()) {
					s_num = 40;
				}
			}
		});
		
		s[40].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s[40].isSelected()) {
					s_num = 41;
				}
			}
		});
	
		
		JButton b_in = new JButton("\uC785\uC2E4");
		b_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m_dao.isMembership(p_num) == true) {
					name = m_dao.name(p_num);
					s_dao.updateSeats(p_num, name, s_num);
					m_dao.updateS_num(s_num, p_num);
					JOptionPane.showMessageDialog(frame, "입실이 완료되었습니다.");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "회원권을 등록해주세요.");
				}
				
			}
		});
		b_in.setBounds(427, 398, 95, 23);
		panel.add(b_in);
		
		JButton b_out = new JButton("\uD1F4\uC2E4");
		b_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m_dao.isS_num(p_num) == true) {
					String s_num1 = m_dao.seatsNum(p_num);
					s_dao.deleteSeats(s_num1);
					m_dao.deleteS_num(p_num);
					JOptionPane.showMessageDialog(frame, "퇴실이 완료되었습니다.");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "사용 중인 좌석이 없습니다.");
				}
				
			}
		});
		b_out.setBounds(534, 398, 95, 23);
		panel.add(b_out);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(342, 384, 15, 15);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(342, 403, 15, 15);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.yellow);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(342, 422, 15, 15);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uC774\uC6A9 \uAC00\uB2A5");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel.setBounds(363, 385, 52, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uC6A9 \uBD88\uAC00");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(363, 403, 52, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uB0B4 \uC88C\uC11D");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(363, 422, 52, 15);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("\uC785\uAD6C");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(37, 414, 95, 23);
		panel.add(btnNewButton_3);
		
		frame.setVisible(true);
	}
	
}
