/*
Start Time: 8:50
End Time: 9:02
*/
package ACSL10_11;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_Prints {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1011C1Jr.in"));
		for(int i = 0; i < 7; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			int[] values = {16, 16, 8, 8, 4, 4, 2, 2, 1, 1};
			int a = sc.nextInt();
			while(a != 0) {
				al.add(a);
				a = sc.nextInt();
			}
			int odd = 1;
			int even = 1;
			for(int j = 0; j < al.size(); j++) {
				if(al.get(j) % 2 == 1)
					odd += values[al.get(j) - 1];
				else
					even += values[al.get(j) - 1];
			}
			System.out.println(even + "/" + odd);
		}
		sc.close();
	}
}