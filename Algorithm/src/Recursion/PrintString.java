package Recursion;
public class PrintString {
	public static void main(String[] args) {
		System.out.println(ps("abcdefghijklmnopqrstuvwxyz"));
	}
	public static String ps(String a) {
		if(a.equals(""))
			return "";
		else {
			System.out.println(a.charAt(0));
			return ps(a.substring(1));
		}
	}
}