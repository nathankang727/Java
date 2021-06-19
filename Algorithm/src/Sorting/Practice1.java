package Sorting;
import java.util.*;
public class Practice1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] b = new int[a];
		for(int i = 0; i < a; i++)
			b[i] = in.nextInt();
		Arrays.sort(b);
		for(int i = 0; i < a; i++)
			System.out.println(b[i]);
		in.close();
	}
}