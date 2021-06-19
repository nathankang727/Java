package Recursion;
public class FactorialIteration {
	public static void main(String[] args) {
		System.out.println(fi(3));
	}
	public static int fi(int a) {
		int res = 1;
		for(int i = 1; i <= a; i++)
			res *= i;
		return res;
	}
}