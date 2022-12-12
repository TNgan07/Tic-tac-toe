package Minimax;

import static Tictactoe.Mark.O;
import static Tictactoe.Mark.X;

import static Tictactoe.Mark.BLANK;
import Tictactoe.board;


public class Minimax_Tic {

	// giải thuật áp dụng cho level easy
	
	private static final int MAX_DEPTH = 6;
		public static int Minimax_Tic(board board, int depth, boolean isMax) {
		int boardVal = evaluateBoard(board); // danh gia o choi 
				
		// Kiểm tra ô chơi còn trống 
		if (Math.abs(boardVal) == 10 || depth == 0 || !board.anyMovesAvailable()) {
			return boardVal;
		}
		
		if (isMax) {
			int highestVal = Integer.MIN_VALUE; // gán giá trị nhỏ nhất 
			for (int row = 0; row< board.getWidth(); row ++) {
				for (int col = 0; col < board.getWidth(); col++) {
					if (!board.isTileMarked(row, col)) {// Kiem tra vị tri da duoc danh dau chua 
						board.setMarkAt(row, col, X); // Danh dau o choi x
						highestVal = Math.max(highestVal, Minimax_Tic(board, depth - 1, false));
						board.setMarkAt(row, col, BLANK); 
					}
				}
			}
			return highestVal;
		}
		else {
			int lowestVal = Integer.MAX_VALUE; // giá trị lớn nhất 
			for (int row = 0; row< board.getWidth(); row ++) {
				for (int col = 0; col < board.getWidth(); col++) {
					if (!board.isTileMarked(row, col)) {
						board.setMarkAt(row, col, O);
						lowestVal = Math.min(lowestVal, Minimax_Tic(board, depth - 1, true));
						board.setMarkAt(row, col, BLANK);
					}
				}
			}
			return lowestVal;
		}
	}
	// phuong thuc lay o choi tot nhat
	public static int[] getBestMove (board board) {
		int bestMove[] = new int[] {-1, -1};
		int bestValue = Integer.MIN_VALUE;
		
		for (int row = 0; row < board.getWidth(); row ++) {
			for (int col = 0; col < board.getWidth(); col ++) {
				if (!board.isTileMarked(row, col)) {
					board.setMarkAt(row, col, X);
					int moveValue = Minimax_Tic(board, MAX_DEPTH, false);
					board.setMarkAt(row, col, BLANK);
					if (moveValue > bestValue) {
						bestMove[0] = row;
						bestMove[1] = col;
						bestValue = moveValue;
					}
				}
			}
		}
		return bestMove;
	}
	// phuong thuc danh gia o choi
	public static int evaluateBoard(board board) {
		int rowSum = 0;
		int bWidth = board.getWidth();
		int xWin = X.getMark() * bWidth;
		int oWin = O.getMark() * bWidth;
		
		// Kiểm tra hàng
		for (int row = 0; row < bWidth; row ++) {
			for (int col = 0; col < bWidth; col++) {
				rowSum += board.getMarkAt(row, col).getMark();
			}
			if (rowSum == xWin)
				return 10;
			else if (rowSum == oWin) {
				return -10;
			}
			rowSum = 0;
		}
		
		// Kiểm tra cột
		rowSum = 0;
        for (int col = 0; col < bWidth; col++) {
            for (int row = 0; row < bWidth; row++) {
                rowSum += board.getMarkAt(row, col).getMark();
            }
            if (rowSum == xWin) {
                return 10;
            } else if (rowSum == oWin) {
                return -10;
            }
            rowSum = 0;
        }
	
        // Kiểm tra đường chéo [1,5,9]
        rowSum = 0;
        for (int i = 0; i < bWidth; i++) {
            rowSum += board.getMarkAt(i, i).getMark();
        }
        if (rowSum == xWin) {
            return 10;
        } else if (rowSum == oWin) {
            return -10;
        }
		
        // Kiểm tra đường chéo [3,5,7]
        rowSum = 0;
        int indexMax = bWidth - 1;
        for (int i = 0; i <= indexMax; i++) {
            rowSum += board.getMarkAt(i, indexMax - i).getMark();
        }
        if (rowSum == xWin) {
            return 10;
        } else if (rowSum == oWin) {
            return -10;
        }

        return 0;
	}
	
	
	
	

}
