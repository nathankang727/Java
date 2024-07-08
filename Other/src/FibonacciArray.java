public class FibonacciArray {
	public static void main(String[] args) {
		int[] fibonacci = new int[100];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for(int i = 2; i < 100; i++)
			fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
	}
}