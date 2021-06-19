package ACSL01_02;
import java.io.*;
public class C3JR_Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("0102C3Jr.in"));
		for(int i = 0; i < 8; i++) {
			//input
			int n = Integer.parseInt(br.readLine());
			//processing
			for(int j = 0; j < 10; j++) {
				//reverse n
				String nB = backwards(n);
				int numberBackwards = Integer.parseInt(nB);
				//add n + reversed n
				n += numberBackwards;
				//check if n is palindrome
				if(isPalindrome(String.valueOf(n)))
					break;
			}
			//check if n is NOT a palindrome
			if(!(isPalindrome(String.valueOf(n))))
				System.out.print("NONE, ");
			//print n
			System.out.print(n);
			System.out.println();
			br.close();
		}
	}
	public static String backwards(int n) {
		return new StringBuilder((n + "")).reverse().toString();
	}
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return s.equals(sb.toString());
	}
}