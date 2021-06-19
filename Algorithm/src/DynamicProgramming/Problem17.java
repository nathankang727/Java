package DynamicProgramming;
import java.util.*;
public class Problem17 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long[] d = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
        d = Arrays.copyOf(d, 101);
        for (int i = 10; i <= 100; i++)
            d[i] = d[i - 1] + d[i - 5];
        int t = in.nextInt();
        int[] a = new int[t];
        for(int i = 0; i < t; i++)
        	a[i] = in.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(d[a[i]]);
        in.close();
    }
}