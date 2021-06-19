package DynamicProgramming;
import java.util.*;
public class Problem14 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int stairs = in.nextInt();
        int[] points = new int[stairs + 1];
        for (int i = 1; i <= stairs; i++)
            points[i] = in.nextInt();
        int[][] memo = new int[stairs + 1][3];
        memo[1][1] = points[1];
        for (int i = 2; i <= stairs; i++) {
            memo[i][2] = memo[i - 1][1] + points[i];
            memo[i][1] = Math.max(memo[i - 2][1], memo[i - 2][2]) + points[i];
        }
        System.out.println(Math.max(memo[stairs][1], memo[stairs][2]));
        in.close();
    }
}