package Recursion;
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fib(2));
	}
	public static int fib(int a) {
		if(a < 2)
			return 1;
		else
			return fib(a - 2) + fib(a - 1);
	}
}