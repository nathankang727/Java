import java.util.*;
import java.io.*;
public class Problem2468 {
	static int n;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int max = 1;
		int[][] ggrid = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				ggrid[i][j] = Integer.parseInt(st.nextToken());
		}
		//anything BELOW depth is submerged
		for(int depth = 1; depth < 102; depth++) {
			grid = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					grid[i][j] = ggrid[i][j] < depth ? 0 : 1;
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(grid[i][j] == 1) {
						bfs(i, j);
						++count;
					}
				}
			}
			if(count > max)
				max = count;
		}
		System.out.println(max);
		br.close();
	}
	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		q.add(y);
		grid[x][y] = 0;
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx < 0 || xx >= n || yy < 0 || yy >= n || grid[xx][yy] == 0)
					continue;
				q.add(xx);
				q.add(yy);
				grid[xx][yy] = 0;
			}
		}
	}
}