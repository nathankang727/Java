package GraphTheory;
import java.util.*;
public class Problem4 {
	 public static void dfs(int[] a, boolean[] b, int c) {
		 if (b[c]) 
			 return;
	     b[c] = true;
	     dfs(a, b, a[c]);
	 }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n + 1];
            boolean[] c = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();
                c[i] = false;
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (c[i] == false) {
                    dfs(b, c, i);
                    res++;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}