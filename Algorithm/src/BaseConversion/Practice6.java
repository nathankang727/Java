package BaseConversion;
import java.util.*;
public class Practice6 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            res = res * a + x;
        }
        convert(res, b);
        System.out.println();
        in.close();
    }
    public static void convert(int num, int base) {
        if (num == 0)
        	return;
        convert(num / base, base);
        System.out.print(num % base + " ");
    }
}