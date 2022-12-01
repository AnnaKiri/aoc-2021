package Day4;

public class BingoBoard {
	private int[][] board;
	private boolean inGame;
	
	public BingoBoard(int[][] arr) {
		this.board = arr;
		this.inGame = true;
	}
	
	
	
	public void crossOutNumber(int n) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == n) {
					board[i][j] = -1;
				}
			}
		}
	}
	
	public boolean checkBoardForWin() {
		for (int i = 0; i < board.length; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < board[i].length; j++) {
				sum1 += board[i][j];
				sum2 += board[j][i];
				if (sum1 == -5 || sum2 == -5) {
					inGame = false;
					return true;
				}
			}
		}
		return false;
	}
	
	public int findSum() {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != -1) {
					sum += board[i][j];
				}
			}
		}
		
		return sum;
	}

	public boolean inGame() {
		return inGame;
	}
}
