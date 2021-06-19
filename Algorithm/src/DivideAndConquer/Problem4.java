package DivideAndConquer;
import java.util.*;
import java.io.*;
public class Problem4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				a[i][j] = sc.nextInt();
		for(int i = 3; i <= n; i += 3) {
			for(int j = 3; j <= n; j += 3) {
			}
		}
		sc.close();
	}
}