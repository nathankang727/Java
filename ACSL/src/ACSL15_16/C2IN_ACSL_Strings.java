package ACSL15_16;
import java.util.*;
import java.io.*;
public class C2IN_ACSL_Strings {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1516C2In.in"));
		for(int i = 0; i < 2; i++) {
			//1
			String s1 = sc.next();
			int n1 = sc.nextInt();
			char c1 = sc.next().charAt(0);
			String res1 = char_split(s1, n1, c1);
			System.out.println(res1);
			//2
			String s2 = sc.next();
			String delete = sc.next();
			String res2 = strrem(s2, delete);
			System.out.println(res2);
			//3
			String s3 = sc.next();
			String c3 = sc.next();
			String res3 = strchr(s3, c3);
			System.out.println(res3);
			//4
			String s4 = sc.next();
			String c4 = sc.next();
			String res4 = strtok(s4, c4);
			System.out.println(res4);
			//5
			String s5 = sc.next();
			int n5 = sc.nextInt();
			String c5 = sc.next();
			String res5 = wordwrap(s5, n5, c5);
			System.out.println(res5);
		}
		sc.close();
	}
	public static String char_split(String s1, int n1, char c1) {
		String res = "";
		for(int j = 0; j < s1.length() - (n1 + 1); j += n1)
			res += s1.substring(j, j + n1) + c1;
		if(s1.length() % n1 == 1)
			res += s1.substring(s1.length() - 3, s1.length() - 1) + "*" + s1.charAt(s1.length() - 1);
		else
			res += s1.substring(s1.length() - n1, s1.length());
		return res;
	}
	public static String strrem(String s2, String delete) {
		String res = "";
		for(int j = 0; j <= s2.length() - delete.length(); j += delete.length())
			if(!(s2.substring(j, j + delete.length()).equals(delete)))
				res += s2.substring(j, j + delete.length());
		if(s2.length() % delete.length() != 0)
			res += s2.substring(s2.length() - (delete.length() - 1), s2.length());
		return res;
	}
	public static String strchr(String s3, String c3) {
		int index3 = s3.indexOf(c3);
		return s3.substring(0, index3);
	}
	public static String strtok(String s4, String c4) {
		String res = "";
		for(int j = 0; j < s4.length(); j++) {
			if(s4.substring(j, j + c4.length()).equals(c4))
				res += " ";
			res += s4.charAt(j);
		}
		return res;
	}
	public static String wordwrap(String s5, int n5, String c5) {
		String res = "";
		int count = 0;
		for(int j = 0; j < s5.length(); j++) {
			if(s5.substring(j, j + c5.length()).equals(c5)) {
				res += " ";
				count = 0;
			}
			res += s5.substring(j, j + c5.length());
			count++;
			if(count == n5) {
				res += " ";
				count = 0;
			}
		}
		return res;
	}
}