package GreedyAlgorithm;
import java.util.Scanner;
import java.util.Arrays;
public class Problem3 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;
        int ans = 0;
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            sum += a[i];
            ans += sum;
        }
        System.out.println(ans);
        sc.close();
    }
}