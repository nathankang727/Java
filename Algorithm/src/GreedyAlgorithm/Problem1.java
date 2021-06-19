package GreedyAlgorithm;
import java.util.*;
public class Problem1 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            res += k / a[i];
            k %= a[i];
        }
        System.out.println(res);
        sc.close();
    }
}