import java.util.*;
import java.io.*;
public class Problem2146 {
	static int n, flag;
	static int[][] a, b;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<Integer> q1, q2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		b = new int[n][n];
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 1) {
					q1.add(i);
					q1.add(j);
					q2.add(i);
					q2.add(j);
				}
				if(a[i][j] == 0)
					b[i][j] = -1;
			}
		}
		flag = 2;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1) {
					bfs(i, j);
					++flag;
				}
			}
		}
		bfs2();
		bfs3();
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
		     for(int j = 0; j < n; j++) {
		         for(int k = 0; k < 4; k++) {
		              int x = i + dx[k];
		              int y = j + dy[k];
		              if(x < 0 || x >= n || y < 0 || y >= n)
		            	  continue;
		              if(a[i][j] != a[x][y])
		            	  ans = Math.min(ans, b[i][j] + b[x][y]);
		          }
		     }
		}
		System.out.println(ans);
	}
	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		q.add(y);
		a[x][y] = flag;
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if(a[nx][ny] == 1) {
					a[nx][ny] = flag;
					q.add(nx);
					q.add(ny);
				}
			}
		}
	}
	public static void bfs2() {
		while(!q1.isEmpty()) {
			int x = q1.poll();
			int y = q1.poll();
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if(a[nx][ny] == 0) {
					a[nx][ny] = a[x][y];
					q1.add(nx);
					q1.add(ny);
				}
			}
		}
	}
	public static void bfs3() {
		while(!q2.isEmpty()) {
			int x = q2.poll();
			int y = q2.poll();
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if(b[nx][ny] == -1) {
					b[nx][ny] = b[x][y] + 1;
					q2.add(nx);
					q2.add(ny);
				}
			}
		}
	}
}