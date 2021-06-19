package ACSL20_21;
import java.io.*;
class C1JR_2021Result {
    public static int sumOfLastRow(int s, int d, int r) {
        int sum = 0;
        int num = 0;
        for(int i = r - 1; i >= 0; i--)
            num += i;
        s += num * d;
        for(int i = 0; i < r; i++) {
            int n = s;
            while(n > 9)
                n = transform(n);
            sum += n;
            s += d;
        }
        return sum;
    }
    public static int transform(int n) {
        String str = String.valueOf(n);
        int digitSum = 0;
        for(int i = 0; i < str.length(); i++)
            digitSum += Integer.parseInt(str.substring(i, i + 1));
        return digitSum;
    }
}
public class C1JR_NumeralTriangles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bufferedReader.readLine().trim());
        int d = Integer.parseInt(bufferedReader.readLine().trim());
        int r = Integer.parseInt(bufferedReader.readLine().trim());
        int result = C1JR_2021Result.sumOfLastRow(s, d, r);
        System.out.println(String.valueOf(result));
        bufferedReader.close();
    }
}