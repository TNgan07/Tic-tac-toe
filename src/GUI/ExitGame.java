package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitGame frame = new ExitGame();
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
	public ExitGame() {
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 298);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DO YOU WANT TO EXIT THE GAME?");
		lblNewLabel.setForeground(new Color(41, 139, 200));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(46, 52, 444, 64);
		contentPane.add(lblNewLabel);
		
		// YESS
		JButton btnYES = new JButton("YES");
		btnYES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnYES.setForeground(new Color(255, 255, 255));
		btnYES.setBackground(new Color(41, 139, 200));
		btnYES.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnYES.setBounds(85, 155, 150, 50);
		contentPane.add(btnYES);
		
		// NO
		JButton btnNO = new JButton("NO");
		btnNO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitGame.this.setVisible(false);
			}
		});
		btnNO.setForeground(new Color(255, 255, 255));
		btnNO.setBackground(new Color(41, 139, 200));
		btnNO.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNO.setBounds(297, 155, 150, 50);
		contentPane.add(btnNO);
	
	}

}
