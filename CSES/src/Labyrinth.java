import java.util.*;
import java.io.*;
public class Labyrinth {
	static int n, m;
	static char grid[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new char[n][m];
		Point a = new Point(0, 0);
		Point b = new Point(0, 0);
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				char input2 = input.charAt(j);
				if(input2 == 'A')
					a = new Point(i, j);
				else if(input2 == 'B')
					b = new Point(i, j);
				grid[i][j] = input2;
			}
		}
		String ans = bfs(a, b);
		if(ans.length() == 0)
			System.out.println("NO");
		else
			System.out.println("YES\n" + ans.length() + "\n" + ans);		
		br.close();
	}
	static class Point {
		public int x;
		public int y;
		public Point(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
	static class qClass {
		public int x;
		public int y;
		public String p;
		public qClass(int xx, int yy, String path) {
			this.x = xx;
			this.y = yy;
			this.p = path;
		}
	}
	public static String bfs(Point a, Point b) {
		int[] rDirect = {-1, 1, 0, 0};
		int[] cDirect = {0, 0, -1, 1};
		Queue<qClass> queue = new LinkedList<qClass>();
		boolean[][] v = new boolean[n][m];
		v[a.x][a.y] = true;
		queue.add(new qClass(a.x, a.y , ""));
		while(!queue.isEmpty()) {
			qClass temp = queue.peek();
			int x = temp.x;
			int y = temp.y;
			if(x == b.x && y == b.y)
				return temp.p;
			queue.remove();
			for(int i = 0; i < 4; i++) {
				int r = x + rDirect[i];
				int c = y + cDirect[i];
				if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] != '#' && !v[r][c]) {
					v[r][c] = true;
					if(i == 0)
						queue.add(new qClass(r, c, temp.p + "U"));
					else if(i == 1)
						queue.add(new qClass(r, c, temp.p + "D"));
					else if(i == 2)
						queue.add(new qClass(r, c, temp.p + "L"));
					else
						queue.add(new qClass(r, c, temp.p + "R"));
				}
			}
		}
		return "";
	}
}