package Math;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println((a + b) % c);
        System.out.println((a + b) % c);
        System.out.println((a * b) % c);
        System.out.println((a * b) % c);
        in.close();
	}
}