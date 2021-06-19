import java.util.*;
import java.io.*;
public class prob05 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		int c = Integer.parseInt(sc.nextLine());
		System.out.println(a + " * (" + b + " + " + c + ") = " + a + " * " + b + " + " + a + " * " + c);
		System.out.println(a + " * " + (b + c) + " = " + (a * b) + " + " + (a * c));
		System.out.println(a * (b + c) + " = " + (a * b + a * c));
		sc.close();
	}
}
