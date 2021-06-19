import java.util.*;
import java.io.*;
public class BFS_Adjacency {
	static boolean[] v;
	static Queue<Integer> q;
	static ArrayList<Integer>[] a;
	static int n, m, ans;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		v = new boolean[n];
		q = new LinkedList<Integer>();
		a = new ArrayList[n];
		for(int i = 0; i < n; i++)
			a[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			a[x].add(y);
			a[y].add(x);
		}
		System.out.println(bfs(s - 1));
		br.close();
	}
	public static String bfs(int s) {
		v[s] = true;
		String result = "";
		q.add(s);
		while(!q.isEmpty()) {
			int n = q.poll();
			result += (n + 1) + " ";
			for(int i : a[n]) {
				if(v[i])
					continue;
				v[i] = true;
				q.add(i);
			}
		}
		return result;
	}
}
/*
8 7 1
1 2
1 3
2 6
2 7
3 4
3 5
4 8
*/