package Recursion;
public class LengthofString {
	public static void main(String[] args) {
		System.out.println(ls("nani"));
	}
	public static int ls(String a) {
		if(a.isEmpty())
			return 0;
		else
			return 1 + a.substring(1, a.length()).length();
	}
}