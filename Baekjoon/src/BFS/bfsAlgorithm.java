package BFS;
import java.util.*;
public class bfsAlgorithm {
	public static void main(String[] args) {
		int N = 5;
		visited = new boolean[N][N];
	}
	static int N;
	static int[][] graph = {{1, 1, 0, 0, 1}, {0, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 1}, {1, 1, 1, 0, 0}};
	static boolean[][] visited;
	public static int bfs(int x, int y) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			if(loc[0] < 0 || loc[0] >= N || loc[1] < 0 || loc[1] >= N)
				continue;
			if(graph[loc[0]][loc[1]] == 0)
				continue;
			if(visited[loc[0]][loc[1]])
				continue;
			visited[loc[0]][loc[1]] = true;
			++cnt;
			q.add(new int[] {x - 1, y});
			q.add(new int[] {x + 1, y});
			q.add(new int[] {x, y - 1});
			q.add(new int[] {x, y + 1});
		}
		return cnt;
	}
}