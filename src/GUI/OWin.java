package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OWin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OWin frame = new OWin();
					frame.setLocationRelativeTo(null);
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
	public OWin() {
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 233);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLAYER O WINS!!!");
		lblNewLabel.setForeground(new Color(41, 139, 200));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(110, 24, 320, 56);
		contentPane.add(lblNewLabel);
		
		JButton btnOK = new JButton("Play Again");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OWin.this.setVisible(false);
			}
		});
		btnOK.setBackground(new Color(41, 139, 200));
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnOK.setBounds(155, 108, 126, 49);
		contentPane.add(btnOK);
		
	
	}

}
