import java.util.*;
import java.io.*;
public class PolandBallandForest {
	static BufferedReader br;
	static int n;
	static boolean[] v;
	static ArrayList<Integer>[] a;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            solve();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
	private static void init() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	v = new boolean[n + 1];
    	a = new ArrayList[n + 1];
    	for(int i = 1; i <= n; i++)
    		a[i] = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		int y = Integer.parseInt(st.nextToken());
    		a[i].add(y);
    		a[y].add(i);
    	}
    }
    private static void solve() {
    	int ans = 0;
    	for(int i = 1; i <= n; i++) {
    		if(!v[i]) {
    			dfs(i);
    			ans++;
    		}
    	}
        System.out.println(ans / 2);
    }
    private static void dfs(int s) {
    	v[s] = true;
    	for(int i : a[n]) {
			if(v[i])
				continue;
			v[i] = true;
			dfs(i);
    	}
    }
}