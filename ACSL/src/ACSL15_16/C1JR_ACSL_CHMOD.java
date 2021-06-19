/*
Start Time: 12:01
End Time: 12:10
*/
package ACSL15_16;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_CHMOD {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1516C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			int[] a = new int[3];
			for(int j = 0; j < 3; j++)
				a[j] = sc.nextInt();
			for(int j = 0; j < 3; j++)
				octalToBinary(a[j]);
			System.out.print("and ");
			for(int j = 0; j < 3; j++)
				permission(a[j]);
			System.out.println();
		}
		sc.close();
	}
	public static void octalToBinary(int n) {
		if(n == 0)
			System.out.print("000" + " ");
		else if(n == 1)
			System.out.print("001" + " ");
		else if(n == 2)
			System.out.print("010" + " ");
		else if(n == 3)
			System.out.print("011" + " ");
		else if(n == 4)
			System.out.print("100" + " ");
		else if(n == 5)
			System.out.print("101" + " ");
		else if(n == 6)
			System.out.print("110" + " ");
		else if(n == 7)
			System.out.print("111" + " ");
		else
			return;
	}
	public static void permission(int n) {
		if(n == 0)
			System.out.print("---" + " ");
		else if(n == 1)
			System.out.print("--x" + " ");
		else if(n == 2)
			System.out.print("-w-" + " ");
		else if(n == 3)
			System.out.print("-wx" + " ");
		else if(n == 4)
			System.out.print("r--" + " ");
		else if(n == 5)
			System.out.print("r-x" + " ");
		else if(n == 6)
			System.out.print("rw-" + " ");
		else if(n == 7)
			System.out.print("rwx" + " ");
		else
			return;
	}
}