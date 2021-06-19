package Recursion;
public class ReversePrinting {
	public static void main(String[] args) {
		System.out.println(ps("abcdefghijklmnopqrstuvwxyz"));
	}
	public static String ps(String a) {
		if(a.equals(""))
			return "";
		else {
			String a1 = ps(a.substring(1));
			System.out.println(a.charAt(0));
			return a1;
		}
	}
}