package BFS;
import java.util.*;
import java.io.*;
public class BFS03 {
	static BufferedReader br;
	static int[][] map;
	static Queue<Integer> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		try {
            br = new BufferedReader(new FileReader(new File("BFS01.in")));
            init();
            solve();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}
	private static void init() throws IOException {
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	map = new int[n][m];
    	q = new LinkedList<Integer>();
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++)
    			map[i][j] = Integer.parseInt(st.nextToken());
    	}
    }
	private static void solve() {
		int max = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					int n = bfs(i, j);
					if(n > max)
						max = n;
				}
			}
		}
		System.out.println(max);
	}
	private static int bfs(int r, int c) {
		int count = 0;
		q.add(r);
		q.add(c);
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int i = 0; i < 4; i++) {
				int nX = x + dx[i];
    			int nY = y + dy[i];
    			if(nX < 0 || nY < 0 || nX >= map.length || nY >= map[0].length)
    				continue;
    			if(map[nX][nY] == 0)
    				continue;
    			q.add(nX);
    			q.add(nY);
    			map[nX][nY] = 0;
    			count++;
			}
		}
		return count;
	}
}