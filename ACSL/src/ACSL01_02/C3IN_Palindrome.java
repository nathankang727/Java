package ACSL01_02;
import java.util.*;
import java.io.*;
public class C3IN_Palindrome {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0102C3In.in"));
		for(int i = 0; i < 9; i++) {
			String n = sc.next();
			int b = sc.nextInt();
			for(int j = 0; j < 10; j++) {
				String reverse = backwards(n);
				int bToT = Integer.parseInt(n, b);
				int reverseBToT = Integer.parseInt(reverse, b);
				int sum10 = bToT + reverseBToT;
				String sumB = Integer.toString(sum10, b);
				n = sumB;
				if(isPalindrome(String.valueOf(n)))
					break;
			}
			if(!(isPalindrome(String.valueOf(n))))
				System.out.print("NONE, ");
			System.out.print(n);
			System.out.println();
		}
		sc.close();
	}
	public static String backwards(String n) {
		return new StringBuilder((n)).reverse().toString();
	}
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return s.equals(sb.toString());
	}
}