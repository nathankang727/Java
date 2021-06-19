
import java.util.*;
public class GoOverArray {
	public static void main(String[] args) {
		Random q = new Random();
		int[][] a = new int[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				a[i][j] = q.nextInt(100) + 1;
			}
		}
		print2D(a);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(a[i][j] % 2 == 0) {
					//System.out.println(i + " " + j + ": " + a[i][j]);
				}
				if(a[i][j] % 5 == 0) {	
					System.out.println(i + " " + j + ": " + a[i][j]);
				}
			}
		}
		//print2D(a);
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