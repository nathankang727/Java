package DynamicProgramming;
import java.util.Scanner;
public class Problem15 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] memo = new int[number + 10];
        for(int i = 1; i <= number; i++) {
            memo[i] = i;
            if(i == 0)
            	continue;
            for(int j = 1; j * j <= i; j++)
                if(memo[i] > memo[i - j * j] + 1)
                	memo[i] = memo[i - j * j] + 1;
        }
        System.out.println(memo[number]);
        in.close();
    }
}