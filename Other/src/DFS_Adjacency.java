import java.util.*;
import java.io.*;
public class DFS_Adjacency {
    static boolean v[];
    static ArrayList<Integer>[] a;
    static int n, m;
    static String result;
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        v = new boolean[n];
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
        result = "";
        dfs(s - 1);
        System.out.println(result);
        br.close();
    }
    static void dfs(int s) {
        v[s] = true;
        result += (s + 1) + " ";
        for(int i : a[s]) {
            if(!v[i]) {
                dfs(i);
            }        
        }
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