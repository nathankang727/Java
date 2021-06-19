package HSPC2017;
import java.util.*;
import java.io.*;
public class Problem8 {
	static int[][] map;
	static int m, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		map = new int[m][n];
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					dfs(i, j);
					++count;
				}
			}
		}
		System.out.println(count);
	}
	public static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= m || y >= n || map[x][y] == 0)
			return;
		map[x][y] = 0;
		dfs(x + 1, y);
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
	}
}