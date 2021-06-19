package HSPC2019H;
import java.util.*;
import java.io.*;
public class Problem8 {
	static int n, m;
	static int[][] maze;
	static int totalGold;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		maze = new int[n][m];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				maze[i][j] = Integer.parseInt(st.nextToken());
		}
		maze[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())] = 3;
		boolean[][] twoDimensionalArray = new boolean[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(maze[i][j] == 2)
					++totalGold;
		int num = traverse(0, 0, 0, 0, twoDimensionalArray);
		if(num == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(num);
	}
	public static int traverse(int x, int y, int count, int goldCount, boolean[][] check) {
		if(x < 0 || y < 0 || x >= n || y >= m || maze[x][y] == 1 || check[x][y] || (maze[x][y] == 3 &&
				goldCount != totalGold))
			return Integer.MAX_VALUE;
		if(maze[x][y] == 2) {
			++goldCount;
			maze[x][y] = 0;
		}
		if(maze[x][y] == 3 && goldCount == totalGold)
			return count;
		check[x][y] = true;
		int n1 = traverse(x + 1, y, count + 1, goldCount, check);
		int n2 = traverse(x - 1, y, count + 1, goldCount, check);
		int n3 = traverse(x, y + 1, count + 1, goldCount, check);
		int n4 = traverse(x, y - 1, count + 1, goldCount, check);
		return Math.min(n1, Math.min(n2, Math.min(n3, n4)));
	}
}