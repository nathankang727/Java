package BaseConversion;
import java.util.Scanner;
public class Practice1 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int r = n % b;
            if (r < 10) {
                ans.append((char)(r + '0'));
            } else {
                ans.append((char)(r - 10 + 'A'));
            }
            n /= b;
        }
        System.out.println(ans.reverse());
        sc.close();
    }
}