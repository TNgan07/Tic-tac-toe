package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGame frame = new MenuGame();
					frame.setLocationRelativeTo(null); //layout center
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
	public MenuGame() {
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 204, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIC-TAC-TOE");
		lblNewLabel.setForeground(new Color(41, 139, 200));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setBounds(245, 79, 293, 50);
		contentPane.add(lblNewLabel);
		
	
		// 1 Nguoi choi
		JButton btnOnePlayer = new JButton("1 PLAYER");
		btnOnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level frame = new Level();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				MenuGame.this.setVisible(false); 
				frame.setVisible(true);
			}
		});
		btnOnePlayer.setForeground(new Color(255, 255, 255));
		btnOnePlayer.setBackground(new Color(41, 139, 200));
		btnOnePlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnOnePlayer.setBounds(268, 180, 200, 50);
		contentPane.add(btnOnePlayer);
		
		// 2 nguoi choi
		JButton btnTwoPlayer = new JButton("2 PLAYERS");
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoPlayer frame = new TwoPlayer();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				MenuGame.this.setVisible(false);
			}
		});
		btnTwoPlayer.setForeground(new Color(255, 255, 255));
		btnTwoPlayer.setBackground(new Color(41, 139, 200));
		btnTwoPlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTwoPlayer.setBounds(268, 257, 200, 50);
		contentPane.add(btnTwoPlayer);
		
		// EXIT
		JButton btn_Exit = new JButton("EXIT GAME");
		btn_Exit.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				ExitGame exit = new ExitGame();
				exit.setVisible(true);
				exit.setLocationRelativeTo(null);
			}
		});
		btn_Exit.setForeground(new Color(255, 255, 255));
		btn_Exit.setBackground(new Color(41, 139, 200));
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_Exit.setBounds(268, 334, 200, 50);
		contentPane.add(btn_Exit);
	}
}
