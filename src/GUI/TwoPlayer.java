package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Tictactoe.board;

import Tictactoe.Mark;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TwoPlayer extends JFrame {

	private JPanel contentPane;
	private int xCount = 0;
	private int oCount = 0;
	private JTextField textField_countX;
	private JTextField textField_countO;
	private static board boardTic = new board();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					TwoPlayer frame = new TwoPlayer();
					frame.setLocationByPlatform(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void checkWin(int row, int colunm) {
		boolean check = boardTic.placeMark(row, colunm);
		if (check) {
			if (boardTic.getWinningMark() == Mark.O) {
				oWin();
				return;

			} else if (boardTic.getWinningMark() == Mark.X) {
				xWin();
				return;
			}

		}
		if (boardTic.isGameOver()) {
			draw();
		}
	}
	
	public void oWin() {
		OWin frame = new OWin();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		oCount++;
		textField_countO.setText(String.valueOf(oCount));
	}

	public void xWin() {
		XWin frame = new XWin();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		xCount++;
		textField_countX.setText(String.valueOf(xCount));
	}

	public void draw() {
		XOWin frame = new XOWin();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	/**
	 * Create the frame.
	 */
	public TwoPlayer() {
	
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 545);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(162, 209, 230));
		panel.setBounds(10, 10, 492, 488);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// ban choi
		JButton btn1 = new JButton("");
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(0, 0)) {
					if (boardTic.isCrossTurn()) {
						btn1.setText("X");
						btn1.setForeground(new Color(100, 149, 237));
						btn1.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn1.setText("O");
						btn1.setForeground(new Color(255, 127, 80));
						btn1.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(0, 0);
				}
			}
		});
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(10, 10, 150, 150);
		panel.add(btn1); 
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(0, 1)) {
					if (boardTic.isCrossTurn()) {
						btn2.setText("X");
						btn2.setForeground(new Color(100, 149, 237));
						btn2.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn2.setText("O");
						btn2.setForeground(new Color(255, 127, 80));
						btn2.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(0, 1);
				}
			}
		});
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(170, 10, 150, 150);
		panel.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(0, 2)) {
					if (boardTic.isCrossTurn()) {
						btn3.setText("X");
						btn3.setForeground(new Color(100, 149, 237));
						btn3.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn3.setText("O");
						btn3.setForeground(new Color(255, 127, 80));
						btn3.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(0, 2);
				}
			}
		});
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(330, 10, 150, 150);
		panel.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(1, 0)) {
					if (boardTic.isCrossTurn()) {
						btn4.setText("X");
						btn4.setForeground(new Color(100, 149, 237));
						btn4.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn4.setText("O");
						btn4.setForeground(new Color(255, 127, 80));
						btn4.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(1, 0);
				}
			}
		});
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(10, 170, 150, 150);
		panel.add(btn4);
		
		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(1, 2)) {
					if (boardTic.isCrossTurn()) {
						btn6.setText("X");
						btn6.setForeground(new Color(100, 149, 237));
						btn6.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn6.setText("O");
						btn6.setForeground(new Color(255, 127, 80));
						btn6.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}

					checkWin(1, 2);
				}
			}
		});
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(330, 170, 150, 150);
		panel.add(btn6);
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(1, 1)) {
					if (boardTic.isCrossTurn()) {
						btn5.setText("X");
						btn5.setForeground(new Color(100, 149, 237));
						btn5.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn5.setText("O");
						btn5.setForeground(new Color(255, 127, 80));
						btn5.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(1, 1);
				}

			}
		});
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(170, 170, 150, 150);
		panel.add(btn5);
		
		JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(2, 0)) {
					if (boardTic.isCrossTurn()) {
						btn7.setText("X");
						btn7.setForeground(new Color(100, 149, 237));
						btn7.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn7.setText("O");
						btn7.setForeground(new Color(255, 127, 80));
						btn7.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(2, 0);
				}
			}
		});
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(10, 330, 150, 150);
		panel.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(2, 1)) {
					if (boardTic.isCrossTurn()) {
						btn8.setText("X");
						btn8.setForeground(new Color(100, 149, 237));
						btn8.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn8.setText("O");
						btn8.setForeground(new Color(255, 127, 80));
						btn8.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(2, 1);
				}
			}
		});
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(170, 328, 150, 150);
		panel.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!boardTic.isTileMarked(2, 2)) {
					if (boardTic.isCrossTurn()) {
						btn9.setText("X");
						btn9.setForeground(new Color(100, 149, 237));
						btn9.setFont(new Font("Tahoma", Font.PLAIN, 100));
					} else {
						btn9.setText("O");
						btn9.setForeground(new Color(255, 127, 80));
						btn9.setFont(new Font("Tahoma", Font.PLAIN, 100));
					}
					checkWin(2, 2);
				}
			}
		});
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(330, 330, 150, 150);
		panel.add(btn9);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(162, 209, 230));
		panel_1.setBounds(512, 10, 301, 488);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Choi lai
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
								
				boardTic = new board();
			}
		});
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(41, 139, 200));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(83, 242, 150, 50);
		panel_1.add(btnReset);
		
		// Bat dau
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
								
				boardTic = new board();
				
				xCount = 0;
				oCount = 0;
				
				textField_countO.setText("0");
				textField_countX.setText("0");
				
				
			}
		});
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.setBackground(new Color(41, 139, 200));
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewGame.setBounds(83, 317, 150, 50);
		panel_1.add(btnNewGame);
		
		// Quay ve Menu
		JButton btnBacktoMenu = new JButton("Back to Menu");
		btnBacktoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGame frame = new MenuGame();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				TwoPlayer.this.setVisible(false);
			}
		});
		

		btnBacktoMenu.setForeground(new Color(255, 255, 255));
		btnBacktoMenu.setBackground(new Color(41, 139, 200));
		btnBacktoMenu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBacktoMenu.setBounds(83, 397, 150, 50);
		panel_1.add(btnBacktoMenu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 281, 468);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIC TAC TOE");
		lblNewLabel.setBounds(73, 21, 157, 31);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(41, 139, 200));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "2 Player ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 84, 261, 116);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPlayerO = new JLabel("PLAYER O");
		lblPlayerO.setBounds(22, 64, 123, 31);
		panel_3.add(lblPlayerO);
		lblPlayerO.setForeground(new Color(41, 139, 200));
		lblPlayerO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPlayerX = new JLabel("PLAYER X");
		lblPlayerX.setBounds(22, 23, 123, 31);
		panel_3.add(lblPlayerX);
		lblPlayerX.setForeground(new Color(41, 139, 200));
		lblPlayerX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_countX = new JTextField();
		textField_countX.setToolTipText("");
		textField_countX.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_countX.setHorizontalAlignment(SwingConstants.CENTER);
		textField_countX.setText("0");
		textField_countX.setBounds(134, 23, 100, 30);
		panel_3.add(textField_countX);
		textField_countX.setColumns(10);
		
		textField_countO = new JTextField();
		textField_countO.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_countO.setHorizontalAlignment(SwingConstants.CENTER);
		textField_countO.setText("0");
		textField_countO.setColumns(10);
		textField_countO.setBounds(134, 65, 100, 30);
		panel_3.add(textField_countO);
	}
}
