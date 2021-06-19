package DFS;
import java.util.*;
import java.io.*;
public class DFS01 {
	static BufferedReader br;
	static int[][] a;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m, cnt;
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
	   	n = Integer.parseInt(br.readLine());
	    m = Integer.parseInt(br.readLine());
	    a = new int[n][m];
	    for(int i = 0; i < n; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < m; j++)
	    		a[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	private static void solve() {
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
}