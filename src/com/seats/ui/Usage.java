package com.seats.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.seats.db.LockerDAO;
import com.seats.db.SeatsDAO;

public class Usage {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usage window = new Usage();
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
	public Usage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("이용 현황");
		frame.setBounds(100, 100, 360, 390);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("좌석", null, panel, null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		SeatsDAO s_dao = new SeatsDAO();
		table_1 = new JTable(s_dao.selectSeatsModel());
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("사물함", null, panel_1, null);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		LockerDAO l_dao = new LockerDAO();
		table = new JTable(l_dao.selectLockerModel());
		scrollPane.setViewportView(table);
		
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}

}
