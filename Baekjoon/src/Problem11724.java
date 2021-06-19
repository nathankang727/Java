import java.util.*;
import java.io.*;
public class Problem11724 {
	static int n, m;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	public static void main(String[] args) {
        try {
            init();
            solve();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	@SuppressWarnings("unchecked")
	private static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	a = new ArrayList[n + 1];
    	v = new boolean[n + 1];
    	for(int i = 0; i < n + 1; i++)
    		a[i] = new ArrayList<Integer>();
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		a[n1].add(n2);
    		a[n2].add(n1);
    	}
    	br.close();
    }
    private static void solve() {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
        	if(!v[i]) {
        		dfs(i);
        		ans++;
        	}
        }
        System.out.println(ans);
    }
    private static void dfs(int s) {
    	if(!v[s]) {
    		v[s] = true;
    		for(int i : a[s])
    			if(!v[i])
    				dfs(i);
    	}
    }
}