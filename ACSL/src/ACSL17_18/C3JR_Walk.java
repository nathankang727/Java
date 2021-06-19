/*
Nathan Kang, 6th Grade
acobot
ACSL 2017-2018 3rd Contest
Thursday, February 8, 2018
*/
package ACSL17_18;
import java.util.*;
import java.io.*;
public class C3JR_Walk {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1718C3Jr.in"));
		int[][] board = new int[5][5];
		int[][] a = new int[5][5];
		int[] values = new int[5];
		for(int j = 1; j < 5; j++)
			values[j] = in.nextInt();
		for(int r = 1; r < 5; r++) {
			for(int c = 4; c > 0; c--) {
				if(values[r] == 0)
					board[r][c] = 0;
				board[r][c] = values[r] % 10;
				values[r] /= 10;
			}
		}
		for(int r = 1; r < 5; r++)
			for(int c = 1; c < 5; c++)
				a[r][c] = board[r][c];
		for(int i = 0; i < 5; i++) {
			int c1 = in.nextInt();
			int c2 = in.nextInt();
			int uc = c1;
			int uc2 = c2;
			for(int j = 0; j < 6; j++) {
				uc = c1;
				uc2 = c2;
				if(board[c1][c2] == 0)
					c2 = c2 + 1;
				else if(board[c1][c2] == 1)
					c2 = c2 - 1;
				else if(board[c1][c2] == 2)
					c1 = c1 - 1;
				else if(board[c1][c2] == 3)
					c1 = c1 + 1;
				board[uc][uc2]++;
				if(board[uc][uc2] == 4)
					board[uc][uc2] = 0;
				if(c1 == 5)
					c1 = 1;
				if(c1 == 0)
					c1 = 4;
				if(c2 == 5)
					c2 = 1;
				if(c2 == 0)
					c2 = 4;
			}
			System.out.println(c1 + " " + c2);
			for(int r = 1; r < 5; r++)
				for(int c = 1; c < 5; c++)
					board[r][c] = a[r][c];
		}
		in.close();
	}
}