package GraphTheory;
import java.util.*;
public class Problem3 {
	public static void dfs(ArrayList<Integer>[] a, int[] color, int b, int c) {
        color[b] = c;
        for(int y : a[b])
            if(color[y] == 0)
                dfs(a, color, y, 3 - c);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            @SuppressWarnings("unchecked")
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for(int i = 1; i <= n; i++)
                a[i] = new ArrayList<Integer>();
            for(int i = 0; i < m; i++) {
                int e = sc.nextInt();
                int v = sc.nextInt();
                a[e].add(v);
                a[v].add(e);
            }
            int[] color = new int[n + 1];
            boolean d = true;
            for(int i = 1; i <= n; i++)
                if (color[i] == 0)
                    dfs(a, color, i, 1);
            for(int i = 1; i <= n; i++)
                for (int j : a[i])
                    if (color[i] == color[j])
                        d = false;
            if(d == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}