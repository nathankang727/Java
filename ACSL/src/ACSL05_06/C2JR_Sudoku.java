package ACSL05_06;
import java.util.*;
import java.io.*;
public class C2JR_Sudoku {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0506C2Jr.in"));
		for(int i = 0; i < 2; i++) {
			int[][] sudoku = new int[10][10];
			for(int j = 1; j <= 9; j++)
				for(int k = 1; k <= 9; k++)
					sudoku[j][k] = sc.nextInt();
			for(int j = 0; j < 5; j++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int[] n = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
				for(int k = 1; k <= 9; k++) {
					if(sudoku[row][k] != 0)
						n[sudoku[row][k]] = 0;
					if(sudoku[k][col] != 0)
						n[sudoku[k][col]] = 0;
				}
				int beginR = 0;
				int endR = 0;
				int beginC = 0;
				int endC = 0;
				if(row >= 1 && row <= 3 && col >= 1 && col <= 3) {
					beginR = 1;
					endR = 3;
					beginC = 1;
					endC = 3;
				}
				else if(row >= 1 && row <= 3 && col >= 4 && col <= 6) {
					beginR = 1;
					endR = 3;
					beginC = 4;
					endC = 6;
				}
				else if(row >= 1 && row <= 3 && col >= 7 && col <= 9) {
					beginR = 1;
					endR = 3;
					beginC = 7;
					endC = 9;
				}
				else if(row >= 4 && row <= 6 && col >= 1 && col <= 3) {
					beginR = 4;
					endR = 6;
					beginC = 1;
					endC = 3;
				}
				else if(row >= 4 && row <= 6 && col >= 4 && col <= 6) {
					beginR = 4;
					endR = 6;
					beginC = 4;
					endC = 6;
				}
				else if(row >= 4 && row <= 6 && col >= 7 && col <= 9) {
					beginR = 4;
					endR = 6;
					beginC = 7;
					endC = 9;
				}
				else if(row >= 7 && row <= 9 && col >= 1 && col <= 3) {
					beginR = 7;
					endR = 9;
					beginC = 1;
					endC = 3;
				}
				else if(row >= 7 && row <= 9 && col >= 4 && col <= 6) {
					beginR = 7;
					endR = 9;
					beginC = 4;
					endC = 6;
				}
				else {
					beginR = 7;
					endR = 9;
					beginC = 7;
					endC = 9;
				}
				for(int r = beginR; r <= endR; r++)
					for(int c = beginC; c <= endC; c++)
						if(sudoku[r][c] != 0)
							n[sudoku[r][c]] = 0;
				for(int k = 1; k < 10; k++)
					if(n[k] == 1)
						System.out.print(k + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}