/*
Start Time: 2:07
End Time: 2:20
*/
package ACSL07_08;
import java.io.*;
import java.util.*;
public class C1JR_Triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0708C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			double[] a = new double[3];
			double[] b = new double[3];
			for(int j = 0; j < 3; j++)
				a[j] = sc.nextDouble();
			for(int j = 0; j < 3; j++)
				b[j] = sc.nextDouble();
			int count = 0;
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(a[j] == b[k]) {
						count++;
						b[k] = 200;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}