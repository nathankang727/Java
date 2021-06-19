package HSPC2018;
import java.util.*;
import java.io.*;
public class Problem8 {
	static int[][] spaceship;
	static int[][] land;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowS = Integer.parseInt(br.readLine());
		int colS = Integer.parseInt(br.readLine());
		spaceship = new int[rowS][colS];
		for(int i = 0; i < rowS; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < colS; j++)
				spaceship[i][j] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		land = new int[m][n];
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				land[i][j] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		int[] coordinates = new int[2];
		for(int i = 0; i <= m - rowS; i++) {
			for(int j = 0; j <= n - colS; j++) {
				int num = check(i, j);
				if(num < min) {
					min = num;
					coordinates[0] = i;
					coordinates[1] = j;
				}
			}
		}
		System.out.println("[" + coordinates[0] + ", " + coordinates[1] + "]");
	}
	public static int check(int r, int c) {
		int index = land[r][c];
		for(int i = r; i < r + spaceship.length; i++)
			for(int j = c; j < c + spaceship[0].length; j++)
				if(index != land[i][j] && spaceship[i - r][j - c] == 1)
					return Integer.MAX_VALUE;
		return index;
	}
}