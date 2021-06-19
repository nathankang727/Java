package Recursion;
public class BinaryPrinting {
	public static void main(String[] args) {
		System.out.println(bp(5));
	}
	public static String bp(int a) {
		if(a == 0)
			return "";
		
		else
			return bp(a / 2) + a % 2;
	}
}