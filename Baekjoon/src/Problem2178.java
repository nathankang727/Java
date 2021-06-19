import java.io.*;
import java.util.*;
public class Problem2178 {
	static int n, m;
    static int[][] maze;
    static Queue<Integer> q;
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	maze = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < m; j++)
    			maze[i][j] = Integer.parseInt(s.substring(j, j + 1));
    	}
    	System.out.println(bfs(0, 0));
    	br.close();
    }
    public static int bfs(int x, int y) {
    	q = new LinkedList<Integer>();
    	q.add(x);
    	q.add(y);
    	maze[x][y] = 2;
    	while(!q.isEmpty()) {
    		x = q.poll();
    		y = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= n || yy < 0 || yy >= m || maze[xx][yy] != 1)
                	continue;
                q.add(xx);
                q.add(yy);
                maze[xx][yy] = maze[x][y] + 1;
    		}
    	}
    	return maze[n - 1][m - 1] - 1;
    }
}