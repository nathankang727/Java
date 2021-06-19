package ACSL14_15;
import java.util.*;
import java.io.*;
public class C3JR_Isola {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1415C3Jr.in"));
		for(int i = 0; i < 5; i++) {
			int[][] board = new int[8][8];
			int t = in.nextInt();
			int x = in.nextInt();
			int count = 1;
			int count2 = 0;
			ArrayList<Integer> boundaries = new ArrayList<Integer>();
			while(boundaries.get(count2) == 0) {
				boundaries.add(in.nextInt());
				count2++;
			}
			for(int r = 1; r < 7; r++) {
				for(int c = 1; c < 7; c++) {
					board[r][c] = count;
					count++;
				}
			}
			for(int j = 1; j < boundaries.size() - 1; j++) {
				for(int r = 1; r < 7; r++) {
					for(int c = 1; c < 7; c++) {
						if(board[r][c] == boundaries.get(j) || board[r][c] == t)
							board[r][c] = 0;
						if(board[r][c] == x)
							board[r][c] = -1;
						print2D(board);
					}
				}
			}
			in.close();
		}
	}
	public static void print2D(int[][] a) {
		for(int r = 0; r < a.length; r++) {
			for(int  c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}
}