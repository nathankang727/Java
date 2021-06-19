package GraphTheory;
import java.util.*;
public class Problem2 {
	public static void dfs(ArrayList<Integer>[] a, boolean[] b, int c) {
        if (b[c])
            return;
        b[c] = true;
        for (int i : a[c])
            if (b[i] == false)
                dfs(a, b, i);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        @SuppressWarnings("unchecked")
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[x + 1];
        for (int i = 1; i <= x; i++)
            a[i] = new ArrayList<Integer>();
        for (int i = 0; i < y; i++) {
            int e = sc.nextInt();
            int v = sc.nextInt();
            a[e].add(v);
            a[v].add(e);
        }
        boolean[] check = new boolean[x + 1];
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            if (check[i] == false) {
                dfs(a, check, i);
                ans += 1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}