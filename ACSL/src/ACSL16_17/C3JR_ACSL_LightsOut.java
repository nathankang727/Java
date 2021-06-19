package ACSL16_17;
import java.util.*;
import java.io.*;
public class C3JR_ACSL_LightsOut {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1617C3Jr.in"));
		for(int i = 0; i < 10; i++) {
			int[][] board = {{2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0, 0}};
			int rowsOn = sc.nextInt();
			for(int j = 0; j < rowsOn; j++) {
				String row = sc.next();
				for(int k = 1; k <= row.length() - 1; k++)
					board[Integer.parseInt(row.substring(0, 1))][Integer.parseInt(row.substring(k, k + 1))] = 1;
			}
			String push = sc.next();
			int r = Integer.parseInt(push.substring(0, 1));
			int c = Integer.parseInt(push.substring(1, 2));
			board[r][c] = swap(board[r][c]);
			if(r + 1 <= 8 && c + 1 <= 8)
				board[r + 1][c + 1] = swap(board[r + 1][c + 1]);
			if(r + 1 <= 8 && c - 1 >= 1)
				board[r + 1][c - 1] = swap(board[r + 1][c - 1]);
			if(r - 1 >= 1 && c + 1 <= 8)
				board[r - 1][c + 1] = swap(board[r - 1][c + 1]);
			if(r - 1 >= 1 && c - 1 <= 8)
				board[r - 1][c - 1] = swap(board[r - 1][c - 1]);
			if(c + 1 <= 8)
				board[r][c + 1] = swap(board[r][c + 1]);
			if(c + 2 <= 8)
				board[r][c + 2] = swap(board[r][c + 2]);
			if(c - 1 >= 1)
				board[r][c - 1] = swap(board[r][c - 1]);
			if(c - 2 >= 1)
				board[r][c - 2] = swap(board[r][c - 2]);
			if(r + 1 <= 8)
				board[r + 1][c] = swap(board[r + 1][c]);
			if(r + 2 <= 8)
				board[r + 2][c] = swap(board[r + 2][c]);
			if(r - 1 >= 1)
				board[r - 1][c] = swap(board[r - 1][c]);
			if(r - 2 >= 1)
				board[r - 2][c] = swap(board[r - 2][c]);
			int on = 0;
			for(int j = 1; j <= 8; j++)
				for(int k = 1; k <= 8; k++)
					if(board[j][k] == 1)
						on++;
			System.out.println(on);
		}
		sc.close();
	}
	public static int swap(int n) {
		if(n == 1)
			return 0;
		else
			return 1;
	}
}