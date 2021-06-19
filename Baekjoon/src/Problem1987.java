import java.util.*;
import java.io.*;
public class Problem1987 {
	static BufferedReader br;
	static int n;
	static int m;
	static char[][] map;
	static char c;
    static Queue<Integer> q;
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            solve();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new char[n][m];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < m; j++)
    			map[i][j] = s.charAt(j);
    	}
    	c = map[0][0];
    	q = new LinkedList<Integer>();
    }
    private static void solve() {
    	int maxCount = 0;
        for(int i = 0; i < map.length; i++) {
        	for(int j = 0; j < map[0].length; j++) {
        		if(map[i][j] != c) {
        			int n = bfs(i, j);
        			if(n > maxCount)
        				maxCount = n;
        		}
        	}
        }
        System.out.println(maxCount);
    }
    private static int bfs(int r, int col) {
    	q.add(r);
    	q.add(col);
    	int count = 0;
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int y = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nX = x + dx[i];
    			int nY = y + dy[i];
    			if(nX < 0 || nY < 0 || nX >= map.length || nY >= map[0].length)
    				continue;
    			if(map[nX][nY] == c)
    				continue;
    			char character = map[nX][nY];
    			q.add(nX);
    			q.add(nY);
    			for(int j = 0; j < n; j++)
    				for(int k = 0; k < m; k++)
    					if(map[j][k] == character)
    						map[j][k] = c;
    			count++;
    		}
    	}
    	return count;
    }
}