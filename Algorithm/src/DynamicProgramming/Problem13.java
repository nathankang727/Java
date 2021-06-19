package DynamicProgramming;
import java.util.*;
public class Problem13 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = a[i];
            if(i == 0)
            	continue;
            if (memo[i] < memo[i - 1] + a[i])
                memo[i] = memo[i - 1] + a[i];
        }
        int ans = memo[0];
        for (int i = 0; i < n; i++)
            if (ans < memo[i])
                ans = memo[i];
        System.out.println(ans);
        in.close();
    }
}