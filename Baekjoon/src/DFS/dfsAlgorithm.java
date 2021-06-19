package DFS;
public class dfsAlgorithm {
	public static void main(String[] args) {
		int N = 5;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(!visited[i][j])
					dfs(i, j);
	}
	//algorithm #1
	static int N;
	static int[][] graph = {{1, 1, 0, 0, 1}, {0, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 1}, {1, 1, 1, 0, 0}};
	static boolean[][] visited;
	public static int dfs(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N)
			return 0;
		if(graph[x][y] == 0)
			return 0;
		if(visited[x][y])
			return 0;
		visited[x][y] = true;
		return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
	}
	//algorithm #2
	static int cnt = 0;
	public static void dfs2(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N)
			return;
		if(graph[x][y] == 0)
			return;
		if(visited[x][y])
			return;
		visited[x][y] = true;
		++cnt;
		dfs2(x + 1, y);
		dfs2(x - 1, y);
		dfs2(x, y + 1);
		dfs2(x, y - 1);
	}
}