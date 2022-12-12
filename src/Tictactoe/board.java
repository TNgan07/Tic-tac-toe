package Tictactoe;

import static Tictactoe.Mark.*;

public class board {

	private final Mark board[][];
	private Mark winningMark;
	private final int BOARD_WIDTH = 3;
	private int availableMoves = BOARD_WIDTH * BOARD_WIDTH;
	private boolean crossTurn, gameOver;

	
	public board() {
		board = new Mark[BOARD_WIDTH][BOARD_WIDTH];
		crossTurn = true; 
		gameOver = false;
		winningMark = BLANK;
		initBoard();
	}
	// khoi tao o choi
	private void initBoard() {
		for (int i = 0; i < BOARD_WIDTH; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				board[i][j] = BLANK;
			}
		}
	}
	// kiem tra trạng thái chơi 
	public boolean placeMark(int row, int colunm) {
		if (row < 0 || row >= BOARD_WIDTH || colunm < 0 || colunm >= BOARD_WIDTH || isTileMarked(row, colunm) || gameOver) {
			return false;
		}
		availableMoves--; // các bước di chuyển 
		board[row][colunm] = crossTurn ? X : O;
		togglePlayer(); // đổi lượt chơi 
		checkWin(row, colunm); // Kiểm tra người thắng
		return true;
	}
	
	// Kiểm tra người thắng 
	private void checkWin(int row, int column) {
		int rowSum = 0;
		
		// Kiểm tra hàng
		for (int c = 0; c < BOARD_WIDTH; c++) {
			rowSum += getMarkAt(row, c).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		
		// Kiểm tra cột
		rowSum = 0;
		for (int r = 0; r < BOARD_WIDTH; r++) {
			rowSum += getMarkAt(r, column).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		
		// Kiểm tra đường chéo [1,5,9]
		rowSum = 0;
		for (int i = 0; i < BOARD_WIDTH; i++) {
			rowSum += getMarkAt(i, i).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		
		// Kiểm tra đường chéo [3,5,7]
		rowSum = 0;
		int indexMax = BOARD_WIDTH - 1;
		for (int i = 0; i <= indexMax; i++) {
			rowSum += getMarkAt(i, indexMax - i).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		if (!anyMovesAvailable()) {
			gameOver = true;
		}
	}
	// gọi Người thắng 
	private Mark calcWinner(int rowSum) {
		int xWin = X.getMark() * BOARD_WIDTH;
		int oWin = O.getMark() * BOARD_WIDTH;
		if (xWin == rowSum) {
			gameOver = true;
			winningMark = X;
			return X;
		} else if (oWin == rowSum) {
			gameOver = true;
			winningMark = O;
			return O;
		}
		return BLANK;
	}
	
	// đổi lượt chơi 
	private void togglePlayer() {
		crossTurn = !crossTurn;
	}
	
	// Kiểm tra ô chơi còn trống
	public boolean anyMovesAvailable() {
		return availableMoves > 0;
	}
	
	// lấy Mark tại vị trí hàng và cột trong mảng board
	public Mark getMarkAt(int row, int column) {
		return board[row][column];
	}
	
	// Kiểm tra vị trí đã đánh dấu chưa 
	public boolean isTileMarked(int row, int column) {
		return board[row][column].isMarked();
	}
	
	// Đánh dấu trại vị trí 
	public void setMarkAt(int row, int column, Mark newMark) {
		board[row][column] = newMark;
	}
	
	// kiểm tra lượt chơi 
	public boolean isCrossTurn() {
		return crossTurn;
	}
	
	// Lấy chiều rộng 
	public int getWidth() {
		return BOARD_WIDTH;
	}
	
	// Kiểm tra game đã kết thúc 
	public boolean isGameOver() {
		return gameOver;
	}

	// Lấy người thắng 
	public Mark getWinningMark() {
		return winningMark;
	}

	// Lấy số ô chưa đánh dấu còn lại của bàn chơi
	public int getAvailableMoves() {
		return availableMoves;
	}

	// Đặt lại ô chưa đánh dấu còn lại
	public void setAvailableMoves(int availableMoves) {
		this.availableMoves = availableMoves;
	}

}
