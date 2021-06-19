package GreedyAlgorithm;
import java.util.*;
public class Problem6 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        int res = 0;
        while(g >= 2 && b >= 1 && g + b >= k + 3) {
            res++;
            g -= 2;
            b--;
        }
        System.out.println(res);
        sc.close();
	}
}