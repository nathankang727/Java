package ACSL12_13;
import java.io.*;
public class C3JR_ChessQueen {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1213C3Jr.in")));
		for(int i = 0; i < 10; i++) {
			String s = br.readLine().replace(" ", "");
			int queenRow = Integer.parseInt(s.substring(0, 1));
			int queenCol = Integer.parseInt(s.substring(1, 2));
			int n = Integer.parseInt(s.substring(2));
			int safes = 0;
			boolean[][] board = new boolean[6][6];
			for(int j = 1; j < 6; j++)
				for(int k = 1; k < 6; k++)
					board[j][k] = true;
			for(int r = queenRow - n; r <= queenRow + n; r++)
				if(r >= 1 && r <= 5)
					board[r][queenCol] = false;
			for(int c = queenCol - n; c <= queenCol + n; c++)
				if(c >= 1 && c <= 5)
					board[queenRow][c] = false;
			for(int j = 1; j <= n; j++) {
				if(queenRow - j >= 1 && queenCol - j >= 1)
					board[queenRow - j][queenCol - j] = false;
				if(queenRow + j <= 5 && queenCol + j <= 5)
					board[queenRow + j][queenCol + j] = false;
				if(queenRow - j >= 1 && queenCol + j <= 5)
					board[queenRow - j][queenCol + j] = false;
				if(queenRow + j <= 5 && queenCol - j >= 1)
					board[queenRow + j][queenCol - j] = false;
			}
			for(int j = 1; j <= 5; j++)
				for(int k = 1; k <= 5; k++)
					if(board[j][k])
						safes++;
			System.out.println(safes);
		}
		br.close();
	}
}