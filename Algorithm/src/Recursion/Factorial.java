package Recursion;
public class Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(3));
	}
	public static int factorial(int a) {
		if(a < 2)
			return 1;
		else
			return a * factorial(a - 1);
	}
}