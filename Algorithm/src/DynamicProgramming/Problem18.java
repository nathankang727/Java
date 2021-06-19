package DynamicProgramming;
import java.util.*;
public class Problem18 {
    public static long mod = 1000000000L;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[][] d = new long[k + 1][n + 1];
        d[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    d[i][j] += d[i - 1][j - l];
                    d[i][j] %= mod;
                }
            }
        }
        System.out.println(d[k][n]);
        in.close();
    }
}