import java.util.*;
import java.io.*;
public class prob28 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[][] c = new char[m][n];
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		for(int i = 0; i < m; i++) {
			String input = br.readLine();
			for(int j = 0; j < n; j++) {
				if(input.charAt(j) == 'T') {
					c[i][j] = '-';
					startX = i;
					startY = j;
				}
				else if(input.charAt(j) == 'D') {
					c[i][j] = '-';
					endX = i;
					endY = j;
				}
				else
					c[i][j] = input.charAt(j);
			}
		}
		System.out.println(bfs(c, startX, startY, endX, endY));
		br.close();
	}
	public static int bfs(char[][] c, int startX, int startY, int endX, int endY) {
		boolean[][] v = new boolean[c.length][c[0].length];
		int[] dirX = {0, 0, 1, -1};
		int[] dirY = {1, -1, 0, 0};
		v[startX][startY] = true;
		Queue<Path> q = new LinkedList<Path>();
		q.add(new Path(startX, startY, 0));
		while(q.size() > 0) {
			int X = q.peek().x;
			int Y = q.peek().y;
			int D = q.peek().d;
			if(X == endX && Y == endY)
				return D;
			q.remove();
			for(int i = 0; i < 4; i++) {
				int row = X + dirX[i];
				int col = Y + dirY[i];
				if(row >= 0 && row < c.length && col >= 0 && col < c[0].length && c[row][col] == '-' && !v[row][col]) {
					v[row][col] = true;
					q.add(new Path(row, col, D + 1));
				}
			}
		}
		return 0;
	}
	static class Path {
		public int x, y, d;
		public Path(int xx, int yy, int distance) {
			this.x = xx;
			this.y = yy;
			this.d = distance;
		}
	}
}