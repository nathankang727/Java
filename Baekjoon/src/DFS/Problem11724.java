package DFS;
import java.util.*;
import java.io.*;
public class Problem11724 {
	static int n, m;
	static ArrayList<Integer>[] lArray;
	static boolean[] b;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lArray = new ArrayList[n];
		b = new boolean[n];
		for(int i = 0; i < n; i++)
			lArray[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			lArray[n1].add(n2);
			lArray[n2].add(n1);
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(!b[i]) {
				dfs(i);
				++ans;
			}
		}
		System.out.println(ans);
		br.close();
	}
	private static void dfs(int s) {
		if(!b[s]) {
			b[s] = true;
			for(int i : lArray[s])
				if(!b[i])
					dfs(i);
		}
	}
}