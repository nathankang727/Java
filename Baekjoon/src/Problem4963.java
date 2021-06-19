import java.util.*;
import java.io.*;
public class Problem4963 {
	static int n, m;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		while(n != 0 || m != 0) {
			grid = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++)
					grid[i][j] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == 1) {
						bfs(i, j);
						++count;
					}
				}
			}
			System.out.println(count);
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
		}
	}
	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		q.add(y);
		grid[x][y] = 0;
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i = 0; i < 8; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx < 0 || xx >= n || yy < 0 || yy >= m || grid[xx][yy] == 0)
					continue;
				q.add(xx);
				q.add(yy);
				grid[xx][yy] = 0;
			}
		}
	}
}