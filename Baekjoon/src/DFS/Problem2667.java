package DFS;
import java.util.*;
import java.io.*;
public class Problem2667 {
	static int n;
	static boolean[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++)
				if(Integer.parseInt(s.substring(j, j + 1)) == 1)
					grid[i][j] = true;
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(grid[i][j])
					list.add(dfs(i, j));
		System.out.println(list.size());
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		br.close();
	}
	public static int dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n || !grid[x][y])
			return 0;
		grid[x][y] = false;
		return 1 + dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1);
	}
}