import java.util.*;
import java.io.*;
public class DFS_BFS {
	static BufferedReader br;
	static int[][] a;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m, cnt;
	static int[][] map;
    static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(new File("xxx.in")));
		//dfs
		n = Integer.parseInt(br.readLine());
	    m = Integer.parseInt(br.readLine());
	    a = new int[n][m];
	    for(int i = 0; i < n; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < m; j++)
	    		a[i][j] = Integer.parseInt(st.nextToken());
		}
	    int ans = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(a[i][j] == 1) {
        			cnt = 0;
        			dfs(i, j);
        			ans++;
        		}
        	}
        }
        System.out.println(ans);
        
        //bfs
        int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	map = new int[n][m];
    	q = new LinkedList<Integer>();
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++)
    			map[i][j] = Integer.parseInt(st.nextToken());
    	}
        int count = 0;
        for(int i = 0; i < map.length; i++) {
        	for(int j = 0; j < map[0].length; j++) {
        		if(map[i][j] == 1) {
        			bfs(i, j);
        			count++;
        		}
        	}
        }
        System.out.println(count);
        br.close();
	}
	static void dfs(int x, int y) {
		cnt++;
		a[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if(a[nx][ny] == 1)
				dfs(nx, ny);
		}
	}
	static void bfs(int r, int c) {
    	q.add(r);
    	q.add(c);
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int y = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nX = x + dx[i];
    			int nY = y + dy[i];
    			if(nX < 0 || nY < 0 || nX >= map.length || nY >= map.length)
    				continue;
    			if(map[nX][nY] == 0)
    				continue;
    			q.add(nX);
    			q.add(nY);
    			map[nX][nY] = 0;
    		}
    	}
    }
}