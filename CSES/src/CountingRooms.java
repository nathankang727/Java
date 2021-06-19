import java.util.*;
import java.io.*;
public class CountingRooms {
	static int n, m;
	static char grid[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new char[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++)
				grid[i][j] = str.charAt(j);
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == '.') {
					dfs(i, j);
					++count;
				}
			}
		}
		System.out.println(count);
		br.close();
	}
	public static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '#')
			return;
		grid[x][y] = '#';
		dfs(x + 1, y);
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
	}
}