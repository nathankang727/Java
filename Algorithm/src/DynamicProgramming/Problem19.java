package DynamicProgramming;
import java.util.*;
public class Problem19 {
    public static int mod = 1000000;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        int n = s.length();
        s = " " + s;
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = s.charAt(i) - '0';
            if (1 <= x && x <= 9) {
                memo[i] += memo[i - 1];
                memo[i] %= mod;
            }
            if (i==1)
                continue;
            if (s.charAt(i - 1) == '0')
                continue;
            x = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (10 <= x && x <= 26) {
                memo[i] += memo[i - 2];
                memo[i] %= mod;
            }
        }
        System.out.println(memo[n]);
        in.close();
    }
}