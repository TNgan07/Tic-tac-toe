package GUI;

import java.awt.EventQueue;
import GUI.OnePlayer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level frame = new Level();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Level() {
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE LEVEL");
		lblNewLabel.setForeground(new Color(41, 139, 200));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(161, 35, 214, 64);
		contentPane.add(lblNewLabel);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnePlayer frame = new OnePlayer();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				frame.setLevel(true);
				frame.setVisible(true);
				Level.this.setVisible(false);
			}
		});
		btnEasy.setForeground(new Color(255, 255, 255));
		btnEasy.setBackground(new Color(41, 139, 200));
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnEasy.setBounds(194, 109, 118, 51);
		contentPane.add(btnEasy);
		
		JButton btnDifficult = new JButton("Difficult");
		btnDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnePlayer frame = new OnePlayer();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				frame.setLevel(false);
				frame.setVisible(true);
				Level.this.setVisible(false);
			}
		});
		btnDifficult.setForeground(Color.WHITE);
		btnDifficult.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDifficult.setBackground(new Color(41, 139, 200));
		btnDifficult.setBounds(194, 190, 118, 51);
		contentPane.add(btnDifficult);
		
		
		
		
	}
}
