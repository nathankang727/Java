/*
Start Time: 7:30
End Time: 7:56
*/
package ACSL02_03;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_Asterisks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0203C1Jr.in"));
		for(int i = 0; i < 9; i++) {
			String a = sc.next();
			int l = sc.nextInt();
			if(a.equals("B")) {
				int w = sc.nextInt();
				for(int j = 0; j < w; j++) {
					for(int k = 0; k < l; k++)
						System.out.print("* ");
					System.out.println();
				}
			}
			else if(a.equals("S")) {
				for(int j = 0; j < l; j++) {
					for(int k = 0; k < l; k++)
						System.out.print("* ");
					System.out.println();
				}
			}
			else if(a.equals("H")) {
				for(int j = l, u = 0; j >= 1; j--) {
					for(int o = 0; o < u; o++)
						System.out.print("  ");
					for(int k = 0; k < j; k++) {
						System.out.print("* ");
					}
					System.out.println();
					u++;
				}
			}
			else if(a.equals("L")){
				for(int j = 1; j <= l; j++) {
					for(int k = 0; k < j; k++)
						System.out.print("* ");
					System.out.println();
				}
			}
			System.out.println();
		}
		sc.close();
	}
}