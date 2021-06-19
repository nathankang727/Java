package Recursion;
public class ExponentialNumber {
	public static void main(String[] args) {
		System.out.println(en(4));
	}
	public static double en(double a) {
		if(a < 2)
			return 1;
		else
			return a * Math.pow(a, a - 1) ;
	}
}