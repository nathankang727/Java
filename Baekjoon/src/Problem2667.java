import java.util.*;
import java.io.*;
public class Problem2667 {
	static int n;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++)
				grid[i][j] = Integer.parseInt(str.substring(j, j + 1));
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(grid[i][j] == 1)
					list.add(bfs(i, j));
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		br.close();
	}
	public static int bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 1;
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
				++count;
			}
		}
		return count;
	}
}