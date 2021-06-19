package GraphTheory;
import java.util.*;
public class Problem1 {
    static ArrayList<Integer>[] a;
    static boolean[] c;
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int start = in.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for (int i = 1; i <= n; i++)
            Collections.sort(a[i]);
        c = new boolean[n + 1];
        dfs(start);
        System.out.println();
        c = new boolean[n + 1];
        bfs(start);
        System.out.println();
        in.close();
    }
    public static void dfs(int x) {
    	c[x] = true;
        System.out.print(x + " ");
        for (int y : a[x])
            if (c[y] == false)
                dfs(y);
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }
}