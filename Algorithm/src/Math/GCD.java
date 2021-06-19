 package Math;
import java.util.*;
public class GCD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = Integer.parseInt(in.nextLine());
		int b = Integer.parseInt(in.nextLine());
		System.out.println(gcd(a, b));
		in.close();
	}
	public static int gcd(int a, int b) {
		if(b == 0)
			return 0;
		else
			return gcd(b, a % b);
	}
}