package com.membership.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class History {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History window = new History();
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
	public History() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("이용 내역");
		frame.setBounds(100, 100, 400, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
