import java.util.*;
import java.io.*;
public class Rumor {
	static int n, m;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	static int[] money;
	static int count = 0;
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
    	st = new StringTokenizer(br.readLine());
    	money = new int[n + 1];
    	for(int i = 1; i <= n; i++)
    		money[i] = Integer.parseInt(st.nextToken());
    	for(int i = 1; i < n + 1; i++)
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
    	long cost = 0;
        for(int i = 1; i <= n; i++)
        	if(!v[i])
        		cost += dfs(i);
        System.out.println(cost);
    }
    private static long dfs(int i) {
    	v[i] = true;
    	long min = money[i];
    	for(int c : a[i])
    		if(!v[c])
    			min = Math.min(min,  dfs(c));
    	return min;
    }
}