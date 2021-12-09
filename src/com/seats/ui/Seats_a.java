package com.seats.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import com.member.ui.Admin;
import com.member.ui.PWChange;
import com.membership.ui.M_Manage;
import com.seats.db.LockerDAO;
import com.seats.db.SeatsDAO;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Seats_a {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats_a window = new Seats_a();
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
	public Seats_a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("관리자 모드");
		frame.setBounds(100, 100, 890, 520);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel p_seat = new JPanel();
		p_seat.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		p_seat.setBounds(0, 42, 676, 441);
		frame.getContentPane().add(p_seat);
		p_seat.setLayout(null);
		
		String s_Title[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
				"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"
				};
		JToggleButton[] s = new JToggleButton[41];
		for (int i = 0; i < s.length; i++) {
			s[i] = new JToggleButton(s_Title[i]);
		}
		
		s[0].setBounds(588, 46, 45, 45);
		s[1].setBounds(482, 46, 45, 45);
		s[2].setBounds(370, 46, 45, 45);
		s[3].setBounds(259, 46, 45, 45);
		s[4].setBounds(153, 46, 45, 45);
		s[5].setBounds(41, 46, 45, 45);
		s[6].setBounds(577, 136, 45, 45);
		s[7].setBounds(577, 185, 45, 45);
		s[8].setBounds(577, 235, 45, 45);
		s[9].setBounds(577, 286, 45, 45);
		s[10].setBounds(577, 336, 45, 45);
		s[11].setBounds(527, 136, 45, 45);
		s[12].setBounds(527, 185, 45, 45);
		s[13].setBounds(527, 235, 45, 45);
		s[14].setBounds(527, 286, 45, 45);
		s[15].setBounds(527, 336, 45, 45);
		s[16].setBounds(407, 136, 45, 45);
		s[17].setBounds(407, 185, 45, 45);
		s[18].setBounds(407, 235, 45, 45);
		s[19].setBounds(407, 286, 45, 45);
		s[20].setBounds(407, 336, 45, 45);
		s[21].setBounds(357, 136, 45, 45);
		s[22].setBounds(357, 185, 45, 45);
		s[23].setBounds(357, 235, 45, 45);
		s[24].setBounds(357, 286, 45, 45);
		s[25].setBounds(357, 336, 45, 45);
		s[26].setBounds(228, 136, 45, 45);
		s[27].setBounds(228, 185, 45, 45);
		s[28].setBounds(228, 235, 45, 45);
		s[29].setBounds(228, 286, 45, 45);
		s[30].setBounds(228, 336, 45, 45);
		s[31].setBounds(178, 136, 45, 45);
		s[32].setBounds(178, 185, 45, 45);
		s[33].setBounds(178, 235, 45, 45);
		s[34].setBounds(178, 286, 45, 45);
		s[35].setBounds(178, 336, 45, 45);
		s[36].setBounds(51, 136, 45, 45);
		s[37].setBounds(51, 185, 45, 45);
		s[38].setBounds(51, 235, 45, 45);
		s[39].setBounds(51, 286, 45, 45);
		s[40].setBounds(51, 336, 45, 45);
		
		for (int i = 0; i < 41; i++) {
			s[i].setEnabled(false);
			s[i].setFont(new Font("굴림", Font.PLAIN, 11));
			s[i].setBackground(Color.WHITE);
			p_seat.add(s[i]);
		}
		
		// 사용 중인 좌석 리스트 생성 후 색 변경
		SeatsDAO s_dao = new SeatsDAO();
		ArrayList<String> useSeats = s_dao.useSeats();
		for (int i = 0; i < useSeats.size(); i++) {
			int n = Integer.parseInt(useSeats.get(i));
			s[n-1].setBackground(Color.LIGHT_GRAY);
		}
				
		JButton btnNewButton_3 = new JButton("\uC785\uAD6C");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(41, 408, 95, 23);
		p_seat.add(btnNewButton_3);
		
		JPanel p_locker = new JPanel();
		p_locker.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		p_locker.setBounds(675, 42, 200, 441);
		frame.getContentPane().add(p_locker);
		p_locker.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0AC\uBB3C\uD568");
		lblNewLabel_3.setFont(new Font("돋움", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(84, 22, 41, 15);
		p_locker.add(lblNewLabel_3);
		
		
		String l_Title[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
						"21", "22", "23", "24", "25", "26", "27"
						};
		
		JToggleButton[] l = new JToggleButton[27];
		for (int i = 0; i < l.length; i++) {
			l[i] = new JToggleButton(l_Title[i]);
		}

		l[0].setBounds(24, 53, 49, 32);
		l[1].setBounds(24, 95, 49, 32);
		l[2].setBounds(24, 138, 49, 32);
		l[3].setBounds(24, 180, 49, 32);
		l[4].setBounds(24, 222, 49, 32);
		l[5].setBounds(24, 264, 49, 32);
		l[6].setBounds(24, 306, 49, 32);
		l[7].setBounds(24, 348, 49, 32);
		l[8].setBounds(24, 390, 49, 32);
		l[9].setBounds(77, 53, 49, 32);
		l[10].setBounds(77, 95, 49, 32);
		l[11].setBounds(77, 138, 49, 32);
		l[12].setBounds(77, 180, 49, 32);
		l[13].setBounds(77, 222, 49, 32);
		l[14].setBounds(77, 264, 49, 32);	
		l[15].setBounds(77, 306, 49, 32);
		l[16].setBounds(77, 348, 49, 32);
		l[17].setBounds(77, 390, 49, 32);
		l[18].setBounds(130, 53, 49, 32);
		l[19].setBounds(130, 95, 49, 32);
		l[20].setBounds(130, 138, 49, 32);
		l[21].setBounds(130, 180, 49, 32);
		l[22].setBounds(130, 222, 49, 32);
		l[23].setBounds(130, 264, 49, 32);
		l[24].setBounds(130, 306, 49, 32);
		l[25].setBounds(130, 348, 49, 32);
		l[26].setBounds(130, 390, 49, 32);

	
		for (int i = 0; i < 27; i++) {
			l[i].setEnabled(false);
			l[i].setFont(new Font("굴림", Font.PLAIN, 11));
			l[i].setBackground(Color.WHITE);
			p_locker.add(l[i]);
		}
		
		// 사용 중인 사물함 리스트 생성 후 색 변경
		LockerDAO l_dao = new LockerDAO();
		ArrayList<String> useLocker = l_dao.useLocker();
		for (int i = 0; i < useLocker.size(); i++) {
			int n = Integer.parseInt(useLocker.get(i));
			l[n-1].setBackground(Color.LIGHT_GRAY);
		}
		
		JPanel p_button = new JPanel();
		p_button.setBounds(0, 0, 360, 42);
		frame.getContentPane().add(p_button);
		p_button.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		p_button.setLayout(null);
		
		JButton btnMember = new JButton("\uD68C\uC6D0 \uAD00\uB9AC");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMember) {
					M_Manage m = new M_Manage();
				}
			}
		});
		btnMember.setFont(new Font("굴림", Font.PLAIN, 10));
		btnMember.setBounds(99, 10, 75, 23);
		p_button.add(btnMember);
		
		JButton btnPW = new JButton("PW \uBCC0\uACBD");
		btnPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPW) {
					PWChange pw = new PWChange();
				}
			}
		});
		btnPW.setFont(new Font("굴림", Font.PLAIN, 10));
		btnPW.setBounds(186, 10, 75, 23);
		p_button.add(btnPW);
		
		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("굴림", Font.PLAIN, 10));
		btnExit.setBounds(273, 10, 75, 23);
		p_button.add(btnExit);
		
		JButton btnUsage = new JButton("\uC774\uC6A9 \uD604\uD669");
		btnUsage.setBounds(12, 10, 75, 23);
		p_button.add(btnUsage);
		btnUsage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnUsage) {
					Usage u = new Usage();
				}
			}
		});
		btnUsage.setFont(new Font("굴림", Font.PLAIN, 10));
		
		JLabel lblNewLabel_1 = new JLabel("\uD604\uC7AC \uC0AC\uC6A9\uC790 \uC778\uC6D0 : ");
		lblNewLabel_1.setBounds(538, 22, 113, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		ArrayList<String> useSeats2 = s_dao.useSeats();
		String c = Integer.toString(useSeats2.size());
		lblNewLabel_1_1.setText(c);
		lblNewLabel_1_1.setBounds(651, 22, 25, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		frame.setVisible(true);
	}
}
