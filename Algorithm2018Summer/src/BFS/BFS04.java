package BFS;
import java.io.*;
import java.util.*;
public class BFS04 {
    static BufferedReader br;
    static ArrayList<Integer>[] a;
    static int n, m, s;
    static boolean[] v;
    static Queue<Integer> q;
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
    	m = Integer.parseInt(br.readLine());
    	s = Integer.parseInt(br.readLine());
    	v = new boolean[n + 1];
    	a = new ArrayList[n + 1];
    	q = new LinkedList<Integer>();
    	for(int i = 1; i <= n; i++)
    		a[i] = new ArrayList<Integer>();
    	for(int i = 0; i <= m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		a[x].add(y);
    		a[y].add(x);
    	}
    }
    private static void solve() {
        System.out.println(bfs(s));
    }
    static String bfs(int s) {
    	v[s] = true;
    	String result = "";
    	q.add(s);
    	while(!q.isEmpty()) {
    		int n = q.poll();
    		result += n + " ";
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