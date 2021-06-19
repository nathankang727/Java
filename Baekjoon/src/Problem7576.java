import java.util.*;
import java.io.*;
public class Problem7576 {
	static int n, m;
	static int[][] grid;
	static Queue<Integer> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean findZero = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 0) {
					findZero = true;
					break;
				}
			}
		}
		if(!findZero)
			System.out.println("0");
		else {
			q = new LinkedList<Integer>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == 1) {
						q.add(i);
						q.add(j);
					}
				}
			}
			bfs();
			findZero = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == 0) {
						findZero = true;
						break;
					}
				}
				if(findZero)
					break;
			}
			if(findZero)
				System.out.println("-1");
			else {
				int max = 1;
				for(int i = 0; i < n; i++)
					for(int j = 0; j < m; j++)
						if(max < grid[i][j])
							max = grid[i][j];
				System.out.println(max - 1);
			}
		}
		br.close();
	}
	public static void bfs() {
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int y = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= n || yy < 0 || yy >= m || grid[xx][yy] != 0)
                	continue;
                q.add(xx);
                q.add(yy);
                grid[xx][yy] = grid[x][y] + 1;
    		}
    	}
    }
}