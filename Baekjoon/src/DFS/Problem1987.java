package DFS;
import java.util.*;
import java.io.*;
public class Problem1987 {
	static int r, c;
	static char[][] grid;
	static boolean[] chk_alpha = new boolean[26];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		grid = new char[r][c];
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++)
				grid[i][j] = s.charAt(j);
		}
		System.out.println(dfs(0, 0, grid[0][0]));
	}
	public static int dfs(int x, int y, int chk) {
		chk_alpha[chk - 'A'] = true;
		int ans = 0;
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
				int next = grid[nx][ny];
				if(!chk_alpha[next - 'A']) {
					chk_alpha[next - 'A'] = true;
					ans = Math.max(ans, dfs(nx, ny, next));
					chk_alpha[next - 'A'] = false;
				}
			}
		}
		return ans + 1;
	}
}