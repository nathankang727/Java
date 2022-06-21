import java.util.*;
import java.io.*;
public class prob02 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		System.out.print(h + " " + m + " " + s + ". ");
		if(m <= h * s)
			System.out.println("I will make it!");
		else
			System.out.println("I will be late!");
		sc.close();
	}
}