package DynamicProgramming;
import java.io.*;
public class Problem3 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] d = new int[11];
        d[0] = 1;
        for (int i=1; i<=10; i++)
            for (int j=1; j<=3; j++)
                if (i-j >= 0)
                    d[i] += d[i-j];
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
            t--;
        }
    }
}