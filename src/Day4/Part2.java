package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day4\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		int [] digits = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		
		List<BingoBoard> boards = new ArrayList<>();
		while (scan.hasNext()) {
			int[][] board = new int[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					board[i][j] = scan.nextInt();
				}
			}
			boards.add(new BingoBoard(board));
		}
		
		int winnedBoards = 0;
		for (int n : digits) {
			for (BingoBoard board : boards) {
				
				if (!board.inGame()) {
					continue;
				}
				
				board.crossOutNumber(n);
				if (board.checkBoardForWin()) {
					winnedBoards++;
				}
				
				if (winnedBoards == boards.size()) {
					System.out.println(board.findSum() * n);
					return;
				}
			}
		}
	}
}
